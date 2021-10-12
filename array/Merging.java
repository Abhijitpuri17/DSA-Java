package array;

public class Merging 
{
	/**
	Given two sorted arrays. Merge them such that entire array is also sorted
	*/
	
	static int[] merge(int a[], int b[])
	{
		int c[] = new int[a.length+b.length] ;
		int i = 0 , j = 0, k = 0 ;
		
		while (i < a.length && j < b.length)
		{
			if (a[i] < b[j]) c[k++] = a[i++] ;
			else c[k++] = b[j++] ;
		}
		
		while (i < a.length) c[k++] = a[i++] ;
		while (j < b.length) c[k++] = b[j++] ;
		
		return c ;
	}

	public static void main(String[] args) 
	{
		int a[] = {1,10,20,30,40,50} ;
		int b[]= {2,12,14,16,35,45,55} ;
		int c[] = merge(a, b) ;
		
		for (int x : c) System.out.print(x + " ");
		

	}

}
