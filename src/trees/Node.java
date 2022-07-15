package trees;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) 
	{
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public void setChildren(Node left, Node right) {
		this.left = left;
		this.right = right;
	}
	
	public static void inOrderTraversal(Node node) 
	{
		if(node.left != null) 
		{
			inOrderTraversal(node.left);
		}
		
		System.out.println(node.value);
		
		if(node.right != null) {
			inOrderTraversal(node.right);
		}
	}
	
	public static void preOrderTraversal(Node node) 
	{
		System.out.println(node.value);
		
		if(node.left != null) 
		{
			preOrderTraversal(node.left);
		}
		
		if(node.right != null) {
			preOrderTraversal(node.right);
		}
	}
	
	public static void postOrderTraversal(Node node) 
	{
		if(node.left != null) 
		{
			postOrderTraversal(node.left);
		}
		
		if(node.right != null) {
			postOrderTraversal(node.right);
		}
		
		System.out.println(node.value);
	}
	
	public static Node createBasicTree() {
		Node root = new Node(10);
		Node n2 = new Node(5);
		Node n3 = new Node(20);
		Node n4 = new Node(3);
		Node n5 = new Node(7);
		Node n6 = new Node(15);
		Node n7 = new Node(25);
		
		root.setChildren(n2, n3);
		n2.setChildren(n4, n5);
		n3.setChildren(n6, n7);
		
		return root;
	}
	
	public static void main(String[] args) {
		Node myTree = createBasicTree();
		
		System.out.println("InOrder:");
		inOrderTraversal(myTree);
		
		System.out.println("\nPreOrder:");
		preOrderTraversal(myTree);
		
		System.out.println("\nPostOrder:");
		postOrderTraversal(myTree);
	}
	
}
