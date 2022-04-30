package stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseRecursive 
{
	
	
	static void reverse(Stack<Integer> mStack)
	{
		if (mStack.size() <= 1) return ;
		
		int el = mStack.pop();
		
		reverse(mStack);
		
		mStack.add(0, el);	
	}

	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in) ;
	    Stack<Integer> mStack = new Stack<>();
	    
	    System.out.println("Enter number of elements");
	    int n = sc.nextInt();
	    
	    System.out.println("Enter all elements ");
	    
	    for (int i = 0 ; i < n ; i++) {
	    	mStack.push(sc.nextInt()) ;
	    }
	    
	    reverse(mStack);
	    
	    while (!mStack.isEmpty()) System.out.print(mStack.pop() + " ");
	    
	}

}
