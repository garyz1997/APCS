public class Knight
{
    public char[][] board = new char[6][6];
    public void Knight
    {
	for (int a = 0;a<6;a++)
	    {
		for (int b = 0;b<6;b++)
		    {
			board[a][b] = '$';
		    }
	    }
	board[5][3]='O';
	board[6][0]='X';
    }
    
    public static void main(String[] args)
    {

    }



    
}
