public class Brute extends Character {
    
    public Brute(String n) {
	super(n);
	hp += 10;
	str += 5;
	def += 10;
	weaponname = "Wooden Club";
	wepstr += 2;
	wepatk -= 0.1;
    }
    
    public int special(Character enemy){
	int damage = (int)((str + wepstr) * (atk + wepatk));
	this.hp -= str;
	if (damage > 0) {
	    enemy.hp -= damage;
	}
	else {
	    enemy.hp -= damage;
	}
	return damage;
    }

    public void levelUp(){
        System.out.println("Level Up!");
        exp = 0;
        level += 1;
        str += 7;
        def += 8;
        hp += 15;
        atk += 0.01;
    }
}
