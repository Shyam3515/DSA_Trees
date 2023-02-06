/*
 *  Link : https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 *  Video : https://www.youtube.com/watch?v=YsLko6sSKh8
 *  
 *  Algorithm(Iterative):
     1)The idea is to use two stacks.
     2) We can use one stack for printing from left to right and other stack for printing from right to left.
     3) In every iteration, we have nodes of one level in one of the stacks. 
     4)We print the nodes, and push nodes of next level in other stack.
    
 * Time Complexity/Space Complexity
 * O(n)/O(n)  
 */
package tree;

import java.util.Stack;

public class SpiralORZigZag {
	Stack<Node> stack1 = new Stack<Node>();
	Stack<Node> stack2 = new Stack<Node>();
	void spiral() 
	{
		if (root == null) {
    		System.out.println("Tree is null...");
    	    return;
    	 }
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) 
		{
			//System.out.println("s1 or s2");
			while(!stack1.isEmpty())
			{
				//System.out.println("s1");
				Node p=stack1.pop();
				System.out.println(p.data);
				if(p.left!=null) {
					stack2.push(p.left);
				}
				if(p.right!=null) {
					stack2.push(p.right);
				}
			}
			while(!stack2.isEmpty())
			{
				//System.out.println("s2");
				Node p1=stack2.pop();
				System.out.println(p1.data);
				if(p1.right!=null) {
					stack1.push(p1.right);
				}
				if(p1.left!=null) {
					stack1.push(p1.left);
				}	
			}
	    }
	}
	static Node root=null;
	public static void main(String[] args) {
		SpiralORZigZag tree = new SpiralORZigZag();
		/*tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);*/
		 tree.root = new Node(4);
		 tree.root.right = new Node(10);
	     tree.root.right.right = new Node(1);
	     tree.root.right.right.left= new Node(30);
	     tree.root.left = new Node(5);
	     tree.root.left.left = new Node(7);
	     tree.root.left.right = new Node(8);
	     tree.root.left.left.right = new Node(9);
	     tree.root.left.left.right.right = new Node(20);	
		
	    tree.spiral();
	}
}
