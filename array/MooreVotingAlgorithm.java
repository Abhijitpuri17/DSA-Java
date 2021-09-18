package array;

public class MooreVotingAlgorithm 
{
	// To find a majority element  i.e. occurring more than n/2 times
	

	public static void main(String[] args) 
	{
		int arr[] = {1,2,3,1,1,1,5} ;
		
		int ans_index = 0 , count = 1;
		for (int i = 1 ; i < arr.length ; i++)
		{
			if (arr[ans_index] == arr[i]) count++ ;
			else count-- ;
			
			if (count == 0) {
				ans_index = i ;
				count = 1 ;
			}
		}
		
		count = 0 ;
		
		for (int i = 0 ; i < arr.length ; i++)
		{
			if (arr[i] == arr[ans_index]) count++ ;
		}
		
		if (count > arr.length/2) System.out.println("Majority element = " + arr[ans_index]);
		else System.out.println("No majority element in given array");
		
	
	}

}
