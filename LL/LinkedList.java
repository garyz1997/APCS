public class LinkedList
{

    private LNode front;

    public LinkedList()
    {
	front = null;	
    }

    public String toString()
    {
	String ans = "";
	LNode current = front;
	while (current != null)
	    {
		ans += "[" + current + "]";
		current = current.getNext();
	    }
	return ans;
    }




    public void add( char c )
    {
        //appends c to the end of the list
	LNode current = front;
	LNode d = new LNode(c);
	if (front == null)
	    {
	    front = d;
	    return;
	    }
	while (current.getNext() != null)
	    {
		current = current.getNext();
	    }
	    current.setNext(d);

    }
    public void add( char c, int i )
    {
        //add c to the list at index i
        //all other elements in the list should remain in it
	if (i == 0)
	    {
		LNode a = new LNode(c);
		a.setNext(front);
		front = a;
		return;
	    }
	int count = 0;
	LNode current = front;
	while (current != null)
	    {
		count++;
		if (count == i)
		    {
			LNode a = new LNode(c);
			a.setNext(current.getNext());
			current.setNext(a);
		    }
		current = current.getNext();
	    }
    }



    public char get( int i )
    {
        //return the value at index i 
        //Zero based indexing
	int count = 0;
	LNode current = front;
        while (current != null)
            {
                count++;
                if (count == i+1)
                    {
                        return current.getData();
                    }
		current = current.getNext();
	    }
	return ' ';
    }
    public void set( char c, int i )
    {
        //Change the value at index i to c
        if (i == 0)
            {
                LNode a = new LNode(c);
                a.setNext(front.getNext());
                front = a;
                return;
            }
        int count = 0;
        LNode current = front;
        while (current != null)
            {
                count++;
                if (count == i)
                    {
                        LNode a = new LNode(c);
                        a.setNext(current.getNext().getNext());
                        current.setNext(a);
                    }
                current = current.getNext();
            }

    }
    public char remove( int i )
    {
        //remove the node at index i and return its value.
        if (i == 0)
            {
                LNode a = front;
                front = front.getNext();
                //front = a;
                return a.getData();
            }
        int count = 0;
        LNode current = front;
        while (current != null)
            {
                count++;
                if (count == i)
                    {
                        LNode a = current.getNext();
                        current.setNext(current.getNext().getNext());
                        //current.setNext(a);
			return a.getData();
                    }
            }
	return ' ';
    }
    public int size()
    {
        //return the number of elements in the list
	int count = 0;
        LNode current = front;
        while (current != null)
            {
                count++;
		current = current.getNext();
	    }
        return count;

    }
    public static void main(String[] args)
    {
	LinkedList foo = new LinkedList();
	foo.add('h');
	System.out.println(foo.size());
	foo.add('o');
	foo.add('t');
	System.out.println(foo.size());
	foo.add('$',3);
	System.out.println(foo.size());
	foo.add('^');
	foo.set('#',1);
	System.out.println(foo.size());
	System.out.println(foo.remove(1));
	System.out.println(foo.size());
	System.out.println(foo);
	System.out.println(foo.get(0));
	System.out.println(foo.get(1));
	System.out.println(foo.get(2));
	System.out.println(foo.get(3));
	System.out.println(foo.get(4));
	System.out.println(foo.size());
	//FINITO :DDD
    }
}
