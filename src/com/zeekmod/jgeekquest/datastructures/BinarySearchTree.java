package com.zeekmod.jgeekquest.datastructures;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<I extends Comparable<I>> {

	TreeNode root;

	public boolean isBalanced() {
		int max = this.getMaxDepth(this.root);
		System.out.println("Max Depth: " + max);
		int min = this.getMinDepth(this.root);
		System.out.println("Min Depth: " + min);
		if (max - min > 1) {
			return false;
		} else {
			return true;
		}
	}

	public int getMaxDepth(TreeNode n) {
		if (n == null) {
			return 0;
		}
		return 1 + Math
				.max(this.getMaxDepth(n.left), this.getMaxDepth(n.right));
	}

	public int getMinDepth(TreeNode n) {
		if (n == null) {
			return 0;
		}
		return 1 + Math
				.min(this.getMinDepth(n.left), this.getMinDepth(n.right));
	}

	public List<I> inOrder() {
		return this.inOrder(this.root);
	}

	public List<I> inOrder(TreeNode r) {
		List<I> i = new ArrayList<I>();
		if (r != null) {
			if (r.left != null) {
				i.addAll(this.inOrder(r.left));
			}
			i.add(r.data);
			if (r.right != null) {
				i.addAll(this.inOrder(r.right));
			}
		}
		return i;
	}

	public List<I> preOrder() {
		return this.preOrder(this.root);
	}

	public List<I> preOrder(TreeNode r) {
		List<I> i = new ArrayList<I>();
		if (r != null) {
			i.add(r.data);
			if (r.left != null) {
				i.addAll(this.preOrder(r.left));
			}
			if (r.right != null) {
				i.addAll(this.preOrder(r.right));
			}
		}
		return i;
	}

	public List<I> postOrder() {
		return this.postOrder(this.root);
	}

	public List<I> postOrder(TreeNode r) {
		List<I> i = new ArrayList<I>();
		if (r != null) {
			if (r.left != null) {
				i.addAll(this.postOrder(r.left));
			}
			if (r.right != null) {
				i.addAll(this.postOrder(r.right));
			}
			i.add(r.data);
		}
		return i;
	}

	public BinarySearchTree<I> add(I data) {
		TreeNode node = this.root;
		if (data == null) {
			return this;
		}
		if (node == null || node.data == null) {
			this.root = new TreeNode(data);
			return this;
		}
		while (node != null) {
			p("comparing " + data + " with " + node.data + " = "
					+ data.compareTo(node.data));
			if (data.compareTo(node.data) == 0) {
				// I found my place in heaven - the search is over
				p("got it: " + data);
				node = null;
			} else if (data.compareTo(node.data) < 0) {
				// The poor ones go to the south left
				if (node.left != null) {
					p("left: " + node.left);
					node = node.left;
				} else {
					node.left = new TreeNode(data);
					p("set left: " + node.left);
					break;
				}
			} else if (data.compareTo(node.data) > 0) {
				// The rich ones go to the north right
				if (node.right != null) {
					p("right: " + node.right);
					node = node.right;
				} else {
					node.right = new TreeNode(data);
					p("set right: " + node.right);
					break;
				}
			}
		}
		return this;
	}

	public TreeNode remove(I data) {
		return this.remove(data, this.root);
	}

	public TreeNode remove(I t, TreeNode n) {
		if (t == null) {
			throw new RuntimeException("Node not found with data: " + t);
		}
		if (n == null) {
			throw new RuntimeException("Invalid node!");
		}

		I x = n.data;

		if (n.left != null || n.right != null) {
			if (x.compareTo(t) < 0) {
				n.left = remove(t, n.left);

			} else if (x.compareTo(t) > 0) {
				n.right = remove(t, n.right);

			} else if (n.left != null && n.right != null) { // Two children
				// n.data = findMin( n.right ).element;
				// n.right = removeMin( n.right );
			} else {
				n = (n.left != null) ? n.left : n.right;
			}
		} else {
			n = null;
		}
		return n;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		List<I> list = this.preOrder();
		if (list != null) {
			for (I i : list) {
				sb.append(i);
				sb.append(" --> ");
			}
			sb.append("the end!");
		}
		return sb.toString();
	}

	public class TreeNode {

		I data;

		TreeNode left;

		TreeNode right;

		private TreeNode(I data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		private TreeNode(I data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			if (data == null) {
				return "n/a";
			}
			return data.toString();
		}

	}

	public static void p(Object o) {
		System.out.println("------------");
		System.out.println(o);
		System.out.println("------------");
	}

	public static void main(String[] args) {
		// p(t.add("A"));
		// p(t.add("A").add("B"));

		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>().add(1)
				.add(2).add(3).add(4).add(5).add(-1);
		p(t + " - balanced? " + t.isBalanced());
		// p(t.add("A").add("B").add("A"));
	}

}
