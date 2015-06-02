import java.util.*;
public class Boss extends Character{
    protected String boss[] = {"Bowser", "Waluigi","Wario","Meta Knight","Boo","Wart","Tatanga"};
    public Boss(int roomnumber){
	hp = roomnumber * 100;
	str = roomnumber * 10;
	atk = roomnumber * 0.5;
	def = roomnumber * 5;
	crit = roomnumber * 5 % 30;
	int number = new Random().nextInt(boss.length);
	name = boss[number];
    }
    
    public String toString(){
        String string = "";
        string += name + "\n";
        string += "Floor Boss" + "\n";
        string += "Health : " + hp + "\n";
        string += "Strength : " + str + "\n";
        string += "Defense : " + def + "\n";
        string += "Attack Rating : " + atk + "\n";
        return string;
    }
}