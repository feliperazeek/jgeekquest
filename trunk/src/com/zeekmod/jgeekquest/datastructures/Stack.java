package com.zeekmod.jgeekquest.datastructures;

public class Stack<I> {

	Node head;

	public Stack() {
		System.out.println("-----------------");
	}

	public Stack<I> push(I v) {
		if (this.head == null) {
			this.head = new Node(v, null);
		} else {
			Node n = new Node(v, this.head);
			this.head = n;
		}
		return this;
	}

	public Stack<I> print() {
		Node n = this.head;
		System.out.print(n.data + "--> ");
		while (n.next != null) {
			n = n.next;
			if (n == null) {
				System.out.print("end");
			} else {
				System.out.print(n.data + "--> ");
			}
		}
		System.out.println("");
		return this;
	}

	public I pop() {
		I result = null;
		if (head != null) {
			result = head.data;
			if (head.next != null) {
				head = head.next;
			} else {
				head = null;
			}
			return result;
		}
		return null;
	}

	public class Node {

		public Node(I data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		private I data;

		private Node next;

	}

	public static void assertStuff(boolean b) {
		if (!b) {
			throw new RuntimeException("You messed up my friend!");
		} else {
			System.out.println("That's what I am talking about!");
		}
	}

	public static void main(String[] args) {
		assertStuff(new Stack<String>().push("A").pop().equals("A"));
		assertStuff(new Stack<String>().push("A").push("B").push("C").pop()
				.equals("C"));
		assertStuff(new Stack<String>().push("A").push("B").pop().equals("B"));
		assertStuff(new Stack<String>().pop() == null);
	}

}
