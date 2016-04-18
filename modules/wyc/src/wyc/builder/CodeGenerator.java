// Copyright (c) 2011, David J. Pearce (djp@ecs.vuw.ac.nz)
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//    * Redistributions of source code must retain the above copyright
//      notice, this list of conditions and the following disclaimer.
//    * Redistributions in binary form must reproduce the above copyright
//      notice, this list of conditions and the following disclaimer in the
//      documentation and/or other materials provided with the distribution.
//    * Neither the name of the <organization> nor the
//      names of its contributors may be used to endorse or promote products
//      derived from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
// ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
// WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// DISCLAIMED. IN NO EVENT SHALL DAVID J. PEARCE BE LIABLE FOR ANY
// DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
// LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
// ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
// SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

package wyc.builder;

import java.util.*;

import static wyc.lang.WhileyFile.internalFailure;
import static wyc.lang.WhileyFile.syntaxError;
import static wyil.util.ErrorMessages.*;
import wyc.lang.*;
import wyc.lang.Stmt.*;
import wyc.lang.WhileyFile.Context;
import wycc.lang.Attribute;
import wycc.lang.NameID;
import wycc.lang.SyntacticElement;
import wycc.lang.SyntaxError;
import wycc.util.Pair;
import wycc.util.ResolveError;
import wycc.util.Triple;
import wyfs.lang.Path;
import wyil.attributes.VariableDeclarations;
import wyil.lang.*;

/**
 * <p>
 * Responsible for compiling the declarations, statements and expression found
 * in a WhileyFile into WyIL declarations and bytecode blocks. For example:
 * </p>
 *
 * <pre>
 * type nat is (int x) where x >= 0
 *
 * function f(nat x) -> int:
 *    return x-1
 * </pre>
 *
 * <p>
 * The code generator is responsible for generating the code for the constraint
 * on <code>nat</code>, as well as compiling the function's statements into
 * their corresponding WyIL bytecodes. For example, the code generated
 * constraint on type <code>nat</code> would look like this:
 * </p>
 *
 * <pre>
 * type nat is int
 * where:
 *     load x
 *     const 0
 *     ifge goto exit
 *     fail("type constraint not satisfied")
 *  .exit:
 * </pre>
 *
 * This WyIL bytecode simply compares the local variable x against 0. Here, x
 * represents the value held in a variable of type <code>nat</code>. If the
 * constraint fails, then the given message is printed.
 *
 * @author David J. Pearce
 *
 */
public final class CodeGenerator {

	/**
	 * The lambdas are anonymous functions used within statements and
	 * expressions in the source file. These are compiled into anonymised WyIL
	 * functions, since WyIL does not have an internal notion of a lambda.
	 */
	private final ArrayList<WyilFile.FunctionOrMethod> lambdas = new ArrayList<WyilFile.FunctionOrMethod>();

	/**
	 * The scopes stack is used for determining the correct scoping for continue
	 * and break statements. Whenever we begin translating a loop of some kind,
	 * a <code>LoopScope</code> is pushed on the stack. Once the translation of
	 * that loop is complete, this is then popped off the stack.
	 */
	private Stack<Scope> scopes = new Stack<Scope>();

	/**
	 * Construct a code generator object for translating WhileyFiles into
	 * WyilFiles.
	 *
	 * @param builder
	 *            The enclosing builder instance which provides access to the
	 *            global namespace.
	 * @param resolver
	 *            The relevant type checker instance which provides access to
	 *            the pool of previously determined types.
	 */
	public CodeGenerator(WhileyBuilder builder, FlowTypeChecker resolver) {
	}

	// =========================================================================
	// WhileyFile
	// =========================================================================

	/**
	 * Generate a WyilFile from a given WhileyFile by translating all of the
	 * declarations, statements and expressions into WyIL declarations and
	 * bytecode blocks.
	 *
	 * @param wf
	 *            The WhileyFile to be translated.
	 * @return
	 */
	public WyilFile generate(WhileyFile wf) {
		ArrayList<WyilFile.Block> declarations = new ArrayList<WyilFile.Block>();

		// Go through each declaration and translate in the order of appearance.
		for (WhileyFile.Declaration d : wf.declarations) {
			try {
				if (d instanceof WhileyFile.Type) {
					declarations.add(generate((WhileyFile.Type) d));
				} else if (d instanceof WhileyFile.Constant) {
					declarations.add(generate((WhileyFile.Constant) d));
				} else if (d instanceof WhileyFile.FunctionOrMethod) {
					declarations.add(generate((WhileyFile.FunctionOrMethod) d));
				}
			} catch (SyntaxError se) {
				throw se;
			} catch (Throwable ex) {
				WhileyFile.internalFailure(ex.getMessage(), (WhileyFile.Context) d, d, ex);
			}
		}

		// Add any lambda functions which were used within some expression. Each
		// of these is guaranteed to have been given a unique and valid WyIL
		// name.
		declarations.addAll(lambdas);

		// Done
		return new WyilFile(wf.module, wf.filename, declarations);
	}

	// =========================================================================
	// Constant Declarations
	// =========================================================================

	/**
	 * Generate a WyilFile constant declaration from a WhileyFile constant
	 * declaration. This requires evaluating the given expression to produce a
	 * constant value. If this cannot be done, then a syntax error is raised to
	 * indicate an invalid constant declaration was encountered.
	 */
	private WyilFile.Constant generate(WhileyFile.Constant cd) {
		return new WyilFile.Constant(cd.modifiers(), cd.name(), cd.resolvedValue);
	}

	// =========================================================================
	// Type Declarations
	// =========================================================================

	/**
	 * Generate a WyilFile type declaration from a WhileyFile type declaration.
	 * If a type invariant is given, then this will need to be translated into
	 * Wyil bytecode.
	 *
	 * @param td
	 * @return
	 * @throws Exception
	 */
	private WyilFile.Type generate(WhileyFile.Type td) throws Exception {
		BytecodeForest forest = new BytecodeForest();
		Environment environment = new Environment();
		// Allocate declared parameter
		environment.allocate(td.resolvedType.raw(), td.parameter.name());
		// Generate code for each invariant condition
		for (Expr invariant : td.invariant) {
			int root = generateInvariantBlock(invariant, environment, forest, td);
			forest.addRoot(root);
		}
		// Add all registers used within the invariant
		forest.registers().addAll(environment.asRegisters());
		// done
		return new WyilFile.Type(td.modifiers(), td.name(), td.resolvedType.nominal(), forest);
	}

	// =========================================================================
	// Function / Method Declarations
	// =========================================================================

	private WyilFile.FunctionOrMethod generate(WhileyFile.FunctionOrMethod fd) throws Exception {
		// Type.FunctionOrMethod rawFnType = fd.resolvedType().raw();
		Type.FunctionOrMethod nominalFnType = fd.resolvedType().nominal();

		// ==================================================================
		// Construct environments
		// ==================================================================

		BytecodeForest forest = new BytecodeForest();
		Environment environment = new Environment();
		ArrayList<BytecodeForest.Register> declarations = new ArrayList<BytecodeForest.Register>();
		addDeclaredParameters(fd.parameters, fd.resolvedType().params(), environment, declarations);
		addDeclaredParameters(fd.returns, fd.resolvedType().returns(), environment, declarations);
		// Allocate all declared variables now. This ensures that all declared
		// variables occur before any temporary variables.
		buildVariableDeclarations(fd.statements, declarations, environment, fd);

		// ==================================================================
		// Generate pre-condition
		// ==================================================================
		for (Expr precondition : fd.requires) {
			int root = generateInvariantBlock(precondition, environment, forest, fd);
			forest.addRoot(root);
		}

		// ==================================================================
		// Generate post-condition
		// ==================================================================
		for (Expr postcondition : fd.ensures) {
			int root = generateInvariantBlock(postcondition, environment, forest, fd);
			forest.addRoot(root);
		}

		// ==================================================================
		// Generate body
		// ==================================================================

		// First, reset the environment. This is necessary because the
		// environment may have been contaminated with local variables arising
		// in the precondition or postcondition. Such variables are possible if
		// quantifiers are used.
		
		// FIXME: using resetEnvironment feels ugly and could fail when multiple
		// variables of the same name are declared in the body of a function
		// or method (currently this is only possible via quantifiers, but won't
		// fail because they have the same type).
		environment = resetEnvironment(environment, declarations);

		BytecodeForest.Block body = new BytecodeForest.Block();
		forest.addAsRoot(body);
		for (Stmt s : fd.statements) {
			generate(s, environment, body, forest, fd);
		}

		// The following is sneaky. It guarantees that every method ends in a
		// return. For methods that actually need a value, this is either
		// removed as dead-code or remains and will cause an error.
		body.add(new Bytecode.Return(), attributes(fd));

		WyilFile.FunctionOrMethod declaration;

		// Second, add the corresponding attribute to the enclosing method.
		forest.registers().addAll(createVariableDeclarations(environment, declarations));

		if (fd instanceof WhileyFile.Function) {
			WhileyFile.Function f = (WhileyFile.Function) fd;
			declaration = new WyilFile.FunctionOrMethod(fd.modifiers(), fd.name(), f.resolvedType.nominal(), forest,
					fd.requires.size(), fd.ensures.size());
		} else {
			WhileyFile.Method md = (WhileyFile.Method) fd;
			declaration = new WyilFile.FunctionOrMethod(fd.modifiers(), fd.name(), md.resolvedType.nominal(), forest,
					fd.requires.size(), fd.ensures.size());
		}

		// Done.
		return declaration;
	}

