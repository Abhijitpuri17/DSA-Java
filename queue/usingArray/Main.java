package queue.usingArray;

public class Main 
{

	public static void main(String[] args) throws Exception 
	{
		CircularQueue q = new CircularQueue(5) ;
		q.enqueue(1) ;
		q.enqueue(2) ;
		q.enqueue(3) ;
		q.enqueue(4) ;
		q.enqueue(5) ;
		
		q.display() ;
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();

		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		
		
		q.display();
		
		
		
		
		

	}

}
