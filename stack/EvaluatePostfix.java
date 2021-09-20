package stack;

import java.util.Stack;

public class EvaluatePostfix // for one digit numbers only
	{
	
		static int evaluate(String postfix)
		{
			
			Stack<Integer> mStack = new Stack<>();
			
			for (int i = 0 ; i < postfix.length() ; i++)
			{
				char c = postfix.charAt(i) ;
				if (isOperand(c)) mStack.push(c - '0') ;
				else {
					
					int x2 = mStack.pop() ;
					int x1 = mStack.pop() ;
					int x = 0 ;
					switch(c)
					{
						case '+' : x = x1 + x2 ; break ;
						case '-' : x = x1 - x2 ; break ;
						case '*' : x = x1 * x2 ; break ;
						case '/' : x = x1 / x2 ; break ;
					}
					mStack.push(x) ;
				}
			}
			
			return mStack.pop() ;
		}
		
		
		
		public static void main(String[] args)
		{
			String s = "2+3*5" ;
			String postfix = InfixToPostfix.infixToPostfix(s) ;
			System.out.println("ans = " + evaluate(postfix));
	
		}
		
		static boolean isOperand(char c)
		{
		   return c >= '0' && c <= '9' ;
		}
		
		
	
	}
