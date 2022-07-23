package trees;

// Depth: Distance between the Node and the root

// Implementing an algorithm to calculate the sum of the depths of every node in a tree.
public class NodeDepths 
{
	
	public static int calculateDepth(Node node, int parentDepth) 
	{
		// Bottom of the tree is reached (base case)
		if(node == null) 
		{
			return 0;
		}
		
		else 
		{
			// The children are always 1 level below their parent
			return parentDepth + calculateDepth(node.left, parentDepth +1) + calculateDepth(node.right, parentDepth + 1);
		}
	}
	
	public static void main(String[] args) 
	{
		Node root = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		
		root.setChildren(n2, n3);
		n2.setChildren(n4, n5);
		n3.setChildren(n6, n7);
		n4.setChildren(n8, n9);
		
		// The root's height/depth is 0
		System.out.println(calculateDepth(root, 0));
		
	}

}
