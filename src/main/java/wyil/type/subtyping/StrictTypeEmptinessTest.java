// Copyright 2011 The Whiley Project Developers
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package wyil.type.subtyping;

import static wyil.lang.WyilFile.SEMTYPE_array;
import static wyil.lang.WyilFile.SEMTYPE_difference;
import static wyil.lang.WyilFile.SEMTYPE_intersection;
import static wyil.lang.WyilFile.SEMTYPE_record;
import static wyil.lang.WyilFile.SEMTYPE_reference;
import static wyil.lang.WyilFile.SEMTYPE_union;
import static wyil.lang.WyilFile.TYPE_any;
import static wyil.lang.WyilFile.TYPE_array;
import static wyil.lang.WyilFile.TYPE_bool;
import static wyil.lang.WyilFile.TYPE_byte;
import static wyil.lang.WyilFile.TYPE_function;
import static wyil.lang.WyilFile.TYPE_int;
import static wyil.lang.WyilFile.TYPE_method;
import static wyil.lang.WyilFile.TYPE_nominal;
import static wyil.lang.WyilFile.TYPE_null;
import static wyil.lang.WyilFile.TYPE_property;
import static wyil.lang.WyilFile.TYPE_record;
import static wyil.lang.WyilFile.TYPE_recursive;
import static wyil.lang.WyilFile.TYPE_reference;
import static wyil.lang.WyilFile.TYPE_staticreference;
import static wyil.lang.WyilFile.TYPE_union;
import static wyil.lang.WyilFile.TYPE_variable;
import static wyil.lang.WyilFile.TYPE_void;

import java.util.ArrayList;
import java.util.Arrays;

import wybs.util.AbstractCompilationUnit.Identifier;
import wybs.util.AbstractCompilationUnit.Name;
import wybs.util.AbstractCompilationUnit.Tuple;
import wyil.lang.WyilFile.Decl;
import wyil.lang.WyilFile.SemanticType;
import wyil.lang.WyilFile.Type;
import wyil.type.util.BinaryRelation;
import wyil.type.util.HashSetBinaryRelation;

