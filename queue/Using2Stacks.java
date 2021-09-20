package queue;
import java.util.Stack;

	public class Using2Stacks
	{
	
		public static void main(String[] args) 
		{
			queueUsingStack q1 = new queueUsingStack();
			q1.enqueue(1);
			q1.enqueue(2);
			q1.enqueue(3);
			q1.enqueue(4);
			
			q1.display();
			q1.dequeue();
			q1.dequeue();
			q1.enqueue(5);
			q1.enqueue(6);
			q1.display();
			
		}
		
	
	}


class queueUsingStack
{
	
	private Stack<Integer> s1 = new Stack<>() ;
	private Stack<Integer> s2 = new Stack<>();
	
	void enqueue(int x)
	{
		s1.push(x) ;
	}
	
	int dequeue()
	{
		if (s2.isEmpty())
		{
			while (!s1.isEmpty()) {
				s2.push(s1.pop()) ;
			}
		}
		
		return s2.pop() ;
	}
	
	void display()
	{
		
		for (int i = s2.size()-1 ; i >= 0 ; i--) System.out.print(s2.get(i) + " ");
		for (int x : s1) System.out.print(x + " ");
		System.out.println();
		
	}
	
	
}