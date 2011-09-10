package wyil.util;

import java.util.HashMap;

import wyil.lang.Type;
import static wyil.lang.Type.*;

/**
 * The Type Parser is used to convert a given string into a type (or a syntax
 * error). This is generally useful for debugging purposes, but it does have
 * other usees as well.
 * 
 * @author djp
 * 
 */
public class TypeParser {
	private int index;
	private String str;
	
	public TypeParser(String str) { 
		this.str = str;
	}
	
	public Type parse() {
		Type term = parseNotTerm();
		skipWhiteSpace();
		while (index < str.length()
				&& (str.charAt(index) == '|' || str.charAt(index) == '&')) {
			if(str.charAt(index) == '|') {
				// union type
				match("|");
				term = T_UNION(term,parse());
			} else {
				// intersection type
				match("&");
				term = T_INTERSECTION(term,parse());
			}
			skipWhiteSpace();
		}
		return term;
	}
	public Type parseNotTerm() {
		skipWhiteSpace();
		char lookahead = str.charAt(index);
		if(lookahead == '!') {
			match("!");
			return T_NOT(parseNotTerm());
		} else {
			return parseBraceTerm();
		}
	}
	public Type parseBraceTerm() {
		skipWhiteSpace();
		char lookahead = str.charAt(index);
		if(lookahead == '(') {
			match("(");
			Type t = parse();
			match(")");
			skipWhiteSpace();
			return t;
		} else {
			return parseTerm();
		}
	}
	public Type parseTerm() {
		skipWhiteSpace();
		char lookahead = str.charAt(index);

		switch (lookahead) {
		case 'a':
			match("any");
			return T_ANY;
		case 'v':
			match("void");
			return T_VOID;
		case 'n':
			match("null");
			return T_NULL;
		case 'b':
			if ((index + 1 < str.length()) && str.charAt(index + 1) == 'o') {
				match("bool");
				return T_BOOL;
			} else {
				match("byte");
				return T_BYTE;
			}
		case 'c':
			match("char");
			return T_CHAR;
		case 'i':
			match("int");
			return T_INT;
		case 'r':
			match("real");
			return T_REAL;
		case 's':
			match("string");
			return T_STRING;
		case '[':
		{
			match("[");
			Type elem = parse();
			match("]");
			return T_LIST(elem);
		}
		case '{':
		{
			match("{");
			Type elem = parse();
			skipWhiteSpace();
			if(index < str.length() && str.charAt(index) != '}') {
				// record
				HashMap<String,Type> fields = new HashMap<String,Type>();
				String id = parseIdentifier();
				fields.put(id, elem);
				skipWhiteSpace();
				while(index < str.length() && str.charAt(index) == ',') {
					match(",");
					elem = parse();
					id = parseIdentifier();
					fields.put(id, elem);
					skipWhiteSpace();
				}
				match("}");
				return T_RECORD(fields);					
			}
			match("}");
			return T_SET(elem);
		}
		default:
			throw new IllegalArgumentException("invalid type string: "
					+ str);
		}
	}
	private String parseIdentifier() {
		skipWhiteSpace();
		int start = index;
		while (index < str.length()
				&& Character.isJavaIdentifierPart(str.charAt(index))) {
			index++;
		}
		return str.substring(start,index);
	}
	private void skipWhiteSpace() {
		while (index < str.length()
				&& Character.isWhitespace(str.charAt(index))) {
			index++;
		}
	}		
	private void match(String match) {
		skipWhiteSpace();
		if ((str.length() - index) < match.length()
				|| !str.startsWith(match, index)) {
			throw new IllegalArgumentException("invalid type string: "
					+ str);
		}
		index += match.length();
	}
}