	/**
	 * Construct a new code block in a given forest corresponding to a
	 * precondition, postcondition or type invariant.
	 * 
	 * @param invariant
	 * @param environment
	 * @param forest
	 * @param context
	 */
	private int generateInvariantBlock(Expr invariant, Environment environment, BytecodeForest forest, Context context) {
		BytecodeForest.Block precondition = new BytecodeForest.Block();
		int index = forest.add(precondition);
		String endLab = freshLabel();
		generateCondition(endLab, invariant, environment, precondition, forest, context);
		precondition.add(new Bytecode.Fail(), attributes(invariant));
		precondition.add(new Bytecode.Label(endLab));
		precondition.add(new Bytecode.Return());
		return index;
	}

	/**
	 * Construct register declarations for this function or method. The register
	 * declarations stores information about the names and declared types of all
	 * registers. Technically speaking, this information is not necessary to
	 * compile and run a Whiley program. However, it is very useful for
	 * debugging and performing verification.
	 */
	private List<BytecodeForest.Register> createVariableDeclarations(Environment environment,
			List<BytecodeForest.Register> declarations) {
		// FIXME: this is a hack. In essence, we're trying to get the types of
		// all intermediate registers used in code generation. To do this, we're
		// looking at their type having typed the entire function.
		for (int i = declarations.size(); i < environment.size(); i = i + 1) {
			Type t = environment.type(i);
			declarations.add(new BytecodeForest.Register(t, null));
		}
		return declarations;
	}

	/**
	 * Add a list of parameter declarations to a given environment
	 *
	 * @param parameters
	 *            --- List of parameters to add
	 * @param types
	 *            --- List of nominal parameter types
	 * @param declarations
	 *            --- List of declarations being constructed
	 */
	private void addDeclaredParameters(List<WhileyFile.Parameter> parameters, List<Nominal> types,
			Environment environment, List<BytecodeForest.Register> declarations) {
		for (int i = 0; i != parameters.size(); ++i) {
			WhileyFile.Parameter parameter = parameters.get(i);
			// allocate parameter to register in the current block
			declarations.add(new BytecodeForest.Register(types.get(i).nominal(), parameter.name));
			// allocate parameter to register in the current block
			environment.allocate(types.get(i).raw(), parameter.name);
		}
	}

	// =========================================================================
	// Statements
	// =========================================================================

