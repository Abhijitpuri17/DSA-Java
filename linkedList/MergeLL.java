package linkedList;


public class MergeLL 
{
	
	static void mergeLL(MyLinkedList l1, MyLinkedList l2)
	{
		if (l1.getHead().getValue() > l2.getHead().getValue())
		{
			MyLinkedList temp = l1 ;
			l1 = l2 ;
			l2 = temp ;
		}
		
		Node p = l1.getHead(), q = l2.getHead(), temp = null;
		
		while (p != null && q != null)
		{
			if (p.getValue() > q.getValue()) {
				Node t = p;
				p = q ;
				q = t ;
			}
			
			while (p != null && p.getValue() <= q.getValue()) {
				temp = p ;
				p = p.getNext() ;
			}
	        
			temp.setNext(q);
		}
		
		l2.setHead(null);
		
	}

	// l1 and l2 are merged in a single list l1. L1 is destroyed
	public static void main(String[] args) throws Exception
	{
		int a[] = {1,20,23,24,50} ;
		MyLinkedList l1 = new MyLinkedList(a);
		
		int b[] = {2, 4, 5, 10, 25, 75} ;
		MyLinkedList l2 = new MyLinkedList(b) ;
		
		mergeLL(l1, l2);
		l1.display();
		l2.display();
			
	}

}
