package strings;

import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{
		System.out.println();
	   Scanner sc = new Scanner(System.in) ;
	   
	   String s = new String("Hello world, How are you?");
	   
	  s =  s.replaceAll(" ", "%20") ;
	  
	  
	   System.out.println(s);
	   

	 
	  
		

	}

}