	/**
	 * Translate a source-level statement into a WyIL block, using a given
	 * environment mapping named variables to slots.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to to slot block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param forest
	 *            --- Forest which encloses the given forest block
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt stmt, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		try {
			if (stmt instanceof VariableDeclaration) {
				generate((VariableDeclaration) stmt, environment, block, forest, context);
			} else if (stmt instanceof Assign) {
				generate((Assign) stmt, environment, block, forest, context);
			} else if (stmt instanceof Assert) {
				generate((Assert) stmt, environment, block, forest, context);
			} else if (stmt instanceof Assume) {
				generate((Assume) stmt, environment, block, forest, context);
			} else if (stmt instanceof Return) {
				generate((Return) stmt, environment, block, forest, context);
			} else if (stmt instanceof Debug) {
				generate((Debug) stmt, environment, block, forest, context);
			} else if (stmt instanceof Fail) {
				generate((Fail) stmt, environment, block, forest, context);
			} else if (stmt instanceof IfElse) {
				generate((IfElse) stmt, environment, block, forest, context);
			} else if (stmt instanceof Switch) {
				generate((Switch) stmt, environment, block, forest, context);
			} else if (stmt instanceof Break) {
				generate((Break) stmt, environment, block, forest, context);
			} else if (stmt instanceof Continue) {
				generate((Continue) stmt, environment, block, forest, context);
			} else if (stmt instanceof While) {
				generate((While) stmt, environment, block, forest, context);
			} else if (stmt instanceof DoWhile) {
				generate((DoWhile) stmt, environment, block, forest, context);
			} else if (stmt instanceof Expr.FunctionOrMethodCall) {
				generate((Expr.Multi) stmt, environment, block, forest, context);
			} else if (stmt instanceof Expr.IndirectFunctionOrMethodCall) {
				generate((Expr.Multi) stmt, environment, block, forest, context);
			} else if (stmt instanceof Expr.New) {
				generate((Expr.New) stmt, environment, block, forest, context);
			} else if (stmt instanceof Skip) {
				generate((Skip) stmt, environment, block, forest, context);
			} else {
				// should be dead-code
				WhileyFile.internalFailure("unknown statement: " + stmt.getClass().getName(), context, stmt);
			}
		} catch (ResolveError rex) {
			WhileyFile.syntaxError(rex.getMessage(), context, stmt, rex);
		} catch (SyntaxError sex) {
			throw sex;
		} catch (Exception ex) {
			WhileyFile.internalFailure(ex.getMessage(), context, stmt, ex);
		}
	}

	/**
	 * Translate a variable declaration statement into a WyIL block. This only
	 * has an effect if an initialiser expression is given; otherwise, it's
	 * effectively a no-op. Consider the following variable declaration:
	 *
	 * <pre>
	 * int v = x + 1
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 * const %3 = 1
	 * add %4 = %0, %3
	 * return %4
	 * </pre>
	 *
	 * Here, we see that variable <code>v</code> is allocated to register 4,
	 * whilst variable <code>x</code> is allocated to register 0.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(VariableDeclaration s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		// First, we allocate this variable to a given slot in the environment.
		int[] targets = { environment.get(s.parameter.name) };
		// Second, translate initialiser expression if it exists.
		if (s.expr != null) {
			int[] operands = { generate(s.expr, environment, block, forest, context) };
			block.add(new Bytecode.Operator(s.expr.result().raw(), targets, operands, Bytecode.OperatorKind.ASSIGN),
					attributes(s));
		}
	}

	/**
	 * Translate an assignment statement into a WyIL block. This must consider
	 * the different forms of assignment which are permitted in Whiley,
	 * including:
	 *
	 * <pre>
	 * x = e     // variable assignment
	 * x,y = e   // tuple assignment
	 * x.f = e   // field assignment
	 * x[i] = e  // index-of assignment
	 * </pre>
	 *
	 * As an example, consider the following index assignment:
	 *
	 * <pre>
	 * xs[i + 1] = 1
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 * const %2 = 1
	 * const %4 = 1
	 * add %5 = %0, %4
	 * update %1[%5] %2
	 * const %6 = 0
	 * return %6
	 * </pre>
	 *
	 * Here, variable <code>i</code> is allocated to register 0, whilst variable
	 * <code>xs</code> is allocated to register 1. The result of the index
	 * expression <code>i+1</code> is stored in the temporary register 5.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Assign s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		// First, we translate all right-hand side expressions and assign them
		// to temporary registers.
		ArrayList<Integer> operands = new ArrayList<Integer>();
		ArrayList<Type> types = new ArrayList<Type>();
		for (int i = 0; i != s.rvals.size(); ++i) {
			Expr e = s.rvals.get(i);
			// FIXME: this is a rather ugly
			if (e instanceof Expr.Multi) {
				// The assigned expression actually has multiple returns,
				// therefore extract them all.
				Expr.Multi me = (Expr.Multi) e;
				for (Nominal t : me.returns()) {
					types.add(t.raw());
				}
				operands.addAll(toIntegerList(generate(me, environment, block, forest, context)));
			} else {
				// The assigned rval is a simple expression which returns a
				// single value
				operands.add(generate(e, environment, block, forest, context));
				types.add(e.result().raw());
			}
		}

		// Second, update each expression on left-hand side of this assignment
		// appropriately. Note that we can safely assume here the number of
		// rvals and lvals matches as this has already been checked by
		// FlowTypeChecker.
		for (int i = 0; i != s.lvals.size(); ++i) {
			Expr.LVal lval = s.lvals.get(i);
			generateAssignment(lval, operands.get(i), types.get(i), environment, block, forest, context);
		}
	}

	public void generateAssignment(Expr.LVal lval, int operand, Type type, Environment environment,
			BytecodeForest.Block block, BytecodeForest forest, Context context) {
		if (lval instanceof Expr.AssignedVariable) {
			Expr.AssignedVariable v = (Expr.AssignedVariable) lval;
			// This is the easiest case. Having translated the right-hand side
			// expression, we now assign it directly to the register allocated
			// for variable on the left-hand side.
			int[] targets = new int[] { environment.get(v.var) };
			int[] operands = new int[] { operand };
			block.add(new Bytecode.Operator(type, targets, operands, Bytecode.OperatorKind.ASSIGN), attributes(lval));
		} else if (lval instanceof Expr.IndexOf || lval instanceof Expr.FieldAccess
				|| lval instanceof Expr.Dereference) {
			// This is the more complicated case, since the left-hand side
			// expression is recursive. However, the WyIL update bytecode comes
			// to the rescue here. All we need to do is extract the variable
			// being updated and give this to the update bytecode. For example,
			// in the expression "x.y.f = e" we have that variable "x" is being
			// updated.
			ArrayList<String> fields = new ArrayList<String>();
			ArrayList<Integer> operands = new ArrayList<Integer>();
			Expr.AssignedVariable lhs = extractLVal(lval, fields, operands, environment, block, forest, context);
			int target = environment.get(lhs.var);
			block.add(new Bytecode.Update(lhs.type.raw(), target, toIntArray(operands), operand, lhs.afterType.raw(),
					fields), attributes(lval));
		} else {
			WhileyFile.syntaxError("invalid assignment", context, lval);
		}
	}

	/**
	 * This function recurses down the left-hand side of an assignment (e.g.
	 * x[i] = e, x.f = e, etc) with a complex lval. The primary goal is to
	 * identify the left-most variable which is actually being updated. A
	 * secondary goal is to collect the sequence of field names being updated,
	 * and translate any index expressions and store them in temporary
	 * registers.
	 *
	 * @param e
	 *            The LVal being extract from.
	 * @param fields
	 *            The list of fields being used in the assignment. Initially,
	 *            this is empty and is filled by this method as it traverses the
	 *            lval.
	 * @param operands
	 *            The list of temporary registers in which evaluated index
	 *            expression are stored. Initially, this is empty and is filled
	 *            by this method as it traverses the lval.
	 * @param environment
	 *            Mapping from variable names to block registers.
	 * @param block
	 *            Code block into which this statement is to be translated.
	 * @param context
	 *            Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private Expr.AssignedVariable extractLVal(Expr e, ArrayList<String> fields, ArrayList<Integer> operands,
			Environment environment, BytecodeForest.Block block, BytecodeForest forest, Context context) {

		if (e instanceof Expr.AssignedVariable) {
			Expr.AssignedVariable v = (Expr.AssignedVariable) e;
			return v;
		} else if (e instanceof Expr.Dereference) {
			Expr.Dereference pa = (Expr.Dereference) e;
			return extractLVal(pa.src, fields, operands, environment, block, forest, context);
		} else if (e instanceof Expr.IndexOf) {
			Expr.IndexOf la = (Expr.IndexOf) e;
			int operand = generate(la.index, environment, block, forest, context);
			Expr.AssignedVariable l = extractLVal(la.src, fields, operands, environment, block, forest, context);
			operands.add(operand);
			return l;
		} else if (e instanceof Expr.FieldAccess) {
			Expr.FieldAccess ra = (Expr.FieldAccess) e;
			Expr.AssignedVariable r = extractLVal(ra.src, fields, operands, environment, block, forest, context);
			fields.add(ra.name);
			return r;
		} else {
			WhileyFile.syntaxError(errorMessage(INVALID_LVAL_EXPRESSION), context, e);
			return null; // dead code
		}
	}

	/**
	 * Translate an assert statement into WyIL bytecodes.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.Assert s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		// First, create assert block body
		BytecodeForest.Block subblock = new BytecodeForest.Block();
		int body = forest.add(subblock);
		String endLab = freshLabel();
		generateCondition(endLab, s.expr, environment, subblock, forest, context);
		subblock.add(new Bytecode.Fail(), attributes(s.expr));
		subblock.add(new Bytecode.Label(endLab));
		// Second, create assert bytecode
		block.add(new Bytecode.Assert(body), attributes(s));

	}

	/**
	 * Translate an assume statement into WyIL bytecodes.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.Assume s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		// First, create assume block body
		BytecodeForest.Block subblock = new BytecodeForest.Block();
		int body = forest.add(subblock);
		String endLab = freshLabel();
		generateCondition(endLab, s.expr, environment, subblock, forest, context);
		subblock.add(new Bytecode.Fail(), attributes(s.expr));
		subblock.add(new Bytecode.Label(endLab));
		// Second, create assert bytecode
		block.add(new Bytecode.Assume(body), attributes(s));
	}

	/**
	 * Translate a return statement into WyIL bytecodes. In the case that a
	 * return expression is provided, then this is first translated and stored
	 * in a temporary register. Consider the following return statement:
	 *
	 * <pre>
	 * return i * 2
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 * const %3 = 2
	 * mul %4 = %0, %3
	 * return %4
	 * </pre>
	 *
	 * Here, we see that variable <code>I</code> is allocated to register 0,
	 * whilst the result of the expression <code>i * 2</code> is stored in
	 * register 4.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.Return s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		List<Expr> returns = s.returns;
		// Here, we don't put the type propagated for the return expression.
		// Instead, we use the declared return type of this function. This
		// has the effect of forcing an implicit coercion between the
		// actual value being returned and its required type.
		List<Type> returnTypes = ((WhileyFile.FunctionOrMethod) context).resolvedType().raw().returns();
		Type[] types = returnTypes.toArray(new Type[returnTypes.size()]);
		int[] operands = new int[types.length];
		int index = 0;
		for (int i = 0; i != returns.size(); ++i) {
			Expr e = returns.get(i);
			// FIXME: this is a rather ugly
			if (e instanceof Expr.Multi) {
				int[] results = generate((Expr.Multi) e, environment, block, forest, context);
				for (int r : results) {
					operands[index++] = r;
				}
			} else {
				operands[index++] = generate(e, environment, block, forest, context);
			}
		}
		block.add(new Bytecode.Return(types, operands), attributes(s));
	}

	/**
	 * Translate a skip statement into a WyIL nop bytecode.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.Skip s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		// TODO: should actually generate a NOP bytecode. This is an assignment
		// from zero operands to zero targets. At the moment, I cannot encode
		// this however because it will fail in the interpreter.
	}

	/**
	 * Translate a debug statement into WyIL bytecodes. The debug expression is
	 * first translated and stored in a temporary register. Consider the
	 * following debug statement:
	 *
	 * <pre>
	 * debug "Hello World"
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 * const %2 = "Hello World"
	 * debug %2
	 * </pre>
	 *
	 * Here, we see that debug expression is first stored into the temporary
	 * register 2.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.Debug s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		int operand = generate(s.expr, environment, block, forest, context);
		block.add(new Bytecode.Debug(operand), attributes(s));
	}

	/**
	 * Translate a fail statement into WyIL bytecodes.
	 *
	 * <pre>
	 * fail
	 * </pre>
	 *
	 * A fail statement is always translated into a WyIL fail bytecode:
	 *
	 * <pre>
	 * fail
	 * </pre>
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param codes
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.Fail s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		block.add(new Bytecode.Fail(), attributes(s));
	}

	/**
	 * Translate an if statement into WyIL bytecodes. This is done by first
	 * translating the condition into one or more conditional branches. The true
	 * and false blocks are then translated and marked with labels. Finally, an
	 * exit label is provided to catch the fall-through case. Consider the
	 * following if statement:
	 *
	 * <pre>
	 * if x+1 < 2:
	 *     x = x + 1
	 * ...
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 * const %3 = 1
	 * add %4 = %0, %3
	 * const %5 = 2
	 * ifge %4, %5 goto label0
	 * const %7 = 1
	 * add %8 = %0, %7
	 * assign %0 = %8
	 * .label0
	 *    ...
	 * </pre>
	 *
	 * Here, we see that result of the condition is stored into temporary
	 * register 4, which is then used in the comparison. In the case the
	 * condition is false, control jumps over the true block; otherwise, it
	 * enters the true block and then (because there is no false block) falls
	 * through.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.IfElse s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {

		String falseLab = freshLabel();
		String exitLab = s.falseBranch.isEmpty() ? falseLab : freshLabel();

		generateCondition(falseLab, invert(s.condition), environment, block, forest, context);

		for (Stmt st : s.trueBranch) {
			generate(st, environment, block, forest, context);
		}
		if (!s.falseBranch.isEmpty()) {
			block.add(new Bytecode.Goto(exitLab));
			block.add(new Bytecode.Label(falseLab));
			for (Stmt st : s.falseBranch) {
				generate(st, environment, block, forest, context);
			}
		}

		block.add(new Bytecode.Label(exitLab));
	}

	/**
	 * Translate a break statement into a WyIL unconditional branch bytecode.
	 * This requires examining the scope stack to determine the correct target
	 * for the branch. Consider the following use of a break statement:
	 *
	 * <pre>
	 * while x < 10:
	 *    if x == 0:
	 *       break
	 *    x = x + 1
	 * ...
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 * loop (%0)
	 *     const %3 = 10
	 *     ifge %0, %3 goto label0
	 *     const %5 = 0
	 *     ifne %0, %5 goto label1
	 *     goto label0
	 *     .label1
	 *     const %7 = 1
	 *     add %8 = %0, %7
	 *     assign %0 = %8
	 * .label0
	 * ...
	 * </pre>
	 *
	 * Here, we see that the break statement is translated into the bytecode
	 * "goto label0", which exits the loop.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.Break s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		LoopScope scope = findEnclosingScope(LoopScope.class);
		if (scope == null) {
			WhileyFile.syntaxError(errorMessage(BREAK_OUTSIDE_SWITCH_OR_LOOP), context, s);
		}
		block.add(new Bytecode.Goto(scope.breakLabel));
	}

	/**
	 * Translate a continue statement into a WyIL unconditional branch bytecode.
	 * This requires examining the scope stack to determine the correct target
	 * for the branch. Consider the following use of a continue statement:
	 *
	 * <pre>
	 * while x < 10:
	 *    x = x + 1
	 *    if x == 0:
	 *       continue
	 *    ...
	 * ...
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 * loop (%0)
	 *     const %3 = 10
	 *     ifge %0, %3 goto label0
	 *     const %7 = 1
	 *     add %8 = %0, %7
	 *     assign %0 = %8
	 *     const %5 = 0
	 *     ifne %0, %5 goto label1
	 *     goto label2
	 *     .label1
	 *     ...
	 *     .label2
	 * .label0
	 * ...
	 * </pre>
	 *
	 * Here, we see that the continue statement is translated into the bytecode
	 * "goto label2", which skips the loop body for one iteration.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.Continue s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		LoopScope scope = findEnclosingScope(LoopScope.class);
		if (scope == null) {
			WhileyFile.syntaxError(errorMessage(CONTINUE_OUTSIDE_LOOP), context, s);
		}
		block.add(new Bytecode.Goto(scope.continueLabel));
	}

	/**
	 * Translate a switch statement into WyIL bytecodes. This is done by first
	 * translating the switch expression and storing its result in a temporary
	 * register. Then, each case is translated in order of appearance. Consider
	 * the following switch statement:
	 *
	 * <pre>
	 * switch x+1:
	 *     case 0,1:
	 *         return x+1
	 *     case 2:
	 *         x = x - 1
	 *     default:
	 *         x = 0
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 *     const %2 = 1
	 *     add %3 = %0, %2
	 *     switch %3 0->label1, 1->label1, 2->label2, *->label0
	 * .label1
	 *     const %3 = 1
	 *     add %4 = %0, %3
	 *     return %4
	 * .label2
	 *     const %6 = 1
	 *     sub %7 = %0, %6
	 *     assign %0 = %7
	 *     goto label3
	 * .label0
	 *     const %8 = 0
	 *     assign %0 = %8
	 *     goto label3
	 * .label3
	 * </pre>
	 *
	 * Here, we see that switch expression is first stored into the temporary
	 * register 3. Then, each of the values 0 -- 2 is routed to the start of its
	 * block, with * representing the default case.
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.Switch s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) throws Exception {
		String exitLab = freshLabel();
		int operand = generate(s.expr, environment, block, forest, context);
		String defaultTarget = exitLab;
		HashSet<Constant> values = new HashSet<>();
		ArrayList<Pair<Constant, String>> cases = new ArrayList<>();
		int start = block.size();

		for (Stmt.Case c : s.cases) {
			if (c.expr.isEmpty()) {
				// A case with an empty match represents the default label. We
				// must check that we have not already seen a case with an empty
				// match (otherwise, we'd have two default labels ;)
				if (defaultTarget != exitLab) {
					WhileyFile.syntaxError(errorMessage(DUPLICATE_DEFAULT_LABEL), context, c);
				} else {
					defaultTarget = freshLabel();
					block.add(new Bytecode.Label(defaultTarget), attributes(c));
					for (Stmt st : c.stmts) {
						generate(st, environment, block, forest, context);
					}
					block.add(new Bytecode.Goto(exitLab), attributes(c));
				}

			} else if (defaultTarget == exitLab) {
				String target = freshLabel();
				block.add(new Bytecode.Label(target), attributes(c));

				// Case statements in Whiley may have multiple matching constant
				// values. Therefore, we iterate each matching value and
				// construct a mapping from that to a label indicating the start
				// of the case body.

				for (Constant constant : c.constants) {
					// Check whether this case constant has already been used as
					// a case constant elsewhere. If so, then report an error.
					if (values.contains(constant)) {
						WhileyFile.syntaxError(errorMessage(DUPLICATE_CASE_LABEL), context, c);
					}
					cases.add(new Pair<>(constant, target));
					values.add(constant);
				}

				for (Stmt st : c.stmts) {
					generate(st, environment, block, forest, context);
				}
				block.add(new Bytecode.Goto(exitLab), attributes(c));

			} else {
				// This represents the case where we have another non-default
				// case after the default case. Such code cannot be executed,
				// and is therefore reported as an error.
				WhileyFile.syntaxError(errorMessage(UNREACHABLE_CODE), context, c);
			}
		}

		block.add(start, new Bytecode.Switch(s.expr.result().raw(), operand, defaultTarget, cases), attributes(s));
		block.add(new Bytecode.Label(exitLab), attributes(s));
	}

	/**
	 * Translate a while loop into WyIL bytecodes. Consider the following use of
	 * a while statement:
	 *
	 * <pre>
	 * while x < 10:
	 *    x = x + 1
	 * ...
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 * loop (%0)
	 *     const %3 = 10
	 *     ifge %0, %3 goto label0
	 *     const %7 = 1
	 *     add %8 = %0, %7
	 *     assign %0 = %8
	 * .label0
	 * ...
	 * </pre>
	 *
	 * Here, we see that the evaluated loop condition is stored into temporary
	 * register 3 and that the condition is implemented using a conditional
	 * branch. Note that there is no explicit goto statement at the end of the
	 * loop body which loops back to the head (this is implicit in the loop
	 * bytecode).
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.While s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		// A label marking where execution continues after the while
		// loop finishes. Used when the loop condition evaluates to false
		// or when a break statement is encountered.
		String exitLab = freshLabel();
		// A label marking the end of the current loop iteration. Used
		// by the continue statement.
		String continueLab = freshLabel();

		BytecodeForest.Block bodyBlock = new BytecodeForest.Block();
		int body = forest.add(bodyBlock);

		for (Expr condition : s.invariants) {
			int invariant = generateInvariantBlock(condition, environment, forest, context);
			bodyBlock.add(new Bytecode.Invariant(invariant), attributes(condition));
		}

		generateCondition(exitLab, invert(s.condition), environment, bodyBlock, forest, context);

		scopes.push(new LoopScope(continueLab, exitLab));
		for (Stmt st : s.body) {
			generate(st, environment, bodyBlock, forest, context);
		}
		scopes.pop(); // break

		bodyBlock.add(new Bytecode.Label(continueLab), attributes(s));
		block.add(new Bytecode.Loop(new int[] {}, body), attributes(s));
		block.add(new Bytecode.Label(exitLab), attributes(s));
	}

	/**
	 * Translate a do-while loop into WyIL bytecodes. Consider the following use
	 * of a do-while statement:
	 *
	 * <pre>
	 * do:
	 *    x = x + 1
	 * while x < 10
	 * ...
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 * loop (%0)
	 *     const %2 = 1
	 *     add %3 = %0, %2
	 *     assign %0 = %3
	 *     const %5 = 10
	 *     ifge %3, %5 goto label0
	 * .label0
	 * ...
	 * </pre>
	 *
	 * Here, we see that the evaluated loop condition is stored into temporary
	 * register 3 and that the condition is implemented using a conditional
	 * branch. Note that there is no explicit goto statement at the end of the
	 * loop body which loops back to the head (this is implicit in the loop
	 * bytecode).
	 *
	 * @param stmt
	 *            --- Statement to be translated.
	 * @param environment
	 *            --- Mapping from variable names to block registers.
	 * @param block
	 *            --- Code block into which this statement is to be translated.
	 * @param context
	 *            --- Enclosing context of this statement (i.e. type, constant,
	 *            function or method declaration). The context is used to aid
	 *            with error reporting as it determines the enclosing file.
	 * @return
	 */
	private void generate(Stmt.DoWhile s, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		// A label marking where execution continues after the do-while
		// loop finishes. Used when the loop condition evaluates to false
		// or when a break statement is encountered.
		String exitLab = freshLabel();
		// A label marking the end of the current loop iteration. Used
		// by the continue statement.
		String continueLab = freshLabel();

		BytecodeForest.Block bodyBlock = new BytecodeForest.Block();
		int body = forest.add(bodyBlock);

		scopes.push(new LoopScope(continueLab, exitLab));
		for (Stmt st : s.body) {
			generate(st, environment, bodyBlock, forest, context);
		}
		scopes.pop(); // break

		for (Expr condition : s.invariants) {
			int invariant = generateInvariantBlock(condition, environment, forest, context);
			bodyBlock.add(new Bytecode.Invariant(invariant), attributes(condition));
		}

		bodyBlock.add(new Bytecode.Label(continueLab), attributes(s));
		generateCondition(exitLab, invert(s.condition), environment, bodyBlock, forest, context);

		block.add(new Bytecode.Loop(new int[] {}, body), attributes(s));
		block.add(new Bytecode.Label(exitLab), attributes(s));
	}

