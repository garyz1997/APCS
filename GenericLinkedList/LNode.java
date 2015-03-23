public class LNode<E> {
    
    private E data;
    private LNode<E> next;

    public LNode( E d ) {
    	data = d;
    }
    public String toString() {
	return "" + data;
    }
    public void setData( E c ) {
	data = c;
    }
    public void setNext( LNode<E> n ) {
	next = n;
    }
    public E getData() {
    	return data;
    }
    public LNode<E> getNext() {
    	return next;
    }    
}
