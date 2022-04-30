package trees.BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderPrint 
{
	
	
	static void traverseTree(Node root, Map<Integer, List<Integer>> m, int d)
	{
		
		if (root == null) {
			return ;
		}
		
		if (m.containsKey(d)) {
			m.get(d).add(root.getVal()) ;
		} else {
			List<Integer> l1 = new ArrayList<>();
			l1.add(root.getVal()) ;
			m.put(d, l1) ;
		}

		traverseTree(root.getLeftChild(), m, d-1);
		traverseTree(root.getRightChild(), m, d+1);
		
	}
	
	static void verticalOrderPrint(MyBT bt)
	{
		Map<Integer, List<Integer>> m = new TreeMap<>();
		
		traverseTree(bt.root, m, 0);
				
		for (int x : m.keySet())
		{
			List<Integer> l = m.get(x) ;
			for (int y : l) System.out.print(y + " ");
			System.out.println();
		}
		
	}

	public static void main(String[] args) 
	{
		MyBT bt =  new MyBT();
		bt.preOrderBuild();
		verticalOrderPrint(bt);
	}

}
