/*
 * Link : https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 * Video : https://www.youtube.com/watch?v=vdwcCIkLUQI
 * 
 * Method 1 (Recursive)
  --> Algorithm – Mirror(tree): 
	(1)  Call Mirror for left-subtree    i.e., Mirror(left-subtree)
	(2)  Call Mirror for right-subtree  i.e., Mirror(right-subtree)
	(3)  Swap left and right subtrees.
	          temp = left-subtree
	          left-subtree = right-subtree
	          right-subtree = temp
 
 * Time Complexity/Space Complexity
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

public class MirrorOfTree {
	void mirror(Node root) {
		if (root == null) {
    	    return;
		}
		mirror(root.left); //Moving to extreme left
		mirror(root.right); // Moving to extreme right
		
		Node temp = root.left; //Swapping
		root.left=root.right;
		/*if(root.left!=null) {
			System.out.println("Root1: "+root.data);
			System.out.println("Left1: "+root.left.data);
		}
		else {
			System.out.println("Root12: "+root.data);
			System.out.println("Left2: "+root.left);
		}
		*/
		root.right=temp;
		/*
		if(root.right!=null) {
			System.out.println("Root2: "+root.data);
			System.out.println("Right1: "+root.right.data);
		}
		else {
		System.out.println("Root21: "+root.data);
		System.out.println("Right2: "+root.right);
		}
		System.out.println("************");
		*/
	}

	static Node root=null;
	public static void main(String[] args) {
		MirrorOfTree tree = new MirrorOfTree();
		tree.root = new Node(1); 
		root.left = new Node(2);
		root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    tree.mirror(root);

	}

}
