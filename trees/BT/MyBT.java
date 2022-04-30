package trees.BT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class MyBT 
{
	public Node root ;
	
	public Queue<Node> queue = new LinkedList<>() ;
	Scanner sc = new Scanner(System.in) ;
	
	public MyBT() 
	{
		
	}
	
	public MyBT(int arr[])
	{
		createBT(arr);
	}
	
	public void preOrderBuild()
	{
		System.out.println("Enter preorder");
		
		root = r_preorder_build();
	}
	
	Node r_preorder_build()
	{
		int x = sc.nextInt() ;
		
		if (x == -1) return null ;
		
		Node n = new Node(x, null, null) ;
		
		n.setLeftChild(r_preorder_build()) ;
		n.setRightChild(r_preorder_build()) ;

		return n ;
	}
	
	public void createBT()
	{
		System.out.println("Enter root element : ") ;
		root = new Node(sc.nextInt() , null , null) ;
		queue.add(root) ;
		
		Node curr = null ;
		
		while(!queue.isEmpty()) 
		{
			curr = queue.poll() ;
			System.out.print("Enter left child of " + curr + " " + curr.getVal() + " ") ;
			int x = sc.nextInt() ;
			if (x != -1) {
			curr.setLeftChild(new Node(x , null , null)) ;
			queue.add(curr.getLeftChild()) ;
			}
			
			System.out.print("Enter Right child of " + curr + " " + curr.getVal() + " ") ;
			x = sc.nextInt() ;
			if (x != -1) {
			curr.setRightChild(new Node(x , null , null));
			queue.add(curr.getRightChild()) ;	
			}
		}
		
	}
	
	public void createBT(int levelOrder[]) 
	{
		root = new Node(levelOrder[0] , null , null) ;
		queue.add(root) ;
		
		Node curr = null ;
		int i = 1 ;
		
		while(i < levelOrder.length) 
		{
			curr = queue.poll() ;
			curr.setLeftChild(new Node(levelOrder[i++] , null , null)) ;
			queue.add(curr.getLeftChild()) ;
			curr.setRightChild(new Node(levelOrder[i++] , null , null)) ;
			queue.add(curr.getRightChild()) ;		
		}
	}
	
	
	public void preorderDisplay()
	{
		r_preOrder(root) ;
		System.out.println();
	}
	
	
	
	 public void r_preOrder(Node p)
	 {
		 if (p != null) 
		 {
			 System.out.print(p.getVal() + " ") ;
			 r_preOrder(p.getLeftChild()) ;
			 r_preOrder(p.getRightChild()) ; 
		 }
	 }
	 
	 
	 public void i_preorder()
	 {
		 Node p = root ;
		 Stack<Node> mStack = new Stack<>() ;
		 
		 while (p != null || !mStack.isEmpty())
		 {
			 if (p != null) {
				 System.out.print(p.getVal() + " ") ;
				 mStack.push(p) ;
				 p = p.getLeftChild() ;
			 } else {
				 p = mStack.pop() ;
				 p = p.getRightChild() ;
			 } 	 
		 }
		 System.out.println(); 
	 }
	 
	 
	 public void inorderDisplay()
	 {
			r_inorder(root);
			System.out.println();
	 }
		
	  public void r_inorder(Node p)
	  {
			if (p.getLeftChild() != null) r_inorder(p.getLeftChild());
			System.out.print(p.getVal() + " ");
			if (p.getRightChild() != null) r_inorder(p.getRightChild());
      }
	  
	  
	  public void i_inorder()
	  {
		  Node p = root ;
		  Stack<Node> mStack = new Stack<>();
		  
		  while (p != null || !mStack.isEmpty())
		  {
			  if (p != null) 
			  {
				  mStack.push(p) ;
				  p = p.getLeftChild();
			  }
			  else {
				  p = mStack.pop();
				  System.out.print(p.getVal() + " ");
				  p = p.getRightChild();
			  }
		  }
		  System.out.println();
		    
	  }
	  
	  
	  public void postorderDisplay()
	  {
		  r_postOrder(root) ;
		  System.out.println();
	  }
	  
	  public void r_postOrder(Node p)
	  {
		  if (p.getLeftChild() != null) r_inorder(p.getLeftChild());
			if (p.getRightChild() != null) r_inorder(p.getRightChild());
			System.out.print(p.getVal() + " ");

	  }
	  
	  
	  public void levelOrderDisplay()
	  {
		  Queue<Node> queue = new LinkedList<>();
		  Node p = root ;
		  queue.add(p) ;
		  queue.add(null) ;
		  
		  while (!queue.isEmpty())
		  {
			  p = queue.poll();
			  
			  if (p == null) 
			  {
				  if (!queue.isEmpty()) {
				  System.out.println();
				  queue.add(null) ;
				  }
			  } 
			  else 
			  {
				  System.out.print(p.getVal() + " ");
				  if (p.getLeftChild() != null)
				  queue.add(p.getLeftChild()) ;
				  if (p.getRightChild() != null)
				  queue.add(p.getRightChild()) ;	  
			  }
		}
		  System.out.println();
		  
	  }
	  
	  // Count nodes
	  public int count()
	  {
		  return r_count(root) ;
	  }
	  
	  public int r_count(Node p) 
	  {
		  if (p == null) return 0 ;
		  int x = r_count(p.getLeftChild()) ;
		  int y = r_count(p.getRightChild()) ;
		  return x + y + 1 ;
	  }
	  
	  
	  public int height()
	  {
		  return r_height(root) ;
	  }
	  
	  public int r_height(Node p)
	  {
		  int x = 0 , y = 0 ;
		  if (p == null) return 0 ;
		  if (p.getLeftChild() == null && p.getRightChild() == null) return 0 ;
		  if (p.getLeftChild() != null)
		  x = r_height(p.getLeftChild()) ;
		  if (p.getRightChild() != null)
		  y = r_height(p.getRightChild()) ;
		  if (x > y) return x + 1 ;
		  else return y + 1 ;
	  }
	  
}




