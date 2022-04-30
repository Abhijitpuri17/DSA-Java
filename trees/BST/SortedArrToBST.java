package trees.BST;

import trees.BT.Node;

public class SortedArrToBST 
{

	static MyBST sortedArrToBST(int arr[])
	{
		
		MyBST bst = new MyBST();
		bst.root = r_create(arr, 0, arr.length-1) ;
		return bst ;
	}
	
	static Node r_create(int arr[], int s, int e)
	{
		if (s > e) return null;
		
		int mid = (s+e)/2 ;
		
		Node root = new Node(arr[mid], null, null) ;
		
		root.setLeftChild(r_create(arr, s, mid-1));
		
		root.setRightChild(r_create(arr, mid+1, e));
		
		return root ;
	}
	
	
	public static void main(String[] args) 
	{
	
		int arr[] = {1, 2, 3, 4, 5, 6, 7} ;
		
		MyBST bst = sortedArrToBST(arr) ;
		
		bst.levelOrderDisplay();

	}

}
