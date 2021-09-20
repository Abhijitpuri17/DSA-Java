package trees.BT;

 public class Node
{
	private int val ;
	private Node leftChild , rightChild ;
	
	public Node(int val , Node leftChild , Node rightChild)
	{
		this.val = val ;
		this.leftChild = leftChild ;
		this.rightChild = rightChild ;
	}
	
	public Node() {
		
	}

	public int getVal() {
		return val ;
	}

	public void setVal(int val) {
		this.val = val ;
	}

	public Node getLeftChild() {
		return leftChild ;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild ;
	}

	public Node getRightChild() {
		return rightChild ;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild ;
	}

	
	
	
	
}
