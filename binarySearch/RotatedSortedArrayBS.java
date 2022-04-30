package binarySearch;

public class RotatedSortedArrayBS 
{
	
	static int rotated_bs(int arr[], int key)
	{
		int s = 0 , e = arr.length - 1 ;
		
		while (s <= e)
		{
			int mid = (s+e)/2 ;
			if (arr[mid] == key) return mid ;
			
			if (arr[s] <= arr[mid])
			{
				if (arr[mid] > key && arr[s] <= key) e = mid-1 ;
				else s= mid+1 ;
			}
			else
			{
				if(arr[mid] < key && arr[e] >= key) s = mid+1 ;
				else e = mid - 1 ;
			}	
		}
		
		return -1 ;
	}

	public static void main(String[] args) 
	{
		int arr[] = {3, 1} ;
		System.out.println(rotated_bs(arr, 1));

	}

}
