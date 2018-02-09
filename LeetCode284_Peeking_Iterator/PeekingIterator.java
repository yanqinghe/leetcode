import java.util.Iterator;

import com.sun.prism.impl.BaseMesh.FaceMembers;

class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> itr;  
    boolean peeked;  
    int peekObj;  
      
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.itr = iterator;
		this.peeked=false;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(!peeked){
			peekObj=itr.next();
			peeked=true;
		}
		return peekObj;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peeked){
			peeked=false;
			return peekObj;
		}
		return itr.next();
	}

	@Override
	public boolean hasNext() {
	    return peeked||itr.hasNext();
	}
}