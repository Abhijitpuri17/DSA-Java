package trees.AVLTrees;

public class Main 
{

	public static void main(String[] args)
	{
	
		MyAVLTree avl = new MyAVLTree();
		avl.insert(avl.root, 10);
		avl.insert(avl.root, 20);
		avl.insert(avl.root, 5);
		avl.insert(avl.root, 2);
		avl.delete(avl.root, 20) ;
		System.out.println(avl.root.val);
	}
	

}