	// =========================================================================
	// Conditions
	// =========================================================================

	/**
	 * Translate a source-level condition into a WyIL block, using a given
	 * environment mapping named variables to slots. If the condition evaluates
	 * to true, then control is transferred to the given target. Otherwise,
	 * control will fall through to the following bytecode. This method is
	 * necessary because the WyIL bytecode implementing comparisons are only
	 * available as conditional branches. For example, consider this if
	 * statement:
	 *
	 * <pre>
	 * if x < y || x == y:
	 *     x = y
	 * else:
	 *     x = -y
	 * </pre>
	 *
	 * This might be translated into the following WyIL bytecodes:
	 *
	 * <pre>
	 *     iflt %0, %1 goto label0
	 *     ifne %0, %1 goto label1
	 * .label0
	 *     assign %0 = %1
	 *     goto label2
	 * .label1
	 *     neg %8 = %1
	 *     assign %0 = %8
	 * .label2
	 * </pre>
	 *
	 * Here, we see that the condition "x < y || x == y" is broken down into two
	 * conditional branches (which additionally implement short-circuiting). The
	 * branches are carefully selected implement the semantics of the logical OR
	 * operator '||'. This function is responsible for translating conditional
	 * expressions like this into sequences of conditional branches using
	 * short-circuiting.
	 *
	 * @param target
	 *            --- Target label to goto if condition is true. When the
	 *            condition is false, control falls simply through to the next
	 *            bytecode in sqeuence.
	 * @param condition
	 *            --- Source-level condition to be translated into a sequence of
	 *            one or more conditional branches.
	 * @param environment
	 *            --- Mapping from variable names to to slot numbers.
	 * @param block
	 *            --- List of bytecodes onto which translation should be
	 *            appended.
	 * @return
	 */
	public void generateCondition(String target, Expr condition, Environment environment, BytecodeForest.Block block,
			BytecodeForest forest, Context context) {
		try {

			// First, we see whether or not we can employ a special handler for
			// translating this condition.

			if (condition instanceof Expr.Constant) {
				generateCondition(target, (Expr.Constant) condition, environment, block, forest, context);
			} else if (condition instanceof Expr.UnOp) {
				generateCondition(target, (Expr.UnOp) condition, environment, block, forest, context);
			} else if (condition instanceof Expr.BinOp) {
				generateCondition(target, (Expr.BinOp) condition, environment, block, forest, context);
			} else if (condition instanceof Expr.Quantifier) {
				generateCondition(target, (Expr.Quantifier) condition, environment, block, forest, context);
			} else if (condition instanceof Expr.ConstantAccess || condition instanceof Expr.LocalVariable
					|| condition instanceof Expr.AbstractInvoke || condition instanceof Expr.AbstractIndirectInvoke
					|| condition instanceof Expr.FieldAccess || condition instanceof Expr.IndexOf) {

				// This is the default case where no special handler applies. In
				// this case, we simply compares the computed value against
				// true. In some cases, we could actually do better. For
				// example, !(x < 5) could be rewritten into x >= 5.

				int result = generate(condition, environment, block, forest, context);
				block.add(new Bytecode.If(Type.T_BOOL, result, target), attributes(condition));

			} else {
				syntaxError(errorMessage(INVALID_BOOLEAN_EXPRESSION), context, condition);
			}

		} catch (SyntaxError se) {
			throw se;
		} catch (Exception ex) {
			internalFailure(ex.getMessage(), context, condition, ex);
		}

	}

