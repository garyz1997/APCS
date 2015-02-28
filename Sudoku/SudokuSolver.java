public class TC
{
    public int rows = 4;
    public int cols = 4;
    public int[][] field = {{1,0,4,0},{0,0,3,1},{4,0,2,0},{0,2,0,4}};
    public int sum = 0;
    public int[] numbers= new int[rows+1];//unused numbers [0,1,0,0,1]
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
	
    public static boolean solve(int[][]puzzle){
	//using backtracking
	for(int i = 0; i<9; i++){
	    for(int j = 0; j<9; j++){
		if(puzzle[i][j]!=0){
		    continue;
		}
		for(int n = 1; n<10; n++){ //testing posabilities
		    if(isTrue(puzzle, i, j, n)){
			puzzle[i][j] = n;
			if(solve(puzzle))
			    return true;
			else{
			    puzzle[i][j] = 0; //backtrack here
			}
		    }
		}
		return false; //no possibilities for the empty space
	    }
	}
	return true; //hits end of the puzzle
    }
    //checks to see if an int possible in the puzzle at space [i][j] is acceptable
    public static boolean isTrue(int [][]puzzle, int y, int x, int possible){
	if(checkRow(puzzle, x, possible) || checkColumn(puzzle, y, possible) || checkBox(puzzle, y, x, possible))
	    return false;
	else
	    return true;
    }
    //checking the row, if there is a conflict ie possible is found in row already, return true
    public static boolean checkRow(int[][]puzzle, int x, int possible){
	for(int i = 0; i<9; i++){
	    if(puzzle[i][x] == possible)
		return true;
	}
	return false;
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
