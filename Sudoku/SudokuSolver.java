public class TC
{
    public int rows = 4;
    public int cols = 4;
    public int[][] field = {{1,0,4,0},{0,0,3,1},{4,0,2,0},{0,2,0,4}};
    public int sum = 0;
    public int[] numbers= new int[rows+1];
    public int[] coord = new int[2];
    public int missingNums;

    
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
    
    public boolean solve( int x, int y, int count) {
	this.nums(x);
	int z = 0;
	for (int a = 1;a<=rows;a++)
	    {
		if (numbers[a] != 1)
		    {
			z = a;
			break;
		    }
	    }

	this.sumRow();
        if (isSolved)
            return true;
	return solve(coord[0],coord[1]);
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
	board[x][y] = 0;
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
	    for (int a = 1;a<=num;a++)
		{
		    ans+=a;
		}
	    sum = ans;
	    return ans;
	}
	
    public static void main(String[] args)
    {
	TC moo = new TC();
	System.out.println(moo.solve(0,2,0,4,6,0));
    }
}
1-4-
--31
4-2-
-2-4
