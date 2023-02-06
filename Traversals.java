// preorder, inorder and postorder traversals of the binary tree, 
//which are nothing but variations of Depth–first search of a Tree.

/*
 * Link : https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * Video : https://www.youtube.com/watch?v=e_Wv_pH4Se8
 * Unlike linear data structures (Array,Linked List,Queues,Stacks,etc)which have only one logical way to traverse them,
   trees can be traversed in different ways. Following are the generally used ways for traversing trees.

Example Tree:
                   1
                  / \
                 2   3
                / \
               4   5
                   
Depth First Traversals: 
(a) Inorder (Left, Root, Right) : 4 2 5 1 3 
(b) Preorder (Root, Left, Right) : 1 2 4 5 3 
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
Breadth-First or Level Order Traversal: 1 2 3 4 5 

* Inorder Traversal (Practice): 
	Algorithm Inorder(tree)
	   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
	   2. Visit the root.
	   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
	Uses of Inorder 
	In the case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversal s reversed can be used. 
	Example: In order traversal for the above-given figure is 4 2 5 1 3.

* Preorder Traversal (Practice): 
	Algorithm Preorder(tree)
	   1. Visit the root.
	   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
	   3. Traverse the right subtree, i.e., call Preorder(right-subtree) 
	Uses of Preorder 
	Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expression on an expression tree. Please see http://en.wikipedia.org/wiki/Polish_notation know why prefix expressions are useful. 
	Example: Preorder traversal for the above-given figure is 1 2 4 5 3.

* Postorder Traversal (Practice): 
	Algorithm Postorder(tree)
	   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
	   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
	   3. Visit the root.
	Uses of Postorder 
	Postorder traversal is used to delete the tree.
	
 *Time Complexity/Space Complexity
 * O(n)/O(1)	
 */

package tree;

/*
 * No need to use Class Node here, as they are from same package we can use Node
   from Implementation class.
 */

public class Traversals {
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

	//In-Order Traversal
	static void inorder(Node root) {
		 if(root==null) {
			 return;
		 } 
		 inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	 }
	
	 // Pre-Order Traversal
	 static void preorder(Node root) {
		 if(root==null) {
			 return;
		 } 
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	 }
	 
	 // Post-Order Traversal
	 static void postorder(Node root) {
		 if(root==null) {
			 return;
		 } 
		 postorder(root.left);
		 postorder(root.right);
		System.out.print(root.data+" ");
	 }
	 
	static Node root=null;
	public static void main(String[] args) {
		Traversals tree = new Traversals();	 
        /*create root*/
        tree.root = new Node(4);
 
        /* following is the tree after above statement
 
              1
            /   \
          null  null     */
 
        tree.root.right = new Node(10);
        tree.root.right.right = new Node(1);
        tree.root.right.right.left= new Node(30);
		/* 2 and 3 become left and right children of 1
		        1
		     /     \
		   2        3
		 /   \     /  \
		null null null null  */
        
        tree.root.left = new Node(5);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.left.right.right = new Node(20);
       
        System.out.println("In-Order Data: ");
        inorder(root);
        System.out.println();
        
        System.out.println("Pre-Order Data: ");
        preorder(root);
        System.out.println();
        
        System.out.println("Post-Order Data: ");
        postorder(root);
	}
}
