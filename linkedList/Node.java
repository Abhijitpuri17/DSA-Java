package linkedList;

	 public class Node 
	{
		   private int value ;
		   private Node next , prev ;       // we can access all nodes with the help of headNode by next
		   
		protected int getValue() 
		{
			return value;
		}
		
		protected void setValue(int value) 
		{
			this.value = value;
		}
		
		protected Node getNext() 
		{
			return next;
		}
		
		protected void setNext(Node next)
		{
			this.next = next;
		}
		
		//Constructor
		protected Node(int value , Node next)
		{
			this.value = value ;
			this.next = next ;
		}
		
		protected Node(int value , Node next , Node prev)
		{
			this.value = value ;
			this.next = next ;
			this.prev = prev ;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
	
	   
		
	}