	/**
	 * <p>
	 * Translate a source-level condition which is a constant (i.e.
	 * <code>true</code> or <code>false</code>) into a WyIL block, using a given
	 * environment mapping named variables to slots. This may seem like a
	 * perverse case, but it is permitted to allow selective commenting of code.
	 * </p>
	 *
	 * <p>
	 * When the constant is true, an unconditional branch to the target is
	 * generated. Otherwise, nothing is generated and control falls through to
	 * the next bytecode in sequence.
	 * </p>
	 *
	 * @param target
	 *            --- Target label to goto if condition is true. When the
	 *            condition is false, control falls simply through to the next
	 *            bytecode in sqeuence.
	 * @param condition
	 *            --- Source-level condition to be translated into a sequence of
	 *            one or more conditional branches.
	 * @param environment
	 *            --- Mapping from variable names to to slot numbers.
	 * @param block
	 *            --- List of bytecodes onto which translation should be
	 *            appended.
	 * @return
	 */
	private void generateCondition(String target, Expr.Constant c, Environment environment, BytecodeForest.Block block,
			BytecodeForest forest, Context context) {
		Constant.Bool b = (Constant.Bool) c.value;
		if (b.value()) {
			block.add(new Bytecode.Goto(target));
		} else {
			// do nout
		}
	}

	/**
	 * <p>
	 * Translate a source-level condition which is a binary expression into WyIL
	 * bytecodes, using a given environment mapping named variables to slots.
	 * </p>
	 *
	 * @param target
	 *            --- Target label to goto if condition is true. When the
	 *            condition is false, control falls simply through to the next
	 *            bytecode in sqeuence.
	 * @param condition
	 *            --- Source-level condition to be translated into a sequence of
	 *            one or more conditional branches.
	 * @param environment
	 *            --- Mapping from variable names to to slot numbers.
	 * @param block
	 *            --- List of bytecodes onto which translation should be
	 *            appended.
	 * @return
	 */
	private void generateCondition(String target, Expr.BinOp v, Environment environment, BytecodeForest.Block block,
			BytecodeForest forest, Context context) throws Exception {

		Expr.BOp bop = v.op;

		if (bop == Expr.BOp.OR) {
			generateCondition(target, v.lhs, environment, block, forest, context);
			generateCondition(target, v.rhs, environment, block, forest, context);

		} else if (bop == Expr.BOp.AND) {
			String exitLabel = freshLabel();
			generateCondition(exitLabel, invert(v.lhs), environment, block, forest, context);
			generateCondition(target, v.rhs, environment, block, forest, context);
			block.add(new Bytecode.Label(exitLabel));

		} else if (bop == Expr.BOp.IS) {
			generateTypeCondition(target, v, environment, block, forest, context);

		} else {
			if (bop == Expr.BOp.EQ && v.lhs instanceof Expr.LocalVariable && v.rhs instanceof Expr.Constant
					&& ((Expr.Constant) v.rhs).value == Constant.Null) {
				// this is a simple rewrite to enable type inference.
				Expr.LocalVariable lhs = (Expr.LocalVariable) v.lhs;
				if (environment.get(lhs.var) == null) {
					syntaxError(errorMessage(UNKNOWN_VARIABLE), context, v.lhs);
				}
				int slot = environment.get(lhs.var);
				block.add(new Bytecode.IfIs(v.srcType.raw(), slot, Type.T_NULL, target), attributes(v));
			} else if (bop == Expr.BOp.NEQ && v.lhs instanceof Expr.LocalVariable
					&& v.rhs instanceof Expr.Constant && ((Expr.Constant) v.rhs).value == Constant.Null) {
				// this is a simple rewrite to enable type inference.
				String exitLabel = freshLabel();
				Expr.LocalVariable lhs = (Expr.LocalVariable) v.lhs;
				if (environment.get(lhs.var) == null) {
					syntaxError(errorMessage(UNKNOWN_VARIABLE), context, v.lhs);
				}
				int slot = environment.get(lhs.var);
				block.add(new Bytecode.IfIs(v.srcType.raw(), slot, Type.T_NULL, exitLabel), attributes(v));
				block.add(new Bytecode.Goto(target));
				block.add(new Bytecode.Label(exitLabel));
			} else {
				int result = generate(v, environment, block, forest, context);
				block.add(new Bytecode.If(v.srcType.raw(), result, target), attributes(v));
			}
		}
	}

	/**
	 * <p>
	 * Translate a source-level condition which represents a runtime type test
	 * (e.g. <code>x is int</code>) into WyIL bytecodes, using a given
	 * environment mapping named variables to slots. One subtlety of this arises
	 * when the lhs is a single variable. In this case, the variable will be
	 * retyped and, in order for this to work, we *must* perform the type test
	 * on the actual varaible, rather than a temporary.
	 * </p>
	 *
	 * @param target
	 *            --- Target label to goto if condition is true. When the
	 *            condition is false, control falls simply through to the next
	 *            bytecode in sqeuence.
	 * @param condition
	 *            --- Source-level binary condition to be translated into a
	 *            sequence of one or more conditional branches.
	 * @param environment
	 *            --- Mapping from variable names to to slot numbers.
	 * @param block
	 *            --- List of bytecodes onto which translation should be
	 *            appended.
	 * @return
	 */
	private void generateTypeCondition(String target, Expr.BinOp condition, Environment environment,
			BytecodeForest.Block block, BytecodeForest forest, Context context) throws Exception {
		int leftOperand;

		if (condition.lhs instanceof Expr.LocalVariable) {
			// This is the case where the lhs is a single variable and, hence,
			// will be retyped by this operation. In this case, we must operate
			// on the original variable directly, rather than a temporary
			// variable (since, otherwise, we'll retype the temporary but not
			// the intended variable).
			Expr.LocalVariable lhs = (Expr.LocalVariable) condition.lhs;
			if (environment.get(lhs.var) == null) {
				syntaxError(errorMessage(UNKNOWN_VARIABLE), context, condition.lhs);
			}
			leftOperand = environment.get(lhs.var);
		} else {
			// This is the general case whether the lhs is an arbitrary variable
			// and, hence, retyping does not apply. Therefore, we can simply
			// evaluate the lhs into a temporary register as per usual.
			leftOperand = generate(condition.lhs, environment, block, forest, context);
		}

		// Note, the type checker guarantees that the rhs is a type val, so the
		// following cast is always safe.
		Expr.TypeVal rhs = (Expr.TypeVal) condition.rhs;

		block.add(new Bytecode.IfIs(condition.srcType.raw(), leftOperand, rhs.type.nominal(), target), attributes(condition));
	}

	/**
	 * <p>
	 * Translate a source-level condition which represents a unary condition
	 * into WyIL bytecodes, using a given environment mapping named variables to
	 * slots. Note, the only valid unary condition is logical not. To implement
	 * this, we simply generate the underlying condition and reroute its branch
	 * targets.
	 * </p>
	 *
	 * @param target
	 *            --- Target label to goto if condition is true. When the
	 *            condition is false, control falls simply through to the next
	 *            bytecode in sqeuence.
	 * @param condition
	 *            --- Source-level condition to be translated into a sequence of
	 *            one or more conditional branches.
	 * @param environment
	 *            --- Mapping from variable names to to slot numbers.
	 * @param block
	 *            --- List of bytecodes onto which translation should be
	 *            appended.
	 * @return
	 */
	private void generateCondition(String target, Expr.UnOp v, Environment environment, BytecodeForest.Block block,
			BytecodeForest forest, Context context) {
		Expr.UOp uop = v.op;
		switch (uop) {
		case NOT:
			// What we do is generate the underlying expression whilst setting
			// its true destination to a temporary label. Then, for the fall
			// through case we branch to our true destination.

			String label = freshLabel();
			generateCondition(label, v.mhs, environment, block, forest, context);
			block.add(new Bytecode.Goto(target));
			block.add(new Bytecode.Label(label));
			return;
		default:
			// Nothing else is a valud boolean condition here.
			syntaxError(errorMessage(INVALID_BOOLEAN_EXPRESSION), context, v);
		}
	}

