package queue.usingArray;

	public class MyQueue 
	{

		// for inserting rear is used and to delete front is used
		// front is at index before first element and rear is at index of last element
		private int size , front , rear ;
		private int[] arr ;
		
		// constructor to create queue
		public MyQueue(int size) 
		{
			this.size = size ;
			front = rear = -1 ;
			arr = new int[size];
		}
	
		// ENQUE fun to add element in queue
		public void enqueue(int x) throws Exception
		{
			if (rear == size-1) throw new Exception("queue is full") ;
			
			rear++ ;
			arr[rear] = x ;
		}
		
		// DEQUEUE fun to remove element from front
		public int dequeue() throws Exception
		{
			if (front == rear) throw new Exception("queue is empty") ;
			front++ ;
			
			return arr[front] ;
		}
		
		// DISPLAY FUN
		public void display()
		{
			int i = front+1 ;
			while (i <= rear) System.out.print(arr[i++] + " ");
			System.out.println();
		}
		
		
		
		
		/*
		     DISADVATAGE :
			    We can not use the positions to enqueue which are dequeued
			    i.e. size of queue will keep decreasing after dequeuing
	    */
		
	}
