package com.zeekmod.jgeekquest.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinarySearchTree<I extends Comparable<I>> {

	TreeNode root;

	public boolean isBalanced() {
		int max = this.getMaxDepth(this.root);
		// System.out.println("Max Depth: " + max);
		int min = this.getMinDepth(this.root);
		// System.out.println("Min Depth: " + min);
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
			// p("comparing " + data + " with " + node.data + " = " + data.compareTo(node.data));
			if (data.compareTo(node.data) == 0) {
				// I found my place in heaven - the search is over
				// p("got it: " + data); 
				node = null;
			} else if (data.compareTo(node.data) < 0) {
				// The poor ones go to the south left
				if (node.left != null) {
					// p("left: " + node.left);
					node = node.left;
				} else {
					node.left = new TreeNode(data);
					// p("set left: " + node.left);
					break;
				}
			} else if (data.compareTo(node.data) > 0) {
				// The rich ones go to the north right
				if (node.right != null) {
					// p("right: " + node.right);
					node = node.right;
				} else {
					node.right = new TreeNode(data);
					// p("set right: " + node.right);
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
	
	public int getCount() {
		return this.getCount(null, 0);
	}
	
	public int getCount(TreeNode n, int count) {
		if ( n != null ) {
			if ( n.left != null ) {
				count = count + this.getCount(n.left, count);
			}
			count++;
			if ( n.right != null ) {
				count = count + this.getCount(n.right, count);
			}
		}
		return count;
	}

	public I getRandomNode() {
		Random r = new Random();
		List<I> list = this.preOrder();
		int random = r.nextInt(list.size());
		return list.get(random);
		
	}

	public TreeNode getRandomNode2() {
		// return this.getRandomNode(this.root, this.getCount());
		return null;
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

        private boolean navigateAndCompare(TreeNode n1, TreeNode n2) {
            if ( n1 == null && n2 == null ) {
                return true;
            }
            if ( n2 != null && n1 == null ) {
                return false;
            }
            if ( n1 != null && n2 == null ) {
                return false;
            }
            if ( n1.data.equals(n2.data) ) {
                boolean left = this.navigateAndCompare(n1.left, n2.left);
                boolean right = this.navigateAndCompare(n1.right, n2.right);
                if ( left && right ) {
                    return true;
                }
                return false;
            } else {
                System.out.println(n1.data + " does NOT match " + n2.data);
                return false;
            }
        }

        private void l(Object o) {
            System.out.println(o);
        }

        public TreeNode findNode(TreeNode node) {
            return this.findNode(this.root, node);
        }

        public TreeNode findNode(TreeNode n, TreeNode node) {
            if ( node == null ) {
                return null;
            }
            while ( n != null ) {
                if ( n.data.equals(node.data) ) {
                    return n;
                }
                if ( node.data.compareTo(n.data) < 0 ) {
                    return this.findNode(n.left, node);
                } else if ( node.data.compareTo(n.data) > 0 ) {
                    return this.findNode(n.right, node);
                }
                throw new RuntimeException("It should never get here!");
            }
            return null;
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

        public void display() {
            this.display(this.root, 0);
        }

        public void display(TreeNode node, int level) {
            if ( node == null ) {
                return;
            }
            System.out.print(node.data + " (" + level + ")");
                level++;
                System.out.println("");
                if ( node.left != null ) {
                    System.out.print("l: ");
                    this.display(node.left, level);
                }

                if ( node.right != null ) {
                    System.out.print("r: ");
                    this.display(node.right, level);
                }
        }

	public static void p(Object o) {
		System.out.println("------------");
		System.out.println(o);
		System.out.println("------------");
	}


        private TreeNode mirror(TreeNode n) {
            if ( n != null ) {
                TreeNode left = null;
                TreeNode right = null;
                if ( n.left != null ) {
                    left = this.mirror(n.left);
                }
                if ( n.right != null ) {
                    right = this.mirror(n.right);
                }
                TreeNode temp = n.left;
                n.left = n.right;
                n.right = temp;
            }
            return n;
        }

	public static void main(String[] args) {
		// p(t.add("A"));
		// p(t.add("A").add("B"));

		// BinarySearchTree<Integer> t = new BinarySearchTree<Integer>().add(1).add(2).add(3).add(4).add(5).add(-1).add(10).add(99).add(-5);
		// p(t + " - balanced? " + t.isBalanced());
                // 1
                // l: 2 r: 3
                // l: -1 rl: 5 rr: 10
                // ll: -5  rrr:99
		
		// BinarySearchTree<Integer> t2 = new BinarySearchTree<Integer>().add(-1);
		// p(t2 + " - balanced? " + t2.isBalanced());

                // p("Subtree: " + t.hasSubTree(new BinarySearchTree<Integer>().add(-1).add(-5)));
                // p("Subtree: " + t.hasSubTree(new BinarySearchTree<Integer>().add(10).add(99)));
                //p("Subtree: " + t.hasSubTree(new BinarySearchTree<Integer>().add(3).add(-1)));
                // p("Subtree: " + t.hasSubTree(new BinarySearchTree<Integer>().add(999).add(-5)));

		// p("random node: " + t.getRandomNode());
		
		// p(t.add("A").add("B").add("A"));

                BinarySearchTree<Integer> t = new BinarySearchTree<Integer>().add(2).add(1).add(4).add(3).add(5);
                t.display();

                p("--------");

                // BinarySearchTree<Integer> m1 = t.mirror();
               // m1.display();

                //p("--------");
	}

}
