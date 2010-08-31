package com.zeekmod.jgeekquest.stanford.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	// Root node pointer. Will be null for an empty tree.
	private Node root;

	/*
	 * --Node-- The binary tree is built using this nested node class. Each node
	 * stores one data element, and has left and right sub-tree pointer which
	 * may be null. The node is a "dumb" nested class -- we just use it for
	 * storage; it does not have any methods.
	 */
	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}

		public String toString() {
			return "Node: " + this.data + " (" + this.isLeaf() + ")";
		}

		public boolean isLeaf() {
			if (this.left == null && this.right == null) {
				return true;
			}
			return false;
		}
	}

	/**
	 * Creates an empty binary tree -- a null root pointer.
	 */
	public BinaryTree() {
		root = null;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	public void mirror(Node n) {
		if (n != null) {
			Node temp = n.left;
			n.left = n.right;
			n.right = temp;
			if (n.left != null) {
				this.mirror(n.left);
			}
			if (n.right != null) {
				this.mirror(n.right);
			}
		}
	}

	public void printPaths() {
		List<Node> l = new ArrayList<Node>();
		this.printPaths(l, this.root);
	}

	public void printPaths(List<Node> path, Node node) {
		if (node == null) {
			return;
		}

		path.add(node);

		if (node.isLeaf()) {
			System.out.println(path);
		} else {
			if (node.left != null) {
				List<Node> l = new ArrayList<Node>();
				l.addAll(path);
				this.printPaths(l, node.left);
			}
			if (node.right != null) {
				List<Node> l = new ArrayList<Node>();
				l.addAll(path);
				this.printPaths(l, node.right);
			}
		}
	}

	public void log(Object o) {
		System.out.println(o);
	}

	public void doubleTree() {
		this.doubleTree(this.root);
	}

	public void doubleTree(Node n) {
		if (n != null) {
			this.log(n + ", left: " + n.left + ", right: " + n.right);
			Node temp = n.left;
			Node newNode = new Node(n.data);
			newNode.left = temp;
			n.left = newNode;
			n.right = temp;
			this.doubleTree(temp);
		}
	}

	public void printPathLevels() {
		this.printPathLevels(this.root, 0);
	}

	public void printPathLevels(Node node, int level) {
		if (node == null) {
			return;
		}

		System.out.print("L" + level);
		System.out.println("   " + node + "   ");

		level++;
		this.printPathLevels(node.left, level);
		this.printPathLevels(node.right, level);

	}

	public int size() {
		return this.size(this.root);
	}

	public int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return this.size(node.left) + 1 + this.size(node.right);
		}
	}

	public int getMaxDepth(Node n) {
		if (n == null) {
			return 0;
		}
		return 1 + Math
				.max(this.getMaxDepth(n.left), this.getMaxDepth(n.right));
	}

	public int getMaxDepth() {
		return this.getMaxDepth(this.root);
	}

	public int getMinValue() {
		Integer min = Integer.MAX_VALUE;
		return this.getMinValue(this.root, min);
	}

	public int getMinValue(Node node, Integer min) {
		if (node == null) {
			return min;
		} else {
			if (node.data < min) {
				min = node.data;
				return this.getMinValue(node.left, min);
			} else {
				return this.getMinValue(node.right, min);
			}

		}
	}

	public int getMaxValue() {
		Integer min = Integer.MIN_VALUE;
		return this.getMaxValue(this.root, min);
	}

	public int getMaxValue(Node node, Integer min) {
		if (node == null) {
			return min;
		} else {
			if (node.data > min) {
				min = node.data;
				return this.getMaxValue(node.right, min);
			} else {
				return this.getMaxValue(node.left, min);
			}

		}
	}

	public void printTree() {
		this.printTree(this.root);
	}

	public void printTree(Node n) {
		if (n == null) {
			return;
		} else {
			this.printTree(n.left);
			System.out.print(" " + n.data + " ");
			this.printTree(n.right);
		}
	}

	public void printPostOrder() {
		this.printPostOrder(this.root);
	}

	public void printPostOrder(Node n) {
		if (n == null) {
			return;
		} else {
			this.printPostOrder(n.left);
			this.printPostOrder(n.right);
			System.out.print(" " + n.data + " ");
		}
	}

	public boolean hasPathSum(int node, int sum) {
		return this.hasPathSum(node, this.root, sum);
	}

	private Boolean hasPathSum(int target, Node n, int sum) {
		Boolean b = null;
		if (n == null) {
			return b;
		} else {
			if (n.data == target) {
				return this.hasPathSum(n, sum);
			} else {
				if (n.left != null) {
					b = this.hasPathSum(target, n.left, sum);
				}
				if (b == null && n.right != null) {
					b = this.hasPathSum(target, n.right, sum);
				}
			}
		}
		return b;
	}

	public boolean hasPathSum(Node n, int targetSum) {
		boolean b = this.hasPathSum(n, targetSum, targetSum);
		System.out.println("");
		System.out.println("----------------------");
		System.out.println(n + " - target: " + targetSum + " - results: " + b);
		return b;
	}

	public boolean hasPathSum(Node n, int targetSum, int current) {
		boolean results = false;
		if (n == null) {
			return false;
		} else {
			current = current - n.data;
			if (current < 0) {
				return false;
			}

			if (this.isLeaf(n)) {
				System.out.println("Leaf - " + n + " - current: " + current);
				if (current == 0) {
					return true;
				}
			} else {
				if (n.left != null
						&& this.hasPathSum(n.left, targetSum, current)) {
					return true;
				}
				if (n.left != null
						&& this.hasPathSum(n.right, targetSum, current)) {
					return true;
				}
			}
		}
		return results;
	}

	private boolean isLeaf(Node n) {
		return n.isLeaf();
	}

	/**
	 * Returns true if the given target is in the binary tree. Uses a recursive
	 * helper.
	 */
	public boolean lookup(int data) {
		return (lookup(root, data));
	}

	/**
	 * Recursive lookup -- given a node, recur down searching for the given
	 * data.
	 */
	private boolean lookup(Node node, int data) {
		if (node == null) {
			return (false);
		}

		if (data == node.data) {
			return (true);
		} else if (data < node.data) {
			return (lookup(node.left, data));
		} else {
			return (lookup(node.right, data));
		}
	}

	/**
	 * Inserts the given data into the binary tree. Uses a recursive helper.
	 */
	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}

		return (node); // in any case, return the new pointer to the caller
	}

	public boolean sameTree(BinaryTree t1) {
		return this.sameTree(this.root, t1.root);
	}

	private boolean sameTree(Node a, Node b) {
		if (a == null && b == null) {
			return true;

		} else if (a == null && b != null) {
			return false;

		} else if (a != null && b == null) {
			return false;

		} else {
			if (a.data == b.data) {
				boolean left = this.sameTree(a.left, b.left);
				boolean right = this.sameTree(a.right, b.right);
				if (left && right) {
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}
		}
	}

	public int countTrees(int n) {
		// Check Input
		if (n <= 1) {
			return 1;

		} else {
			// Loop on all values because they can all be root
			int count = 0;
			for (int i = 1; i <= n; i++) {
				// Log Debug
				log("Root: " + i);

				// Get left side - only smaller numbers than current root
				int left = this.countTrees(i - 1);
				log("Left: " + left);

				// Get right side - bigger than root but not larger than max
				int right = this.countTrees(n - i);
				log("Right: " + right);

				// Sum both sides
				count = count + (left * right);
			}

			// Return Total
			return count;
		}
	}

	public boolean isBST() {
		if (this.root == null) {
			return false;
		}
		return this.isBST(this.root);
	}

	private boolean isBST(Node n) {
		int root = n.data;
		int left = Integer.MIN_VALUE;
		int right = Integer.MAX_VALUE;
		if ( n.left != null ) {
			left = n.left.data;
		}
		if ( n.right != null ) {
			right = n.right.data;
		}
		log("Root: " + n.data + ", Left: " + left + ", Right: " + right);
		if ( root < left ) {
			return false;
		}
		if ( root > right ) {
			return false;
		}
		
		boolean results = true;
		if ( n.left != null ) {
			results = this.isBST(n.left);
		}
		if ( n.right != null && results == true ) {
			results = this.isBST(n.right);
		}
		return results;
	}

	public static BinaryTree buildInvalidBST() {
		BinaryTree b = new BinaryTree();
		Node n = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n.left = n2;
		n.right = n3;
		return b;
	}
}