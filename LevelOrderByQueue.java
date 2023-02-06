/*
 * Link : https://www.interviewbit.com/blog/level-order-traversal/#:~:text=the%20balanced%20tree)
 * Algorithm:
 *    1)Firstly we insert the root into the queue and iterate over the queue until the queue is empty.
	  2)In every iteration, we will pop from the top of the queue and print the value at the top of the queue.
	  3)Then, add its left and right nodes to the end of the queue.
	
 * Time Complexity/Space Complexity
 * O(n)/O(n)
 */
package tree;
import java.util.LinkedList;

import java.util.Queue;

public class LevelOrderByQueue {
							/* Tree...
						    
						    4
						  /   \
						 5    10
						/ \     \
						7   8     1
						    \   /
						     9 30
						      \  
						       20 
						           
						*/
	    void printLevelOrder()
		{
	    	if (root == null) {
	    		System.out.println("Tree is null...");
	    	    return;
	    	 }
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);// added to print line by line.
			
			while (!queue.isEmpty()) {
				Node tempNode = queue.remove();
				
				//To print line by line
				if(tempNode==null) {  //If temp==null, this condition executes,else child nodes gets added to queue.  
					if(queue.isEmpty()) {
						return;
					}
					queue.add(null);
					System.out.println(); // after null this will start from new line
					continue; // if temp==null, it moves to next iteration, here. So, curr.node doesn't print here.
					//because as currnode=null, we can't have child's for that.
				}
				System.out.print(tempNode.data + "   ");
				
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
		}

	static Node root=null;
	public static void main(String[] args) {
		LevelOrderByQueue tree = new LevelOrderByQueue();
		tree.root = new Node(4);
		 tree.root.right = new Node(10);
	     tree.root.right.right = new Node(1);
	     tree.root.right.right.left= new Node(30);
	     tree.root.left = new Node(5);
	     tree.root.left.left = new Node(7);
	     tree.root.left.right = new Node(8);
	     tree.root.left.left.right = new Node(9);
	     tree.root.left.left.right.right = new Node(20);
	   
		/*tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);*/
		
        tree.printLevelOrder();
	     System.out.println();

	}

}
