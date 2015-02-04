public class Fib
{
    public int fibnum(int n,int low, int high, int count)
    {
	if (count != n)
	    {
		return fibnum(n,high,low+high,count+1);
	    }
	else
	    {
		return low;
	    }
    }

    public static void main(String[] args)
    {
	Fib a = new Fib();
	for (int b = 1;b<25;b++)
	    {
		System.out.println(a.fibnum(b,1,1,1));
	    }
    }
}
