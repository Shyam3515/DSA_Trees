/*
 * Link : https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
 * Video1 : https://www.youtube.com/watch?v=UG3OhQ5QRkk&t=317s
 * Video2 : https://www.youtube.com/watch?v=9jH2L2Ysxko
 * 
 * Algorithm :
 * For two trees ‘a’ and ‘b’ to be mirror images, the following three conditions must be true: 
	1)Their root node’s key must be same
	2)Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
	3)Right subtree of ‘a’ and left subtree of ‘b’ are mirror.
	
 *Time Complexity/Space Complexity
 * O(n)/O(1)	 	
 */
package tree;
/*
		     1                                              1                                       
		   /   \                 ---->                    /   \
		  2     3                                        3     2
		 / \                                                  /  \
	    4   5                                                5    4
		
*/

public class CheckMirror {
	    /* Given two trees, return true if they are
	       mirror of each other */
	    boolean areMirror(Node root1, Node root2)
	    {
	        /* Base case : Both empty */
	        if (root1 == null && root2 == null) {
	            return true;
	        }
	        // If only one is empty
	        if (root1 == null || root2 == null) {
	            return false;
	        }
	        /* Both non-empty, compare them recursively
	           Note that in recursive calls, we pass left
	           of one tree and right of other tree */
	        return root1.data == root2.data
	                && areMirror(root1.left, root2.right)
	                && areMirror(root1.right, root2.left);
	    }
	    
	static Node root1=null;
	static Node root2=null;
	public static void main(String[] args) {
		CheckMirror tree =new CheckMirror();
		//tree 1
		tree.root1 = new Node(1); 
		root1.left = new Node(2);
		root1.right = new Node(3);
	    root1.left.left = new Node(4);
	    root1.left.right = new Node(5);
	    
	  //tree 2
  		tree.root2 = new Node(1); 
  		root2.left = new Node(3);
  		root2.right = new Node(2);
  	    root2.right.left = new Node(5);
  	    root2.right.right = new Node(4);
  	    if(tree.areMirror(root1, root2)==true) {
  	    	System.out.println("Yes");
  	    }
  	    else {
  	    System.out.println("No");
  	    }
	}
}
