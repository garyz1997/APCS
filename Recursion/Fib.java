public class Fib
{
    public static long fibnum(long n)
    {
	return fibhelp(n,1,1,1);
    }
    public static long fibhelp(long n,long low, long high, long count)
    {
	if (count != n)
	    {
		return fibhelp(n,high,low+high,count+1);
	    }
	else
	    {
		return low;
	    }
    }
    public static long fib2(int k)
    {
	if (k<=2)
	    return 1;
	return fib2(k-1)+fib2(k-2);
    }

    public static long fib3(int k,ArrayList<Long> values)
    {
	if (k <=2)
	    {
		values.add(1);
		return 1;
	    }
	if (k <= values.size())
	    return values.get(k-1);
	return fib2(k-1,values)+fib(k-2,values);
    }
    
    
    public static void main(String[] args)
    {
	for (int b = 1;b<90;b++)
	    {
		System.out.println(fibnum(b));
	    }
	System.out.println(fib2(5));
	ArrayList<Long> vals = new ArrayList<Long>();
	System.out.println(Fib.fib3(50,vals));
    }
}
