/*
 * Link : 
 * Video : https://www.youtube.com/watch?v=aYwiLCCdb-k
 * Question : Print Root to Leaf Path with Given sum(Print all K-Sum paths) in a given Binary Tree
 
 * Algorithm :
 * 	1) With preorder traversal,we find path.
 *  2) Nodes will be added to sum, and gets popped until sum reaches to given sum. 
 *  3) If sum equals given sum, print the path from stack.
  
 *  Time Complexity/Space Complexity
 * O(n)/O(n)
 * 
 */
package tree;
import java.util.Stack;

public class RootToLeafPathWithGivenSum {
	static Stack<Integer> stack= new Stack<Integer>();
	static int sum=0;
	static void preorder(Node root) {
		int k=7;
		 if(root==null) {
			 return;
		 } 
		 sum=sum+root.data;
		 //System.out.println("Root:"+root.data);
		//System.out.println("Sum: "+sum);
		 stack.push(root.data);
		 if(sum==k) {
			 System.out.println("Stack Elements:");
			 for(Object ele:stack)
					System.out.print(ele+" ");
				System.out.println();
		 }
		
		preorder(root.left);
		//System.out.println("sum1:"+sum);
		preorder(root.right);
		sum-=root.data;
		stack.pop(); // We will get every path of elements from here, as they will be popped out, if not matched.
	 //we get 1,2,4 as it matches 7, and when it reaches pop condition,it pops 4, and it goes back pops all elements until it finds given sum.
	}
	static Node root=null;
	public static void main(String[] args) {
		RootToLeafPathWithGivenSum tree = new RootToLeafPathWithGivenSum();
		tree.root = new Node(1); 
		root.left = new Node(2);
		root.right = new Node(6);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    tree.preorder(root);
	}
}
