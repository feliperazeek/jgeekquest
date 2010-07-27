package com.zeekmod.jgeekquest.datastructures;

public class Queue<I> {

	Node first, last;

	public Queue() {
		System.out.println("-----------------");
	}

	public Queue<I> enqueue(I v) {
		if (this.first == null) {
			Node n = new Node(v, null);
			this.last = n;
			this.first = this.last;
		} else {
			this.last.next = new Node(v, null);
			this.last = this.last.next;
		}
		return this;
	}

	public I dequeue() {
		if (this.first != null) {
			I r = this.first.data;
			this.first = this.first.next;
			return r;
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

	public static void l(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		l(new Queue<String>().dequeue());
		l(new Queue<String>().enqueue("A").enqueue("B").enqueue("C").dequeue());
		assertStuff(new Queue<String>().enqueue("A").enqueue("B").dequeue()
				.equals("A"));
	}

}
