public class Marksman extends Character{

    public Marksman(String n){
	super(n);
	crit += 20;
	str += 10;
	atk += 0.5;
	weaponname = "Wooden Bow";
	wepstr += 2;
	wepatk += 0.5;
    }

    public void levelUp(){
    System.out.println("Level Up!");
	level += 1;
	exp = 0;
	str += 12;
	def += 4;
	hp += 5;
	atk += 0.1;
    }
}
 
