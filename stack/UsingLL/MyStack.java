package stack.UsingLL;


     

 public class MyStack 
	{
	
		private Node top ;
		private int size ;
		
	    public MyStack()
		  {
		    this.size = 0 ;
		    top = null ;
		  }
		
		
		 public void push(int val) throws Exception
			{
			   Node newNode = new Node(val , top) ;
			   top = newNode ;
			   size++ ;
			 }
		
		 public void pop() throws Exception
			 {
			     if (top == null) throw new Exception("Stack underflow") ;
			   
			     top = top.getNext();
			     size-- ;
		     }
		
		
		 public int peek(int pos) throws Exception
			 {
			     if (pos > size || pos <= 0) throw new Exception("Invalid position") ;
			    	Node curr = top ;
			    	while (pos-- > 1) curr = curr.getNext();
			   		return curr.getVal();
			 }
		
		 public int get(int index) throws Exception
		    {
			 
			          
			   if (index < 0 || index >= size) throw new Exception("Invalid index") ;
					Node curr = top ;
				   for (int i = 0 ; i < size-1-index ; i++) 
				   curr = curr.getNext();
		            
					   
					   return curr.getVal();
		   }
		
		   public void display()
			{
			  rDisplay(top);
			  System.out.println();
			}
		   
		
		   public void rDisplay(Node h)
		   {
			   if (h == null) return ;
			   rDisplay(h.getNext());
			   System.out.print(h.getVal() + " ");
		   }
		   
		   		
			public boolean isEmpty()
			{
			   return top == null ;
			}
		
	}

	
	class Node 
    {
		private int val ;
		private Node next ;
   	 
		public Node(int val , Node next) {
			this.val = val ;
			this.next = next ;
		}
		
		int getVal() {
			return val;
		}
		
		void setVal(int val) {
			this.val = val;
		}
		
		Node getNext() {
			return next;
		}
		
		void setNext(Node next) {
			this.next = next;
		} 
    }