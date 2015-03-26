public class LNodeQueue<E>{

	LNode<E> top;
	LNode<E> bottom;

	public LNodeQueue(E object){
		bottom = top = new LNode<E>(object);
	}

	public String toString() {
		String s = "";
		LNode<E> curr = bottom;
	
		while ( curr != null ) {
	    	s+= curr.getData() + " ";
	    	curr = curr.getNext();
		}
		return s;	
    }

	public void enqueue(E object){

		if (isEmpty()){
		    bottom = top = new LNode<E>(object);
			}
		else{
		    //LNode <E> curr = top;
		    //top = new LNode<E>(object);
		    //top.setnext(curr)
		    //	}
		    LNode<E> o = new LNode<E>(object);
		    top.setNext(o);
		    top = o;
		}
	}

	public E dequeue(){
		LNode<E> old = bottom;
		if(bottom.getNext() == null){
			E ret = bottom.getData();
			bottom.setData(null);
			return ret;
		}

		else{
			bottom = bottom.getNext();
			return old.getData();
		}
	}

	public E peek(){
		return bottom.getData();
	}

	public boolean isEmpty(){
	    if(top.getData() == null){
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String[] args){
	    LNodeQueue<Integer> num = new LNodeQueue<Integer>(4);
	    LNodeQueue<Character> cha = new LNodeQueue<Character>('c');
	    
	    System.out.println("Number Stack: " + num);
	    System.out.println("Character Stack: " + cha + "\n");
	    System.out.println(num);
	    //enqueue
	    for (int i = 1; i < 10; i++){
		num.enqueue(i);
	    System.out.println(num);
	    }
	    cha.enqueue('y');
	    System.out.println("should be 4 1 2 3 4 5 6 7 8 9: " + num);
	    System.out.println("should be 'c y': " + cha + "\n");
	    
	    //dequeue
	    System.out.println("should be 4: " + num.dequeue());
	    System.out.println("should be c: " + cha.dequeue() + "\n");
	    
	    
	    System.out.println("Number Stack: " + num);
	    System.out.println("Character Stack: " + cha + "\n");
	    
	    //peek
	    System.out.println("should be 1: " + num.peek());
	    System.out.println("should be y: " + cha.peek() + "\n");
	    
	    //isEmpty
	    cha.dequeue();
	    System.out.println("should be true: " + cha.isEmpty());
	    System.out.println("should be false: " + num.isEmpty());
	    

	}
}
