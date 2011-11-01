package wyjc.runtime;

import java.math.BigInteger;


public final class Tuple extends java.util.ArrayList {		
	/**
	 * The reference count is use to indicate how many variables are currently
	 * referencing this compound structure. This is useful for making imperative
	 * updates more efficient. In particular, when the <code>refCount</code> is
	 * <code>1</code> we can safely perform an in-place update of the structure.
	 */
	int refCount = 100; // TODO: implement proper reference counting
	
	// ================================================================================
	// Generic Operations
	// ================================================================================	 	
	
	public Tuple() {
		super();				
	}
	
	public Tuple(int size) {
		super(size);			
	}
	
	Tuple(java.util.Collection items) {
		super(items);			
		for(Object item : items) {
			Util.incRefs(item);
		}
	}
	
	Tuple(Object... items) {
		super();
		for(Object item : items) {
			add(item);
			Util.incRefs(item);
		}
	}	
		
	public String toString() {
		String r = "(";
		boolean firstTime=true;
		for(Object o : this) {
			if(!firstTime) {
				r += ",";
			}
			firstTime=false;
			r += whiley.lang.Any$native.toString(o);
		}
		return r + ")";
	}
	
	// ================================================================================
	// List Operations
	// ================================================================================	 
	
	public static Tuple add(Tuple list,Object item) {		
		Util.incRefs(item);
		list.add(item);
		return list;		
	}
	
	public static Object get(Tuple list, BigInteger index) {		
		Object item = list.get(index.intValue());
		Util.incRefs(item);
		return item;
	}
			
	public static Tuple set(Tuple list, final BigInteger index, final Object value) {
		if(list.refCount > 1) {			
			// in this case, we need to clone the list in question
			list.refCount--;
			list = new Tuple(list);						
		}
		Object v = list.set(index.intValue(),value);
		Util.decRefs(v);
		Util.incRefs(value);
		return list;
	}
	
	public static BigInteger length(Tuple list) {
		list.refCount--;
		return BigInteger.valueOf(list.size());
	}
	
	public static int size(final Tuple list) {
		return list.size();
	}
	
	public static java.util.Iterator iterator(Tuple list) {
		return list.iterator();
	}		
}
