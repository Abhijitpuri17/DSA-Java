package stack;

import java.util.Scanner;
import java.util.Stack;

public class ParanthesisMatching 
	{
	

		static boolean isParanthesisMatching(String s) 
		{
			Stack<Character> myStack = new Stack<Character>() ;
			for (int i = 0 ; i < s.length() ; i++)
			{
				if (s.charAt(i) == '(') myStack.push('(') ;
				else if (s.charAt(i) == ')') 
				{
					if (myStack.isEmpty()) return false ;
					else myStack.pop();
				}
			}
			return myStack.isEmpty();
		}
	
		public static void main(String[] args) 
		{
			Scanner sc = new Scanner(System.in) ;
			
			System.out.println("Enter the expression");
			String s = sc.nextLine();
	       System.out.println("Are paranthesis matching : " + isParanthesisMatching(s));
	       sc.close();
		}
	
	}
