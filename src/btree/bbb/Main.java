package btree.bbb;

import java.util.ArrayList;

class BTreeNode {

	// Vector of keys
	private ArrayList<Integer> keys;

	// Minimum degree
	private int t;

	// Vector of child pointers
	private ArrayList<BTreeNode> C;

	// Is true when node is leaf, else false
	private boolean leaf;

	// Constructor
	public BTreeNode(int t, boolean leaf) {
		this.t = t;
		this.leaf = leaf;
		this.keys = new ArrayList<>();
		this.C = new ArrayList<>();
	}

	// Traversing the node and print its content
	// with tab number of tabs before
	public void traverse(int tab) {
		StringBuilder s = new StringBuilder();

		// Print 'tab' number of tabs
		for (int j = 0; j < tab; j++) {
			s.append('\t');
		}

		for (int i = 0; i < keys.size(); i++) {

			// If this is not leaf, then before printing key[i]
			// traverse the subtree rooted with child C[i]
			if (!leaf) {
				C.get(i).traverse(tab + 1);
			}
			System.out.println(s.toString() + keys.get(i));
		}

		// Print the subtree rooted with the last child
		if (!leaf) {
			C.get(keys.size()).traverse(tab + 1);
		}
	}

	// Returns true if node is full
	public boolean isFull() {
		// returns true if node is full
		return keys.size() == 2 * t - 1;
	}

	// Makes new root, setting current root as its child
	public BTreeNode makeNewRoot(int val, BTreeNode newEntry) {
		// Create new root
		BTreeNode root = new BTreeNode(t, false);

		// Stores keys value
		root.keys.add(val);

		// Push child pointers
		root.C.add(this);
		root.C.add(newEntry);
		return root;
	}

	// Function to split the current node and store the new
	// parent value in *val and new child pointer in &newEntry
	// called only for splitting non-leaf node
	public void split(int[] val, BTreeNode newEntry) {

		// Create new non-leaf node
		BTreeNode newNode = new BTreeNode(t, false);

		// (t+1)th becomes parent
		val[0] = this.keys.get(t);

		// Last (t-1) entries will go to the new node
		for (int i = t + 1; i < 2 * t; i++) {
			newNode.keys.add(this.keys.get(i));
		}

		// This node stores the first t entries
		this.keys.subList(t, 2 * t - 1).clear();

		// Last t entries will go to the new node
		newNode.C.addAll(this.C.subList(t + 1, 2 * t));

		// This node stores the first (t+1) entries
		this.C.subList(t + 1, 2 * t + 1).clear();
		this.C.add(newNode);
	}

	// Function to insert a new key in the given node.
	// If the child of this node is split, we have to insert *val
	// into keys vector and newEntry pointer into C vector
	public void insert(int newKey, int[] val, BTreeNode[] newEntry) {

		// Non-leaf node
		if (!leaf) {
			int i = 0;

			// Find the first key greater than newKey
			while (i < keys.size() && newKey > keys.get(i))
				i++;

			// We have to insert newKey into the left child of
			// Node with index i
			C.get(i).insert(newKey, val, newEntry);

			// No split was done
			if (newEntry[0] == null)
				return;

			if (keys.size() < 2 * t - 1) {
				// This node can accommodate a new key
				// and child pointer entry
				// Insert *val into key vector
				keys.add(i, val[0]);

				// Insert newEntry into C vector
				C.add(i + 1, newEntry[0]);

				// As this node was not split, set newEntry
				// to null
				newEntry[0] = null;
			} else {
				// Insert *val and newentry
				keys.add(i, val[0]);
				C.add(i + 1, newEntry[0]);

				// Current node has 2*t keys, so split it
				split(val, newEntry[0]);
			}
		} else {
			// Insert newKey in this node
			int i = 0;

			// Find correct position
			while (i < keys.size() && newKey > keys.get(i))
				i++;

			// Insert in correct position
			keys.add(i, newKey);

			// If node is full
			if (keys.size() == 2 * t) {

				// Create a new node
				BTreeNode newLeaf = new BTreeNode(t, true);

				// Set (t+1)th key as parent
				val[0] = this.keys.get(t);

				// Insert last (t-1) keys into new node
				newLeaf.keys.addAll(keys.subList(t + 1, 2 * t));

				// This node stores the first t keys
				this.keys.subList(t, 2 * t - 1).clear();

				newEntry[0] = newLeaf;
			}
		}
	}
}

class BTreebbb {

	// Root of B-Tree
	private BTreeNode root;

	// Minimum degree
	private int t;

	// Constructor
	public BTreebbb(int t) {
		this.root = new BTreeNode(t, true);
		this.t = t;
	}

	// Function to insert a node in the B-Tree
	public void insert(int key) {
		BTreeNode[] newEntry = {null};
		int[] val = {0};

		// Insert in B-Tree
		root.insert(key, val, newEntry);

		// If newEntry is not null then root needs to be
		// split. Create new root
		if (newEntry[0] != null) {
			root = root.makeNewRoot(val[0], newEntry[0]);
		}
	}

	// Prints BTree
	public void display() {
		root.traverse(0);
	}
}

// Driver code
public class Main {

	public static void main(String[] args) {

		// Create B-Tree
		BTreebbb tree = new BTreebbb(3);
		System.out.println("After inserting 1 and 2");
		tree.insert(1);
		tree.insert(2);
		tree.display();

		System.out.println("After inserting 5 and 6");
		tree.insert(5);
		tree.insert(6);
		tree.display();

		System.out.println("After inserting 3 and 4");
		tree.insert(3);
		tree.insert(4);
		tree.display();
	}
}
