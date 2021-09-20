package stack;

import java.util.Stack;

public class InfixToPostfix 
{
	/*
	     INFIX : operand operator operand        ex.  a + b * c
	     
	     POSTFIX : operand operand operator      ex. a b c * +
	 
	     PREFIX : operator operand operand       ex. + * b c a
	 
	 */
	
	
	
	static String infixToPostfix(String s)
	{
		Stack<Character> mStack = new Stack<>();
		String postfix = "" ;
		
		for (int i = 0 ; i < s.length() ; i++)
		{
			char c = s.charAt(i) ;
			
			if (isOperator(c))
			{
				
			  while (!mStack.isEmpty() && precedence(mStack.peek()) >= precedence(c)) 
			  {
				  postfix = postfix + mStack.peek() ;
				  mStack.pop();
			  }
					  mStack.push(c) ;	
			} else postfix = postfix + c ;
		}
		
		while (!mStack.isEmpty()) 
		{
			postfix = postfix + mStack.peek();
			mStack.pop();
		}
		
		return postfix ;
	}

	public static void main(String[] args) 
	{
	
		String s = "a+b*c" ;
		System.out.println(infixToPostfix(s));
	}
	
	
	static boolean isOperator(char c)
	{
		return (c== '+' || c == '-' || c == '*' || c == '/') ;
	}
	
	static int precedence(char c)
	{
		if (c == '+' || c == '-') return 1 ;
		if (c == '*' || c == '/') return 2 ;
		return 0 ;
	}

}
