
package trees.BST;

import trees.BT.MyBT;
import trees.BT.Node;

public class MyBST extends MyBT
{
	public MyBST() 
	{
			
	}
	
	public MyBST(int arr[])
	{
		super(arr);
	}

	public Node search(int x)
	{
		Node p = root;
		while (p != null)
		{
			if (p.getVal() == x) return p ;
			if (p.getVal() < x) p = p.getRightChild();
			else p = p.getLeftChild();
		}
		return null ;
	}
	
	
	public Node r_search(Node p , int x)
	{
		if (p == null) return null ;
		
		if (p.getVal() == x) return p ;
		if (p.getVal() < x) return r_search(p.getRightChild(), x) ;
		return r_search(p.getLeftChild(), x) ;
	}
	
	
	public void insert(int x)
	{
		
		Node p = root , q = null ;
		while (p != null)
		{
			if (p.getVal() == x) return ;
			q = p ;
			if (p.getVal() < x) p = p.getRightChild();
			else p = p.getLeftChild();
		}
		
		if (q.getVal() < x) q.setRightChild(new Node(x , null , null));
		else q.setLeftChild(new Node(x , null , null));
		
	}
	
	public void r_insert(Node p , int x) 
	{
		if (p.getVal() == x) 
		    return ;
		
		if (p.getVal() < x) {
			if (p.getRightChild() == null) {
				p.setRightChild(new Node(x , null , null));
				return ;
			}
			else
			r_insert(p.getRightChild(), x);
		}
		else{
			if (p.getLeftChild() == null) {
				p.setLeftChild(new Node(x , null , null));
				return ;
			}
			else
			r_insert(p.getLeftChild(), x);
		}
		
	}
	
	
	public Node delete(Node p ,int x)
	{
		
		if (p == null) return null;
		
		if (p.getLeftChild() == null && p.getRightChild() == null)
		{
			if (p.getVal() == x) {
			if (p == root ) root = null ;
			p = null ;
			return null;
			}
		}
		else
		if (p.getVal() < x) p.setRightChild(delete(p.getRightChild(), x));
		else if (p.getVal() > x) p.setLeftChild(delete(p.getLeftChild(), x));
		else 
		{	
			if ((Height(p.getLeftChild())) > (Height(p.getRightChild())))
			{
				Node q = InPre(p.getLeftChild()) ;
				if (q != null) {
				p.setVal(q.getVal());
				p.setLeftChild(delete(p.getLeftChild(),q.getVal())) ;
				}
			}
			else 
			{
				Node q = InSucc(p.getRightChild()) ;
				if (q != null) {
				p.setVal(q.getVal());
				p.setRightChild(delete(p.getRightChild(),q.getVal())) ;
				}
			}
		}
		return p ;
	}
	
	public int Height(Node p)
	{
		int x , y ;
		if (p == null) return 0 ;
		x = Height(p.getLeftChild()) ;
		y = Height(p.getRightChild()) ;
		if (x > y) return x + 1 ;
		else return y + 1 ;
		
	}
	
	public Node InPre(Node p)
	{

		while (p != null && p.getRightChild() != null) p = p.getRightChild();
		return p ;
	}
	
	public Node InSucc(Node p)
	{
		while (p != null && p.getLeftChild() != null) p = p.getLeftChild();
		return p ;
	}
	
	
	
	
}
