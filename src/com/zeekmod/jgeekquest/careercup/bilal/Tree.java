package com.zeekmod.jgeekquest.careercup.bilal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree<I extends Comparable<I>> {

	TreeNode root;

	public I getRandomNode() {
		Random r = new Random();
		List<I> list = this.preOrder();
		int random = r.nextInt(list.size());
		return list.get(random);

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
	
	public String toString() {
		return this.preOrder().toString();
	}
	
	public Tree<I> add(I data) {
		TreeNode node = this.root;
		if (data == null) {
			return this;
		}
		if (node == null || node.data == null) {
			this.root = new TreeNode(data);
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
					node.left = new TreeNode(data);
					break;
				}
			} else if (data.compareTo(node.data) > 0) {
				// The rich ones go to the north right
				if (node.right != null) {
					node = node.right;
				} else {
					node.right = new TreeNode(data);
					break;
				}
			}
		}
		return this;
	}
	
	public static void p(Object o) {
		System.out.println("------------");
		System.out.println(o);
		System.out.println("------------");
	}

	public static void main(String[] args) {
		Tree<Integer> t = new Tree<Integer>().add(1).add(2).add(3).add(4).add(5).add(-1).add(10).add(99).add(-1);
		p(t);
		p("random node: " + t.getRandomNode());
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

		public String toString() {
			if (data == null) {
				return "n/a";
			}
			return data.toString();
		}

	}
}