/**
 * <p>
 * The subtype operator implements the algorithm for determining whether or not
 * one type is a <i>subtype</i> of another. For the most part, one can take
 * subtype to mean <i>subset</i> (this analogy breaks down with function types,
 * however). Following this analogy, <code>T1</code> is a subtype of
 * <code>T2</code> (denoted <code>T1 <: T2</code>) if the set of values
 * represented by <code>T1</code> is a subset of those represented by
 * <code>T2</code>. Subtyping in Whiley is surprisingly complex due to the
 * presence of the three type combinators, namely: <i>union</i>,
 * <i>intersection</i> and <i>negations</i>. This requires one to distinguish
 * between <i>syntactic types</i> and <i>semantic types</i>: the former
 * corresponds to a finite representation, such as found in a Whiley source file
 * or represented internally within the compiler, whereas the latter corresponds
 * to a mathematical ideal with which we can coinductively formulate the subtype
 * operator. We now highlight some of the main points:
 * </p>
 * <p>
 * <b>Algebraic Reasoning.</b> Subtyping must respect the standard algebraic
 * rules for reasoning about unions, intersections and negations. For example,
 * "<code>T|T</code>" is equivalent to "<code>T</code>". Likewise,
 * "<code>T1&(T2|T3)</code>" is equivalent to "<code>(T1&T2)|(T1&T3)</code>"
 * whilst "<code>!(T1|T2)</code>" is equivalent to "<code>(!T1)&(!T2)</code>".
 * Some additional rules exist which are perhaps less obvious. For example,
 * "<code>{T1|T2 f}</code>" is (in some sense) equivalent to
 * "<code>{T1 f}|{T2 f}</code>".
 * </p>
 * <p>
 * <b>Coinductive Reasoning.</b> Types in Whiley are defined <i>inductively</i>
 * as recursive types. The following illustrates the syntax:
 * </p>
 *
 * <pre>
 * type blist is null | { bool data, blist next }
 * </pre>
 *
 * <p>
 * The set of values accepted by the type <code>blist</code> is given by
 * "<code>null</code>", "<code>{data:true, list:null}</code>",
 * "<code>{data:true, list:{data:true, list:null}}</code>", etc. Whilst types
 * are defined inductively, the subtyping operator is defined
 * <i>coninductively</i>. For example, consider this type:
 * </p>
 *
 * <pre>
 * type alist is { any data, alist next }
 * </pre>
 *
 * <p>
 * Intuitively, it follows that <code>blist</code> is a subtype of
 * <code>alist</code>. However, mechanically, this is not at all obvious. To
 * understand this, consider the derivation of <code>blist <: alist</code> given
 * below:
 * </p>
 *
 * <pre>
 * blist <: alist
 * = (null|{bool data, blist next}) <: (null|{any data, alist next})
 *
 * case (i)
 *   = null <: (null|{any data, alist next})
 *   = null <: null
 *
 * case (ii)
 *   = {bool data, blist next} <: (null|{any data, alist next})
 *   = {bool data, blist next} <: {any data, alist next}
 *   = bool <: any && blist <: alist
 *   = blist <: alist
 * </pre>
 * <p>
 * The problem here is that testing whether <code>blist <: alist</code> holds
 * reduces to the question of whether <code>blist <: alist</code> holds! This is
 * resolved by coinductively assuming that it holds <i>unless it can be shown
 * otherwise.</i>
 * </p>
 * <p>
 * <b>Contractivity.</b> Non-contractive types are those which are non-sensical,
 * and we cannot reason safely about such types. For example:
 * </p>
 *
 * <pre>
 *  type Invisible is Invisible | Invisible
 * </pre>
 * <p>
 * This type does not sensibly describe an actual type as it never actually
 * describes the structure of a value. Hence, the compiler should detect this
 * and report an error.
 * </p>
 *
 * <p>
 * <b>Emptiness.</b> Some types are said to be <i>empty</i> as they contain no
 * instances. The most prominent example is the <code>void</code> type.
 * Likewise, <code>!any</code> is equivalent to <code>void</code>. Indeed, there
 * are an infinite number of empty types in Whiley. The following illustrates
 * one of the more esoteric examples:
 * </p>
 *
 * <pre>
 *  type InfList is { int data, InfList next }
 *
 *  function get(InfList l) -> (int d, InfList r):
 *     return l.data, l.next
 * </pre>
 * <p>
 * In languages with lazy evaluation or implicit references, such a type would
 * be perfectly reasonable. However, in Whiley, all values are trees of finite
 * depth and, hence, it is impossible construct a value of type
 * <code>InfList</code>. Again, the compiler should detect this and report an
 * error in such case.
 * </p>
 * <p>
 * <b>Implementation Overview.</b> The algorithm actually operates by computing
 * the <i>intersection</i> relation for two types (i.e. whether or not an
 * intersection exists between their set of values). Subtyping is closely
 * related to intersection and, in fact, we have that <code>T1 :> T2</code> iff
 * <code>!(!T1 & T2)</code> (where <code>&</code> is the intersection relation).
 * The choice to compute intersections, rather than subtypes, was for
 * simplicity. Namely, it was considered conceptually easier to think about
 * intersections rather than subtypes.
 * </p>
 * <h3>References</h3>
 * <ul>
 * <li>
 * <p>
 * <b>Sound and Complete Flow Typing with Unions, Intersections and
 * Negations</b>. David J. Pearce. In Proceedings of the Conference on
 * Verification, Model Checking, and Abstract Interpretation (VMCAI), volume
 * 7737 of Lecture Notes in Computer Science, pages 335--354, 2013.
 * </p>
 * </li>
 * <li>
 * <p>
 * <b>A Mechanical Soundness Proof for Subtyping over Recursive Types</b>.
 * Timothy Jones and David J. Pearce. In Proceedings of the Workshop on Formal
 * Techniques for Java-like Languages (FTFJP), 2016.
 * </p>
 * </li>
 * <li>
 * <p>
 * <b>Rewriting for Sound and Complete Union, Intersection and Negation
 * Types</b>. David J. Pearce. In Proceedings of the Conference on Generative
 * Programming: Concepts & Experience (GPCE), 2017.
 * </p>
 * </li>
 * </ul>
 *
 * @see SubtypeOperator
 * @author David J. Pearce
 *
 */
public class StrictTypeEmptinessTest implements EmptinessTest<SemanticType> {

	@Override
	public boolean isVoid(SemanticType lhs, EmptinessTest.State lhsState, SemanticType rhs,
			EmptinessTest.State rhsState, LifetimeRelation lifetimes) {
		// FIXME: this is really temporary for now.
		Term<?> lhsTerm = new Term<>(lhs, lhsState);
		Term<?> rhsTerm = new Term<>(rhs, rhsState);
		HashSetBinaryRelation<Term<?>> assumptions = new HashSetBinaryRelation<>();
		return isVoidTerm(lhsTerm, rhsTerm, assumptions, lifetimes);
	}

	protected boolean isVoidTerm(Term<?> lhs, Term<?> rhs, BinaryRelation<Term<?>> assumptions,
			LifetimeRelation lifetimes) {
		//
		if (assumptions.get(lhs, rhs)) {
			// This represents the "coinductive" case. That is, we have
			// encountered a pair of recursive types whose "voidness" depends
			// circularly on itself. In such case, we assume they are indeed
			// void.
			return true;
		} else {
			assumptions.set(lhs, rhs, true);
			ArrayList<Atom<?>> truths = new ArrayList<>();
			Worklist worklist = new Worklist();
			worklist.push(lhs);
			worklist.push(rhs);
			boolean r = isVoid(truths, worklist, assumptions, lifetimes);
			assumptions.set(lhs, rhs, false);
			return r;
		}
	}

