public class Stack
{
    private LinkedList<E> list;

    public Stack(LinkedList<E> a)
    {
	list = a;
    }
    public void push(E c)
    {
	list.add(c);
    }
    public LNode<E> pop()
    {
	return list.remove(list.size()-1);
    }


    
    public static void main(String[] args)
    {

	LinkedList<Character> hi= new LinkedList<Character>();
	Stack hi = new Stack(hi);
	hi.add('a');
	hi.add('b');
	hi.add('c');
	hi.add('d');
	hi.add('e');
	System.out.println(hi);
	
    }
}
