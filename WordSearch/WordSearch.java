import java.util.*;
import java.io.*;
public class WordSearch {
    private char[][] grid;
    private String[] words;
    //private String[] possiblewords;

    public ArrayList<String> loadDictionary() {
	String s = "zzz";
	ArrayList<String> dictionary = new ArrayList<String>();
	
	try {
	    FileReader f = new FileReader("wordlist.txt");
	    BufferedReader b = new BufferedReader(f);
	    while( s != null ) {
		s = b.readLine();
		if ( s != null )
		    dictionary.add(s);
	    }
	}
	catch (IOException e) {}
	
	return dictionary;
    }

    public WordSearch(){
	grid = new char[10][10];
    }

    public WordSearch(int rows, int cols){
	grid = new char[rows][cols];
    }

    public String toString(){

        String s = "";
        for (int a = 0; a < grid.length; a ++) {
            for (int b = 0; b < grid[a].length; b ++) {
                s += grid[a][b] + " ";
            }
            s += "\n";
        }
	for (int c = 0; c < words.length; c++){
	    s += "\n" + words[c];
	}
        return s;

    }

    public static void main(String[] args){
	WordSearch a = new WordSearch();
	//System.out.println(a.loadDictionary());
	/*
	WordSearch ws = new WordSearch();
        
        //working horizontal words
        ws.addWordH(0, 0, "hello");
        ws.addWordH(2, 4, "batman");
        ws.addWordH(5, 1, "apple");

        //Horizontal index error checking
        ws.addWordH(-2, 4, "joker");
        ws.addWordH(10, 4, "unicorn");  
        ws.addWordH(3, -1, "cowboys");
        ws.addWordH(5, 8, "dogs");

        //horizontal collision checking
        ws.addWordH(5, 3, "plow");
        ws.addWordH(2, 0, "neato");
        
        //working vertical words
        ws.addWordV(1, 0, "nice");
        ws.addWordV(4, 9, "yankee");
        ws.addWordV(4, 4, "old");
        
        //Verical index error checking
        ws.addWordV(-2, 4, "joker");
        ws.addWordV(7, 4, "unicorn");   
        ws.addWordV(3, -1, "cowboys");
        ws.addWordV(5, 20, "dogs");
        
        //vertical collision checking
        ws.addWordV(0, 4, "ores");
        ws.addWordV(4, 9, "goober");
       
        //working diagonal words
        ws.addWordD(7, 0,  "cat");
        ws.addWordD(0, 0, "home");
        ws.addWordD(0, 3, "loam");
        //Diagonal index error checking
        ws.addWordD(-2, 0,  "cat");
        ws.addWordD(3, -1,  "whelm");
        ws.addWordD(7, 7,  "after");    

        //Diagonal collision checking
        ws.addWordD(0, 4, "ores");
        ws.addWordD(4, 4, "oats");

        System.out.println(ws);
        
        ws.fillGrid();
        System.out.println(ws);
	*/
    }
}
import java.util.*;
import java.io.*;
public class WordTree
{

	Arraylist<String> dict;
	WTreeNode root;

	public ArrayList<String> loadDictionary()
	{
		String s = "zzz";
		ArrayList<String> dictionary = new ArrayList<String>();
		try
		{
			FileReader f = new FileReader("wordlist.txt");
			BufferedReader b = new BufferedReader(f);
			while( s != null )
			{
				s = b.readLine();
				if ( s != null )
				dictionary.add(s);
			}
		}
		catch (IOException e) {}
		return dictionary;
	}


	// Dict.add(")
	public WordTree()
	{
		dict = loadDictionary();
		rot = '0';
		WTreeNode curr = root;
		for (String s : dict)
			{
			int count = 0;
			while (count < s.length())
				{
					if (curr.getKids().contains(s.charAt(count)))
						{
							curr = curr.getKids()//set the thing to a new node
						}
					}
				}
			}
	}


	public void add( WTreeNode w ) 
	{
		curr WeTreeNode = 
		if (root.getKids().size() == 0)
		{
			root.setKid( w );
			return;
		}
		while (w.getKids().size() != 0)
		{
			if (root.indexOf(w) > -1)
				
		}
	}
		
	
	public static void main(String[] args)
	{
		WordTree Tina = new WordTre();
	
	}
}
