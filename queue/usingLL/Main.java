package queue.usingLL;

public class Main 
{

	public static void main(String[] args) throws Exception 
	{
		MyQueue q = new MyQueue();
		q.enqueue(10) ;
		q.enqueue(20) ;
		q.enqueue(30) ;
		q.display() ;
		
		q.dequeue() ;
		q.display() ;
		
		q.dequeue() ;
		q.dequeue() ;
		q.display() ;
		
		q.dequeue() ;
		
		

	}

}
