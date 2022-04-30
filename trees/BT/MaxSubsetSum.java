package trees.BT;

public class MaxSubsetSum 
{
	
	// if node n is included then direct parent and direct children of 
	// n can't be included in subset. Find maximum sum of such subsets
	
	static int maxSubsetSum(MyBT bt)
	{
	    Pair p = maxSum(bt.root) ;
	    
	    return Math.max(p.exc, p.inc) ;
	}
	
	static Pair maxSum(Node n)
	{
		
		if (n == null) {
			return new Pair(0, 0) ;
		}
		
		Pair left = maxSum(n.getLeftChild()) ;
		Pair right = maxSum(n.getRightChild()) ;
		
		
		int inc_sum = n.getVal() + left.exc + right.exc ;
		int exc_sum = Math.max(left.exc, left.inc) + Math.max(right.exc, right.inc) ;
		
		Pair p = new Pair(inc_sum, exc_sum) ;

		return p ;
	}
	
	static class Pair{
		int inc, exc ;
		public Pair(int inc, int exc) {
			this.inc = inc ;
			this.exc=exc ;
		}
	}

	public static void main(String[] args) 
	{
		MyBT bt  = new MyBT();
		bt.preOrderBuild();
		System.out.println(maxSubsetSum(bt));

	}

}
