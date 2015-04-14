public quicksort
{
    public static void quickSort( int[] list,int start,int end)
    {
    
	int i = 0;
	if (start < end)
	    {
		i = partition(list,start,end);
		quickSort(list,start,i);
		quickSort(list,i+1,end);
	    }
    }
}
