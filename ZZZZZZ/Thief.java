import java.util.Random;
public class Thief extends Character{
    private int stealth;
    
    public Thief(String n){
	super(n);
	stealth = 10; 
	weaponname = "Dagger";
	crit += 5; 
	hp += 5; 
	def += 5;
    }

    public void attack(Character enemy){
        int luck = new Random().nextInt(100);
        int wepstat = new Random().nextInt(room + 10);
        
        System.out.println("You attacked " + enemy.name);
        int damage = (int)((str + wepstr - enemy.def) * (atk + wepatk));
        int recoil = (enemy.str + enemy.wepstr - def) / 4;
        if (crits()){
            damage *= 4;
        }
        if (enemy.hp - damage > 0 && luck <= 90){
            enemy.hp -= damage;
            System.out.println("You did " + damage + " to your enemy. It has " + enemy.hp + " remaining");
            System.out.println("You took " +recoil + " damage.");
            hp -= recoil;
        }else{
            enemy.hp = 0;
            if (luck > 90){
                System.out.println("Backstab!");
            }else{
                System.out.println("You killed your opponent.");
                exp += room * 100;
                if (exp >= level * 150){
                    levelUp();
                }
                if (luck >= 65){
                    pickWep(wepstat / 3 * 2, wepstat / 9.0);
                }
            }
            room += 1;
            System.out.println("\nYou enter the next room");
        }
    }
    
    public void levelUp(){
    System.out.println("Level Up!");
	level += 1;
	exp = 0;
	str += 12;
	def += 7;
	hp += 6;
	atk += 0.05;
    }
    
}
