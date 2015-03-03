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
	return (String)this.data;
    }
    
    public static void main(String[] args)
    {
	LNode node1 = new LNode( 'A' );
	LNode node2 = new LNode( 'B' );
	LNode node3 = node2;
	System.out.println( node1 );
	System.out.println( node2 );
	System.out.println( node3 );
	node1.next = node2;
	System.out.println(node1.next);
	
    }






    
}
