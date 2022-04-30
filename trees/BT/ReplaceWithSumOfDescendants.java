package trees.BT;

public class ReplaceWithSumOfDescendants 
{

	
	static void replaceWithSumOfDescendants(MyBT bt)
	{
		Node root = bt.root;
		replace(root) ;
	}
	
	static int replace(Node n)
	{
		if (n == null) return 0 ;
		
		if (n.getLeftChild() == null && n.getRightChild() == null) {
			return n.getVal();
		}
		
		int l_sum = replace(n.getLeftChild()) ;
		int r_sum = replace(n.getRightChild()) ;
		
		int sum = l_sum + r_sum + n.getVal() ;
		n.setVal(l_sum + r_sum);
		
		return sum ;	
	}
	
	
	public static void main(String[] args) 
	{
		MyBT bt = new MyBT() ;
		bt.preOrderBuild();
        replaceWithSumOfDescendants(bt);
		bt.levelOrderDisplay();
	}
	
	
}
