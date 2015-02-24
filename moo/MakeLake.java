public class MakeLake
{
    public int rows4 = 4;
    public int cols6 = 6;
    private int[][] lake = { {28,25,20,32,34,36},{27,25,20,20,30,34},{24,20,20,20,20,30},{20,20,14,14,20,20} };
    
    public int MakeLake(int row,int col,int stomp)
    {

	System.out.println("(row "+(row)+", col "+(col)+")");
	int newmax = findmax(row-1,col-1)-stomp;
	System.out.println(stomp(row-1, col-1, newmax));
	return newmax;
    }

    public int findmax(int rowstart,int colstart)
    {
	String box = "";
	int ans = lake[rowstart][colstart];
	for (int a = rowstart;a < rowstart+3;a++)
	    {
		for (int b = colstart;b<colstart+3;b++)
		    {
			box += lake[a][b] + "\t";
			if (lake[a][b] > ans)
			    ans = lake[a][b];
		    }
		box += "\n";
	    }
	System.out.println(box);
	return ans;
    }
    public String printlake(int rows, int cols)
    {
	String ans = "";
	for (int a = 0;a<rows;a++)
	    {
		for (int b = 0;b<cols;b++)
		    {
			ans += lake[a][b] + "\t";
		    }
		ans += "\n";
	    }
	return ans;
    }

    public String stomp(int rowstart,int colstart,int max)
    {
	String newLake = "";
	for (int a = rowstart;a < rowstart+3;a++)
            {
                for (int b = colstart;b<colstart+3;b++)
                    {
                       
                        if (lake[a][b] > max)
                            lake[a][b] = max;
			newLake += lake[a][b] + "\t";
                    }
                newLake += "\n";
            }
	return newLake;
    } 
    public int depth(int deep)
    {
	String newLake = "";
	int ans = 0;
	for (int a = 0;a < rows4;a++)
            {
                for (int b = 0;b<cols6;b++)
                    { 
                        if (lake[a][b] > deep)
                            lake[a][b] = 0;
			else
			    lake[a][b] = deep - lake[a][b];
			newLake += lake[a][b] + "\t";
			ans+=lake[a][b];
		    }
                newLake += "\n";
            }
        System.out.println(newLake);
	return ans*72*72;

    }
    public static void main(String[] args)
    {
	MakeLake hello = new MakeLake();
	System.out.println("\n"+hello.printlake(4,6));
	System.out.println(hello.MakeLake(1,4,4));
	System.out.println(hello.MakeLake(1,1,10));
	System.out.println("\n"+hello.printlake(4,6));
	System.out.println("Volume: "+hello.depth(22));
    }
}
