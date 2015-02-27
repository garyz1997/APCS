public class TC
{
    public int rows = 4;
    public int cols = 5;
    public char[][] field = {{'.','.','.','*','.'},{'.','.','.','*','.'},{'.','.','.','.','.'},{'.','.','.','.','.'}};
    
    public int solve( int x, int y, int endx, int endy,int time, int numMoves ) {
	int ans = 0;
        if ((time == numMoves)&&(x == endx)&&(y == endy))
            return 1;
        if ((x < 0) || (x >= rows) || (y<0) || (y>=cols) || (numMoves>time) || (field[x][y] == '*'))
            return 0;
	return solve(x, y+1, endx, endy, time, numMoves+1) + solve(x, y-1, endx, endy, time, numMoves+1) + solve(x+1, y, endx, endy, time, numMoves+1) + solve(x-1, y, endx, endy, time, numMoves+1);
    }

    
    public static void main(String[] args)
    {
	TC moo = new TC();
	System.out.println(moo.solve(0,2,0,4,6,0));
    }
}
