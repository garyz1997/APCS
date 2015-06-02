import java.util.*;
public class Guard extends Character{
    protected String guard[] = {"Dreamy", "Grumpy", "Happy", "Sleepy", "Bashful", "Sneezy", "Dopey"};
   public Guard(int roomnumber){
       hp = roomnumber * 10;
       str = roomnumber * 10;
       atk = roomnumber * 1.0;
       def = roomnumber * 4;
       room = roomnumber;
       crit = roomnumber * 5 % 30;
       int number = new Random().nextInt(guard.length);
       name = guard[number];
   }
    
    public String toString(){
        String string = "";
        string += name + "\n";
        string += "Level : " + room + "\n";
        string += "Health : " + hp + "\n";
        string += "Strength : " + str + "\n";
        string += "Defense : " + def + "\n";
        string += "Attack Rating : " + atk + "\n";
        return string;
    }
}