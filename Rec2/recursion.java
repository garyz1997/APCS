import java.util.*;
public class recursion
{
    public static int factorial(int n)
    {
	if (n == 0) return 1;
	return n*factorial(n-1);
    }
    public static long fib2(int n, ArrayList<Long> values)
    {
	if (n<=2)
	    {
		values.add((long)1);
		return 1;
	    }
	if (n <= values.size())
	    return n-1;
	return fib2(n-1,values) + fib2(n-2,values);
    }
    public static double sqrt(int n)
    {
	return sqrthelper(n,n/2);
    }
    public static double sqrthelper(int n, double guess)
    {
	double diff = Math.pow(guess,2)-n;
	if (Math.abs(diff) < 0.001)
	    {
		return guess;
	    }
	//System.out.println(guess-diff/2.0);
	return sqrthelper(n,(n/guess+guess)/2);
    }
    public static ArrayList<String> scramble(String s)
    {
	int len = s.length();
	ArrayList<Boolean> used = new ArrayList<Boolean>();
	for (int x = 0;x<len;x++)
	    {
		used.add(false);
	    }
	System.out.println(used);
	ArrayList<String> blah = new ArrayList<String>();
	blah.add("hi");
	return blah;
	/*
	ArrayList<String> ans = new ArrayList<String>();
	for (int x = 1; x < s.length();x++)
	    {

	    }

	*/
    }
    
    public static ArrayList<String> scramblehelper(int pos,String s,ArrayList<String> combos,ArrayList<Boolean> used)
    {
	ArrayList<String> combosnew = new ArrayList(combos);
	ArrayList<Boolean> usednew = new ArrayList(used);
	int len = s.length();
	if (combos.get(0).length()==len)
	    return combos;
	for (int x = 0;x<used.size();x++)
	    {
		if (! used.get(x))
		    {
			combosnew.set(pos, combos.get(pos)+s.charAt(x));
			usednew.set(x,true);
			scramblehelper(pos,s,combosnew,usednew);
		    }
	    }
	return combos;
	/*	
	ArrayList<String> strings = new ArrayList<String>();
	String anstr = "";
	int len = s.length();
	if (str.length == 1)
	    {
	    strings.add(s);
	    return strings;
	    }
	for (x = 0; x < str.length();x++)
	    {
		strings.add((String)s.charAt(0));
	    }
	
	*/	
    }

    public static void main(String[] args)
    {
	ArrayList<Long> vals = new ArrayList<Long>();
	for (int x = 0;x<10;x++)
	    {
		System.out.println(x+" factorial is "+factorial(x));
	    }
	
	for (int x = 1;x<10;x++)
	    {
		System.out.println("Fib of "+ x + " is " +fib2(x,vals));
	    }
	for (int x =10;x<=100;x+=10)
	    {
		System.out.println("sqrt of " + x + " is about "+sqrt(x));
	    }
	System.out.println(scramble("hi"));
	System.out.println("I give up on scramble :(");
    }
}
/*
    scramble
        Takes a string as a parameter (s)
        Returns an ArrayList containing all the possible ways of arranging the letters of s
        Example:
            scramble( "bat") ==> [ "bat", "bta", "abt", "atb", "tab", "tba"]
*/
