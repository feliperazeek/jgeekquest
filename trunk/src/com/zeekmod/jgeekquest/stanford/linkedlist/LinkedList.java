package com.zeekmod.jgeekquest.stanford.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA. User: felipera Date: Aug 29, 2010 Time: 10:11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedList {
	
	public static Node createNode(Integer i, Node n) {
		return new LinkedList.Node(i, n);
	}

	public Node head;

	public LinkedList() {
	}

	public LinkedList add(Integer v) {
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

	public LinkedList push(Integer v) {
		if (this.head == null) {
			this.head = new Node(v, null);
		} else {
			Node currentHead = this.head;
			this.head = new Node(v, currentHead);
		}
		return this;
	}
	
	public String toString() {
		Node n = this.head;
		if ( n == null ) {
			System.out.println("n/a - empty list");
			return "n/a empty list";
		}
		List<Integer> l = new ArrayList<Integer>();
		l.add(n.data);
		while (n.next != null) {
			n = n.next;
			if (n == null) {
				System.out.print("end");
			} else {
				l.add(n.data);
			}
		}
		return l.toString();
	}

	public LinkedList print() {
		Node n = this.head;
		if ( n == null ) {
			System.out.println("n/a - empty list");
			return null;
		}
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

	public boolean contains(Integer i) {
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

	public Integer find(int i) {
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

	public static class Node {

		public Node(Integer data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public Node(Integer data) {
			super();
			this.data = data;
			this.next = null;
		}

		public Integer data;

		public Node next;

		public String toString() {
			return data.toString();
		}

	}
}
