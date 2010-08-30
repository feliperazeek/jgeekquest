package com.zeekmod.jgeekquest.stanford.linkedlist;

public class LinkedListProblems {

	private void check(int a, int b) {
		if (a != b) {
			throw new RuntimeException(a + " != " + b);
		} else {
			System.out.println("Good! " + a + " = " + b);
		}
	}

	private void checkCount(LinkedList l, int c) {
		int actual = this.getCount(l);
		this.check(c, actual);
	}

	public LinkedList build(int n) {
		LinkedList l = new LinkedList();
		for (int i = 0; i < n; i++) {
			l.add(i);
		}
		return l;
	}

	public LinkedList buildOneTwoThree() {
		return new LinkedList().add(1).add(2).add(3);
	}

	public void countTest() {
		LinkedList l = this.buildOneTwoThree();
		this.check(1, this.getCount(l, 1));
	}

	public void nthTest() {
		LinkedList l = this.buildOneTwoThree();
		this.check(2, this.getNth(l, 1));
		this.check(3, this.getNth(l, 2));
	}

	public void sortedInsertTest() {
		LinkedList l1 = this.buildOneTwoThree();
		l1.add(99);
		l1.add(88);
		l1.add(100);
		System.out.println(l1);
		l1 = this.insertSort(l1);
		System.out.println("Insert Sort: " + l1);
	}
	
	public LinkedList sortedInsert(LinkedList list, int value) {
		LinkedList.Node node = list.head;
		if ( node == null ) {
			list.head = this.getNode(value, null);
			return list;
		}
		while ( node != null ) {
			if ( node.next == null ) {
				node.next = this.getNode(value, null);
				return list;
			} else {
				if ( value <= node.next.data ) {
					LinkedList.Node temp = node.next;
					node.next = this.getNode(value, temp);
					return list;
				}
			}
			node = node.next;
		}
		if ( node != null ) {
			LinkedList.Node distant = node.next;
			node.next = this.getNode(value, distant);
			return list;
		}
		return null;
	}
	
	public LinkedList insertSort(LinkedList list) {
		LinkedList results = new LinkedList();
		LinkedList.Node node = list.head;
		while ( node != null ) {
			results = this.sortedInsert(results, node.data);
			node = node.next;
		}
		return results;
	}
	
	public LinkedList.Node getNode(Integer i, LinkedList.Node n) {
		return LinkedList.createNode(i, n);
	}

	public LinkedList.Node getNthNode(LinkedList l, int i) {
		int count = 0;
		LinkedList.Node n = l.head;
		while (n != null) {
			if (count == i) {
				return n;
			}
			n = n.next;
			count++;
		}
		return null;
	}

	public Integer getNth(LinkedList l, int i) {
		int count = 0;
		LinkedList.Node n = l.head;
		while (n != null) {
			if (count == i) {
				return n.data;
			}
			n = n.next;
			count++;
		}
		return null;
	}

	public int getCount(LinkedList list, int x) {
		int i = 0;
		LinkedList.Node n = list.head;
		while (n != null) {
			if (n.data == x) {
				i++;
			}
			n = n.next;
		}
		return i;
	}

	public int getCount(LinkedList list) {
		int i = 0;
		LinkedList.Node n = list.head;
		while (n != null) {
			i++;
			n = n.next;
		}
		return i;
	}

	private LinkedList.Node getLastNode(LinkedList l) {
		LinkedList.Node n = l.head;
		while (n != null) {
			if (n.next == null) {
				return n;
			}
			n = n.next;
		}
		return null;
	}

	public void append(LinkedList a, LinkedList b) {
		LinkedList.Node aEnd = this.getLastNode(a);
		aEnd.next = b.head;
		b.head = null;
	}

	public void appendTest() {
		LinkedList a = this.buildOneTwoThree();
		LinkedList b = this.buildOneTwoThree();
		this.append(a, b);
		System.out.println("-- Start Append --");
		a.print();
		b.print();
		this.checkCount(a, 6);
		this.checkCount(b, 0);
		System.out.println("-- End Append --");
	}

	private LinkedList.Node walkTwiceAsFast(LinkedList.Node n) {
		if (n == null || n.next == null || n.next.next == null) {
			return null;
		} else {
			return n.next.next;
		}
	}

