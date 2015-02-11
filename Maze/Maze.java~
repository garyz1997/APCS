import java.io.*;
import java.util.*;

public class Maze {
    char[][] board;
    int maxX;
    int maxY;

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
	return false;
    }
    
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);

    }
}
