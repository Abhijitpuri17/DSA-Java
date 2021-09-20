package linkedList;

	public class DoublyLL 
	{
		private Node head , last ;
		private int size ;
		
		public DoublyLL()
		{
			
		}
		
		
		
		public DoublyLL(int arr[])
		{
			create(arr);
		}
		
		
		
		public int getSize()
		{
			return size ;
		}
		
		
		
		public void create(int arr[]) 
		{
			if (arr.length < 0) return ;
			head = last = new Node(arr[0], null , null) ;
	
			for (int i = 1 ; i < arr.length ; i++)
			{
				last.setNext(new Node(arr[i], last.getNext() , last));
				last = last.getNext();
			}
			size = arr.length; 
		}
		
		
		
	    public void insert(int pos , int value)	throws Exception
	    {
	    	if (pos < 0 || pos > size) throw new Exception("Invalid index") ;
	    	
	    	if (size == 0) {
	    		head = last = new Node(value, null, null) ;
	    	}
	    	else
	    	if (pos == 0) {
	    		head.setPrev(new Node(value, head , null));
	    		head = head.getPrev();
	    	}
	    	else if (pos == size) {
	    		last.setNext(new Node(value, null ,last));
	    		last = last.getNext();
	    	}
	    	else {
	    		
	    		Node curr = head ;
	    		for (int i = 1 ; i < pos ; i++) curr = curr.getNext();
	    		curr.setNext(new Node(value, curr.getNext() , curr));
	    		curr.getNext().getNext().setPrev(curr.getNext());
			}
	    	size++ ;
	    }
	    
	    
		
	    public void delete(int pos) throws Exception
	    {
	    	if (pos < 0 || pos >= size) throw new Exception("Invalid index") ;
	    	
	    	if (pos == 0) { 
	    		head = head.getNext();
	    		if (head != null)
	    	    head.setPrev(null);
	    	}
	    	else {
	    		Node curr = head ;
	    		for (int i = 1 ; i < pos ; i++) curr = curr.getNext();
	    		curr.setNext(curr.getNext().getNext());
	    		if (curr.getNext() != null)
	    		curr.getNext().setPrev(curr);
	    	}
	    	size-- ;
	    	
	    }
	    
	    
	    
	    
		public void display()
		{
			if (size <= 0) return ;
			Node curr = head ;
			while (curr.getNext() != null) {
				System.out.print(curr.getValue() + " <--> ");
				curr = curr.getNext();
			}
			System.out.println(curr.getValue());
			
			
			
		}
		
		
		public void reverse()
		{
			if (size < 2) return ;
		    Node p = head , q = null ;
		    
		       while (p != null) {
		    	   p.setPrev(p.getNext());
		    	   p.setNext(q);
		    	   q = p ;
		    	   p = p.getPrev();
		       }
		      last = head ;
		      head = q;
		}
		
	
	}
