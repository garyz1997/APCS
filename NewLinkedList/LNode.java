public class LNode {
    
    private char data;
    private LNode next;

    public LNode( char d ) {
	data = d;
    }
    public String toString() {
	return "" + data;
    }
    public void setData( char c ) {
	data = c;
    }
    public void setNext( LNode n ) {
	next = n;
    }
    public char getData() {
	return data;
    }
    public LNode getNext() {
	return next;
    }    
}