	/**
	 * Determine whether or not the intersection of a given list of types (the
	 * worklist) reduces to void or not. This is performed in the context of a
	 * number of ground "atoms" which are known to hold. In essence, this algorithm
	 * exhaustively expands all items on the worklist to form atoms. The expanded
	 * atoms are then checked for consistency.
	 *
	 * is type is equivalent to void. This is a relatively complex operation which
	 * builds up a list of clauses known to hold.
	 *
	 * @param truths
	 *            The set of truths which have been established.
	 * @param worklist
	 *            The set of types currently being expanded
	 * @param assumptions
	 *            The set of assumed subtype relationships
	 * @return @
	 */
	protected boolean isVoid(ArrayList<Atom<?>> truths, Worklist worklist, BinaryRelation<Term<?>> assumptions,
			LifetimeRelation lifetimes) {
		// FIXME: there is a bug in the following case which needs to be
		// addressed:
		//
		// {int|null f} & !{int f} & !{null f}
		//
		// The problem is that we need the "pairwise consistency property" in
		// order for this algorithm to be complete. To get that, we must expand
		// records containing union types. Thus, the above should be expanded
		// to:
		//
		// ({int f} & !{int f} & !{null f}) || ({null f} & !{int f} & !{null f})
		//
		// This will now produce the correct result.

		if (worklist.size() == 0) {
			// At this point, we have run out of terms to expand further.
			// Therefore, we have accumulated the complete list of "truths" and
			// we must now attempt to establish whether or not this is
			// consistent. For example, "int & !bool & !int" is not consistent
			// because "int & !int" is not consistent.
			//
			// Therefore, we consider each possible pair of truths looking for
			// consistency.
			//
			for (int i = 0; i != truths.size(); ++i) {
				Atom<?> ith = truths.get(i);
				for (int j = i + 1; j != truths.size(); ++j) {
					Atom<?> jth = truths.get(j);
					if (isVoidAtom(ith, jth, assumptions, lifetimes)) {
						return true;
					}
				}
			}
			return false;
		} else {
			// In this case, we still have items on the worklist which need to
			// be processed. That is, broken down into "atomic" terms.
			Term<SemanticType> item = worklist.pop();
			SemanticType t = item.type;
			//
			boolean conjunct = item.sign;
			switch (t.getOpcode()) {
			case SEMTYPE_union:
			case TYPE_union:
				conjunct = !conjunct;
			case SEMTYPE_intersection: {
				Type.Combinator ut = (Type.Combinator) t;
				if (conjunct) {
					worklist.push(ut.getAll(), item);
				} else {
					return isVoidDisjunction(ut, item, truths, worklist, assumptions, lifetimes);
				}
				break;
			}
			case SEMTYPE_difference: {
				SemanticType.Difference nt = (SemanticType.Difference) t;
				worklist.push(nt.getLeftHandSide(), item);
				worklist.push(nt.getRightHandSide(), item.invert());
				break;
			}
			case TYPE_nominal: {
				Type.Nominal nom = (Type.Nominal) t;
				Decl.Link<Decl.Type> link = nom.getLink();
				if (link.isResolved()) {
					Decl.Type decl = link.getTarget();
					if (item.maximise || decl.getInvariant().size() == 0) {
						// Push everything, including the type variables and arguments for any binding.
						worklist.push(nom.getConcreteType(), item);
					} else if (item.sign) {
						// Corresponds to void, so we're done on this path.
						return true;
					}
				} else {
					// Error recovery case. Basically return a conservative result since we don't
					// know what the type in question is.
					return false;
				}
				break;
			}
			case TYPE_recursive: {
				Type.Recursive rec = (Type.Recursive) t;
				worklist.push(rec.getHead(), item);
				break;
			}
			default:
				truths.add(new Atom((SemanticType.Atom) item.type, item));
			}
			return isVoid(truths, worklist, assumptions, lifetimes);
		}
	}

	protected boolean isVoidDisjunction(Type.Combinator combinator, Context context,
			ArrayList<Atom<?>> truths, Worklist worklist, BinaryRelation<Term<?>> assumptions,
			LifetimeRelation lifetimes) {
		SemanticType[] operands = combinator.getAll();
		for (int i = 0; i != operands.length; ++i) {
			Worklist tmp = worklist.clone();
			tmp.push(operands[i], context);
			if (!isVoid((ArrayList<Atom<?>>) truths.clone(), tmp, assumptions, lifetimes)) {
				// If a single clause of the disjunct is definitely
				// not void, then the whole thing is not void.
				return false;
			}
		}
		return true;
	}

	protected Name[] append(Name[] lhs, Name rhs) {
		if (rhs == null) {
			return lhs;
		} else {
			lhs = Arrays.copyOf(lhs, lhs.length + 1);
			lhs[lhs.length - 1] = rhs;
			return lhs;
		}
	}

