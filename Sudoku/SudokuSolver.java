import java.io.*;
import java.util.*;


public class SudokuSolver
{
    public int rows = 4;
    public int cols = 4;
    public int[][] field = {{1,0,4,0},{0,0,3,1},{4,0,2,0},{0,2,0,4}};
    public int sum = 0;
    public int[] numbers= new int[rows+1];//unused numbers [0,1,0,0,1]
    public int[] coord = new int[2];
    public int missingNums;
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

    public void SudokuSolver() {
        int maxX=rows;
        int maxY=cols;
        field = new int[maxX][maxY];

        try {       
            Scanner sc = new Scanner(new File("maze2.dat"));
            int j=0;

            while (sc.hasNext()) {
                String line = sc.nextLine();
                for (int i=0; i < maxX; i++) {
                    field[i][j] = line.charAt(i)-48;
                }
                j++;
            }
        }
        catch (Exception e) {}  
    }

    public String toString() {
        String s = "";
        for (int y=0;y<cols;y++) {
            for (int x=0;x<rows;x++)
                s = s +field[x][y] + "\t";
            s=s+"\n";
        }
        
        return clear + hide + go(0,0) + s + show;
    }


    
    public void nums(int x)
    {

	for(int b = 1;b<rows+1;b++)//checks 1 to 4
	    {
		if (this.binarySearch(field[x],b) <0)
		    {
			numbers[b]=1;
			System.out.println(numbers);
		    }
	    }
    }
    
    public boolean solve() {
	for (int x = 0;x<rows;x++)
	    {
		this.nums(x);
		int z = 0;
		for (int a = 1;a<=cols;a++)
		    {
			if (numbers[a] != 1)
			    {
				numbers[a] = 1;
				z = a;
				break;
			    }
		    }
		for (int b = 0; b<cols;b++)
		    {
			if (field[x][b] != 0)
			    {
				field[x][b]=z;
				x--;
			    }
		    }
	    }
	this.sumRow();
        if (this.isSolved())
            return true;
	return solve();
	return false;
    }

    public boolean emptySpace()
    {
        for (int a = 0;a<rows;a++)
            {
                for (int b = 0;b<cols;b++)
                    {
                        if (field[a][b] == 0)
			    {
				coord[0]=a;
				coord[1]=b;
				return true;
			    }
		    }
	    }
	return false;
    }
    public boolean isSolved()
    {
	int horiz = 0;
	for (int a = 0;a<rows;a++)
	    {
		for (int b = 0;b<cols;b++)
		    {
			horiz += field[a][b];
		    }
		if (horiz != sum)
		    return false;
		horiz = 0;
	    }
	for (int a = 0;a<rows;a++)
            {
                for (int b = 0;b<cols;b++)
                    {
                        horiz += field[b][a];
                    }
                if (horiz != sum)
                    return false;
                horiz = 0;
            }
	return true;
    }

	public int sumRow()
	{
	    int ans = 0;
	    for (int a = 1;a<=cols;a++)
		{
		    ans+=a;
		}
	    sum = ans;
	    return ans;
	}

    public static void main(String[] args)
    {
	SudokuSolver moo = new SudokuSolver();
	System.out.println(moo.solve());
    }
}
/*
1-4-
--31
4-2-
-2-4
*/
