/*
 * Link1 : https://www.javatpoint.com/vertical-traversal-of-a-binary-tree
 * Link2 : https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
 * Video : https://www.youtube.com/watch?v=PQKkr036wRc&t=711s
 * https://github.com/vivekanand44/codes-Youtube-videos(github link)
 *  Algorithm :
	This algorithm is a combination of level order traversal and hash table. 
	The following are the steps required for the vertical traversal of a binary tree:
	Step 1: Update Hd distance for root as 0.Return, if root is null.
	Step 2: if map contains same key, add value to same key.
	Step 3: else, add data to arraylist and then add to map.
	Step 4: if left and right child of root are not null:
	        a) Assign left child key as (hd-1) and send to vertical method to add to map.
	        b) Assign right child key as (hd+1) and send to vertical method to add to map.
 * Time Complexity/Space Complexity
 * O(n)/O(n)	        
						
 */
package tree;
import java.util.ArrayList;
import java.util.HashMap;

public class VerticalOrder {
	
						/* Tree...
						    
						    4
						  /   \
						 5    10
						/ \     \
						7   8     1
						 \       /
						  9     30
						   \     \
						    20    40
						            \
						             50
						*/
	//To add values of same key.
	ArrayList<Integer> al = new ArrayList<>();
	                //Key      //Values
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	int hd=0;
	void vertical(Node root, int hd,HashMap< Integer,ArrayList<Integer> > map) {
		if(root==null) {
			return;
		}
		if(map.containsKey(hd)) {
			map.get(hd).add(root.data); //when we add many values to same key,follow the format)
		 }
		else {
            ArrayList<Integer> al = new ArrayList<>();//for every iteration it creates newspace for keys,if not present
            al.add(root.data);// add value to arraylist and then add to map.
            map.put(hd, al);
        }
		if (root.left != null) {
		vertical(root.left,hd-1,map);
		}
		if (root.right != null) {
			vertical(root.right,hd+1,map);
		}
	}
	  
	static Node root=null;
	public static void main(String[] args) {
		VerticalOrder tree = new VerticalOrder();
		 tree.root = new Node(4);
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
	     
		/*Node root = new Node(20);
	    root.left = new Node(8);
	    root.right = new Node(22);
	    root.left.left = new Node(5);
	    root.left.right = new Node(3);
	    root.right.left = new Node(4);
	    root.right.right = new Node(25);
	    root.left.right.left = new Node(10);
	    root.left.right.right = new Node(14);
 */
	     tree.vertical(root, 0, map);
	     System.out.println("Vertical Order traversal: "+map);
	}
}