	/**
	 * Determine whether the intersection of two arbitrary atoms results in void or
	 * not. Each atom is either a "positive" or "negative" term. The latter
	 * corresponds to negated terms, such as !int or !{int f}.
	 *
	 * @param a
	 * @param b
	 * @param assumptions
	 *            The set of assumed subtype relationships
	 * @return @
	 */
	@SuppressWarnings("unchecked")
	protected boolean isVoidAtom(Atom<?> a, Atom<?> b, BinaryRelation<Term<?>> assumptions,
			LifetimeRelation lifetimes) {
		// At this point, we have several cases left to consider.
		boolean aSign = a.sign;
		boolean bSign = b.sign;
		int aOpcode = a.type.getOpcode();
		int bOpcode = b.type.getOpcode();
		// Normalise the opcodes for convenience
		aOpcode = normaliseOpcode(aOpcode);
		bOpcode = normaliseOpcode(bOpcode);
		//
		if (aOpcode == bOpcode) {
			// In this case, we are intersecting two atoms of the same kind, of
			// which at least one is positive. For primitive types, this reduces
			// to void is one of them is negative. For non-primitive types, it
			// requires further investigation.
			switch (aOpcode) {
			case TYPE_void:
				// void & void => void
				// !void & void => void
				return true;
			case TYPE_any:
			case TYPE_null:
			case TYPE_bool:
			case TYPE_byte:
			case TYPE_int:
				// any & !any => void
				// int & !int => void
				return (aSign != bSign) ? true : false;
			case SEMTYPE_array:
				return isVoidArray((Atom<SemanticType.Array>) a, (Atom<SemanticType.Array>) b, assumptions, lifetimes);
			case SEMTYPE_record:
				return isVoidRecord((Atom<SemanticType.Record>) a, (Atom<SemanticType.Record>) b, assumptions,
						lifetimes);
			case SEMTYPE_reference:
				return isVoidReference((Atom<SemanticType.Reference>) a, (Atom<SemanticType.Reference>) b, assumptions,
						lifetimes);
			case TYPE_function:
			case TYPE_method:
			case TYPE_property:
				return isVoidCallable((Atom<Type.Callable>) a, (Atom<Type.Callable>) b, assumptions, lifetimes);
			case TYPE_variable:
				return isVoidVariable((Atom<Type.Variable>) a, (Atom<Type.Variable>) b, assumptions, lifetimes);
			default:
				throw new RuntimeException("invalid type encountered: " + a);
			}
		} else if (aSign && bSign) {
			// We have two positive atoms of different kind. For example, int
			// and {int f}, or int and bool. This always reduces to void,
			// unless one of them is any.
			return (aOpcode != TYPE_any && bOpcode != TYPE_any) ? true : false;
		} else if (aSign) {
			// We have a positive atom and a negative atom of different kinds.
			// For example, int and !bool or int and !(bool[]). This only
			// reduces to void in the case that one of them is equivalent to
			// void (i.e. is void or !any).
			return (aOpcode == TYPE_void || bOpcode == TYPE_any) ? true : false;
		} else if (bSign) {
			// We have a negative atom and a positive atom of different kinds.
			// For example, !int and bool or !(int[]) and bool[]. This only
			// reduces to void in the case that one of them is equivalent to
			// void (i.e. is void or !any).
			return (aOpcode == TYPE_any || bOpcode == TYPE_void) ? true : false;
		} else {
			// We have two negative atoms of different kinds. For example, !int
			// and !bool or !int[] and !bool. This only reduces to void in the
			// case that one of them is equivalent to void (i.e. is !any).
			return (aOpcode == TYPE_any || bOpcode == TYPE_any) ? true : false;
		}
	}

	private static int normaliseOpcode(int opcode) {
		switch (opcode) {
		case TYPE_array:
			return SEMTYPE_array;
		case TYPE_record:
			return SEMTYPE_record;
		case TYPE_reference:
		case TYPE_staticreference:
			return SEMTYPE_reference;
		case TYPE_union:
			return SEMTYPE_union;
		case TYPE_method:
			return TYPE_function;
		}
		return opcode;
	}

	/**
	 * <p>
	 * Determine whether the intersection of two array types is void or not. For
	 * example, <code>int[]</code> intersecting with <code>bool[]</code> gives void.
	 * In contrast, intersecting <code>(int|null)[]</code> with <code>int[]</code>
	 * does not give void. Likewise, <code>int[]</code> intersecting with
	 * <code>!(int[])</code> gives void, whilst intersecting <code>int[]</code> with
	 * <code>!(bool[])</code> does not give void.
	 * </p>
	 *
	 * @param lhsSign
	 *            The sign of the first type being intersected. If true, we have a
	 *            positive atom. Otherwise, we have a negative atom.
	 * @param lhs.
	 *            The first type being intersected, referred to as the "left-hand
	 *            side".
	 * @param rhsSign
	 *            The sign of the second type being intersected. If true, we have a
	 *            positive atom. Otherwise, we have a negative atom.
	 * @param rhs
	 *            The second type being intersected, referred to as the "right-hand
	 *            side".
	 * @param assumptions
	 *            The set of assumed subtype relationships
	 * @return @
	 */
	protected boolean isVoidArray(Atom<SemanticType.Array> lhs, Atom<SemanticType.Array> rhs,
			BinaryRelation<Term<?>> assumptions, LifetimeRelation lifetimes) {
		Term<?> lhsTerm = new Term<>(lhs.type.getElement(), lhs);
		Term<?> rhsTerm = new Term<>(rhs.type.getElement(), rhs);
		if (lhs.sign && rhs.sign) {
			// In this case, we are intersecting two array types, of which at
			// least one is positive. This is void only if there is no
			// intersection of the underlying element types. For example, int[]
			// and bool[] is void, whilst (int|null)[] and int[] is not. Note that void[]
			// always intersects with another array type regardless and, hence, we must
			// check whether the element type of each is void or not.
			return isVoidTerm(lhsTerm, rhsTerm, assumptions, lifetimes)
					&& !isVoidTerm(lhsTerm, lhsTerm, assumptions, lifetimes)
					&& !isVoidTerm(rhsTerm, rhsTerm, assumptions, lifetimes);
		} else if (lhs.sign || rhs.sign) {
			// int[] & !bool[] != 0, as int & !bool != 0
			// int[] & !int[] == 0, as int & !int == 0
			// void[] & !int[] == 0, as void && !int == 0
			// int[] & !void[] != 0, as int && !void != 0
			return isVoidTerm(lhsTerm, rhsTerm, assumptions, lifetimes);
		} else {
			// In this case, we are intersecting two negative array types. For
			// example, !(int[]) and !(bool[]). This never reduces to void.
			return false;
		}
	}

