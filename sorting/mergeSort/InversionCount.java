package sorting.mergeSort;

public class InversionCount
{
	// inversion ==> i < j and arr[i] > arr[j]
	
	static int inversion_count(int arr[], int s, int e)
	{
		if (s >= e) return 0;
		
		int mid = (s+e)/2 ;
		
		int c1 = inversion_count(arr, s, mid);
		int c2 = inversion_count(arr, mid+1, e);

		
		int CI = merge(arr, s, mid, e) ;
		return c1 + c2 + CI ;
	}
	
	
	static int merge(int arr[], int s, int mid, int e)
	{
		
		int cnt = 0 ;
		
		int i = s , j = mid+1 , k = 0;
		int temp[] = new int[e-s+1] ;
		
		while (i <= mid && j <= e)
		{
			if (arr[i] < arr[j]) 
			{
				temp[k++] = arr[i++] ;
			}
			else 
			{
				cnt += mid - i + 1 ;
				temp[k++] = arr[j++] ;
			}
		}
		
		while (i <= mid ) temp[k++] = arr[i++] ;
		while (j <= e) temp[k++] = arr[j++] ;
		
		
		for (int l = 0 ; l < e-s+1 ; l++)
		{
			arr[s+l] = temp[l] ;
		}
		
		return cnt ;
			
	}
	
	

	public static void main(String[] args) 
	{
		int arr[] = {0, 5, 2, 3, 1} ;
		System.out.println(inversion_count(arr, 0, arr.length-1));
	}

}
