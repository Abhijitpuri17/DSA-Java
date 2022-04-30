package linkedList;

 
   /*
         Each element of LL is a node which holds the data and also reference to next node
         , with that reference we can access next elements of LL with the help of only headNode
    */
              

        
public class MyLinkedList 
	{                   
		private Node head , last ;
		private int size ;
		
		public Node getHead() {
			return head;
		}
		
		public void setHead(Node head) {
			this.head = head;
		}
		
		//CONSTRUCTORS
		public  MyLinkedList()
		{
			
		}
		
		public MyLinkedList(int arr[])
		{
			create(arr);
		}
		
		// METHOD TO CREATE LL FROM ARRAY
		public void create(int arr[]) 
		{
			if (arr.length <= 0) return ;
			head = new Node(arr[0] , null) ;
			Node currNode = head ;
			for (int i = 1 ; i < arr.length ; i++)
			{
				currNode.setNext(new Node(arr[i], null));
				currNode = currNode.getNext() ;
			}
			last = currNode ;
			size = arr.length ;
			
		}
		
		
		// METHOD TO GET SIZE
		public int getSize() {
			return size ;
		}
		
		
		
		// METHOD TO DISPLAY LL
		public void display()
		{
			if (head == null) return ;
			
			Node currNode = head ;
			
			while (currNode.getNext() != null) 
			{
				System.out.print(currNode.getValue() + " --> ");
				currNode = currNode.getNext() ;
			}
			System.out.println(currNode.getValue());
		}
		
		
		// METHOD TO ADD ELEMENT FROM FRONT
		public void insertFromFront(int value)
		{
			Node newNode = new Node(value, head) ;
			head = newNode ;
			size++ ;
			
			if (size == 1) last = head ;
		}
		
		//METHOD TO ADD AT LAST
		public void insertAtLast(int value)
		{
			if (size == 0) {
				insertFromFront(value);
				return ;
			}
			
			last.setNext(new Node(value, null));
			last = last.getNext();
			size++ ;
			
		}
		
		//METHOD TO INSERT AT GIVEN INDEX
		public void insert(int index , int value) throws Exception 
		{
			if (index < 0 || index > size) throw new Exception("Invalid index") ;
			if (index == 0) insertFromFront(value);
			else if (index == size) insertAtLast(value);
			else {
				
				// SET NEXTNODE OF ELEMENT AT INDEX-1 TO NEWNODE
				
				int i = 1 ;
				Node currNode = head ;
				while (i++ < index) {
					currNode = currNode.getNext() ;
				}
				
				Node newNode = new Node(value, currNode.getNext()) ;
				currNode.setNext(newNode) ;
				size++ ;
			}
		}
		
		
		
		// METHOD TO DELETE AN ELEMENT FROM LL
		public void delete(int index) throws Exception
		{
			if (index < 0 || index >= size) throw new Exception("Invalid index") ;
			int i = 0 ;
			Node currNode = head ;
			if (index == 0) head = head.getNext();
			else {
				while (i++ < index-1) {
					currNode = currNode.getNext();
				}
				if (currNode.getNext() == last) last = currNode ;
				currNode.setNext(currNode.getNext().getNext());
			}
			size-- ;
		}
		
		// METHOD TO FIND SUM
		public int sum()
		{
			int sum = 0 ;
			Node currNode = head ;
			while (currNode != null) {
				sum += currNode.getValue() ;
					currNode = currNode.getNext() ;
			}
			return sum ;
 		}
		
		//METHOD TO GET MAXIMUM ELEMENT
		public int max()
		{
			int max = Integer.MIN_VALUE ;
			Node currNode =head;
			while (currNode != null)
			{
				if (currNode.getValue() > max ) max = currNode.getValue() ;
				currNode = currNode.getNext() ;
			}
			return max ;
		}
		
		// LINEAR SEARCH
		public int indexOf(int key)
		{
			int index = 0 ;
			Node currNode = head ;
			while (currNode != null && currNode.getValue() != key) {
				index++ ;
				currNode = currNode.getNext();
			}
			if (index < size) return index ;
			return -1 ;
		}
		
		// METHOD TO CHECK IF LL IS SORTED
		public boolean isSorted() 
		{
		
			 Node currNode = head ;
			 while (currNode != last)
			 {
				 if (currNode.getValue() > currNode.getNext().getValue()) return false ;
				 currNode = currNode.getNext();
			 }
			
			return true ;
		}
		
		// METHOD TO REVERSE LL
		public void reverse()
		{
			// USING SLIDING POINTERS (3 VARIABLES)
			
			Node pNode =head , qNode , rNode;
			qNode = rNode = null ;
			
			last = head ;
			
			while (pNode != null)
			{
				rNode = qNode ;
				qNode = pNode ;
				pNode = pNode.getNext();
				
				qNode.setNext(rNode);
			}
			
			head = qNode ;
						
		}
		
		
		// RECURSIVE METHOD TO REVERSE LL
		public void recursiveReverse(Node p , Node q)
		{
			// q IS TAIL POINTER. WHILE RETURNING WE SET NEXTNODE OF p TO q
			if (p != null)
			{
				 recursiveReverse(p.getNext() , p);
			     p.setNext(q);
			} else head = q ;
		}
		
		
		// METHOD TO CONCAT ANOTHER LL TO GIVEN LL
		public void concat(MyLinkedList list2)
		{
			last.setNext(list2.head);
			size += list2.size ;
			last = list2.last ;
		}
		
		
		//METHOD TO CHECK IF LL IS A LOOP (IF LAST NODE POINTS TOWARDS SOME ELEMENT OF LL)
		public boolean isLoop()
		{
			Node p , q ;
			p = q= head;
			while (p != null && p.getNext() != null)
			{
			    p = p.getNext().getNext() ;
			    q = q.getNext() ;
			    if (p == q) return true ;
			}
			return false ;
		}
		
		public void makeLoop(int pos)
		{
			Node curr = head ;
			Node start_of_loop = head ;
			
			while (curr.getNext() != null)
			{
				if (pos > 0) {
					start_of_loop = start_of_loop.getNext();
					pos-- ;
				}
				
				curr = curr.getNext();	
			}
			
			if (pos > 0) return ;
			
			curr.setNext(start_of_loop);
		}
		
		public void removeLoop()
		{
			Node slow = head , fast = head ;
			
			if (fast == null || fast.getNext() == null) return ;
			
			do {
				slow = slow.getNext();
				fast = fast.getNext().getNext();
				
				if (fast == null || fast.getNext() == null) {
					System.out.println("NO LOOP");
					return ;
				}
				
			} while(fast != slow) ;
			
			fast = head;
			while (fast.getNext() != slow.getNext()) {
				fast = fast.getNext();
				slow = slow.getNext();
			}
			
			slow.setNext(null);
		}
		
		
	}
		