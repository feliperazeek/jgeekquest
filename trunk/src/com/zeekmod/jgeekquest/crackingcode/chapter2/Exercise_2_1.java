package com.zeekmod.jgeekquest.crackingcode.chapter2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.zeekmod.jgeekquest.datastructures.SingleLinkedList;

public class Exercise_2_1 {
	
	public static SingleLinkedList removeDuplications(SingleLinkedList in) {
		SingleLinkedList list = new SingleLinkedList();
		SingleLinkedList.Node last = null;
		SingleLinkedList.Node i = in.head;
		while (i != null) {
			if ( last != null && i != null && i.data != null && i.data.equals(last.data) ) {
				// dup is found
				System.out.println( "dup: " + i.data );
			} else {
				System.out.println( "good: " + i.data );
				list.add(i);
			}
			last = i;
			
			i = i.next;
		}
		return list;
	}
	
	public static void main(String[] args) {
		SingleLinkedList l = new SingleLinkedList();
		l.add(new Integer(1));
		l.add(new Integer(0));
		l.add(new Integer(2));
		l.add(new Integer(0));
		l.add(new Integer(2));
		l.add(new Integer(5));
		System.out.println( "before: " + l.print() );
		System.out.println( "after: " + (removeDuplications(l)).print() );
	}

}
