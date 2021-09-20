package sorting;

public class CountingSort 
{

	public static void main(String[] args)
	{
		int arr[] = {10,1,2,3,42,100,4,2,3};
      countingSort(arr , 1 , 100) ;
      for (int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ");

	}
	
	public static void countingSort(int arr[] , int min , int max)
	{
		int countArray[] = new int[max-min+1] ;
		
		for (int i = 0 ; i < arr.length ; i++)
		{
			countArray[arr[i]-min]++ ;
		}
		
		
		int j = 0 ;
		for (int i = min ; i <= max ; i++)
		{
			while(countArray[i-min] > 0)
			{
				arr[j++] = i ;
				countArray[i-min]-- ;
			}
		}
	}

}
