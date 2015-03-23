public class LinkedList {

    private LNode front;
    private LNode back;
    private int size;
    
    public LinkedList() {
	front = back = null;
    }

    public String toString() {
	String s = "";
	LNode curr = front;
	
	while ( curr != null ) {
	    s+= curr.getData() + " ";
	    curr = curr.getNext();
	}
	return s;	
    }

    public void add( char c ) {
    
	LNode n = new LNode( c );
	size++;
	
	if ( size == 1 )
	    front = back = n;

	else {
	    back.setNext( n );
	    back = back.getNext();
	}
    }

    public void add( char c, int i ) throws IndexOutOfBoundsException {
    
	if ( i > size || i < 0 )
	    throw new IndexOutOfBoundsException();
	
	LNode n = new LNode( c );
	LNode curr = front;

	size++;	

	if ( curr == null ) {
	    front = back = n;
	    return;
	}

	if ( i == 0 ) {	    
	    n.setNext( front );
	    front = n;
	    if ( size == 1 )
		back = n;
	    return;
	}

	if ( i == size - 1 ) {
	    add( c );
	    return;
	}
	    	
	while ( i > 1 ) {
	    curr = curr.getNext();
	    i--;
	}

	n.setNext( curr.getNext() );
	curr.setNext( n );
    }
    

    public char set( char c, int i ) throws IndexOutOfBoundsException {
        	
	if ( i >= size || i < 0 )
	    throw new IndexOutOfBoundsException();

	LNode curr = front;
	char old;
	
	if ( i == size - 1 ) {
	    old = back.getData();
	    back.setData( c );
	    return old;
	}

	while ( i > 0 ) {	    
	    curr = curr.getNext();
	    i--;
	}

	old = curr.getData();
	curr.setData( c );
	return old;
    }

    public char get( int i ) throws IndexOutOfBoundsException {
    
	if ( i >= size || i < 0 )
	    throw new IndexOutOfBoundsException();


	if ( i == size - 1 )
	    return back.getData();
	
       	LNode curr = front;
		
	while ( i > 0 ) {	    
	    curr = curr.getNext();
	    i--;
	}
	return curr.getData();
    }

    public char remove( int i ) throws IndexOutOfBoundsException {
    
	if ( i >= size() || i < 0 )
	    throw new IndexOutOfBoundsException();

	LNode curr = front;
	size--;
	
	if ( i == 0 ) {
	    front = front.getNext();

	    if ( size == 0 )
		back = null;
	    
	    return curr.getData();
	}
	    
	while ( i > 1 ) {
	    curr = curr.getNext();
	    i--;	    
	}
	
	if ( curr.getNext() == back )
	    back = curr;
	
	char old = curr.getNext().getData();
	curr.setNext( curr.getNext().getNext()  );

	return old;
    }
    
    public int size() {
	return size;
    }

       

    public static void main(String[] args) {

	LinkedList l = new LinkedList();

	for (char c = 'A'; c < 'F'; c++)
	    l.add(c);
	
	System.out.println( l );	
	
	l.add( '0', 0 );
	l.add( '1', 1 );
	l.add( '2', 3 );
	l.add( '3', 8 );
	
	System.out.println( l );	

	l.set( '!', 0 );
	l.set( '@', 8 );

	System.out.println( l );	
	
	System.out.println( l.get(0) );
	System.out.println( l.get(5) );
	//	System.out.println( l.get(9) );
	

	System.out.println( l.remove(0) );
	System.out.println( l.remove(5) );

	System.out.println( l );
	System.out.println( l.size() );	
    }    
}
