package sorting;


public class insertionSort 
{

	public static void main(String[] args) 
	{
		int arr[] = {10,1,2,3,42,100,4,2,3};
		
		for (int firstUnsortedPos = 1 ; firstUnsortedPos < arr.length ; firstUnsortedPos++)
		{
			int temp = arr[firstUnsortedPos] ;
			int i = firstUnsortedPos ;
			for ( ; i > 0 && temp < arr[i-1] ; i--)
			{
				arr[i] = arr[i-1] ;
			}
			arr[i] = temp ;
		}
		
		for (int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ") ;

	}

}
