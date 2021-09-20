package stack.UsingLL;

public class Main 
	{
	
		public static void main(String[] args) throws Exception 
		{
			MyStack myStack = new MyStack() ;
			myStack.push(5);
			myStack.push(10);
			myStack.push(15);
			System.out.println("element at index 2 : " + 	myStack.get(2) );
		 
			System.out.println("element at position 2 from top : " + myStack.peek(2) );
			
			myStack.display();
			myStack.pop();
			myStack.display();
	
		}
	
	}
