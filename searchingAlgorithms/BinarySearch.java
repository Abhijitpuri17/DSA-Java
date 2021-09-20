package searchingAlgorithms;

public class BinarySearch
{

	static int binarySearch(int arr[] , int key)     // Array must be sorted
	{
		int l = 0 , h = arr.length - 1 , mid ;
		while (l <= h)
		{
			mid = (l+h)/2 ;
			if (arr[mid] == key) return mid ;
		    if (arr[mid] > key) h = mid - 1 ;
			else l = mid + 1 ;
		}
		return -1;
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {1 , 2 , 4 , 9 , 16 , 40} ;
        System.out.println(binarySearch(arr , 100));

	}

}
