public class Game {
    public static void main(String[] args) {
	
	Mage m = new Mage();
	Warrior w = new Warrior();

	System.out.println("Mage values and attack String:");
	System.out.println(m);
	m.attack();
	System.out.println("Warrior values and attack String:");
	System.out.println(w);
	w.attack();

	m.attack(w);
	w.attack(m);
	System.out.println("Values after each character attacks:");
	System.out.println(m);
	System.out.println(w);
	
    }
}
