package trees.BT;

public class NodesAtDistanceK 
{
	
	
	// function to print all nodes below root and at distance k
	static void printAtLevelK(Node root, int k)
	{
		if (root == null) return ;
		
		if (k == 0) {
			System.out.print(root.getVal() + " ");
			return ;
		}
		
		printAtLevelK(root.getLeftChild(), k-1);
		printAtLevelK(root.getRightChild(), k-1 );	
	}
	
	
	
	static int printNodesAtDistK(Node root, Node target, int k)
	{
		
		// if we reach at null target is not present in this subtree
		if (root == null) return -1 ;
		
		// if we get target print all nodes below this node at distance k
		if (root == target) {
			printAtLevelK(target, k) ;
			return 0 ;
		}
		
		int dl = printNodesAtDistK(root.getLeftChild(), target, k);
		
		// if target is present in left subtree of root at dist dl+1,
		if (dl != -1)
		{
			// if current node is at distance k from target print it
			if (dl + 1 == k) {
				System.out.print(root.getVal() + " ");
			}
			// else
			// find all nodes which are distance k-dl-1 in right subtree
			// i.e. for root.right all nodes at k- dl - 2
			else {
				printAtLevelK(root.getRightChild(), k-2-dl);
			}
			return 1 + dl ;
		}
		
		int dr = printNodesAtDistK(root.getRightChild(), target, k) ;
		
		// if target is present in left subtree of root at dist dl+1,
		if (dr != -1)
		{
			// if current node is at distance k from target print it
			if (dr+1 == k) 
			{
				System.out.print(root.getVal() + " ");
			} else 
			// else
			// find all nodes which are distance k-dl-1 in right subtree
			// i.e. for root.right all nodes at k- dl - 2
			{
				printAtLevelK(root.getLeftChild(), k-2-dr);
			}
			return 1 + dr ;
		}
		
		// if from this node no node can be found in right and left subtree
		// return -1
		
		return -1 ;
	}
	

	public static void main(String[] args) 
	{
	
		MyBT bt = new MyBT();
		//1 2 4 -1 -1 5 7 -1 -1 8 9 -1 -1 10 -1 -1 3 -1 6 -1 -1
		bt.preOrderBuild();

		Node target = bt.root.getLeftChild().getRightChild();
		int k = 2 ;
		
		printNodesAtDistK(bt.root, target, k) ;
		
	}

}
