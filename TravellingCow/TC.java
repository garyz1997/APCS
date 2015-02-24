public class TC
{
    public int rows = 4;
    public int cols = 5;
    public int ans = 0;
    public char[][] field = {{'.','.','.','*','.'},{'.','.','.','*','.'},{'.','.','.','.','.'},{'.','.','.','.','.'}};
    // 0 up, 1 right, 2 down, 3 left

    public int move(int rowStart,int colStart, int rowEnd, int colEnd, int time,int numMoves)
    {
	int x = 0;
	System.out.println(ans);
	if (numMoves>time)
	    return 0;
	if ((rowStart==rowEnd)&&(colStart==colEnd)&&(numMoves==time))
	    return 1;
	if (openMove(rowStart,colStart,1))
	    x += move(rowStart,colStart+1,rowEnd,colEnd,time,numMoves+1);
	if (openMove(rowStart,colStart,2))
            x += move(rowStart+1,colStart,rowEnd,colEnd,time,numMoves+1);
	if (openMove(rowStart,colStart,3))
            x += move(rowStart,colStart-1,rowEnd,colEnd,time,numMoves+1);
	if (openMove(rowStart,colStart,0))
            x += move(rowStart-1,colStart,rowEnd,colEnd,time,numMoves+1);
	return x;
    }
    
    public boolean openMove(int r, int c, int dir)
    {
	if (dir == 1)//right
	    {
		if ((c+1<cols)&&(field[r][c+1] == '.'))
		    return true;
	    }
	if (dir == 2)//down
            {
                if ((r+1<rows)&&(field[r+1][c] == '.'))
                    return true;
            }
        if (dir == 3)//left
            {
                if ((c-1>0)&&(field[r][c-1] == '.'))
                    return true;
            }
        if (dir == 0)//up
            {
                if ((r-1>0)&&(field[r-1][c] == '.'))
                    return true;
            }
	return false;
    }
    
    public static void main(String[] args)
    {
	TC moo = new TC();
	System.out.println(moo.move(0,2,0,4,6,0));
    }
}