	/**
	 * <p>
	 * Determine whether the intersection of two record types is void or not. For
	 * example, <code>{int f}</code> intersecting with <code>{int g}</code> gives
	 * void. In contrast, intersecting <code>{int|null f}</code> with
	 * <code>{int f}</code> does not give void. Likewise, <code>{int f}</code>
	 * intersecting with <code>!{int f}</code> gives void, whilst intersecting
	 * <code>{int f}</code> with <code>!{int g}</code> does not give void.
	 * </p>
	 *
	 * @param lhsSign
	 *            The sign of the first type being intersected. If true, we have a
	 *            positive atom. Otherwise, we have a negative atom.
	 * @param lhs.
	 *            The first type being intersected, referred to as the "left-hand
	 *            side".
	 * @param rhsSign
	 *            The sign of the second type being intersected. If true, we have a
	 *            positive atom. Otherwise, we have a negative atom.
	 * @param rhs
	 *            The second type being intersected, referred to as the "right-hand
	 *            side".
	 * @param assumptions
	 *            The set of assumed subtype relationships
	 * @return @
	 */
	protected boolean isVoidRecord(Atom<SemanticType.Record> lhs, Atom<SemanticType.Record> rhs,
			BinaryRelation<Term<?>> assumptions, LifetimeRelation lifetimes) {
		Tuple<? extends SemanticType.Field> lhsFields = lhs.type.getFields();
		Tuple<? extends SemanticType.Field> rhsFields = rhs.type.getFields();
		//
		if (lhs.sign || rhs.sign) {
			// Attempt to match all fields In the positive-positive case this
			// reduces to void if the fields in either of these differ (e.g.
			// {int f} and {int g}), or if there is no intersection between the
			// same field in either (e.g. {int f} and {bool f}).
			int matches = matchRecordFields(lhs, rhs, assumptions, lifetimes);
			//
			if (matches == -1) {
				return lhs.sign == rhs.sign;
			} else {
				return analyseRecordMatches(matches, lhs.sign, lhs.type.isOpen(), lhsFields, rhs.sign,
						rhs.type.isOpen(), rhsFields);
			}
		} else {
			// In this case, we are intersecting two negative record types. For
			// example, !({int f}) and !({int g}). This never reduces to void.
			return false;
		}
	}

	protected int matchRecordFields(Atom<SemanticType.Record> lhs, Atom<SemanticType.Record> rhs,
			BinaryRelation<Term<?>> assumptions, LifetimeRelation lifetimes) {
		Tuple<? extends SemanticType.Field> lhsFields = lhs.type.getFields();
		Tuple<? extends SemanticType.Field> rhsFields = rhs.type.getFields();
		//
		boolean sign = (lhs.sign == rhs.sign);
		int matches = 0;
		//
		for (int i = 0; i != lhsFields.size(); ++i) {
			SemanticType.Field lhsField = lhsFields.get(i);
			Term<?> lhsTerm = new Term<>(lhsField.getType(), lhs);
			for (int j = 0; j != rhsFields.size(); ++j) {
				SemanticType.Field rhsField = rhsFields.get(j);
				if (!lhsField.getName().equals(rhsField.getName())) {
					continue;
				} else {
					Term<?> rhsTerm = new Term<>(rhsField.getType(), rhs);
					if (sign == isVoidTerm(lhsTerm, rhsTerm, assumptions, lifetimes)) {
						// For pos-pos case, there is no intersection
						// between these fields and, hence, no intersection
						// overall; for pos-neg case, there is some
						// intersection between these fields which means
						// that some intersections exists overall. For
						// example, consider the case {int f, int|null g} &
						// !{int f, int g}. There is no intersection for
						// field f (i.e. since int & !int = void), whilst
						// there is an intersection for field g (i.e. since
						// int|null & !int = null). Hence, we can conclude
						// that there is an intersection between them with
						// {int f, null g}.
						return -1;
					} else {
						matches = matches + 1;
					}
				}
			}
		}
		return matches;
	}

