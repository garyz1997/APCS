import java.util.*;
import java.io.*;
public class WTreeNode {
    private boolean isEnd;
    private char data;
    ArrayList<WTreeNode> children = new ArrayList<WTreeNode>();
    
    public WTreeNode( char c ){
	data = c;
    }
    
    public String toString() {
	return "" + data;
    }
    
    public void setData( char c ) {
	data = c;
    }
    
    public char getData() {
	return data;
    }
    
    public void addKid( WTreeNode w ) {
	children.add(w);
    }
    
    public void setEnd(boolean b)
    {
	isEnd = b;
    }
    public boolean getEnd()
    {
	if (isEnd == true) return true;
	else return false;
    }

    public ArrayList<WTreeNode> getKids() {
	return children;
    }
}
