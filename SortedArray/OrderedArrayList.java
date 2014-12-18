import java.util.*;
public class OrderedArrayList{
    private ArrayList<Comparable> data;

    public OrderedArrayList(){
	data = new ArrayList<Comparable>();
    }
    public String toString(){
	String s = "";
	for (int x = 0;x < data.size();x++){
	    s+=data.get(x)+" ";
	}
	return s;
    }
    public boolean add(Comparable n){
	if (data.size() == 0) {
	    data.add(n);
	}
	else if ((data.size() > 0) && (n.compareTo(data.get(0))) < 0){
	    data.add(0,n);
	    return true;
	}
	else if ((data.size()>0) && (n.compareTo(data.get(data.size()-1))) > 0){
	    data.add(n);
	    return true;
	}
	else {
	    for (int c = 0;c<data.size();c++){
		if ((n.compareTo(data.get(c))>0)&&(n.compareTo(data.get(c+1))<0)){
		    data.add(c+1,n);
		    return true;
		}	
	    }
	}
	return false;
    }

    public Comparable remove(int n){ return data.remove(n);}
    public Comparable get(int n){ return data.get(n);}
    public int size(){ return data.size();}

    public int find(Comparable n)
    {
	for (int x = 0;x<data.size();x++)
	    {
		if (data.get(x).compareTo(n)==0)
		    {
			return x;
		    }
	    }
	return -1;
    }


    public static void main(String[] args){
	OrderedArrayList arr = new OrderedArrayList();
	OrderedArrayList x = new OrderedArrayList();
	arr.add(1);
	arr.add(3);
	arr.add(2);
	System.out.println(arr);
	x.add("a");
	x.add("b");
	System.out.println(x);
	System.out.println(x.find("ba"));
    }
}
