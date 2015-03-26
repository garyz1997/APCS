public class LNodeStack<E>{

	LNode<E> top;

	public LNodeStack(E object){
		top = new LNode<E>(object);
	}

	public String toString() {
		String s = "";
		LNode<E> curr = top;
	
		while ( curr != null ) {
	    	s+= curr.getData() + " ";
	    	curr = curr.getNext();
		}
		return s;	
    }

	public void push(E object){
		LNode<E> o = new LNode<E>(object);
		o.setNext(top);
		top = o;
	}

	public E pop(){
		LNode<E> old = top;
		if(top.getNext() == null){
			E ret = top.getData();
			top.setData(null);
			return ret;
		}

		else{
			top = top.getNext();
			return old.getData();
		}
	}

	public E peek(){
		return top.getData();
	}

	public boolean isEmpty(){
		if(top.getData() == null && top.getNext() == null){
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String[] args){
		LinkedStack<Integer> num = new LinkedStack<Integer>(4);
		LinkedStack<Character> cha = new LinkedStack<Character>('c');

		System.out.println("Number Stack: " + num);
		System.out.println("Character Stack: " + cha + "\n");

		//push
		for (int i = 1; i < 10; i++){
			num.push(i);
		}
		cha.push('y');
		System.out.println("should be 9 8 7 6 5 4 3 2 1 4: " + num);
		System.out.println("should be 'y c': " + cha + "\n");

		//pop
		System.out.println("should be 9: " + num.pop());
		System.out.println("should be y: " + cha.pop() + "\n");


		System.out.println("Number Stack: " + num);
		System.out.println("Character Stack: " + cha + "\n");

		//peek
		System.out.println("should be 8: " + num.peek());
		System.out.println("should be c: " + cha.peek() + "\n");

		//isEmpty
		cha.pop();
		System.out.println("should be true: " + cha.isEmpty());
		System.out.println("should be false: " + num.isEmpty());


	}
}