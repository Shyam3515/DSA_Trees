/*
 * Video : https://www.youtube.com/watch?v=81PpYQ0AN_w
 * Link : https://thecodingsimplified.com/create-binary-search-tree/
 * Link1: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * 
 * Algorithm:
  		1) A first node is always the root, inserted with help of class node.
 		2) Second element value will be compared, if greater right side recursive call will be called.
  		3) Otherwise, left side recursive call will be called.
  		
 * Time Complexity/Space Complexity
 * O(n)/O(1)		
 */
package tree;

public class BST {
	 static int flag=0;
	 
	 public Node insert(Node node, int data) {
		    if(node == null) {
		      //return createNewNode(val);
		    	//As this is in same node, class is present in treeImplementation
		    	  node = new Node(data);
		    }
		    if(data < node.data) {
		      node.left = insert(node.left, data);
		    } else if((data > node.data)) {
		      node.right = insert(node.right, data);
		    }
		    return node;
		  }
	 
	  /*public Node createNewNode(int k) {
	    Node node = new Node();
	    node.data = k;
	    node.left = null;
	    node.right = null;
	    
	    return node;   
	  }
	  */
	// Pre-Order Traversal
		 static void preorder(Node root) {
			 if(root==null) {
				 return;
			 } 
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		 }
		 
		 Node search(Node root) {
			 int val=10;
			 if(root==null || val==root.data) {
				 return root;
			 }
			 else if(val<root.data) {
				 return search(root.left);
			 }
			 else {
				 return search(root.right);
			 }
		 }
		 
	public static void main(String[] args) {
		BST tree= new BST();
		Node root = null;
	  
	    root = tree.insert(root, 8);
	    root = tree.insert(root, 3);
	    //System.out.println("Second:"+root.data);
	    root = tree.insert(root, 6);
	    root = tree.insert(root, 10);
	    //System.out.println("Second:"+root.data);
	    root = tree.insert(root, 5);
	    root = tree.insert(root, 11);
	    root = tree.insert(root, 4);
	   // System.out.println(root.left.right.left.data);
	    System.out.println("Pre-Order Data: ");
        preorder(root);
        System.out.println();
       
       Node r= tree.search(root);
       if(r!=null) {
       System.out.println("Data Found is..."+r.data);
       }
       else {
    	   System.out.println("Data NOt Found..!");
       }
	}
}
