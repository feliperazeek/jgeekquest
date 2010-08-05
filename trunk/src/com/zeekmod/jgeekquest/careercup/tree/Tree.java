package com.zeekmod.jgeekquest.careercup.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree<I extends Comparable<I>> {

	TreeNode<I> root;

	public I getRandomNode() {
		Random r = new Random();
		List<I> list = this.preOrder();
		int random = r.nextInt(list.size());
		return list.get(random);

	}

	public List<I> preOrder() {
		return this.preOrder(this.root);
	}

	public void preOrderWithoutRecursionOrStack2() {
		if (this.root == null) {
			return;
		}

		TreeNode<I> current = null;
		TreeNode<I> pre = null;

		current = this.root;
		while (current != null) {
			// System.out.print(" " + current + " ");
			
			if (current.left == null) {
				System.out.print(" " + current.data + " ");
				current = current.right;
				
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in if part to restore the original
				 * tree i.e., fix the right child of predecssor
				 */
				else {
					pre.right = null;
					System.out.print(" " + current.data + " ");
					current = current.right;
				} /* End of if condition pre.right == null */
			} /* End of if condition current.left == null */
		}
	}
		
		public void preOrderWithoutRecursionOrStack() {
			if (this.root == null) {
				return;
			}

			TreeNode<I> current = null;
			TreeNode<I> pre = null;

			current = this.root;
			while (current != null) {
				// System.out.print(" " + current + " ");
				
				if (current.left == null && current.right == null) {
					System.out.print(".. " + current.parent.data + " ");
				
				} else if (current.left == null) {
					current = current.right;
					
				} else {
					/* Find the inorder predecessor of current */
					pre = current.left;
					while (pre.right != null && pre.right != current)
						pre = pre.right;

					/* Make current as right child of its inorder predecessor */
					if (pre.right == null) {
						pre.right = current;
						current = current.left;
					}

					/*
					 * Revert the changes made in if part to restore the original
					 * tree i.e., fix the right child of predecssor
					 */
					else {
						pre.right = null;
						System.out.print(" " + current.data + " ");
						current = current.right;
					} /* End of if condition pre.right == null */
				} /* End of if condition current.left == null */
			}

	}

	public List<I> preOrder(TreeNode<I> r) {
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

	public List<I> inOrder() {
		return this.inOrder(this.root);
	}

	public List<I> inOrder(TreeNode<I> r) {
		List<I> i = new ArrayList<I>();
		if (r != null) {
			if (r.left != null) {
				i.addAll(this.preOrder(r.left));
			}
			i.add(r.data);
			if (r.right != null) {
				i.addAll(this.preOrder(r.right));
			}
		}
		return i;
	}

	public String toString() {
		return this.preOrder().toString();
	}

	public Tree<I> add(I data) {
		TreeNode<I> node = this.root;
		if (data == null) {
			return this;
		}
		if (node == null || node.data == null) {
			this.root = new TreeNode<I>(data, null);
			return this;
		}
		while (node != null) {
			if (data.compareTo(node.data) == 0) {
				// I found my place in heaven - the search is over
				node = null;
			} else if (data.compareTo(node.data) < 0) {
				// The poor ones go to the south left
				if (node.left != null) {
					node = node.left;
				} else {
					node.left = new TreeNode(data, node);
					break;
				}
			} else if (data.compareTo(node.data) > 0) {
				// The rich ones go to the north right
				if (node.right != null) {
					node = node.right;
				} else {
					node.right = new TreeNode(data, node);
					break;
				}
			}
		}
		return this;
	}

	public static void p(Object o) {
		// System.out.println("------------");
		System.out.println(o);
		// System.out.println("------------");
	}

	public static int search(List<Integer> i, int x, int start, int end) {
		int c = 0;
		for (Integer j : i.subList(start, end)) {
			if (j == x) {
				break;
			}
			c++;
		}
		return c;
	}

	static int index = 0;

	public static TreeNode createTree(List<Integer> preOrder,
			List<Integer> inOrder, int start, int end) {
		// Check Size
		if (index + 1 > preOrder.size() - 1) {
			return null;
		}

		// Check Range
		if (end < start) {
			return null;
		}

		// Find Root
		index++;
		Integer root = preOrder.get(index);
		TreeNode n = new TreeNode(root, null);

		// Check if work is done
		if (start == end) {
			return n;
		}

		// Find Median
		int idx = search(inOrder, root, start, end);

		// Build Child Trees
		n.left = createTree(preOrder, inOrder, start, idx - 1);
		n.right = createTree(preOrder, inOrder, idx + 1, end);

		// Return Tree
		return n;
	}

	public static void main(String[] args) {
		Tree<Integer> t = new Tree<Integer>().add(20).add(1).add(40).add(5)
				.add(30).add(8).add(12);
		p("original: " + t);
		p("inorder: " + t.inOrder());
		p("preorder: " + t.preOrder() + " (get head)");
		// p("random node: " + t.getRandomNode());

		t.preOrderWithoutRecursionOrStack();
		// p("results: " + tt);
	}

	public static class TreeNode<I extends Comparable<I>> {

		I data;

		TreeNode<I> left;

		TreeNode<I> right;
		
		TreeNode<I> parent;
		
		private TreeNode(I data, TreeNode<I> parent) {
			this.data = data;
			this.parent = parent;
		}

		public String toString() {
			if (data == null) {
				return "n/a";
			}
			return data.toString();
		}

	}
}