	protected boolean analyseRecordMatches(int matches, boolean lhsSign, boolean lhsOpen,
			Tuple<? extends SemanticType.Field> lhsFields, boolean rhsSign, boolean rhsOpen,
			Tuple<? extends SemanticType.Field> rhsFields) {
		// NOTE: Don't touch this method unless you know what you are doing. And, trust
		// me, you don't know what you are doing.
		//
		// Perform comparison
		State lhsState = compare(matches, lhsOpen, lhsFields, rhsOpen, rhsFields);
		// Exhaustive case analysis
		switch (lhsState) {
		case UNCOMPARABLE:
			// {int x} & {int y} == 0
			// {int x, ...} & {int y} == 0
			// {int x, ...} & {int y, ...} != 0
			// {int x} & !{int y} != 0
			// !{int x} & !{int y} != 0
			return lhsSign && rhsSign && !(lhsOpen && rhsOpen);
		case SMALLER:
			// {int x} & {int x, ...} != 0
			// !{int x} & {int x, ...} != 0
			// !{int x} & !{int x, ...} != 0
			// {int x} & !{int x, ...} == 0
			return lhsSign && !rhsSign && rhsOpen;
		case GREATER:
			// {int x, ...} & {int x} != 0
			// {int x, ...} & !{int x} != 0
			// !{int x, ...} & !{int x} != 0
			// !{int x, ...} & {int x} == 0
			return !lhsSign && rhsSign && lhsOpen;
		case EQUAL:
			// {int x} & {int x} != 0
			// {int x, ...} & {int x, ...} != 0
			// {int x} & !{int x} == 0
			// {int x, ...} & !{int x, ...} == 0
			return lhsSign != rhsSign;
		default:
			throw new RuntimeException(); // dead code
		}
	}

	protected enum State {
		EQUAL, UNCOMPARABLE, SMALLER, GREATER
	}

	protected State compare(int matches, boolean lhsOpen, Tuple<? extends SemanticType.Field> lhsFields,
			boolean rhsOpen, Tuple<? extends SemanticType.Field> rhsFields) {
		int lhsSize = lhsFields.size();
		int rhsSize = rhsFields.size();
		//
		if (matches < lhsSize && matches < rhsSize) {
			return State.UNCOMPARABLE;
		} else if (matches < lhsSize) {
			// {int x, int y} != {int x}
			// {int x, int y} << {int x, ...}
			return rhsOpen ? State.SMALLER : State.UNCOMPARABLE;
		} else if (matches < rhsSize) {
			// {int x} != {int x, int y}
			// {int x, ...} >> {int x, int y}
			return lhsOpen ? State.GREATER : State.UNCOMPARABLE;
		} else if (lhsOpen != rhsOpen) {
			// {int x} << {int x, ... }
			// {int x, ...} >> {int x }
			return lhsOpen ? State.GREATER : State.SMALLER;
		} else {
			// {int x,int y} == {int x,int y}
			// {int x, ... } == {int x, ... }
			return State.EQUAL;
		}
	}

	/**
	 * <p>
	 * Determine whether the intersection of two reference types is void or not.
	 * Reference types are "invariant", meaning that element types must match
	 * exactly for an intersection to arise. For example, <code>&int</code>
	 * intersecting with <code>&bool</code> gives void. In contrast, intersecting
	 * <code>&int</code> with <code>&int</code> does not give void. Hoever,
	 * <code>&int</code> intersecting with <code>&(int|bool)</code> gives void.
	 * </p>
	 *
	 * @param lhsSign
	 *            The sign of the first type being intersected. If true, we have a
	 *            positive atom. Otherwise, we have a negative atom.
	 * @param lhs.
	 *            The first type being intersected, referred to as the "left-hand
	 *            side".
	 * @param rhsSign
	 *            The sign of the second type being intersected. If true, we have a
	 *            positive atom. Otherwise, we have a negative atom.
	 * @param rhs
	 *            The second type being intersected, referred to as the "right-hand
	 *            side".
	 * @param assumptions
	 *            The set of assumed subtype relationships
	 * @return @
	 */
	protected boolean isVoidReference(Atom<SemanticType.Reference> lhs, Atom<SemanticType.Reference> rhs,
			BinaryRelation<Term<?>> assumptions, LifetimeRelation lifetimes) {
		String lhsLifetime = extractLifetime(lhs.type);
		String rhsLifetime = extractLifetime(rhs.type);
		// FIXME: need to look at lifetime parameters
		Term<?> lhsTrueTerm = new Term<>(lhs.type.getElement(), lhs.positify());
		Term<?> rhsTrueTerm = new Term<>(rhs.type.getElement(), rhs.positify());
		Term<?> lhsFalseTerm = new Term<>(lhs.type.getElement(), lhs.negatify());
		Term<?> rhsFalseTerm = new Term<>(rhs.type.getElement(), rhs.negatify());
		// Check whether lhs :> rhs (as (!lhs & rhs) == 0)
		boolean elemLhsSubsetRhs = isVoidTerm(lhsFalseTerm, rhsTrueTerm, assumptions, lifetimes);
		// Check whether rhs :> lhs (as (!rhs & lhs) == 0)
		boolean elemRhsSubsetLhs = isVoidTerm(rhsFalseTerm, lhsTrueTerm, assumptions, lifetimes);
		// Check whether lhs within rhs
		boolean lhsWithinRhs = lifetimes.isWithin(lhsLifetime, rhsLifetime);
		// Check whether lhs within rhs
		boolean rhsWithinLhs = lifetimes.isWithin(rhsLifetime, lhsLifetime);
		// Calculate whether lhs == rhs
		boolean elemEqual = elemLhsSubsetRhs && elemRhsSubsetLhs;
		//
		if (lhs.sign && rhs.sign) {
			// (&T1 & &T2) == 0 iff T1 != T2 || !(lhs in rhs || rhs in lhs)
			return !elemEqual || !lhsWithinRhs && !rhsWithinLhs;
		} else if (lhs.sign) {
			// (!(&T1) & &T2) == 0 iff T1 == T2 && T2 in T1
			return elemEqual && rhsWithinLhs;
		} else if (rhs.sign) {
			// (T1 & !(&T2)) == 0 iff T1 == T2 && T1 in T2
			return elemEqual && lhsWithinRhs;
		} else {
			// (!(&T1) & !(&T2)) != 0
			return false;
		}
	}

