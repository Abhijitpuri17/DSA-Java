package stack.UsingArray;

	public class MyStack 
	{
	   // Top points to index of last inserted element
	   
	   private int size , top , arr[] ;
	   
	   public MyStack(int size)
	   {
		   this.size = size ;
		   arr = new int[size] ;
		   top = -1 ;
	   }
		
	   // To insert new element at top
	   public void push(int val) throws Exception
	   {
		   if (top == size - 1) throw new Exception("Stack Overflow") ;
		  
		   top++ ;
		   arr[top] = val ;
	   }
	   
	   // To delete last element at top
	   public void pop() throws Exception
	   {
		   if (top == -1) throw new Exception("Stack underflow") ;
		   
		   top-- ;
	   }
		
	   
	   // To check what element is present at position 'p' from top
	   // index = top - pos + 1
	   public int peek(int pos) throws Exception
	   {
		   int index = top - pos + 1 ;
		   if (index < 0 || index > top) throw new Exception("Invalid Position") ;
		   return arr[index] ;
	   }
	   
	   
	   // To get element at some index
	   public int get(int index) throws Exception
	   {
		   if (index < 0 || index > top) throw new Exception("Invalid Position") ;
		   return arr[index] ;
	   }
	   
	   // Display all elements of stack
	   public void display()
	   {
		   for (int i = 0 ; i <= top ; i++) System.out.print(arr[i]+ " ");
		   System.out.println();
	   }
	   
	   // function to check whether stack is empty or not
	   public boolean isEmpty()
	   {
		   return top == -1 ;
	   }
	   
	   // Function to check whether stack is full or not
	   public boolean isFull()
	   {
		   return top == (size - 1) ;
	   }
	   
	   
	   
	}
