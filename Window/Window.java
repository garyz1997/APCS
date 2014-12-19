public class Window {
    private int myNumRows, myNumCols;
    private int[][] myMat;
    public Window(int r, int c) {
        myNumRows = r;
        myNumCols = c;
        myMat = new int[r][c];
        fillWindow();
    }
    public void fillWindow() {
        for (int i = 0; i < myNumRows; i++)
            for (int j = 0; j < myNumCols; j++) myMat[i][j] = (int)(Math.random() * 90) + 10;
    }
    public String toString() {
	String s = "";
	for (int i = 0; i < myNumRows; i++) {
	    for (int j = 0; j < myNumCols; j++) s += myMat[i][j] + " ";
	    s += "\n";
	}
	return s;
    }
    //SOLUTIONS GO HERE!!! 
    public boolean isInBounds(int row, int col) {
        if ((row >= 0) && (row < myNumRows) && (col >= 0) && (col < myNumCols)) return true;
        return false;
    }
    public void colorSquare(int ULrow, int ULcol, int n, int val) {
	for (int a = ULrow; a < ULrow + n; a++) {
	    for (int b = ULcol; b < ULcol + n; b++) {
		if (this.isInBounds(a,b)) myMat[a][b] = val;
	    }
	}
    }
    public void enlarge(int ULrow, int ULcol, int numRows, int numCols, int factor) {
	for (int a = ULrow+numRows-1;a >= ULrow;a--){
	    for (int b = ULcol+numCols-1;b >= ULcol;b--){
		this.colorSquare(a*factor,b*factor,factor,myMat[a][b]);
	    }
	}
    }
    public int valAt(int row, int col){
	return myMat[row][col];
    }
    public static void main(String[] args) {
	Window w = new Window(5, 4);
	System.out.println(w.isInBounds(4,3));
	System.out.println(w.isInBounds(4,4));
	System.out.println("Before colorSquare: \n" + w);
	w.colorSquare(2,2,10,99);
	System.out.println("Before enlarge: \n" +w);
	w.enlarge(0,0,2,2,2);
	System.out.println("After enlarge: \n" +w);
	System.out.println("Value at row 2 col 3 is: "+w.valAt(2,3));
    }
}


