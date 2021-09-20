package searchingAlgorithms;

public class LinearSearch 
{

	static int linearSearch(int arr[] , int key)
	{
		
		for (int i = 0 ; i < arr.length ; i++)
		{
			if (arr[i] == key) return i ;
		}
		return -1 ;
	}
	
	public static void main(String[] args) 
	{
         int arr[] = {5 , 4 , 3 , 2 , 1 , 10 , 9  , 8} ;
         System.out.println(linearSearch(arr , 100));
	}

}
