// Gary, Andy
import java.util.*;

public class Game {
    
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        Map m = new Map(0);
        //m.reset();
        //System.out.println(m.spawn()); 
        //System.out.println(m);
        //m.reset();
        System.out.println(m);

        System.out.println("You wake up alone in a dark room with no memory of last night. Nothing that hasn't happened before, but it feels different this time. You see the bars that make up your door, a sink, and a toilet. You're stuck in a dungeon, and you don't even know who you are. What is your name?");
        //Scanner input  = new Scanner(System.in);
        String nickname = input.nextLine();
        
        System.out.println("Are you sneaky, fast, or strong?");
        String classy = input.nextLine();
        int classier = 0;
        String type = "";
        Character hero = new Character();
        Character enemy = new Character();
        while ( !type.toLowerCase().equals("thief") && !type.toLowerCase().equals("marksman") && !type.toLowerCase().equals("brute")){
            if (classy.toLowerCase().equals("sneaky")){
                hero = new Thief(nickname);
                type = "Thief";
            }else if (classy.toLowerCase().equals("fast")){
                hero = new Marksman(nickname);
                type = "Marksman";
            }else if (classy.toLowerCase().equals("strong")){
                hero = new Brute(nickname);
                type = "Brute";
            }else{
                System.out.println("Sorry, could you repeat that?");
                classy = input.nextLine();
            }
        }
        System.out.println("Oh! So you are a " + type + " then!");
        
        String answer = "";
        while (hero.room == 0){
            
            System.out.println("You find yourself in a dark cell with nothing but your " + hero.weaponname + " and your wits.");
            System.out.println("Do you exit the room?");
            answer = input.nextLine();
            if (answer.toLowerCase().equals("yes")){
                hero.room += 1;
            }else{
                System.out.println("You go back to sleep...");
            }
        }

        while (hero.hp > 0){
            System.out.println();
            if (enemy.hp <= 0){
                if (hero.room % 10 == 0){
                    enemy = new Boss(hero.room);
                    System.out.println("A boss has appeared!");
                }else{
                    enemy = new Guard(hero.room);
                }
                System.out.println("You have encountered " + enemy.name + " Level : "+ hero.room);
            }

            hero.encounter(enemy);
        }
        
        System.out.println("You have died! Game Over!");
        System.out.println("Your statistics:");
        System.out.println(hero);
    }
}



