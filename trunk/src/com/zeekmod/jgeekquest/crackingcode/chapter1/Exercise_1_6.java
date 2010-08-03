package com.zeekmod.jgeekquest.crackingcode.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Exercise_1_6 {
	
	public static void main(String[] args) {
		int[] c1 = {1, 2, 3};
		int[] c2 = {4, 0, 6};
		int[] c3 = {0, 8, 9};
		int m[][] = {c1, c2, c3};
		int n = 3;
		
		List<Integer> cols = new ArrayList<Integer>();
		List<Integer> rows = new ArrayList<Integer>();
		for ( int row = 0; row < n; row++ ) {
			for ( int i = 0; i < n; i++ ) {
				int value = m[row][i];
				System.out.println(value);
				if ( value == 0 ) {
					System.out.println( "row: " + row + " - col: " + i );
					rows.add(row);
					cols.add(i);
				}
			}
		}
		
		// for ( rows )
		
	}

}
