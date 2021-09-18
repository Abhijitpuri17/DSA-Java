package array;

public class KadenAlgorithm 
{
	// To find max sum of sub-array from given array
	
	static int kaden(int arr[])
	{
		int currSum = 0 , maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length ; i++)
		{
			currSum += arr[i] ;
			if (maxSum < currSum) maxSum = currSum ;
			
			if (currSum < 0) currSum = 0 ;
		}
		return maxSum ;
	}

	public static void main(String[] args) 
	{
		int arr[] = {1,2,3,-4,5,-10,5,2} ;
		System.out.println(kaden(arr));
	}

}