	private String extractLifetime(SemanticType.Reference ref) {
		if (ref.hasLifetime()) {
			return ref.getLifetime().get();
		} else {
			return "*";
		}
	}

	/**
	 * <p>
	 * Determine whether the intersection of two function types is void or not. For
	 * example, <code>function(int)->(int)</code> intersecting with
	 * <code>function(bool)->(int)</code> gives void. In contrast, intersecting
	 * <code>function(int|null)->(int)</code> with <code>function(int)->(int)</code>
	 * does not give void. Likewise, <code>function(int)->(int)</code> intersecting
	 * with <code>!function(int)->(int)</code> gives void, whilst intersecting
	 * <code>function(int)->(int)</code> with <code>!function(bool)->(int)</code>
	 * does not give void.
	 * </p>
	 *
	 *
	 * @param lhsSign
	 *            The sign of the first type being intersected. If true, we have a
	 *            positive atom. Otherwise, we have a negative atom.
	 * @param lhs.
	 *            The first type being intersected, referred to as the "left-hand
	 *            side".
	 * @param rhsSign
	 *            The sign of the second type being intersected. If true, we have a
	 *            positive atom. Otherwise, we have a negative atom.
	 * @param rhs
	 *            The second type being intersected, referred to as the "right-hand
	 *            side".
	 * @param assumptions
	 *            The set of assumed subtype relationships private boolean @
	 */
	protected boolean isVoidCallable(Atom<Type.Callable> lhs, Atom<Type.Callable> rhs,
			BinaryRelation<Term<?>> assumptions, LifetimeRelation lifetimes) {
		boolean lhsMeth = (lhs.type instanceof Type.Method);
		boolean rhsMeth = (rhs.type instanceof Type.Method);
		//
		// FIXME: this needs to deal properly with lifetime parameters
		//
		if (lhsMeth != rhsMeth && lhsMeth && lhs.sign) {
			// Intersecting positive method (lhs) with positive or negative function (rhs)
			// never gives void. This is because the set of methods includes the set of
			// functions, but not vice-versa.
			return false;
		} else if (lhsMeth != rhsMeth && rhsMeth && rhs.sign) {
			// Intersecting positive method (rhs) with positive or negative function (lhs)
			// never gives void. This is because the set of methods includes the set of
			// functions, but not vice-versa.
			return false;
		} else if (lhs.sign || rhs.sign) {
			// The sign indicates whether were in the pos-pos case, or in the
			// pos-neg case.
			Tuple<Type> lhsParameters = lhs.type.getParameters();
			Tuple<Type> rhsParameters = rhs.type.getParameters();
			Tuple<Type> lhsReturns = lhs.type.getReturns();
			Tuple<Type> rhsReturns = rhs.type.getReturns();
			// FIXME: should maximise be flipped for parameters as well?
			boolean equalParams = isEqualParameters(lhs, lhsParameters, rhs, rhsParameters,
					assumptions, lifetimes);
			boolean equalReturns = isEqualParameters(lhs, lhsReturns, rhs, rhsReturns,
					assumptions, lifetimes);
			// If both parameters and returns are void, then the whole thing is void.
			boolean elemEqual = equalParams && equalReturns;
			//
			if (lhs.sign && rhs.sign) {
				// (&T1 & &T2) == 0 iff T1 != T2
				return !elemEqual;
			} else if (lhs.sign || rhs.sign) {
				// (!(&T1) & &T2) == 0 iff T1 == T2 && T2 in T1
				return elemEqual;
			} else {
				// (!(&T1) & !(&T2)) != 0
				return false;
			}
		} else {
			// In this case, we are intersecting two negative function types.
			// For example, !(function(int)->(int)) and
			// !(function(bool)->(int)). This never reduces to void.
			return false;
		}
	}

