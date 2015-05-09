import java.util.*;
import java.io.*;
public class WordTree
{

    ArrayList<String> dict = new ArrayList<String>();
    static WTreeNode root;

    public ArrayList<String> loadDictionary()
    {
	String s = "zzz";
	ArrayList<String> dictionary = new ArrayList<String>();
	try
	    {
		FileReader f = new FileReader("words_test.txt");
		BufferedReader b = new BufferedReader(f);
		while( s != null )
		    {
			s = b.readLine();
			if ( s != null )
			    dictionary.add(s);
		    }
	    }
	catch (IOException e) {}
	System.out.println(dictionary);
	return dictionary;
    }


    // Dict.add(")
    public WTreeNode WordTree()
    {
	dict = loadDictionary();
	root = new WTreeNode('0');
	WTreeNode curr = new WTreeNode(root.getData());
	root = curr;
	for (String s : dict)
	    {
		int count = 0;
		curr = root;
		while (count < s.length())
		    {
			boolean cont = false;
			for (WTreeNode child: curr.getKids())
			    {
				if (child.getData()==s.charAt(count))
				    {
					cont = true;
					curr = child;
				    }
			    }
			if (cont == true)
			    {
				count++;
			    }
			else
			    {
				WTreeNode nextNode = new WTreeNode(s.charAt(count));
				curr.addKid(nextNode);
				curr = nextNode;
				count++;
			    }
		    }
		curr.setEnd(true);
	    }
	return root;
    }
    
    public String getRandom()
    {
	String ans = "";
	WTreeNode curr = root;
	while (curr.getKids().size() != 0)
	    {
		if ((curr.getEnd() == true) && ((int)(Math.random()*(curr.getKids().size()+1)) == 0))
		    {
			return ans;
		    }
		else
		    {
			curr = curr.getKids().get((int)(Math.random()*curr.getKids().size()));
			ans+=(curr.getData());
		    }
	    }
	return ans;
    }

    public int longest()
    {
	int count = 0;
	//String ans = "";
	count = longestHelper(root,0);
	System.out.println(count);
	return count;
    }

    public int longestHelper(WTreeNode w, int a)
    {
	int p = 0;
	if (w.getKids().size()==0) return a;
	else
	    {
		for (WTreeNode x:w.getKids())
		    {
			int curr = longestHelper(x,a+1);
			if (curr > p)
			    {
				p = curr;

			    }
		    }	
	    }
	return p;
    } 

    public String longestWord()
    {
	int num = longest();
	//System.out.println(longest());
	int count = 0;
	String ans = "";
	ans+=Character.toString(longestWordhelper(root,0,num));
	return ans;
    }
    public char longestWordhelper(WTreeNode w, int a, int match)
    {
	if (a==match)
	    {
		return w.getData();
	    }
	else
	    {
		for (WTreeNode x:w.getKids())
		    {
			return longestWordhelper(x,a+1,match);
		    }
	    }
		return ' ';
	    
	//return ' ';
    }

    public ArrayList<String> beginning(String pre)
    {
	int count = 0;
	WTreeNode curr = root;
	ArrayList<String> ans = new ArrayList<String>();
	while (count < pre.length())
	    {
		for (WTreeNode w : curr.getKids())
		    {
			if (Character.toString(w.getData()).equals(pre.substring(0,1)))
			    {
				count++;
				curr = w;
			    }
		    }
	    }
	//now curr is the node with the last letter of the prefix
	for (WTreeNode x : curr.getKids())
	    {	
		ans.add(pre+beginningHelper(x));
	    }
	return ans;
    }
    public String beginningHelper(WTreeNode w)
    {
	if (w.getKids().size()==0) return Character.toString(w.getData());
	
	for (WTreeNode x : w.getKids())
	    {
		return Character.toString(w.getData()) + beginningHelper(x);
	    } 
	return "";
    }
    /*
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
    */
    public void printTree(WTreeNode bleh)
    {
	int count = 0;
	WTreeNode curr = bleh;
	while (count < 1)
	    {
		if (curr.getKids().size()==0)
		    System.out.println("\n_____");
		for (WTreeNode a : curr.getKids())
		    {
			System.out.print(a.getData());
			printTree(a);
		    }
		count++;
	    }
    }
    public static void main(String[] args)
    {
	WordTree Tina = new WordTree();
	System.out.println(Tina.WordTree());
	System.out.println(root.getKids());
	Tina.printTree(root);
	for (int a = 0;a<50;a++)
	    {
		System.out.println(Tina.getRandom());
	    }
	System.out.println();
	System.out.println(Tina.longestWord());
	//System.out.println(Tina.beginning("a"));
	//Tina.loadDictionary();
    }
}