	/**
	 * <p>
	 * Translate a source-level condition which represents a quantifier
	 * expression into WyIL bytecodes, using a given environment mapping named
	 * variables to slots.
	 * </p>
	 *
	 * @param target
	 *            --- Target label to goto if condition is true. When the
	 *            condition is false, control falls simply through to the next
	 *            bytecode in sqeuence.
	 * @param condition
	 *            --- Source-level condition to be translated into a sequence of
	 *            one or more conditional branches.
	 * @param environment
	 *            --- Mapping from variable names to to slot numbers.
	 * @param block
	 *            --- List of bytecodes onto which translation should be
	 *            appended.
	 * @return
	 */
	private void generateCondition(String target, Expr.Quantifier e, Environment environment, BytecodeForest.Block block,
			BytecodeForest forest, Context context) {

		String exit = freshLabel();
		generate(e.sources.iterator(), target, exit, e, environment, block, forest, context);

		switch (e.cop) {
		case NONE:
			block.add(new Bytecode.Goto(target));
			block.add(new Bytecode.Label(exit));
			break;
		case SOME:
			break;
		case ALL:
			block.add(new Bytecode.Goto(target));
			block.add(new Bytecode.Label(exit));
			break;
		}
	}

	private void generate(Iterator<Triple<String, Expr, Expr>> srcIterator, String trueLabel, String falseLabel,
			Expr.Quantifier e, Environment environment, BytecodeForest.Block block, BytecodeForest forest, Context context) {

		if (srcIterator.hasNext()) {
			// This is the inductive case (i.e. an outer loop)
			Triple<String, Expr, Expr> src = srcIterator.next();

			// First, determine the src slot.
			int varSlot = environment.allocate(Type.T_INT, src.first());
			int startSlot = generate(src.second(), environment, block, forest, context);
			int endSlot = generate(src.third(), environment, block, forest, context);

			// Second, recursively generate remaining parts
			BytecodeForest.Block bodyBlock = new BytecodeForest.Block();
			int body = forest.add(bodyBlock);
			generate(srcIterator, trueLabel, falseLabel, e, environment, bodyBlock, forest, context);
			// Finally, create the forall loop bytecode
			block.add(new Bytecode.Quantify(startSlot, endSlot, varSlot, new int[0], body), attributes(e));
		} else {
			// This is the base case (i.e. the innermost loop)
			switch (e.cop) {
			case NONE:
				generateCondition(falseLabel, e.condition, environment, block, forest, context);
				break;
			case SOME:
				generateCondition(trueLabel, e.condition, environment, block, forest, context);
				break;
			case ALL:
				generateCondition(falseLabel, invert(e.condition), environment, block, forest, context);
				break;
			}
		}
	}

	// =========================================================================
	// Multi-Expressions
	// =========================================================================

	public int[] generate(Expr.Multi expression, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		List<Nominal> returns = expression.returns();
		int[] targets = new int[returns.size()];
		for (int i = 0; i != targets.length; ++i) {
			targets[i] = environment.allocate(returns.get(i).raw());
		}
		try {
			if (expression instanceof Expr.FunctionOrMethodCall) {
				Expr.FunctionOrMethodCall fmc = (Expr.FunctionOrMethodCall) expression;
				generateStmt(fmc, environment, block, forest, context, targets);
			} else if (expression instanceof Expr.IndirectFunctionOrMethodCall) {
				Expr.IndirectFunctionOrMethodCall fmc = (Expr.IndirectFunctionOrMethodCall) expression;
				generateStmt(fmc, environment, block, forest, context, targets);
			} else {
				// should be dead-code
				internalFailure("unknown expression: " + expression.getClass().getName(), context, expression);
			}
		} catch (ResolveError rex) {
			syntaxError(rex.getMessage(), context, expression, rex);
		} catch (SyntaxError se) {
			throw se;
		} catch (Exception ex) {
			internalFailure(ex.getMessage(), context, expression, ex);
		}
		// done
		return targets;
	}

	public void generateStmt(Expr.FunctionOrMethodCall expr, Environment environment, BytecodeForest.Block block,
			BytecodeForest forest, Context context, int... targets) throws ResolveError {
		//
		int[] operands = generate(expr.arguments, environment, block, forest, context);
		block.add(new Bytecode.Invoke(expr.type().nominal(), targets, operands, expr.nid()), attributes(expr));
	}

	public void generateStmt(Expr.IndirectFunctionOrMethodCall expr, Environment environment, BytecodeForest.Block block,
			BytecodeForest forest, Context context, int... targets) throws ResolveError {
		//
		int operand = generate(expr.src, environment, block, forest, context);
		int[] operands = generate(expr.arguments, environment, block, forest, context);
		block.add(new Bytecode.IndirectInvoke(expr.type().raw(), targets, operand, operands), attributes(expr));
	}

	// =========================================================================
	// Expressions
	// =========================================================================

