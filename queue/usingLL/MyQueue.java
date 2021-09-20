package queue.usingLL;

	public class MyQueue 
	{
	
		// for inserting rear is used and to delete front is used
		Node front , rear ;
		
		//ENQUEUE fun to add element
		public void enqueue(int x)
		{
			if (front == null) front = rear = new Node(x, null) ;
			else 
				{
					rear.setNext(new Node(x, null));
					rear = rear.getNext();
				}	
		}
		
		// DEQUEUE fun to remove from front
		public int dequeue() throws Exception
		{
			if(front == null) throw new Exception("Queue is empty") ;
			int x = front.getVal();
			front = front.getNext();
			return x ;
		}
		
		// DISPLAY fun
		public void display()
		{
			Node curr = front ;
			while (curr != null)
			{ 
				System.out.print(curr.getVal() + " ");
			    curr = curr.getNext();
			}
			System.out.println();
		}
		
	}

	
	class Node
	{
		private int val ;
		private Node next ;
		
		public Node(int val , Node next)
		{
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