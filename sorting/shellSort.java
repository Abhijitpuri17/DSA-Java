package sorting;


public class shellSort
{

	       public static void main(String[] args) 
	       {
	    	   int arr[] = {10,1,2,3,42,100,4,2,3};
				
				for (int gap = arr.length/2 ; gap > 0 ; gap /= 2)
				{
					
					for (int i = gap ; i < arr.length ; i++)
					{ 
						int j = i ;
						int temp = arr[i] ;
						while (j >= gap && arr[j-gap] > temp)
						{
							arr[j] = arr[j-gap] ;
							j -= gap ;
						}
						arr[j] = temp ;
					}
					
				}
				
				
				for (int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ");

	       }

}
