import java.util.*;
public class Character{
    protected int hp, str, def, exp, wepstr, crit, level, room;
    protected String name, weaponname;
    protected double atk, wepatk;
    
    public Character(){
        // Intentionally Left Blank
    }
    
    public Character(String nickname){
        name = nickname;
        hp = 10;
        str = 10;
        atk = 1.0;
        def = 10;
        crit = 10;
        exp = 0;
        room = 0;
        wepstr = 0;
        wepatk = 0;
        weaponname = "Fists of Fury";
        level = 1;
    }
    
    public String toString(){
        String string = "";
        string += "Name : " + name + "\n";
        string += "Level : " + level + "\n";
        string += "Health : " + hp + "\n";
        string += "Strength : " + str + "\n";
        string += "Attack Rating : " + atk + "\n";
        string += "Defense : " + def + "\n";
        string += "Experience : " + exp + "\n";
        string += "Weapon : " + weaponname + "\n";
        string += "Weapon Strength : " + wepstr + "\n";
        string += "Weapon Attack Rating : " + wepatk + "\n";
        return string;
    }
    
    public boolean crits(){
        int luck = new Random().nextInt(100);
        if (luck <= crit){
            System.out.println("Critical Hit!");
            return true;
        }else{
            return false;
        }
    }
    
    public void attack(Character enemy){
        int luck = new Random().nextInt(100);
        int number = new Random().nextInt(room + 10);
        System.out.println("You attacked " + enemy.name);
        int damage = (int)((str + wepstr - enemy.def) * (atk + wepatk));
        int recoil = (enemy.str + enemy.wepstr - def) / 2;
        if (crits()){
            damage *= 3;
        }
        if (enemy.hp - damage > 0){
            enemy.hp -= damage;
            System.out.println("You did " + damage +" to the enemy. He has " + enemy.hp + " remaining");
            System.out.println("You took " + recoil + " damage.");
            hp -= recoil;
        }else{
            enemy.hp = 0;
            System.out.println("You killed your opponent");
            exp += room * 100;
            if (exp >= level * 150){
                levelUp();
            }
            if (luck >= 80){
                pickWep(number / 2, number / 10.0);
            }
            room += 1;
            System.out.println("You enter the next room");
        }
    }
    
    public void pickWep(int wepstrength, double wepattack){
        Scanner input = new Scanner(System.in);
        String[] nameList = {"Long Sword", "Brutalizer", "Cutlass", "Blade of the Ruined King", "Ravenous Hydra", "Tiamat", "Last Whisper", "Executioner's Calling", "Stattik Shiv", "Infinity Edge", "Atma's Impaler"};
        int number = new Random().nextInt(nameList.length);
        String nickname = nameList[number % nameList.length];
        System.out.println("You found " + nickname + "!\n  Damage = " + wepstrength + "\n Attack Rating = " + wepattack);
        System.out.println("Would you like to equip the weapon?");
        String answer = input.nextLine().toLowerCase();
        boolean answered = false;
        while (!answered){
            if (answer.equals( "yes")){
                answered = true;
                weaponname = nickname;
                wepstr = wepstrength;
                wepatk = wepattack;
                System.out.println("You picked up " + nickname + ".");
            }else if(answer.equals("no")){
                answered = true;
                System.out.println("You left the weapon alone.");
            }else if(answer.equals("status")){
                System.out.println(toString());
                answer = input.nextLine().toLowerCase();
            }else{
                System.out.println("I didn't quite catch that...");
                answer = input.nextLine().toLowerCase();
            }
        }
    }
    
    public void levelUp(){
        exp = 0;
        level += 1;
        str += 7;
        def += 7;
        hp += 12;
        atk += 0.02;
    }
    
    public void encounter(Character enemy){
        Scanner input = new Scanner(System.in);

        System.out.println("Would you like to attack or run?");
        String answer = input.nextLine().toLowerCase();
        while (!answer.equals("attack") && !answer.equals("run")){
            if (answer.equals("status")){
                System.out.println(toString());
                System.out.println(enemy);
                answer = input.nextLine().toLowerCase();
            }else{
                System.out.println("Sorry, I didn't quite catch that");
                answer = input.nextLine().toLowerCase();
            }
        }
        if (answer.equals("attack")){
            attack(enemy);
        }else if(answer.equals("run")){
            System.out.println("You decided to run away.");
            enemy.hp = 0;
            room -= 1;
        }
    }
}

