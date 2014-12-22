public class Greeter {
    
    //Instance Variables
    private String message;
    
    //Methods
    public void setMessage( String m ) {
	message = m;
    }
    
    public void greet() {
	System.out.println( message );
    }

    public void greet( String name ) {
	System.out.println( message + " " + name );
    }

    public static void main(String[] args) {
	Greeter g;
	Greeter bob;
	bob = new Greeter();
	g = new Greeter();

	bob.setMessage("Hello");	
	g.setMessage( "Good News Everyone!" );
	g.greet();
	
	bob.greet();
	bob.greet("Fred");

    }
}
