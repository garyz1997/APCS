public class WordTree
{

	Arraylist<String> Dict;
	TreeNode root;
	
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
		catch (IOException e)
		return dictionary;
	}
	
	
    //	Dict.add(")
	
	public WordTree() 
	{
		
	}
}