	protected boolean isEqualParameters(Context lhsContext, Tuple<Type> lhs, Context rhsContext, Tuple<Type> rhs, BinaryRelation<Term<?>> assumptions, LifetimeRelation lifetimes) {
		//
		if (lhs.size() != rhs.size()) {
			// Different number of parameters. In either pos-pos or neg-neg
			// cases, this reduces to void. Otherwise, it doesn't.
			return false;
		} else {
			//
			for (int i = 0; i != lhs.size(); ++i) {
				Type lhsParameter = lhs.get(i);
				Type rhsParameter = rhs.get(i);
				Term<?> lhsTrueTerm = new Term<>(lhsParameter, lhsContext.positify());
				Term<?> rhsTrueTerm = new Term<>(rhsParameter, rhsContext.positify());
				Term<?> lhsFalseTerm = new Term<>(lhsParameter, lhsContext.negatify());
				Term<?> rhsFalseTerm = new Term<>(rhsParameter, rhsContext.negatify());
				// Check whether lhs :> rhs (as (!lhs & rhs) == 0)
				boolean elemLhsSubsetRhs = isVoidTerm(lhsFalseTerm, rhsTrueTerm, assumptions, lifetimes);
				// Check whether rhs :> lhs (as (!rhs & lhs) == 0)
				boolean elemRhsSubsetLhs = isVoidTerm(rhsFalseTerm, lhsTrueTerm, assumptions, lifetimes);
				// Check whether element not equal
				if (!elemLhsSubsetRhs || !elemRhsSubsetLhs) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * Determine whether the intersection of two type variables is void or not.
	 * Since type variables currently do not support bounds, two variables intersect
	 * iff they are the same variable.
	 *
	 * @param lhs
	 * @param rhs
	 * @param assumptions
	 * @param lifetimes
	 * @return
	 */
	protected boolean isVoidVariable(Atom<Type.Variable> lhs, Atom<Type.Variable> rhs,
			BinaryRelation<Term<?>> assumptions, LifetimeRelation lifetimes) {
		//
		Identifier lval = lhs.type.getOperand();
		Identifier rval = rhs.type.getOperand();
		//
		if (lval.equals(rval)) {
			// T & T = T
			// T & !T = void
			// !T & T = void
			// !T & !T = !T
			return lhs.sign != rhs.sign;
		} else {
			// Comparing variables with different names. In this case, we can never be sure
			// there is no overlap regardless of sign.
			return false;
		}
	}

	// ========================================================================
	// Helpers
	// ========================================================================

	private final static class Worklist extends ArrayList<Term<SemanticType>> {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		public Term<SemanticType> top() {
			return get(size() - 1);
		}

		public void push(Term item) {
			add(item);
		}

		public void push(SemanticType type, Context context) {
			add(new Term(type, context));
		}

		public void push(SemanticType[] types, Context context) {
			for (int i = 0; i != types.length; ++i) {
				add(new Term(types[i], context));
			}
		}

		public Term<SemanticType> pop() {
			Term<SemanticType> i = get(size() - 1);
			remove(size() - 1);
			return i;
		}

		@Override
		public Worklist clone() {
			Worklist wl = new Worklist();
			wl.addAll(this);
			return wl;
		}
	}

	public static class Context {
		public final boolean sign;
		public final boolean maximise;

		public Context(EmptinessTest.State state) {
			this.sign = state.sign;
			this.maximise = state.maximise;
		}

		public Context(Context other) {
			this.sign = other.sign;
			this.maximise = other.maximise;
		}

		private Context(boolean sign, boolean maximise) {
			this.sign = sign;
			this.maximise = maximise;
		}

		public Context negate() {
			return new Context(!sign, maximise);
		}

		public Context invert() {
			return new Context(!sign, !maximise);
		}

		public Context positify() {
			return new Context(true, maximise);
		}

		public Context negatify() {
			return new Context(false, maximise);
		}
	}

	public static class Term<T extends SemanticType> extends Context {
		public final T type;


		public Term(T type, EmptinessTest.State state) {
			super(state);
			this.type = type;
		}

		public Term(T type, Context other) {
			super(other);
			this.type = type;
		}

		@Override
		public String toString() {
			return type.toString() + ":" + sign + ":" + maximise;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Term) {
				Term t = (Term) o;
				return sign == t.sign && maximise == t.maximise && type.equals(t.type);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return type.hashCode();
		}
	}

	protected static class Atom<T extends SemanticType.Atom> extends Term<T> {
		public Atom(T type, Context other) {
			super(type, other);
		}

		@Override
		public String toString() {
			String r = type.toString();
			if (sign) {
				return r;
			} else {
				return "!" + r;
			}
		}
	}
}
