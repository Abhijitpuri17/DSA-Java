package trees.BST;

public class Main {

	public static void main(String[] args) 
	{
		int arr[] = {10 , 5 , 20 , 2 , 8 , 15 , 100} ;
		MyBST bt = new MyBST(arr) ;
	     bt.preorderDisplay();
	     System.out.println(bt.search(8));
	     System.out.println(bt.r_search(bt.root , 8));
	     System.out.println("Initial height : " + bt.height());
	     bt.insert(22);
	     bt.r_insert(bt.root, 1);
	     bt.inorderDisplay();
	     bt.levelOrderDisplay();
	     System.out.println("Final height : " + bt.height());
	     bt.delete(bt.root, 1) ;
	     bt.inorderDisplay();
	     bt.levelOrderDisplay();
	}

}
