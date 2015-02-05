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
    public static void main(String[] args)
    {
	ArrayList<Long> vals = new ArrayList<Long>();
	for (int x = 0;x<10;x++)
	    {
		System.out.println(factorial(x));
	    }
	
	for (int x = 1;x<10;x++)
	    {
		System.out.println("Fib of "+ x + " is " +fib2(x,vals));
	    }

    }
}
/*
    Fibonacci2
        Takes 2 parameters, a number (n) and a list (values)
        Returns the nth term in the fibonacci series, (1, 1, 2, 3, 5, 8, ...)
        The second parameter should be a list (either an array or ArrayList) that will contain any previously computed value. The purpose of this list is to make the method run much faster than the standard way, which is O(2^n)
    sqrt
        Returns the square root of a number using the following algorithm:
            Make any guess for the square root (like n/2, 1, whatever)
            Check whether your guess times itself is close to the original number (say within 0.001, but you can change this value)
            If the guess isn't close enough, compute a new guess:
                guess = ( n / guess + guess ) / 2
            If the guess is close enough, return the guess
            Example of the algorithm:
                N = 100, guess = 1   //guess not close enough
                guess = 50.5             //guess not close enough
                guess = 26.240099   //guess not close enough
                guess = 15.025530   //guess not close enough
                guess = 10.840436   //guess not close enough
                guess = 10.032578   //guess not close enough
                guess = 10.000052   //Good Enough!
    scramble
        Takes a string as a parameter (s)
        Returns an ArrayList containing all the possible ways of arranging the letters of s
        Example:
            scramble( "bat") ==> [ "bat", "bta", "abt", "atb", "tab", "tba"]
*/
