/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeekmod.jgeekquest.careercup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flipflop
 */
public class TreePreOrderNoRecursionNoStack<I extends Comparable<I>> {

	Node root;

	public TreePreOrderNoRecursionNoStack<I> add(I data) {
		Node node = this.root;
		if (data == null) {
			return this;
		}
		if (node == null || node.data == null) {
			this.root = new Node(data);
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
					node.left = new Node(data, node);
					// p("set left: " + node.left);
					break;
				}
			} else if (data.compareTo(node.data) > 0) {
				// The rich ones go to the north right
				if (node.right != null) {
					// p("right: " + node.right);
					node = node.right;
				} else {
					node.right = new Node(data, node);
					// p("set right: " + node.right);
					break;
				}
			}
		}
		return this;
	}

	public List<I> preOrderRecursion() {
		return this.preOrderRecursion(this.root);
	}

	public List<I> preOrderRecursion(Node r) {
		List<I> i = new ArrayList<I>();
		if (r != null) {
			i.add(r.data);
			if (r.left != null) {
				i.addAll(this.preOrderRecursion(r.left));
			}
			if (r.right != null) {
				i.addAll(this.preOrderRecursion(r.right));
			}
		}
		return i;
	}

        public void preOrder() {
            Node previous = this.root;
            Node node = this.root;
            while( node != null ) {
                // If the previous node is this node’s parent node, descend to the left child node.
                // If the previous node is this node’s left child node, descend to the right child node.
                // If the previous node is this node’s right child node, ascend to the parent node.

                this.visit(node);


                Node next = null;
                if ( node.parent == null || (node.parent != null && node.equals(previous)) ) {
                    System.out.println("go left");
                    next = node.left;
                    /*
                    if ( next == null ) {
                        System.out.println("go left - now right");
                        next = node.right;
                        if ( next == null ) {
                            System.out.println("go left - now right - now parent");
                            next = node.parent;
                        }
                    }
                     * 
                     */

                } else if ( node.left != null ) {
                    next = node.left;

                } else if ( node.left == null && node.right != null ) {
                    next = node.right;

                } else if ( previous != null && node.parent != null && node.parent.right != null && previous.data.equals(node.parent.data) && (!previous.data.equals(node.data)) ) {
                    System.out.println("go right");
                    next = node.parent.right;

                } else if ( previous != null && node.parent != null && (previous.data.equals(node.parent.left.data) || node.parent.left == null) ) {
                    if ( node.parent.left != null) {
                        System.out.println("aaa: " + node.parent.left.left + " - " + node.parent.left.right);
                        if ( node.parent.left.left != null ) {
                            System.out.println("go far left left");
                            next = node.parent.left.left;
                        } else if ( node.parent.left.right != null ) {
                            System.out.println("go far left right");
                            next = node.parent.left.right;
                        }
                    } else {
                        System.out.println("go up");
                        next = node.parent;
                    }

               // } else if ( this.root.equals(node) ) {
                    // this.visit(node);
                }



                System.out.println("Previous: " + previous + ", Node: " + node + ", Parent: " + node.parent + ", Next: " + next );
                if ( next == null ) {
                    return;
                }

                previous = node;
                node = next;
            }
        }

        private void visit(Node n) {
            System.out.println("");
            System.out.println("Node: " + n);
        }

        public static void main(String[] args) {
            TreePreOrderNoRecursionNoStack t = new TreePreOrderNoRecursionNoStack();
            t.add(2).add(4).add(1).add(10).add(7).add(0).add(-1).add(-4).add(-3).add(-2);
            System.out.println(t.preOrderRecursion());
            //      2
            //     1 4
            //  -1 0  7 10
            // -4 -3
            //      -2
            t.preOrder();
        }

	public class Node {

		I data;

		Node left;

		Node right;

                Node parent;

		private Node(I data) {
			this(data, null, null, null);
		}

                private Node(I data, Node parent) {
                    this(data, null, null, parent);
                }

		private Node(I data, Node left, Node right, Node parent) {
			this.data = data;
			this.left = left;
			this.right = right;
                        this.parent = parent;
		}

		@Override
		public String toString() {
			if (data == null) {
				return "n/a";
			}
			return data.toString();
		}

	}

}