	public void frontBackSplit(LinkedList l, LinkedList a, LinkedList b) {
		if (l.head == null) {
			System.out.println("Empty Input - Split List A: " + a
					+ ", Split List B: " + b);
			return;
		} else if (l.head.next == null) {
			a.add(l.head.data);
			System.out.println("Size 1 Input - Split List A: " + a
					+ ", Split List B: " + b);
			return;
		} else if (l.head != null && l.head.next != null
				&& l.head.next.next == null) {
			a.add(l.head.data);
			b.add(l.head.next.data);
			System.out.println("Size 2 Input - Split List A: " + a
					+ ", Split List B: " + b + " - Input: " + l);
			return;
		}

		LinkedList.Node n1 = l.head;
		LinkedList.Node n2 = this.walkTwiceAsFast(n1);
		while (n1 != null && n2 != null) {
			System.out.println("n1: " + n1 + ", n2: " + n2);
			a.add(n1.data);
			n1 = n1.next;
			n2 = this.walkTwiceAsFast(n1);
			if (n1 != null && n2 == null) {
				a.add(n1.data);
			}
		}

		if (n1 != null) {
			LinkedList.Node o = n1.next;
			while (o != null) {
				b.add(o.data);
				o = o.next;
			}
		}

		System.out.println("Split List A: " + a);
		System.out.println("Split List B: " + b);
	}

	public void frontBackSplitTest() {
		// 2
		int n = 2;
		LinkedList l = this.build(n);
		this.checkCount(l, n);
		LinkedList a = new LinkedList();
		LinkedList b = new LinkedList();
		this.frontBackSplit(l, a, b);
		this.checkCount(a, 1);
		this.checkCount(b, 1);

		// 1
		n = 1;
		l = this.build(n);
		this.checkCount(l, n);
		a = new LinkedList();
		b = new LinkedList();
		this.frontBackSplit(l, a, b);
		this.checkCount(a, 1);
		this.checkCount(b, 0);

		// 3
		n = 3;
		l = this.build(n);
		this.checkCount(l, n);
		a = new LinkedList();
		b = new LinkedList();
		this.frontBackSplit(l, a, b);
		this.checkCount(a, 2);
		this.checkCount(b, 1);

		// 4
		n = 4;
		l = this.build(n);
		this.checkCount(l, n);
		a = new LinkedList();
		b = new LinkedList();
		this.frontBackSplit(l, a, b);
		this.checkCount(a, 2);
		this.checkCount(b, 2);

		// 0
		n = 1;
		l = new LinkedList();
		this.checkCount(l, n);
		a = new LinkedList();
		b = new LinkedList();
		this.frontBackSplit(l, a, b);
		this.checkCount(a, 0);
		this.checkCount(b, 0);
	}

	public LinkedList removeDuplicates(LinkedList list) {
		LinkedList.Node node = list.head;
		while (node != null) {
			if (node.next != null && node.next.data != null
					&& node.data != null && node.data.equals(node.next.data)) {
				node.next = node.next.next;
			}
			node = node.next;
		}
		return list;
	}

	public void removeDuplicatesTest() {
		LinkedList l1 = new LinkedList().add(0).add(1).add(1).add(2);
		this.checkCount(l1, 4);
		l1 = this.removeDuplicates(l1);
		this.checkCount(l1, 3);
		this.check(0, this.getNth(l1, 0));
		this.check(1, this.getNth(l1, 1));
		this.check(2, this.getNth(l1, 2));
	}

	public void moveNodes(LinkedList dest, LinkedList src) {
		while (src.head != null) {
			dest.push(src.head.data);
			LinkedList.Node current = src.head;
			src.head = current.next;
		}

		src.head = null;
	}

	public void moveNodesTest() {
		LinkedList l1 = this.buildOneTwoThree();
		LinkedList l2 = this.buildOneTwoThree();
		System.out.println("Move Nodes Dest: " + l1);
		System.out.println("Move Nodes Src: " + l2);
		this.moveNodes(l1, l2);
		this.checkCount(l2, 0);
		this.checkCount(l1, 6);
		System.out.println("Move Nodes: " + l1);
	}

	public void alternatingSplit(LinkedList src, LinkedList a, LinkedList b) {
		int count = 0;
		while (src.head != null) {
			// Add to A or B - should use bitmap here (faster and cooler!)
			if (count % 2 == 0) {
				a.add(src.head.data);
			} else {
				b.add(src.head.data);
			}

			// Remove from source
			LinkedList.Node current = src.head;
			src.head = current.next;

			// Counter
			count++;
		}

		src.head = null;
	}
	
	public int length(LinkedList list) {
		return this.getCount(list);
	}

	public void alternatingSplitTests() {
		LinkedList src = new LinkedList().add(0).add(1).add(0).add(1).add(0)
		.add(1);
		LinkedList a = new LinkedList();
		LinkedList b = new LinkedList();
		this.alternatingSplit(src, a, b);
		this.checkCount(src, 0);
		this.checkCount(a, 3);
		this.checkCount(b, 3);
		System.out.println("Alternating Splits: " + src + ", A: " + a + ", B: "
				+ b);
	}

	public LinkedList shuffleMerge(LinkedList a, LinkedList b) {
		LinkedList dest = new LinkedList();
		return this.shuffleMerge(dest, a, b);
	}

