package com.zeekmod.jgeekquest.datastructures;

public class SingleLinkedList<I> {

	Node head;

	public SingleLinkedList() {
		System.out.println("-----------------");
	}

	public SingleLinkedList<I> add(I v) {
		if (this.head == null) {
			this.head = new Node(v, null);
			return this;
		}
		Node n = head.next;
		if (n != null) {
			while (n.next != null) {
				n = n.next;
			}
		} else {
			n = head;
		}
		Node newNode = new Node(v, null);
		n.next = newNode;
		return this;
	}

	public SingleLinkedList<I> print() {
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

	public SingleLinkedList<I> delete(I o) {
		System.out.println("Deleting " + o);
		if (head != null && head.data.equals(o)) {
			if (head.next != null) {
				head = head.next;
			} else {
				head = null;
			}
			return this;
		}
		Node n = head;
		if (n.next != null) {
			while (n != null) {
				System.out.println(n.next.data);
				if (n.next != null && n.next.data != null
						&& n.next.data.equals(o)) {
					// Ok the next one is the one that needs to go
					if (n.next.next != null) {
						System.out.println("Deleting " + o
								+ ", to do so we will be linking next of "
								+ n.data + " to " + n.next.next.data);
					} else {
						System.out.println("Deleting " + o
								+ ", to do so we will be linking next of "
								+ n.data + " to nada");
					}
					n.next = n.next.next;
					return this;
				}
				n = n.next;
			}
		}
		return this;
	}

	public boolean contains(I i) {
		Node n = head;
		if (n == null) {
			return false;
		}
		if (i == null) {
			return false;
		}
		if (head.data.equals(i)) {
			return true;
		}
		while (n != null) {
			if (n != null && n.data.equals(i)) {
				return true;
			}
			n = n.next;
		}
		return false;
	}

	public I find(int i) {
		Node n = head;
		if (n == null) {
			return null;
		}
		int j = 0;
		while (n != null) {
			if (i == j) {
				return n.data;
			}
			n = n.next;
			j++;
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

	public static void main(String[] args) {
		SingleLinkedList<String> l = new SingleLinkedList<String>().add("A")
				.add("B").add("C").print();
		SingleLinkedList<String> l1 = new SingleLinkedList<String>().add("A")
				.add("B").add("C").delete("A").print();
		SingleLinkedList<String> l2 = new SingleLinkedList<String>().add("A")
				.add("B").add("C").delete("B").print();
		SingleLinkedList<String> l3 = new SingleLinkedList<String>().add("A")
				.add("B").add("C").delete("C").print();

		l1 = new SingleLinkedList<String>().add("A").add("B").add("C");
		System.out.println(l1.contains("A") + " - " + l1.contains("D") + " - "
				+ l1.contains("C"));
		System.out.println(l1.find(0) + ", " + l1.find(1) + ", " + l1.find(2)
				+ ", " + l1.find(3) + ", " + l1.find(4));
	}

}
