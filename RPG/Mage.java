public class Mage extends Character {

    int energy;

    public Mage() {
	super("Molly");
	damage+= 10;
	energy = 5;
    }

    public String toString() {
	String s = super.toString() + energy;	
	return s;
    }

    public void attack( Character c ) {
	super.attack(c);
	energy-= 3;
    }

    public void attack() {
	System.out.println( "pew pew" );
    }
}
