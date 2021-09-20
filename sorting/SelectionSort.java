package sorting;


public class SelectionSort 
{
	

	public static void main(String[] args)
	{
         
		int arr[] = {10,1,2,3,42,100,4,2,3};
		
		for (int lastUnsortedPos = arr.length - 1 ; lastUnsortedPos > 0 ; lastUnsortedPos--)
		{
			int largestElementPos = 0 ;
			for (int i = 1 ; i <= lastUnsortedPos ; i++)
			{
				if (arr[largestElementPos] < arr[i] ) largestElementPos = i ;
			}
			swap(arr , largestElementPos , lastUnsortedPos) ;
		}

		for (int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ") ;
	}
	
	
	      public static void swap(int arr[] , int i , int j)
         {
        	if (i == j) return ;
          
        	   int temp = arr[i] ;
               arr[i] = arr[j] ;
               arr[j] = temp ;
         }

}
