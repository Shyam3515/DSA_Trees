/*
 * Link : https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
 * Video : https://www.youtube.com/watch?v=ey7DYc9OANo&t=759s
 * Question : The diameter of a tree is the number of nodes on the longest path between two leaves in the tree. 
 			  The diagram below shows two trees each with diameter nine, 
 			  the leaves that form the ends of the longest path are colored 
 			  (note that there may be more than one path in the tree of the same diameter).
  
 * Algorithm : 
      -->Diameter of a tree can be calculated by only using the height function, 
      because the diameter of a tree is nothing but maximum value of
      (left_height + right_height + 1) for each node. So we need to calculate this value 
      (left_height + right_height + 1) for each node and update the result.
      
 * 
	 * Input :      1
		          /   \
		        2      3
		      /  \
		    4     5
		
		Output : 4
 
 * Time Complexity/Space Complexity
 * O(n)/O(1)		
 */

package tree;

public class DiameterOfTree {
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
	
	int diameter(Node root) {
		if (root == null) {
    	    return 0;
		}
		int leftheight  =  height(root.left);
		System.out.println("Left Height:"+leftheight);
		int rightheight =  height(root.right);
		System.out.println("Right Height:"+rightheight);
		int leftdiameter =  diameter(root.left);
		System.out.println("Left Diameter:"+leftdiameter);
		int rightdiameter =  diameter(root.right);
		System.out.println("Right Diameter:"+rightdiameter);
		System.out.println("****************");
		
		int fd = Math.max((leftheight + rightheight + 1),Math.max(leftdiameter,rightdiameter));

		return fd;
	}

	static Node root=null;
	public static void main(String[] args) {
		DiameterOfTree tree = new DiameterOfTree();
		/*tree.root = new Node(4);
		 tree.root.right = new Node(10);
	     tree.root.right.right = new Node(1);
	     tree.root.right.right.left= new Node(30);
	     tree.root.right.right.left.right= new Node(40);
	     tree.root.right.right.left.right.right= new Node(50);
	     tree.root.left = new Node(5);
	     tree.root.left.left = new Node(7);
	     tree.root.left.right = new Node(8);
	     tree.root.left.left.right = new Node(9);
	     tree.root.left.left.right.right = new Node(20);
	     */
		tree.root = new Node(1); 
		root.left = new Node(2);
		root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
        System.out.println("Diameter of Tree: "+tree.diameter(root));
	}
}
