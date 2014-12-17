public class Character {
    
    protected String name;
    protected int health;
    protected int xp;
    protected int damage;

    public Character() {
	name = "Bob";
	health = 10;
	damage = 8;
    }

    public Character( String n ) {
	name = n;
	health = 10;
	damage = 8;
    }

    public void attack( Character c ) {
	c.health-= damage;
    }

    public void attack() {
	System.out.println( "I'm attacking!" );
    }

    public String toString() {
	String s = name + " ";
	s+= health + " ";
	s+= damage + " ";
	s+= xp + " ";
	
	return s;
    }
}
