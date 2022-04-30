/**
 * @author Abhijit
 * @version 1.0
 **/

package trees.AVLTrees;

     public class MyAVLTree 
	{
	
		Node root ;
		
		public void insert(Node p ,int x)
		{
			if (p == null) {
				root = new Node(x, null , null , 1) ;
				return;
			}
			
			if (p.val == x) return ;
			
			if (p.val < x ) {
				if (p.rChild == null) p.rChild = new Node(x, null, null, 1) ;
				else
				insert(p.rChild, x);
			}
			else {
				if (p.lChild == null) p.lChild = new Node(x, null, null, 1) ;
				else
				insert(p.lChild, x);
			}
			p.height = nodeHeight(p);
			
			if (balanceFactor(p) == 2 && balanceFactor(p.lChild) == 1) 
				llRotation(p) ;
			else if (balanceFactor(p) == 2 && balanceFactor(p.lChild) == -1) 
				lrRotation(p) ;
			else if (balanceFactor(p) == -2 && balanceFactor(p.rChild) == -1) 
				rrRotation(p) ;
			else if (balanceFactor(p) == -2 && balanceFactor(p.rChild) == 1) 
				rlRotation(p) ;
			
		}
		
		public Node delete(Node p , int x)
		{
			if (p == null) return null ;
			
			if (p.lChild == null && p.rChild == null)
			{
				if (p.val == x) {
					if (p == root) root = null ;
					p = null ;
					return null ;
				}
			}
			
			if (p.val < x) p.rChild = delete(p.rChild, x) ;
			else if (p.val > x) p.lChild = delete(p.lChild, x) ;
			else 
			{
				
				if (nodeHeight(p.lChild) > nodeHeight(p.rChild))
				{
					Node q = InPre(p.lChild) ;
					if (q != null) {
						p.val = q.val ;
						p.lChild = delete(p.lChild, q.val) ;
					}
				} 
				else 
				{
					Node q = InSucc(p.rChild) ;
					if (q != null) {
						p.val = q.val ;
						p.rChild = delete(p.rChild, q.val) ;
					}
				}
				
			}
			
			if (balanceFactor(p) == 2 && balanceFactor(p.lChild) == 1) 
				llRotation(p) ;
			else if (balanceFactor(p) == 2 && balanceFactor(p.lChild) == -1) 
				lrRotation(p) ;
			else if (balanceFactor(p) == -2 && balanceFactor(p.rChild) == -1) 
				rrRotation(p) ;
			else if (balanceFactor(p) == -2 && balanceFactor(p.rChild) == 1) 
				rlRotation(p) ;
			
			return p ;
		}
		
		private Node InPre(Node p) 
		{
			while (p != null && p.rChild != null) p = p.rChild ;
			return p;
		}
		
		private Node InSucc(Node p) 
		{
			while (p != null && p.lChild != null) p = p.lChild ;
			return p;
		}
		
		private int nodeHeight(Node p)
		{
			int hl , hr ;
			if (p != null && p.lChild != null) hl = p.lChild.height ;
			else hl = 0 ;
			
			if (p != null && p.rChild != null) hr = p.rChild.height ;
			else hr = 0 ;
			
			return Math.max(hl, hr) + 1 ;	
		}
		
		private int balanceFactor(Node p) 
		{
			int hl , hr ;
			if (p != null && p.lChild != null) hl = p.lChild.height ;
			else hl = 0 ;
			
			if (p != null && p.rChild != null) hr = p.rChild.height ;
			else hr = 0 ;
			
			return hl - hr ;
		}
		
		private void llRotation(Node p) 
		{
			Node pl = p.lChild;
			Node plr = p.rChild ;
			pl.rChild = p ;
			p.lChild = plr ;
			p.height = nodeHeight(p) ;
			pl.height = nodeHeight(pl) ;
			
			if (p == root) root = pl ; 

		}
		
		private void lrRotation(Node p) 
		{
			Node pl = p.lChild ;
			Node plr = pl.rChild ;
			pl.rChild = plr.lChild ;
			p.lChild = plr.rChild ;
			
			plr.lChild = pl ;
			plr.rChild = p ;
			
			p.height = nodeHeight(p) ;
			pl.height = nodeHeight(pl) ;
			plr.height = nodeHeight(plr) ;
			
			if (p == root) root = plr ;
			
		}
		
		private void rlRotation(Node p) 
		{
			Node pr = p.rChild;
			Node prl = pr.lChild ;
			
			p.rChild = prl.lChild ;
			pr.lChild = prl.rChild ;
			
			prl.lChild = p ;
			prl.rChild = pr ;
			
			p.height = nodeHeight(p) ;
			pr.height = nodeHeight(pr) ;
			prl.height = nodeHeight(prl) ;
			
			if (p == root) root = prl ;

		}
		
		private void rrRotation(Node p) 
		{
			Node pr = p.rChild;
			Node prl = pr.lChild ;
			
			p.rChild = prl ;
			pr.lChild = p ;
			
			p.height = nodeHeight(p) ;
			pr.height = nodeHeight(pr) ;
			
			if (p == root) root = pr ;
		}
		
		
	}
	
	class Node
	{
		int val;
		Node lChild , rChild ;
		int height ;
		
		public Node(int val , Node lChild , Node rChild , int height) 
		{
			this.val = val ;
			this.lChild = lChild ; 
			this.rChild = rChild ;
			this.height = height;
		}
		
	}


