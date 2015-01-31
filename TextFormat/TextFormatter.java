public class TextFormatter
{
    private String line;
    public TextFormatter(String lineToFormat)
    {
	line = lineToFormat;
    }

    private int findString(String str, int start)
    {
	char strChar = str.charAt(0);
	for (int x = start;x<line.length()-2;x++)
	    {
		char lineChar = line.charAt(x);
		char nextChar = line.charAt(x+1);
		if ((lineChar==strChar) && (lineChar != nextChar))
		    {
			return x;
		    }
		if (lineChar == nextChar)
		    {
			x++;
		    }
	    }
	if ((line.charAt(line.length()-1)==strChar) && (line.charAt(line.length()-2) != strChar))
	    {
		return line.length()-1;
	    }
	return -1;
    }

    private int countStrings(String str)
    {
	int count = 0;
	char strChar = str.charAt(0);
	for (int x = 0;x<line.length()-2;x++)
	    {
		char lineChar = line.charAt(x);
		char nextChar = line.charAt(x+1);
		if ((lineChar==strChar) && (lineChar != nextChar))
		    {
			count++;
		    }
		if (lineChar == nextChar)
		    {
			x++;
		    }
	    }
	if ((line.charAt(line.length()-1)==strChar) && (line.charAt(line.length()-2) != strChar))
	    {
		count++;
	    }
	return count;
    }

    public String convertItalics()
    {
	String ans = "";
	int match = 0;
	for (int a = 0;a<line.length()-3;a++)
	    {
		if (line.charAt(a)=='_')
		    {
			match++;
			int c = a+2;
			for (int b = c;b<line.length()-1;b++)
			    {
				if (line.charAt(b)=='_')
				    {
					for (int d = a;d<b;d++)
					    {
						if (d == a)
						    {
							ans+="<I>";
						    }
						else
						    {
							ans+=line.charAt(d);
						    }
					    }
					ans += "</I>";
					match++;
					a=b+1;
					b = line.length();
				    }
			    }
			if (match==1)
			    {
				for (int e = c-2;e<line.length()-1;e++)
				    {
					ans+= line.charAt(e);
				    }
			    }
		    }
		else
		    {
			ans+=line.charAt(a);
		    }
		match=0;
	    }
	String backwards = "";
	for (int g = line.length()-1;g>=line.length()-3;g--)
	    {
		if (line.charAt(g) == '_')
		    {
			g = 0;
		    }
		else
		    {
			backwards+=line.charAt(g);
		    }
	    }
	for (int h = backwards.length()-1;h>=0;h--)
	    {
		ans+=backwards.charAt(h);
	    }
	return ans;
    }


    public static void main(String[] args)
    {
	TextFormatter o = new TextFormatter("aabaccb");
	System.out.println(o.findString("a",0));
	System.out.println(o.findString("b",4));
	System.out.println(o.findString("c",0));
	System.out.println(o.countStrings("a"));
	System.out.println(o.countStrings("b"));
	System.out.println(o.countStrings("c"));
	TextFormatter a = new TextFormatter("This is _very_ _good_.");
	System.out.println(a.convertItalics());
    }






}
