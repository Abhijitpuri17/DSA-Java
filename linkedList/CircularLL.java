package linkedList;

	public class CircularLL 
	{
	
			private Node head , last ;
			private int size = 0;
			
			public CircularLL(int arr[]) 
			{
				create(arr);
			}
			
			public CircularLL() {
				
			}
			
			public int getSize() {
				return size ;
			}
			
			
			public void create(int arr[]) 
			{
				head = last = new Node(arr[0] , null) ;
				last.setNext(head) ;
				
				for (int i = 1 ; i < arr.length ; i++)
				{
					Node newNode = new Node(arr[i] , last.getNext()) ;
					last.setNext(newNode) ;
					last = newNode ;
				}
				size = arr.length ;
			}
			
			public void insert(int pos , int value) throws Exception
			{
				if (pos < 0 || pos > size)
				           throw new Exception("Invalid index") ;
				
				if (size == 0)
				{
					head = last = new Node(value , null) ;
					last.setNext(head) ;
				}
				else
				if (pos == 0)
				{
					 
					last.setNext(new Node(value, head));
					head = last.getNext();
					
				}
				
				else 
				{
					
					Node currNode = head ;
					for (int i = 0 ; i < pos - 1 ; i++) currNode = currNode.getNext() ;
					
					Node newNode = new Node(value, currNode.getNext()) ;
					currNode.setNext(newNode) ;
					if (pos == size) last = newNode ;
				}
				
				size++ ;	
			}
			
			
			
			public void delete(int pos) throws Exception
			{
				if (pos >= size) throw new Exception("Invalid index");
				
				Node currNode = head ;
				if (pos == 0) {
					
					if (size == 1) {
						head = last = null;
					}
					else {
					last.setNext(head.getNext());
					head = head.getNext();
					}
					
				} else {
					for (int i = 0 ; i < pos - 1 ; i++) {
						currNode = currNode.getNext();
					}
					currNode.setNext(currNode.getNext().getNext());
				}
				
				if (pos == size - 1) last = currNode ;
				size-- ;
			}
			
			
			
			public void display()
			{
				Node currNode = head ;
				
				while (currNode != null && currNode.getNext() != head )
				{
					System.out.print(currNode.getValue() + " --> ");
					currNode = currNode.getNext();
				}
				if (currNode != null)
				System.out.println(currNode.getValue());
			}
		
		
	}
