public class LNode
{
    public char data;
    public LNode next;

    public LNode( char d )
    {
	data = d;
    }

    public String toString()
    {
	return "" + data;
    }
    
    public static void main(String[] args)
    {
	LNode n1 = new LNode( 'A' );
	LNode n2 = new LNode( 'B' );
	LNode n3 = new LNode('$');
	System.out.println( n1 );
	System.out.println( n2 );
	System.out.println( n3 );
	n1.next = n2;
	n2.next = n3;
	System.out.println(n1.next);
	System.out.println(n2.next);
	
    }






    
}
