public class MakeLake
{
    public int rows;
    public int cols;
    private int[][] lake = { {28,25,20,32,34,36},{27,25,20,20,30,34},{24,20,20,20,20,20},{20,20,14,14,20,20} };
    
    public int MakeLake(int row,int col,int stomp)
    {
	int max = findmax(row,col);
	return max;
    }

    public int findmax(int rowstart,int colstart)
    {
	int ans = lake[rowstart][colstart];
	for (int a = rowstart;a < rowstart+3;a++)
	    {
		for (int b = colstart;b<colstart+3;b++)
		    {
			if (lake[rowstart][colstart] > ans)
			    ans = lake[rowstart][colstart];
		    }
	    }
	return ans;
    }
    public String printlake()
    {
	for (a = 0;a<lake.length
    }
    public static void main(String[] args)
    {
	MakeLake hello = new MakeLake();
	System.out.println(hello.MakeLake(0,3,6));
	System.out.println(hello.lake);
    }
}
