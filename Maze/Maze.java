import java.io.*;
import java.util.*;

public class Maze {
    char[][] board;
    int maxX;
    int maxY;

    static final String clear = "\033[?25l";
    static final String hide = "\033[?25l";
    static final String go = "\033[?25l";

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
    
    private String clear(){
	return  "\033[2J";
    }
    public String toString() {
	String s = "\n";
	s+= clear();
	for (int y=0;y<maxY;y++) {
	    for (int x=0;x<maxX;x++)
		s = s +board[x][y];
	    s=s+"\n";
	}
	return s;
    }

    
    public void solve() {
	solveHelper( 1, 1 );
    }

    public boolean solveHelper( int x, int y ) {
	if (board[x][y] == '$')
	    return true;
        if (board[x][y] != ' ')
	    return false;
	board[x][y] = '.';
	if (solveHelper(x+1,y)){
	    board[x][y] = '+';
	    return true;
	}
	if (solveHelper(x-1,y)){
	    board[x][y] = '+';
	    return true;
	}
	if (solveHelper(x,y-1)){
	    board[x][y] = '+';
	    return true;
	}
	if (solveHelper(x,y+1)){
	    board[x][y] = '+';
	    return true;
	}
	
	return false;
    }
    
    public static void main(String[] args){
	Maze m = new Maze();
	m.solve();
	System.out.println(m);
	//System.out.println(m.clear());

    }
}
