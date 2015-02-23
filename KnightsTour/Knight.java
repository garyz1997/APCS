import java.io.*;
import java.util.*;

public class Knight {
    int[][] board;
    int maxX;
    int maxY;
    
    

    static final String clear = "\033[2J";
    static final String hide = "\033[?25l";
    static final String show = "\033[?25h";

    public String go(int x, int y) {
	return "\033[" + x + ";" + y + "H";
    }
    
    public void wait( int ms ) {
	try {
	    Thread.sleep( ms );
	}
	catch( Exception e ) {}
    }

    public Knight(int size) {
	maxX=size;
	maxY=size;
	board = new int[maxX][maxY];

	try {	    
 	    Scanner sc = new Scanner(new File("maze2.dat"));
	    int j=0;

	    while (sc.hasNext()) {
		String line = sc.nextLine();
		for (int i=0; i < maxX; i++) {
		    board[i][j] = line.charAt(i)-48;
		}
		j++;
	    }
	}
	catch (Exception e) {}	
    }

    public String toString() {
	String s = "";
	for (int y=0;y<maxY;y++) {
	    for (int x=0;x<maxX;x++)
		s = s +board[x][y] + "\t";
	    s=s+"\n";
	}
	
	return clear + hide + go(0,0) + s + show;
    }

    
    public void solve() {
	solveHelper( 0, 0, 1 );
    }

    public boolean solveHelper( int x, int y, int count ) {
	
	//System.out.println( this );
	//wait( 1 );
	
	if ( count  == maxX*maxY+1 )
	    return true;
	if ((x < 0) || (x >= maxX) || (y<0) || (y>=maxY) || (board[x][y] !=0))
	    return false;
	board[x][y] = count;
	
	
	if ( solveHelper( x + 2, y - 1, count+1 ) )
	    return true;
	else if ( solveHelper( x + 2, y + 1, count+1 ) )
	    return true;
	else if ( solveHelper( x + 1, y + 2,count+1 ) )
	    return true;
	else if ( solveHelper( x + 1, y - 2,count+1 ) )
	    return true;

	else if ( solveHelper( x - 1, y - 2,count+1 ) )
	    return true;
	else if ( solveHelper( x - 1, y + 2,count+1 ) )
	    return true;
	else if ( solveHelper( x - 2, y + 1,count+1 ) )
	    return true;
	else if ( solveHelper( x - 2, y - 1,count+1 ) )
	    return true;




	else {
	    board[x][y] = 0;
	    return false;
	}
	
    }
    
    
    public static void main(String[] args){
	Scanner input  = new Scanner(System.in);
	System.out.println("What is the size of the board? (integer from 5 to 9)");
	int side = input.nextInt();
	Knight m = new Knight(side);
	m.solve();
	System.out.println(m);
    }
}
