import java.io.*;
import java.util.*;

public class Map
{
    int maxX=127;
    int maxY=36;
    char[][] board = new char[maxX][maxY];    
    
    
    static final String clear = "\033[2J";
    static final String hide = "\033[?25l";
    static final String show = "\033[?25h";
    
    public String go(int x, int y) 
    {
	return "\033[" + x + ";" + y + "H";
    }
    
    public void wait( int ms ) 
    {
	try 
	    {
		Thread.sleep( ms );
	    }
	catch( Exception e ) {}
    }

    public Map(int choice)
    {
	if (choice==0)
	    {
		try 
		    {	    
			Scanner sc = new Scanner(new File("intro.dat"));
			int j=0;
		
			while (sc.hasNext())
			    {
				String line = sc.nextLine();
				for (int i=0; i < maxX; i++) 
				    {
					board[i][j] = line.charAt(i);
				    }
				j++;
			    }
		    }
		catch (Exception e) {}	
	    }
	
	if (choice==1)
	    {
		try 
		    {	    
			Scanner sc = new Scanner(new File("Maze1.dat"));
			int j=0;
		
			while (sc.hasNext())
			    {
				String line = sc.nextLine();
				for (int i=0; i < maxX; i++) 
				    {
					board[i][j] = line.charAt(i);
				    }
				j++;
			    }
		    }
		catch (Exception e) {}	
	    }
    }

    public String toString() 
    {
	String s = "";
	for (int y=0;y<maxY;y++) 
	    {
		for (int x=0;x<maxX;x++)
		    s = s +board[x][y];
		s=s+"\n";
	    }
	return clear + hide + go(0,0) + s + show;
    }

    public String spawn()
    {
	for (int a = 1;a<maxX-1;a++)
	    {
		for (int b =1;b<maxX-1;b++)
		    {
			if ((int)(Math.random()*10) == 0)//spawns monsters in 1/10 of the spaces
			    {
				board[a][b]='@';//monsters: @
			    }
		    }
	    }
	return "The monsters have risen";
    }

    public void reset()
    {
	for (int a = 1;a<maxX-1;a++)
	    {
		for (int b =1;b<maxX-1;b++)
		    {
			board[a][b]=' ';
		    }
	    }
    }

    public static void main(String[] args)
    {
	Scanner input  = new Scanner(System.in);
	//System.out.println("What is the size of the board? (integer from 5 to 9)");
	//int side = input.nextInt();
	Map m = new Map(0);
	m.reset();
	System.out.println(m.spawn());
	//m.solve();
	System.out.println(m);
	m.reset();
	System.out.println(m);
    }
    

}
