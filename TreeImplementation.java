/*
 * Link : https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
 * Video : https://www.youtube.com/watch?v=QhIM-G7FAow&t=716s
 * Video : https://www.youtube.com/watch?v=6vt3PFRC11E
 * 
 * Why Trees? 
 --> One reason to use trees might be because you want to store information 
  	 that naturally forms a hierarchy.

 * Binary Tree: 
 --> A tree whose elements have at most 2 children is called a binary tree. 
     Since each element in a binary tree can have only 2 children, we typically name them the left and right child.
    
 * Algorithm: 
	 Binary Tree Representation: 
	  --> A tree is represented by a pointer to the topmost node in tree. 
	   	  If the tree is empty, then value of root is NULL. 
			A Tree node contains following parts. 
			1. Data 
			2. Pointer to left child 
			3. Pointer to right child
 * In C, we can represent a tree node using structures. 
   In other languages we can use classes as part of their OOP feature.
 */
package tree;

import java.util.Scanner;
	/* Class containing left and right child of current
	node and data value*/
class Node {
	int data;
	Node right;
	Node left;
	
	Node(int data){
		this.data = data;
		left = right = null;
	}
}

public class TreeImplementation {
	 static Node root=null;
	 //static Node root1=null;
	 
	 static Node create() {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the node :");
		int data= sc.nextInt();
		if(data==-1) {
			return null;
		}
		 /*create root
		
		if(root==null) {
		    root=new Node(data);
			//root1=root;
		}
		//root=root1;*/
		
		root=new Node(data);
		// Entering the left child
		// This continues and enters the left child value until you give -1.
		System.out.println("Enter left child of "+data+": "); 
		root.left=create();
		System.out.println("Enter right child of "+data+": "); // Entering the right child
		root.right=create();
		return root;
	}

	public static void main(String[] args) {
		System.out.println("Enter the root node: ");
		Node root=create(); // Calling the create function.	
		System.out.println(root);
	}
}



