import java.io.*;
import java.util.*;

public class Maze {
    char[][] board;
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

    public Maze() {
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];

	try {	    
 	    Scanner sc = new Scanner(new File("maze2.dat"));
	    int j=0;

	    while (sc.hasNext()) {
		String line = sc.nextLine();
		for (int i=0; i < maxX; i++) {
		    board[i][j] = line.charAt(i);
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
		s = s +board[x][y];
	    s=s+"\n";
	}
	
	return clear + hide + go(0,0) + s + show;
    }

    
    public void solve() {
	solveHelper( 1, 1 );
    }

    public boolean solveHelper( int x, int y ) {
	
	System.out.println( this );
	wait( 30 );
	
	if ( board[x][y] == '$' )
	    return true;
	if ( board[x][y] != ' ' )
	    return false;
	
	board[x][y] = '+';
	if ( solveHelper( x + 1, y ) )
	    return true;

	else if ( solveHelper( x, y + 1 ) )
	    return true;
	
	else if ( solveHelper( x - 1, y ) )
	    return true;

	else if ( solveHelper( x, y - 1 ) )
	    return true;

	else {
	    board[x][y] = '.';
	    return false;
	}
    }
    
    public static void main(String[] args){
	Maze m = new Maze();
	m.solve();
	System.out.println(m);
    }
}
