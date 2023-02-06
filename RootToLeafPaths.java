package tree;

import java.util.Stack;

public class RootToLeafPaths {
	static Stack<Integer> stack= new Stack<Integer>();
	static void preorder(Node root) {
		 if(root==null) {
			 return;
		 } 
		// Add elements to stack
		stack.push(root.data); 
		// traverse to the left extreme
		preorder(root.left);
		// If both are null, thats the leaf node then print stack path.
		if(root.left==null && root.right==null) {
			System.out.println("Stack Elements:");
			 for(Object ele:stack)
					System.out.print(ele+" ");
				System.out.println();
		 }
		preorder(root.right);
		stack.pop();
	 }
	
	static Node root=null;
	public static void main(String[] args) {
		RootToLeafPaths tree= new RootToLeafPaths();
		tree.root = new Node(1); 
		root.left = new Node(2);
		root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    tree.preorder(root);

	}
}