	/**
	 * Translate a source-level expression into a WYIL bytecode block, using a
	 * given environment mapping named variables to registers. The result of the
	 * expression is stored in a given target register.
	 *
	 * @param expression
	 *            --- Source-level expression to be translated
	 * @param environment
	 *            --- Mapping from variable names to to slot numbers.
	 * @param block
	 *            --- List of bytecodes onto which translation should be
	 *            appended.
	 *
	 * @return --- the register
	 */
	public int generate(Expr expression, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		try {
			if (expression instanceof Expr.Constant) {
				return generate((Expr.Constant) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.LocalVariable) {
				return generate((Expr.LocalVariable) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.ConstantAccess) {
				return generate((Expr.ConstantAccess) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.ArrayInitialiser) {
				return generate((Expr.ArrayInitialiser) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.ArrayGenerator) {
				return generate((Expr.ArrayGenerator) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.BinOp) {
				return generate((Expr.BinOp) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.Dereference) {
				return generate((Expr.Dereference) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.Cast) {
				return generate((Expr.Cast) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.IndexOf) {
				return generate((Expr.IndexOf) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.UnOp) {
				return generate((Expr.UnOp) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.FunctionOrMethodCall) {
				return generate((Expr.FunctionOrMethodCall) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.IndirectFunctionCall) {
				return generate((Expr.IndirectFunctionCall) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.IndirectMethodCall) {
				return generate((Expr.IndirectMethodCall) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.Quantifier) {
				return generate((Expr.Quantifier) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.FieldAccess) {
				return generate((Expr.FieldAccess) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.Record) {
				return generate((Expr.Record) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.FunctionOrMethod) {
				return generate((Expr.FunctionOrMethod) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.Lambda) {
				return generate((Expr.Lambda) expression, environment, block, forest, context);
			} else if (expression instanceof Expr.New) {
				return generate((Expr.New) expression, environment, block, forest, context);
			} else {
				// should be dead-code
				internalFailure("unknown expression: " + expression.getClass().getName(), context, expression);
			}
		} catch (ResolveError rex) {
			syntaxError(rex.getMessage(), context, expression, rex);
		} catch (SyntaxError se) {
			throw se;
		} catch (Exception ex) {
			internalFailure(ex.getMessage(), context, expression, ex);
		}

		return -1; // deadcode
	}

	public int generate(Expr.FunctionOrMethodCall expr, Environment environment, BytecodeForest.Block block,
			BytecodeForest forest, Context context) throws ResolveError {
		int target = environment.allocate(expr.result().raw());
		generateStmt(expr, environment, block, forest, context, target);
		return target;
	}

	public int generate(Expr.IndirectFunctionOrMethodCall expr, Environment environment, BytecodeForest.Block block,
			BytecodeForest forest, Context context) throws ResolveError {
		int target = environment.allocate(expr.result().raw());
		generateStmt(expr, environment, block, forest, context, target);
		return target;
	}

	private int generate(Expr.Constant expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		Constant val = expr.value;
		int target = environment.allocate(val.type());
		block.add(new Bytecode.Const(target, expr.value), attributes(expr));
		return target;
	}

	private int generate(Expr.FunctionOrMethod expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		Type.FunctionOrMethod rawType = expr.type.raw();
		Type.FunctionOrMethod nominalType = expr.type.nominal();
		int target = environment.allocate(rawType);
		block.add(new Bytecode.Lambda(nominalType, target, new int[0], expr.nid), attributes(expr));
		return target;
	}

	private int generate(Expr.Lambda expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		Type.FunctionOrMethod tfm = expr.type.raw();
		List<Type> tfm_params = tfm.params();
		List<WhileyFile.Parameter> expr_params = expr.parameters;

		// Create environment for the lambda body.
		ArrayList<Integer> operands = new ArrayList<Integer>();
		ArrayList<Type> paramTypes = new ArrayList<Type>();
		BytecodeForest bodyForest = new BytecodeForest();
		List<BytecodeForest.Register> declarations = bodyForest.registers();
		Environment benv = new Environment();
		for (int i = 0; i != tfm_params.size(); ++i) {
			Type type = tfm_params.get(i);
			String name = expr_params.get(i).name;
			benv.allocate(type, name);
			paramTypes.add(type);
			declarations.add(new BytecodeForest.Register(type, name));
		}
		for (Pair<Type, String> v : Exprs.uses(expr.body, context)) {
			if (benv.get(v.second()) == null) {
				Type type = v.first();
				benv.allocate(type, v.second());
				paramTypes.add(type);
				operands.add(environment.get(v.second()));
				declarations.add(new BytecodeForest.Register(type, v.second()));
			}
		}
		// Generate body based on current environment

		BytecodeForest.Block bodyBlock = new BytecodeForest.Block();
		bodyForest.addAsRoot(bodyBlock);
		if (tfm.returns().isEmpty()) {
			bodyBlock.add(new Bytecode.Return(), attributes(expr));
		} else {
			int target = generate(expr.body, benv, bodyBlock, bodyForest, context);
			bodyBlock.add(new Bytecode.Return(tfm.returns().toArray(new Type[tfm.returns().size()]), target),
					attributes(expr));
		}

		// Add type information for all temporary registers allocated
		// during code generation. This complements the existing information
		// about declared variables.
		for (int i = declarations.size(); i != benv.size(); i = i + 1) {
			Type t = benv.type(i);
			declarations.add(new BytecodeForest.Register(t, null));
		}
		// Create concrete type for private lambda function
		Type.FunctionOrMethod cfm;
		if (tfm instanceof Type.Function) {
			cfm = Type.Function(tfm.returns(), paramTypes);
		} else {
			cfm = Type.Method(tfm.returns(), paramTypes);
		}

		// Construct private lambda function using generated body
		int id = expr.attribute(Attribute.Source.class).start;
		String name = "$lambda" + id;
		ArrayList<Modifier> modifiers = new ArrayList<Modifier>();
		modifiers.add(Modifier.PRIVATE);
		WyilFile.FunctionOrMethod lambda = new WyilFile.FunctionOrMethod(modifiers, name, cfm, bodyForest, 0, 0,
				attributes(expr));
		lambdas.add(lambda);
		Path.ID mid = context.file().module;
		NameID nid = new NameID(mid, name);

		// Finally, create the lambda
		int target = environment.allocate(tfm);
		block.add(new Bytecode.Lambda(cfm, target, toIntArray(operands), nid), attributes(expr));
		return target;
	}

	private int generate(Expr.ConstantAccess expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) throws ResolveError {
		Constant val = expr.value;
		int target = environment.allocate(val.type());
		block.add(new Bytecode.Const(target, val), attributes(expr));
		return target;
	}

	private int generate(Expr.LocalVariable expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) throws ResolveError {

		if (environment.get(expr.var) != null) {
			int target = environment.get(expr.var);
			Type type = expr.result().raw();
			return target;
		} else {
			syntaxError(errorMessage(VARIABLE_POSSIBLY_UNITIALISED), context, expr);
			return -1;
		}
	}

	private int generate(Expr.UnOp expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		int[] operands = new int[] { generate(expr.mhs, environment, block, forest, context) };
		int[] targets = new int[] { environment.allocate(expr.result().raw()) };
		switch (expr.op) {
		case NEG:
			block.add(new Bytecode.Operator(expr.result().raw(), targets, operands, Bytecode.OperatorKind.NEG),
					attributes(expr));
			break;
		case INVERT:
			block.add(new Bytecode.Operator(expr.result().raw(), targets, operands, Bytecode.OperatorKind.BITWISEINVERT),
					attributes(expr));
			break;
		case NOT:
			block.add(new Bytecode.Operator(expr.result().raw(), targets, operands, Bytecode.OperatorKind.NOT),
					attributes(expr));
			break;
		case ARRAYLENGTH:
			block.add(new Bytecode.Operator(expr.type.raw(), targets, operands, Bytecode.OperatorKind.ARRAYLENGTH), attributes(expr));
			break;
		default:
			// should be dead-code
			internalFailure("unexpected unary operator encountered", context, expr);
			return -1;
		}
		return targets[0];
	}

	private int generate(Expr.Dereference expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		int[] operands = new int[] { generate(expr.src, environment, block, forest, context) };
		int[] targets = new int[] { environment.allocate(expr.result().raw()) };
		block.add(new Bytecode.Operator(expr.srcType.raw(), targets, operands, Bytecode.OperatorKind.DEREFERENCE),
				attributes(expr));
		return targets[0];
	}

	private int generate(Expr.IndexOf expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		int[] operands = { generate(expr.src, environment, block, forest, context),
				generate(expr.index, environment, block, forest, context) };
		int[] targets = new int[] { environment.allocate(expr.result().raw()) };
		block.add(new Bytecode.Operator(expr.srcType.raw(), targets, operands, Bytecode.OperatorKind.ARRAYINDEX), attributes(expr));
		return targets[0];
	}

	private int generate(Expr.Cast expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		int operand = generate(expr.expr, environment, block, forest, context);
		Type from = expr.expr.result().raw();
		Type to = expr.result().raw();
		int target = environment.allocate(to);
		block.add(new Bytecode.Convert(from, target, operand, to), attributes(expr));
		return target;
	}

	private int generate(Expr.BinOp v, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) throws Exception {
		// could probably use a range test for this somehow
		if(v.op == Expr.BOp.AND || v.op == Expr.BOp.OR) {
			String trueLabel = freshLabel();
			String exitLabel = freshLabel();
			generateCondition(trueLabel, v, environment, block, forest, context);
			int target = environment.allocate(Type.T_BOOL);
			block.add(new Bytecode.Const(target, Constant.Bool(false)), attributes(v));
			block.add(new Bytecode.Goto(exitLabel));
			block.add(new Bytecode.Label(trueLabel));
			block.add(new Bytecode.Const(target, Constant.Bool(true)), attributes(v));
			block.add(new Bytecode.Label(exitLabel));
			return target;
		} else {
			Type result = v.result().raw();
			int[] targets = new int[] { environment.allocate(result) };
			int[] operands = { 
					generate(v.lhs, environment, block, forest, context),
					generate(v.rhs, environment, block, forest, context) 
			};

			block.add(new Bytecode.Operator(result, targets, operands, OP2BOP(v.op, v, context)), attributes(v));

			return targets[0];
		}
	}

	private int generate(Expr.ArrayInitialiser expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		int[] operands = generate(expr.arguments, environment, block, forest, context);
		int[] targets = new int[] { environment.allocate(expr.result().raw()) };
		block.add(new Bytecode.Operator(expr.type.raw(), targets, operands, Bytecode.OperatorKind.ARRAYCONSTRUCTOR),
				attributes(expr));
		return targets[0];
	}

	private int generate(Expr.ArrayGenerator expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		int[] operands = new int[] { generate(expr.element, environment, block, forest, context),
				generate(expr.count, environment, block, forest, context) };
		int[] targets = new int[] { environment.allocate(expr.result().raw()) };
		block.add(new Bytecode.Operator(expr.type.raw(), targets, operands, Bytecode.OperatorKind.ARRAYGENERATOR), attributes(expr));
		return targets[0];
	}

	private int generate(Expr.Quantifier e, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		String trueLabel = freshLabel();
		String exitLabel = freshLabel();
		generateCondition(trueLabel, e, environment, block, forest, context);
		int target = environment.allocate(Type.T_BOOL);
		block.add(new Bytecode.Const(target, Constant.Bool(false)), attributes(e));
		block.add(new Bytecode.Goto(exitLabel));
		block.add(new Bytecode.Label(trueLabel));
		block.add(new Bytecode.Const(target, Constant.Bool(true)), attributes(e));
		block.add(new Bytecode.Label(exitLabel));
		return target;
	}

	private int generate(Expr.Record expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		ArrayList<String> keys = new ArrayList<String>(expr.fields.keySet());
		Collections.sort(keys);
		int[] operands = new int[expr.fields.size()];
		for (int i = 0; i != operands.length; ++i) {
			String key = keys.get(i);
			Expr arg = expr.fields.get(key);
			operands[i] = generate(arg, environment, block, forest, context);
		}
		int[] targets = new int[] { environment.allocate(expr.result().raw()) };
		block.add(new Bytecode.Operator(expr.result().raw(), targets, operands, Bytecode.OperatorKind.RECORDCONSTRUCTOR),
				attributes(expr));
		return targets[0];
	}

	private int generate(Expr.FieldAccess expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		int operand = generate(expr.src, environment, block, forest, context);
		int target = environment.allocate(expr.result().raw());
		block.add(new Bytecode.FieldLoad((Type.EffectiveRecord) expr.srcType.raw(), target, operand, expr.name),
				attributes(expr));
		return target;
	}

	private int generate(Expr.New expr, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) throws ResolveError {
		int[] operands = new int[] { generate(expr.expr, environment, block, forest, context) };
		int[] targets = new int[] { environment.allocate(expr.result().raw()) };
		block.add(new Bytecode.Operator(expr.type.raw(), targets, operands, Bytecode.OperatorKind.NEW));
		return targets[0];
	}

	private int[] generate(List<Expr> arguments, Environment environment, BytecodeForest.Block block, BytecodeForest forest,
			Context context) {
		int[] operands = new int[arguments.size()];
		for (int i = 0; i != operands.length; ++i) {
			Expr arg = arguments.get(i);
			operands[i] = generate(arg, environment, block, forest, context);
		}
		return operands;
	}

	// =========================================================================
	// Helpers
	// =========================================================================

	private Bytecode.OperatorKind OP2BOP(Expr.BOp bop, SyntacticElement elem, Context context) {
		switch (bop) {
		case ADD:
			return Bytecode.OperatorKind.ADD;
		case SUB:
			return Bytecode.OperatorKind.SUB;
		case MUL:
			return Bytecode.OperatorKind.MUL;
		case DIV:
			return Bytecode.OperatorKind.DIV;
		case REM:
			return Bytecode.OperatorKind.REM;
		case EQ:
			return Bytecode.OperatorKind.EQ;
		case NEQ:
			return Bytecode.OperatorKind.NEQ;
		case LT:
			return Bytecode.OperatorKind.LT;
		case LTEQ:
			return Bytecode.OperatorKind.LTEQ;
		case GT:
			return Bytecode.OperatorKind.GT;
		case GTEQ:
			return Bytecode.OperatorKind.GTEQ;
		case BITWISEAND:
			return Bytecode.OperatorKind.BITWISEAND;
		case BITWISEOR:
			return Bytecode.OperatorKind.BITWISEOR;
		case BITWISEXOR:
			return Bytecode.OperatorKind.BITWISEXOR;
		case LEFTSHIFT:
			return Bytecode.OperatorKind.LEFTSHIFT;
		case RIGHTSHIFT:
			return Bytecode.OperatorKind.RIGHTSHIFT;
		default:
			syntaxError(errorMessage(INVALID_BINARY_EXPRESSION), context, elem);
		}
		// dead-code
		return null;
	}

	@SuppressWarnings("incomplete-switch")
	private static Expr invert(Expr e) {
		if (e instanceof Expr.BinOp) {
			Expr.BinOp bop = (Expr.BinOp) e;
			Expr.BinOp nbop = null;
			switch (bop.op) {
			case AND:
				nbop = new Expr.BinOp(Expr.BOp.OR, invert(bop.lhs), invert(bop.rhs), e.attributes());
				break;
			case OR:
				nbop = new Expr.BinOp(Expr.BOp.AND, invert(bop.lhs), invert(bop.rhs), e.attributes());
				break;
			case EQ:
				nbop = new Expr.BinOp(Expr.BOp.NEQ, bop.lhs, bop.rhs, e.attributes());
				break;
			case NEQ:
				nbop = new Expr.BinOp(Expr.BOp.EQ, bop.lhs, bop.rhs, e.attributes());
				break;
			case LT:
				nbop = new Expr.BinOp(Expr.BOp.GTEQ, bop.lhs, bop.rhs, e.attributes());
				break;
			case LTEQ:
				nbop = new Expr.BinOp(Expr.BOp.GT, bop.lhs, bop.rhs, e.attributes());
				break;
			case GT:
				nbop = new Expr.BinOp(Expr.BOp.LTEQ, bop.lhs, bop.rhs, e.attributes());
				break;
			case GTEQ:
				nbop = new Expr.BinOp(Expr.BOp.LT, bop.lhs, bop.rhs, e.attributes());
				break;
			}
			if (nbop != null) {
				nbop.srcType = bop.srcType;
				return nbop;
			}
		} else if (e instanceof Expr.UnOp) {
			Expr.UnOp uop = (Expr.UnOp) e;
			switch (uop.op) {
			case NOT:
				return uop.mhs;
			}
		}

		Expr.UnOp r = new Expr.UnOp(Expr.UOp.NOT, e);
		r.type = Nominal.T_BOOL;
		return r;
	}
	
	/**
	 * This resets the environment so that all variable names refer to those
	 * variables indicated in the given list of declared registers. This flushes
	 * out any unwanted assignments of variable names to temporary registers
	 * which can occur when we have multiple variables with the same name. 
	 * 
	 * @param environment
	 * @param declarations
	 * @return
	 */
	public Environment resetEnvironment(Environment environment, List<BytecodeForest.Register> declarations) {
		Environment nenv = new Environment();
		for(int i=0;i!=declarations.size();++i) {
			BytecodeForest.Register reg = declarations.get(i);
			nenv.allocate(reg.type(),reg.name());
		}
		for(int i=declarations.size();i<environment.size();++i) {
			nenv.allocate(environment.type(i));
		}
		return nenv;
	}
	
	/**
	 * Construct the set of variable declarations for a given list of variables.
	 *
	 * @param block
	 * @param declarations
	 */
	public void buildVariableDeclarations(List<Stmt> block, List<BytecodeForest.Register> declarations,
			Environment environment, WhileyFile.Context context) {
		//
		for (int i = 0; i != block.size(); ++i) {
			buildVariableDeclarations(block.get(i), declarations, environment, context);
		}
	}

	public void buildVariableDeclarations(Stmt stmt, List<BytecodeForest.Register> declarations, Environment environment,
			WhileyFile.Context context) {
		if (stmt instanceof Assign || stmt instanceof Assert || stmt instanceof Assume || stmt instanceof Return
				|| stmt instanceof Debug || stmt instanceof Fail || stmt instanceof Break || stmt instanceof Continue
				|| stmt instanceof Expr.MethodCall || stmt instanceof Expr.IndirectMethodCall
				|| stmt instanceof Expr.FunctionCall || stmt instanceof Expr.IndirectFunctionCall
				|| stmt instanceof Expr.New || stmt instanceof Skip) {
			// Don't need to do anything in these cases.
			return;
		} else if (stmt instanceof VariableDeclaration) {
			VariableDeclaration d = (VariableDeclaration) stmt;
			declarations.add(new BytecodeForest.Register(d.type.nominal(), d.parameter.name));
			environment.allocate(d.type.raw(), d.parameter.name);
		} else if (stmt instanceof IfElse) {
			IfElse s = (IfElse) stmt;
			buildVariableDeclarations(s.trueBranch, declarations, environment, context);
			buildVariableDeclarations(s.falseBranch, declarations, environment, context);
		} else if (stmt instanceof Switch) {
			Switch s = (Switch) stmt;
			for (Stmt.Case c : s.cases) {
				buildVariableDeclarations(c.stmts, declarations, environment, context);
			}
		} else if (stmt instanceof While) {
			While s = (While) stmt;
			buildVariableDeclarations(s.body, declarations, environment, context);
		} else if (stmt instanceof DoWhile) {
			DoWhile s = (DoWhile) stmt;
			buildVariableDeclarations(s.body, declarations, environment, context);
		} else {
			// should be dead-code
			WhileyFile.internalFailure("unknown statement: " + stmt.getClass().getName(), context, stmt);
		}
	}

	/**
	 * The attributes method extracts those attributes of relevance to WyIL, and
	 * discards those which are only used for the wyc front end.
	 *
	 * @param elem
	 * @return
	 */
	private static List<wyil.lang.Attribute> attributes(SyntacticElement elem) {
		ArrayList<wyil.lang.Attribute> attrs = new ArrayList<wyil.lang.Attribute>();
		Attribute.Source s = elem.attribute(Attribute.Source.class);
		if (s != null) {
			// TODO: need to identify the file here
			attrs.add(new wyil.attributes.SourceLocation(0, s.start, s.end));
		}
		return attrs;
	}

	public List<Integer> toIntegerList(int... items) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i != items.length; ++i) {
			list.add(items[i]);
		}
		return list;
	}

	private int[] toIntArray(List<Integer> items) {
		int[] arr = new int[items.size()];
		for(int i=0;i!=arr.length;++i) {
			arr[i] = items.get(i);
		}
		return arr;
	}
	
	private static int _idx=0;
	public static String freshLabel() {
		return "blklab" + _idx++;
	}

	
	/**
	 * Maintains a mapping from Variable names to their allocated register slot,
	 * and their declared types.
	 *
	 * @author David J. Pearce
	 *
	 */
	public static final class Environment {
		private final HashMap<String, Integer> var2idx;
		private final ArrayList<Type> idx2type;

		public Environment() {
			var2idx = new HashMap<String, Integer>();
			idx2type = new ArrayList<Type>();
		}

		public Environment(Environment env) {
			var2idx = new HashMap<String, Integer>(env.var2idx);
			idx2type = new ArrayList<Type>(env.idx2type);
		}

		public int allocate(Type t) {
			int idx = idx2type.size();
			idx2type.add(t);
			return idx;
		}

		public int allocate(Type t, String v) {
			int r = allocate(t);
			var2idx.put(v, r);
			return r;
		}

		public int size() {
			return idx2type.size();
		}

		public Integer get(String v) {
			return var2idx.get(v);
		}

		public String get(int idx) {
			for (Map.Entry<String, Integer> e : var2idx.entrySet()) {
				int jdx = e.getValue();
				if (jdx == idx) {
					return e.getKey();
				}
			}
			return null;
		}

		public Type type(int idx) {
			return idx2type.get(idx);
		}

		public void put(int idx, String v) {
			var2idx.put(v, idx);
		}

		public ArrayList<BytecodeForest.Register> asRegisters() {
			ArrayList<BytecodeForest.Register> registers = new ArrayList<BytecodeForest.Register>();
			for (int i = 0; i != idx2type.size(); ++i) {
				Type t = idx2type.get(i);
				registers.add(new BytecodeForest.Register(t, get(i)));
			}
			return registers;
		}

		public String toString() {
			return idx2type.toString() + "," + var2idx.toString();
		}
	}

	private <T extends Scope> T findEnclosingScope(Class<T> c) {
		for (int i = scopes.size() - 1; i >= 0; --i) {
			Scope s = scopes.get(i);
			if (c.isInstance(s)) {
				return (T) s;
			}
		}
		return null;
	}

	/**
	 * Respresents the scope of a statement or block (e.g. for a While or For
	 * loop). The allows additional information to be retained about that scope
	 * and passed down to statements which need it (e.g. break / continued
	 * statements). It also allows such statements to determine what the
	 * "nearest" enclosing scope is.
	 *
	 * @author David J. Pearce
	 *
	 */
	private abstract class Scope {
	}

	/**
	 * A scope representing a given loop statement, allowing contained
	 * statements to determine where the break and continue statements should be
	 * directed.
	 *
	 *
	 * @author David J. Pearce
	 *
	 */
	private class LoopScope extends Scope {
		public final String continueLabel;
		public final String breakLabel;

		public LoopScope(String cl, String bl) {
			continueLabel = cl;
			breakLabel = bl;
		}
	}
}
