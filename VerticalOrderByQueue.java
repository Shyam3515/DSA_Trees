/*
 * Link : https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
 * Video : https://www.youtube.com/watch?v=PQKkr036wRc&t=460s
 * 
 * Algorithm: If we use level order traversal, we can make sure that if a node like 12 
    comes below in the same vertical line, it is printed after a node like 9 which comes 
    above in the vertical line.

	1. To maintain a hash for the branch of each node.
	2. Traverse the tree in level order fashion.
	3. In level order traversal, maintain a queue
	   which holds, node and its vertical branch.
	    * pop from queue.
	    * add this node's data in vector corresponding
	      to its branch in the hash.
	    * if this node hash left child, insert in the 
	      queue, left with branch - 1.
	    * if this node hash right child, insert in the 
	      queue, right with branch + 1.
 * 
 */
package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Qobj {
    int hd;
    Node node;
    Qobj(int hd, Node node)
    {
        this.hd = hd;
        this.node = node;
    }
}
public class VerticalOrderByQueue {
	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> list2 = new ArrayList<Integer>();
	 // Create a map and store vertical order in
    // map using function getVerticalOrder()
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	static int hd=0;
	// The main function to print vertical order of a
    // binary tree with given root
    void printVerticalOrder(Node root)
    {
        // Base case
        if (root == null)
            return;

        // Create queue to do level order traversal.
        // Every item of queue contains node and
        // horizontal distance.
        Queue<Qobj> que = new LinkedList<Qobj>();
        que.add(new Qobj(0, root));
 
        while (!que.isEmpty()) {
            // pop from queue front
            Qobj temp = que.poll();
            hd = temp.hd; //here, hd points to hd(key).
            Node node = temp.node; // node points to value.
 
            // insert this node's data in array of hash
            if (map.containsKey(hd)) {
            	map.get(hd).add(node.data);
            }
            else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(node.data);
                map.put(hd, al);
            }
            if (node.left != null)
                que.add(new Qobj(hd - 1, node.left));
            if (node.right != null)
                que.add(new Qobj(hd + 1, node.right));
        }
    }
	void print(){
		// Traverse the map and print nodes at
        // every horizontal distance (hd)
        for (Map.Entry<Integer, ArrayList<Integer> > entry : map.entrySet()) {
            ArrayList<Integer> al = entry.getValue();
            list.add(al.get(0));
            list2.add(al.get(al.size()-1));
           /* 
            for (Integer i : al){ // To print vertical values line by line.
                System.out.print(i + " "); 
                }
            System.out.println();
            */
        }
        System.out.println("Top-View Elements: ");
		for(int e:list){
			System.out.print(" "+e);
		}
		System.out.println();
		System.out.println("Bottom-View Elements: ");
		for(int e:list2) {
			System.out.print(" "+e);
		}
	}

	public static void main(String[] args) {
		VerticalOrderByQueue tree =new VerticalOrderByQueue();
		Node root = new Node(20);
	    root.left = new Node(8);
	    root.right = new Node(22);
	    root.left.left = new Node(5);
	    root.left.right = new Node(3);
	    root.right.left = new Node(4);
	    root.right.right = new Node(25);
	    root.left.right.left = new Node(10);
	    root.left.right.right = new Node(14);
 
	    tree.printVerticalOrder(root);
	    System.out.println("Vertical Order traversal: "+map);
	    tree.print();

	}

}
