/*
 *  This search is referred to as level order traversal or Breadth–first search (BFS), 
    as the search tree is broadened as much as possible on each depth before going to the next depth.
  
 *  Link : https://www.techiedelight.com/level-order-traversal-binary-tree/
 *  Video:https://www.youtube.com/watch?v=lXIk1PXb1Jc
 *  Algorithm(LOT) : 
 *  	1) Here, we maintain a method for levels, after completion of one level we move to another by incrementing of level.
 *  	2) Until while returns true level gets incremented.
 *  	3) First time as level=1, root gets printed and returns true, and level gets updated to 2.
 *  	4) Here, as level=2, it moves to root.left then left value prints and returns true, to left.
 *  	5) After completion of left right prints and returns true to right.
 *  	6) Now, level becomes 3, so it reaches root.left.left(until level equals 1).
 *  
 *  Algorithm(For Left-view and Right-view):
 *  	1) After LOT, we can get Left-view elements, by taking first element in each level.
 *  	2) We can get Right-view elements, by taking last element in each level.
 *  
 * Time Complexity/Space Complexity
 * O(n^2)/O(n)
 */

package tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
				/* Tree...
			    
			    4
			  /   \
			 5    10
			/ \     \
			7   8     1
			    \   /
			     9 30
			      \  \
			       20 40
			            \
			             50
			*/
	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> list1 = new ArrayList<Integer>();
	static List<Integer> list2 = new ArrayList<Integer>();
	
	// Level-Order Traversal
	  static boolean printlevel(Node root,int level) {
			if(root==null) {
				return false;
			}
			if(level==1) {
				System.out.println("Data: "+root.data);
				list.add(root.data); // adding data to list for every iteration
				return true;
			}
		
			boolean left=printlevel(root.left,level-1);
			boolean right=printlevel(root.right,level-1);
			
			return left || right;
		}
			
		static void levelOrder(Node root) {
			int level=1;
			while(printlevel(root,level)) {
				list1.add(list.get(0)); // we take every first element for left-view.
				list2.add(list.get(list.size()-1)); // we take every last element for right-view.
				list.clear();// clearing list, so we get first element of each level.
				System.out.println("l:"+level);
				level++; // This total level Order, depends here
			}
			System.out.println("Left-View Elements: ");
			for(int e:list1){
				System.out.print(" "+e);
			}
			
			System.out.println();
			System.out.println("Right-View Elements: ");
			for(int e:list2) {
				System.out.print(" "+e);
			}
		}
	
	static Node root=null;
	public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();	 
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
	     
        System.out.println("Level-Order Data: ");
        levelOrder(root);
	}
}
