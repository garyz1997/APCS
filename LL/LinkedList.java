public class LinkedList
{

    private LNode front;

    public LinkedList()
    {
	front = new LNode('');	
    }

    public String toString()
    {
	String ans = "";
	LNode current = front.getNext();
	while (current != null)
	    {
		ans += "[" + current.getData() + "]";
		    current = current.getNext();
	    }
	return ans;
    }
    public void add( char c )
    {
        //appends c to the end of the list
	LNode current = front.getNext();
	while (current != null)
	    {
		current = current.getNext();
	    }
	LNode d = new LNode(c);
	current.setNext(d);
    }
    public void add( char c, int i )
    {
        //add c to the list at index i
        //all other elements in the list should remain in it
    }
    public char get( int i )
    {
        //return the value at index i 
        //Zero based indexing
    }
    public void set( char c, int i )
    {
        //Change the value at index i to c
    }
    public char remove( int i )
    {
        //remove the node at index i and return its value.
    }
    public int size()
    {
        //return the number of elements in the list
    }
}
