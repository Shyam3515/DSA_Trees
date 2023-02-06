// Height of Binary tree = 1+ no.of edges on the longest path from root to leaf node.
/*
 * Link : https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 * Video : https://www.youtube.com/watch?v=_O-mK2g_jhI
 * 
 * Question : Write a Program to Find the Maximum Depth or Height of a Tree
 * 
 * Algorithm: 
   --> Recursively calculate height of left and right subtrees of a node and 
       assign height to the node as max of the heights of two children plus 1.
		 maxDepth()
		1. If tree is empty then return -1
		2. Else
		     (a) Get the max depth of left subtree recursively  i.e., 
		          call maxDepth( tree->left-subtree)
		     (a) Get the max depth of right subtree recursively  i.e., 
		          call maxDepth( tree->right-subtree)
		     (c) Get the max of max depths of left and right 
		          subtrees and add 1 to it for the current node.
		         max_depth = max(max dept of left subtree,max depth of right subtree) + 1                     
		     (d) Return max_depth
	
 * Time Complexity/Space Complexity
 * O(n)/O(1)  		     
 */
package tree;

public class HeightOfTree {
	/* Compute the "maxDepth" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
	int height(Node root) {
		if (root == null) {
    	    return 0;
		}
		/* compute the depth of each subtree */
		int left  =  height(root.left);
		int right =  height(root.right);
		/* use the larger one */
		int h;
		if(left>right) {
			 h= 1+left;
		}
		else {
			 h=1+right;
		}
		return h;
	}

	static Node root=null;
	public static void main(String[] args) {
		HeightOfTree tree = new HeightOfTree();
		 tree.root = new Node(4);
		 tree.root.right = new Node(10);
	     tree.root.right.right = new Node(1);
	     tree.root.right.right.left= new Node(30);
	     tree.root.left = new Node(5);
	     tree.root.left.left = new Node(7);
	     tree.root.left.right = new Node(8);
	     tree.root.left.left.right = new Node(9);
	     tree.root.left.left.right.right = new Node(20);
	     System.out.println("Height of root node is: "+tree.height(root));
	}
}
