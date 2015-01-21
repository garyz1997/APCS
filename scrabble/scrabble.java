import java.util.*;
import java.io.*;
public class scrabble {
    private char[][] grid;
    private String[] words;
    //private String[] possiblewords;

    public ArrayList<String> loadDictionary() {
	String s = "zzz";
	ArrayList<String> dictionary = new ArrayList<String>();
	
	try {
	    FileReader f = new FileReader("words.txt");
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

    public scrabble(String sevenletters){

	ArrayList<Character> letters = new ArrayList<Character>();
	for (int a = 0;a < 7;a++)
	    {
		ArrayList<String> dictSlice = new ArrayList<String>();
		for (int b = 0; b < loadDictionary().size();b++)
		    {
			if (loadDictionary().get(b).charAt(0) == sevenletters.charAt(a))
			    {
				dictSlice.add(loadDictionary().get(b));
			    }
		    }
		for (int c = 0;c < dictSlice.size();c++)
		    {
			for (int d = 0;d < 7;d++)
			    {
				letters.add(sevenletters.charAt(a));			
			    }

			for (int e = 0;e < dictSlice.get(c).length();e++)
			    {
				if (letters.size() != 0)
				    {
					String word = dictSlice.get(c);
					if (letters.contains(word.charAt(e)))
					    {
						if (e == word.length() - 1)
						    {
							System.out.println(word);
						    }
						letters.remove((word.charAt(e)));
					    } 
					else
					    {
						letters.clear();
					    }
				    }
				else 
				    {
					break;
				    }
			    }
			letters.clear();
			
		    }
		System.out.println(dictSlice);
		dictSlice.clear();
	    }
    }



    public String toString(){
	return "0";
    }

    public static void main(String[] args){
	scrabble a = new scrabble("xevenhi");
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
