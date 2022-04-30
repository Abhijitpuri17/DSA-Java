package trees.BT;

public class DiameterOfTree 
{

	static int d = 0 ;
	static int diameter(MyBT bt)
	{
		Node root = bt.root;
		
		if (root == null) return 0 ;
		
		d = 0 ;
		
		height(root);
		
		return d ;
	}
	
	static int height(Node n)
	{
		if (n == null) return 0 ;
		
		int x = height(n.getLeftChild()) ;
		int y = height(n.getRightChild()) ;
		
		if (x + y > d) d = x + y ;
		
		return Math.max(x, y) + 1 ;
	}
	
	public static void main(String[] args)
	{
		MyBT bt = new MyBT();
		bt.preOrderBuild();
		bt.levelOrderDisplay();
		System.out.println("Diameter : " + diameter(bt)) ;
	}
}
