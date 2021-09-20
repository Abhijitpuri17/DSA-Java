package sorting;

public class RadixSort 
{

	public static void main(String[] args) 
	{
	
        int arr[] = {1452 , 7856 , 1278 , 4521 , 2145 , 9875, 5647} ; 

		radixSort(arr, 10 , 4);
		for (int i = 0  ; i  <   arr.length ; i++) System.out.print(arr[i] + " ");

	}
	
	public static void radixSort(int[] arr , int radix , int width)
	{
		for (int i = 0 ; i < width ; i++)
		{
			radixSingleSort(arr , i , radix) ;
		}
	}
	
	public static void radixSingleSort(int[] arr , int pos , int radix)
	{
		int[] countArray = new int[radix] ;
		for (int i = 0 ; i < arr.length ; i++)
		{
			countArray[getDigit(arr[i], pos, radix)]++ ;
		}
		
		for (int i = 1 ; i < countArray.length ; i++)
		{
			countArray[i] += countArray[i-1] ;
		}
		
		int temp[] = new int[arr.length] ;
		for (int tempIndex = arr.length-1 ; tempIndex >= 0 ; tempIndex--)
		{
			temp[--countArray[getDigit(arr[tempIndex], pos, radix)]] = arr[tempIndex] ;
		}
		
		System.arraycopy(temp, 0, arr, 0, arr.length) ;
	}
	
	public static int getDigit(int value, int pos , int radix)
	{
		return value/(int)Math.pow(10, pos) % 10 ;
	}

}
