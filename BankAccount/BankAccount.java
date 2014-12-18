//Gary Zheng PD10 APCS

//Every bullet point is labelled

// 1 Instance Variables
//   a Account holder's full name
//   b Account password
//   c ATM pin number (some 4 digit number)
//   d Account number (some 9 digit number)
//   e Account balance (money in the accoutn)

// 2 Methods
//   a  A constructor that takes parameters for each instance variable and sets them accordingly
//   b  Methods to set each of the 5 instance variables individually
//   c  A method to print out all of the account information at once
//   d  A deposit method that will take an amount of money as a parameter and add it to the account balance
//   e  A withdraw method that will take an amount of money as a parameter and remove it from the balance
//   f  A main method that tests your code

public class BankAccount {

    //Instance Variables 1a-1e
    private String fullName;
    private String pass;
    private int pin;
    private long accNum;
    private double balance;


    //Methods
    //2b
    public void setName( String n ) {
	fullName = n;
    }
    public void setPass( String p ) {
	pass = p;
    }
    public void setPin( int q ) {
	if ((q >= 1000) && (q <= 9999)) {
	    pin = q;
	}
	else {
	    pin = 9999;
	    System.out.println("Invalid PIN! PIN must be 4 digits!");
		}
    }
    public void setAccNum( long a ) {
	if ((a >= 100000000) && (a <= 999999999)) {	
		accNum = a;
	    }
	else {
	    accNum = 999999999;
	    System.out.println("Invalid Account Number! Account Number must be 9 digits!");
	}
    }
    public void setBalance( double b ) {
	balance = b;
	System.out.println( "Original Balance: $" + b );
    }
    public void accInfo() {
	//2c
	System.out.println( "Account name: "      + "\t" + "\t" + fullName + "\n" + 
			    "Account password: "  + "\t" + pass     + "\n" + 
			    "Account pin: "       + "\t" + "\t" + pin      + "\n" + 
			    "Account number: "    + "\t" + accNum   + "\n" + 
			    "Account balance: "   + "\t$" + balance );
    }
    public BankAccount( String n, String p, int q, long a, double b ) {
	//2a
	fullName=n;
	pass=p;
	pin=q;
	accNum=a;
	balance=b;
    }
    public void deposit( double b ) {
	//2d
	balance = balance + b;
	System.out.println("You have deposited $" + b );
    }
    public boolean withdraw( double w ) {
	//2e
	if (balance - w < 0){
	    System.out.println("YOU DON'T HAVE THAT MONEY TO WITHDRAW! $" + w + " NOT WITHDRAWN.");
	    return false;	
	}
	else {
	    balance = balance - w;
	    System.out.println("You have withdrawn $" + w );
	    return true;	
	}
    }
    public boolean authenticate( long a, String p ) {
	if ((a == accNum) && (p == pass)) {
	    System.out.println("TRUE");
	    return true;
	}
	else {
	    System.out.println("FALSE");
	    return false;
      	}
    }
    public static void main(String[] args){
	//2f
	BankAccount bob;
	bob=new BankAccount( "a" , "b" , 1 , 2 , 3 );
	bob.setName("bob");
	bob.setPass("bobpass");
	bob.setPin(19979);
	bob.setAccNum(23518576);
	bob.setBalance(100);
	bob.deposit(12.02);
	bob.withdraw(15.01);
        bob.withdraw(120);
	bob.accInfo();
	bob.authenticate( 999999999, "bobpass" );
	    }
}
