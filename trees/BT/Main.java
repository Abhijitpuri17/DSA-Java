package trees.BT;

public class Main 
{

	public static void main(String[] args) 
	{
		int arr[] = {1,2,3,4,5,6,7} ;
		MyBT bt = new MyBT(arr);
		//bt.createBT();
		System.out.print("PREORDER : ");
        bt.preorderDisplay();
        bt.i_preorder();
        System.out.print("INORDER : ") ;
       bt.inorderDisplay() ;
       bt.i_inorder() ;
       System.out.print("POSTORDER : ") ;
       bt.postorderDisplay() ;
       System.out.print("LEVEL ORDER : ") ;
       bt.levelOrderDisplay() ;
       System.out.println("Number of nodes : " + bt.count()) ;
       System.out.println("Height : " + bt.height()) ;
	}

}
