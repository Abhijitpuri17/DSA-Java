package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestConcatString 
{
	
	// sort the strings. First compare their length then check alphabetically
	
	public static void main(String[] args)
	{
		String[] strings = {"a", "ab", "aba"};
		Arrays.sort(strings, new MyCom());
		
		System.out.println(concatStrings(strings));
	}
	
	static class MyCom implements Comparator<String>
	{

		@Override
		public int compare(String a, String b) {
			return ((a+b).compareTo(b+a)) ;
		}
		
	}
	
	static String concatStrings(String strings[])
	{
		String ans = "" ;
		
		for (int i = 0 ; i < strings.length ; i++) ans += strings[i] ;
		
		return ans ;
	}
	

}
