/*
 * Algorithm:
 *   1) Take the pre-order function.
 *   2) After checking the root, check for left and right child of root.
 *   3) If left and right child of root are null, then print the node, it is a leaf node.
 */
package tree;

public class LeafNodes {
	 // Pre-Order Traversal
	 static void preorder(Node root) {
		 if(root==null) {
			 return;
		 } 
		 else if(root.left==null && root.right==null) {
			 System.out.print(root.data+" ");
		 }
		preorder(root.left);
		preorder(root.right);
	 }

	static Node root=null;
	public static void main(String[] args) {
		LeafNodes tree = new LeafNodes();
		 tree.root = new Node(4);
		 tree.root.right = new Node(10);
	     tree.root.right.right = new Node(1);
	     tree.root.right.right.left= new Node(30);
	     tree.root.left = new Node(5);
	     tree.root.left.left = new Node(7);
	     tree.root.left.right = new Node(8);
	     tree.root.left.left.right = new Node(9);
	     tree.root.left.left.right.right = new Node(20);
	     System.out.println("The leaf node are: ");
	     preorder(root);


	}

}
