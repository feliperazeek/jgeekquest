package com.zeekmod.jgeekquest.crackingcode.chapter2;

import com.zeekmod.jgeekquest.datastructures.SingleLinkedList;

public class Exercise_2_2 {
	
	public static SingleLinkedList.Node getNthToLast(SingleLinkedList list, int n) {
		return getNthToLast(list, 0, 0, list.head, list.head);
	}
	
	public static SingleLinkedList.Node getNthToLast(SingleLinkedList list, int n, int start, SingleLinkedList.Node p1, SingleLinkedList.Node p2) {
		
		if ( n == start ) {
			return p1;
		}
		
		for ( int i = 0; i < n; i++ ) {
			if ( p2.next != null ) {
				p2 = p2.next;
			}
		}
		System.out.println("p1: " + p1 + " - p2: " + p2);
		
		if (p2.next == null) {
			
		}
		
		return null;
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
