package queue.usingArray;

	public class CircularQueue 
	{
	
		// front is at index before first element and rear is at index of last element
				private int size , front , rear ;
				private int[] arr ;
				
				// constructor to create queue
				public CircularQueue(int size) 
				{
					this.size = size + 1 ;
					front = rear = 0 ;
					arr = new int[this.size];
				}
			
				// ENQUE fun to add element in queue
				public void enqueue(int x) throws Exception
				{
					if ((rear + 1) % size == front) throw new Exception("queue is full") ;
					
					rear = (rear+1)%size;
					arr[rear] = x ;
				}
				
				// DEQUEUE fun to remove element from front
				public int dequeue() throws Exception
				{
					if (front == rear) throw new Exception("queue is empty") ;
					front = (front + 1) % size ;
					
					return arr[front] ;
				}
				
				// DISPLAY FUN
				public void display()
				{
					int i = (front+1)%size ;
					while (i != (rear+1)%size)
						{
							System.out.print(arr[i] + " ");
							i = (i+1)%size ;
						}
					System.out.println();
				}
		
	}