	public LinkedList shuffleMerge(LinkedList dest, LinkedList a, LinkedList b) {
		if (a.head == null && b.head == null) {
			return dest;
		}
		if (a.head != null) {
			dest.add(a.head.data);
			LinkedList.Node current = a.head;
			a.head = current.next;
		}
		if (b.head != null) {
			dest.add(b.head.data);
			LinkedList.Node current = b.head;
			b.head = current.next;
		}
		return this.shuffleMerge(dest, a, b);
	}

	public void shuffleMergeTests() {
		LinkedList a = this.buildOneTwoThree();
		LinkedList b = this.buildOneTwoThree();
		LinkedList dest = this.shuffleMerge(a, b);
		this.checkCount(dest, 6);
		this.checkCount(a, 0);
		this.checkCount(b, 0);
		System.out
		.println("Shuffle Merge: " + dest + ", A: " + a + ", B: " + b);

	}

	public LinkedList sortedMerge(LinkedList a, LinkedList b) {
		return this.sortedMerge(new LinkedList(), a.head, b.head);
	}

	private LinkedList sortedMerge(LinkedList dest, LinkedList.Node a, LinkedList.Node b) {
		if (a == null && b == null) {
			return dest;
		}
		Integer dataA = null;
		Integer dataB = null;
		if ( a != null ) {
			dataA = a.data;
		}
		if ( b != null ) {
			dataB = b.data;
		}
		
		if ( dataA == null && dataB == null ) {
			return dest;
		}
		
		if ( (dataA != null && dataA <= dataB) || (dataA != null && dataB == null) ) {
			System.out.println( "* " + dataA + " - " + dataB );
			dest.add(dataA);
			return this.sortedMerge(dest, a.next, b);
		} else if ( (dataB != null && dataA == null) || (dataB != null && dataB < dataA) ) {
			System.out.println( dataA + " - " + dataB + " *" );
			dest.add(dataB);
			return this.sortedMerge(dest, a, b.next);
		}
		
		return dest;

	}
	
	public LinkedList mergeSort(LinkedList list) {
		if ( list == null || list.head == null || list.head.next == null ) {
			return list;
		}
		
		LinkedList a = new LinkedList();
		LinkedList b = new LinkedList();
		this.alternatingSplit(list, a, b);
		
		this.mergeSort(a);
		this.mergeSort(b);
		
		list = this.sortedMerge(a, b);
		
		return list;
	}
	
	public void sortedMergeTests() {
		LinkedList l1 = this.buildOneTwoThree();
		LinkedList l2 = new LinkedList().add(0).add(2).add(100).add(500);
		System.out.println( "Sorted: " + this.sortedMerge(l1, l2) + ", A: " + l1 + ", B: " + l2 );
	}
	
	public void mergeSortTests() {
		LinkedList l1 = this.buildOneTwoThree();
		LinkedList l2 = new LinkedList().add(0).add(2).add(10).add(50);
		System.out.println( "Sorted: " + this.sortedMerge(l1, l2) + ", A: " + l1 + ", B: " + l2 );
	}
	
	public LinkedList sortedIntersect(LinkedList l1, LinkedList l2) {
		LinkedList results = new LinkedList();
		return this.sortedIntersect(l1.head, l2.head, results);
	}
	
	public LinkedList sortedIntersect(LinkedList.Node a, LinkedList.Node b, LinkedList results) {
		Integer dataA = null;
		Integer dataB = null;
		if ( a != null ) {
			dataA = a.data;
		}
		if ( b != null ) {
			dataB = b.data;
		}
		
		if ( dataA == null || dataB == null ) {
			return results;
		}
		
		if ( dataA != null && dataB != null && dataA.equals(dataB) ) {
			results.push(dataA);
			return this.sortedIntersect(a.next, b.next, results);
			
		} else if (dataA < dataB) {
			return this.sortedIntersect(a.next, b, results);
			
		} else if (dataB < dataA) {
			return this.sortedIntersect(a, b.next, results);
		}
		
		return results;
	}
	
	public void sortedIntersectTests() {
		int n = 10;
		LinkedList l1 = this.build(n);
		LinkedList l2 = this.build(n);
		LinkedList r1 = this.sortedIntersect(l1, l2);
		this.checkCount(r1, n);
		
		l1 = this.buildOneTwoThree();
		l2 = new LinkedList().add(1).add(5).add(10).add(50);
		r1 = this.sortedIntersect(l1, l2);
		this.checkCount(r1, 1);
		
		
	}

	public static void main(String[] args) {
		LinkedListProblems p = new LinkedListProblems();
		// p.countTest();
		// p.nthTest();
		// p.sortedInsertTest();
		// p.appendTest();
		// p.frontBackSplitTest();
		// p.removeDuplicatesTest();
		// p.moveNodesTest();
		// p.alternatingSplitTests();
		// p.shuffleMergeTests();
		// p.sortedMergeTests();
		// p.mergeSortTests();
		p.sortedIntersectTests();
	}

}
;