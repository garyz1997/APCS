public class RationalNumber2 {
    private int num;
    private int denom;
    public RationalNumber2(int n, int d){
	num = n;
	denom = d;
    }
    public void display(){
	System.out.println(num + "/" + denom);
    }
    public void add(RationalNumber2 x){
	num = num * x.denom + denom * x.num;
	denom = denom * x.denom;
    }
    public void subtract(RationalNumber2 x){
	num = num * x.denom - denom * x.num;
	denom = denom * x.denom;
    }
    public void gcd(){
	int a = num;
	int b = denom;
	if (a > b){
	    while (a / b != 1){
		
		b = a % b;
		a = b;
		gcd();
	    }
	    System.out.println(b);
	}
    }
    public static void main(String[] args){
	RationalNumber2 hi;
	hi = new RationalNumber2(16, 5);
	hi.display();
	RationalNumber2 bye;
	bye = new RationalNumber2(1, 2);
	bye.display();
	;hi.subtract(bye);
	hi.display();
	hi.gcd();
    }
}
