package com.zeekmod.jgeekquest.crackingcode.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Exercise_3_6_SortStack {
	
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		Integer last = Integer.MIN_VALUE;
		while(s.isEmpty() == false) {
			// Get value we are supposed to insert on new stack
			Integer current = s.peek();
			
			// Get the current value of new stack
			Integer stored = null;
			if ( r.isEmpty() == false ) {
				stored = r.peek();
			}
			
			// If stack is empty just add it - it will be the biggest one
			if ( stored == null ) {
				r.push(s.pop());
			} else {
				// Ok pop as many as it's needed until the current value is smaller than
				List<Integer> list = new ArrayList<Integer>();
				while ( stored < current && r.isEmpty() == false ) {
					list.add(stored);
					stored = r.pop();
				}
				r.push(s.pop());
				for ( int i = list.size()-1; i >= 0; i--) {
					r.push(list.get(i));
				}
			}
		}
		return r;
	}
	
	public void add(Stack s, int i) {
		
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(2);
		s.push(4);
		s.push(7);
		System.out.println(s);
		s = sort(s);
		System.out.println(s);
		while (s.isEmpty() == false) {
			System.out.println(s.pop());
		}
		
	}

}
