public class LinkedList<E> {

    private LNode<E> front;
    private LNode<E> back;
    private int size;
    
    public LinkedList() {
	front = back = null;
    }

    public String toString() {
	String s = "";
	LNode<E> curr = front;
	
	while ( curr != null ) {
	    s+= curr.getData() + " ";
	    curr = curr.getNext();
	}
	return s;	
    }

    public void add( E c ) {
    
	LNode<E> n = new LNode( c );
	size++;
	
	if ( size == 1 )
	    front = back = n;

	else {
	    back.setNext( n );
	    back = back.getNext();
	}
    }

    public void add( E c, int i ) throws IndexOutOfBoundsException {
    
	if ( i > size || i < 0 )
	    throw new IndexOutOfBoundsException();
	
	LNode<E> n = new LNode( c );
	LNode<E> curr = front;

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
	    size--;
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
    

    public E set( E c, int i ) throws IndexOutOfBoundsException {
        	
	if ( i >= size || i < 0 )
	    throw new IndexOutOfBoundsException();

	LNode<E> curr = front;
	E old;
	
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

    public E get( int i ) throws IndexOutOfBoundsException {
    
	if ( i >= size || i < 0 )
	    throw new IndexOutOfBoundsException();


	if ( i == size - 1 )
	    return back.getData();
	
       	LNode<E> curr = front;
		
	while ( i > 0 ) {	    
	    curr = curr.getNext();
	    i--;
	}
	return curr.getData();
    }

    public E remove( int i ) throws IndexOutOfBoundsException {
    
	if ( i >= size() || i < 0 )
	    throw new IndexOutOfBoundsException();

	LNode<E> curr = front;
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
	
	E old = curr.getNext().getData();
	curr.setNext( curr.getNext().getNext()  );

	return old;
    }
    
    public int size() {
	return size;
    }

       

    public static void main(String[] args) {

	LinkedList<Character> l = new LinkedList<Character>();

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
