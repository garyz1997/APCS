import java.util.*;

public class Stat {

    private int[] data;

    /**
     * Initialize the data array to a size of your choosing.
     */
    public Stat()  {
	data = new int[10];
    }
    
    /**
     * Initialize the data array to the specified size.
     */
    public Stat(int s)  {
	data = new int[s];
    }

    /**
     * Returns a string that contains all the elements of the array.
     */
    public String toString() {
	String s = "";

	for(int i=0; i < data.length; i++ )
	    s+= data[i] + " ";

	return s;
    }
    
    /*
     * Go through the array and have the user enter 
     * values for each available space.
     */
    public void setValues() {
	Scanner scan = new Scanner( System.in );

	for(int i=0; i < data.length; i++ ) {

	    System.out.print( "Enter data: " );
	    data[i] = scan.nextInt();
	}
    }

    /**
     * Return the sum of all the data in the array.
     */
    public int calcSum() {
	int sum = 0;
	for(int i=0; i < data.length; i++ )
	    sum+= data[i];
	
	return sum;
    }

    /**
     * Return the average of the data in the array.
     */
    public double calcAvg() {
	return calcSum() * 1.0 / data.length;
    }

    /**
     * Return the smallest value in the array.
     */
    public int findMin() {
	int min = data[0];

	for(int i=1; i < data.length; i++ )
	    if ( data[i] < min )
		min = data[i];
	    
	return min;
    }

    /**
     * Return the largest value in the array.
     */
    public int findMax() {
	int max = data[0];

	for(int i=1; i < data.length; i++ )
	    if ( data[i] > max )
		max = data[i];
	    
	return max;
    }


    public int frequency( int n ) {

	int freq = 0;
	for(int i=0; i < data.length; i++ )
	    if ( data[i] == n )
		freq++;

	return freq;
    }


    public boolean evenBalance() {
	int lsum = 0;
	int rsum = 0;

	for (int i=0; i < data.length/2; i++ ) {
	    lsum+= data[i];
	    rsum+= data[ data.length - 1 - i];
	}
	return lsum == rsum;
    }

    public int mode() {
	int guess = data[0];
	int freq = frequency( guess );

	for (int i=1; i < data.length; i++ ) {
	    if ( frequency( data[i] ) > freq ) {
		freq = frequency( data[i] );
		guess = data[i];
	    }
	}
	return guess;
    }

    public static void main( String[] args ) {

	int n;
	Stat s;
	Scanner scan = new Scanner( System.in );
	
	System.out.print("Number of entries: ");
	n = scan.nextInt();

	s = new Stat(n);

	s.setValues();
	System.out.println( "Data: " + s );
	System.out.println("Sum: " +  s.calcSum() );
	System.out.println("Average: " + s.calcAvg() );
	System.out.println("Min: " + s.findMin() );
	System.out.println("Max: " + s.findMax() );

	System.out.println( "Frequency of 10: " + s.frequency(10));
	System.out.println( "Frequency of -1: " + s.frequency(-1));

	System.out.println( "Balanced? " + s.evenBalance() );

	System.out.println( "Mode: " + s.mode() );
    }
}
