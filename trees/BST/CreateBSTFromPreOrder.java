package trees.BST;

import java.util.Stack;

import trees.BT.Node;

public class CreateBSTFromPreOrder 
{

	public static void main(String[] args) 
	{
		int preorder[] = {30,20,10,15,25,40,50,45} ;
        MyBST bst = createBST(preorder);
        bst.inorderDisplay();
        bst.preorderDisplay();
        bst.levelOrderDisplay();
        System.out.println(bst.height());
        System.out.println(bst.count());
	}
	
	public static MyBST createBST(int preorder[])
	{
		Stack<Node> mStack = new Stack<>();
		MyBST bst = new MyBST();
		bst.root = new Node(preorder[0] , null , null) ;
		
		Node p = bst.root;
		int i = 1 ;
		while (i < preorder.length)
		{
			if (preorder[i] < p.getVal()) 
			{
				p.setLeftChild(new Node(preorder[i++] , null , null));
				mStack.push(p) ;
				p = p.getLeftChild();
			}
			else 
			{
				if (preorder[i] > p.getVal() && (mStack.isEmpty() || preorder[i] < mStack.peek().getVal()))
				{
					p.setRightChild(new Node(preorder[i++] , null , null));
					p = p.getRightChild();
				}
				else 
				{
					p = mStack.pop();
				}
			}
		}
		
		return bst;
		
		
	}

}
