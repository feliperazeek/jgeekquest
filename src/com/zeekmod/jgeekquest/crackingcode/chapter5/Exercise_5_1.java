package com.zeekmod.jgeekquest.crackingcode.chapter5;

public class Exercise_5_1 {
	
	public static void main(String[] args) {
		int n = Integer.parseInt("1000000000", 2);
		int m = Integer.parseInt("10101", 2);
		System.out.println("n: " + n + ", m: " + m);
		
		int x = 5;
		System.out.println( x + " power? " + power(x) );
		
		System.out.println( x + " log2? " + log2(x) );
		x = 4;
		System.out.println( x + " log2? " + log2(x) );
		x = 8;
		System.out.println( x + " log2? " + log2(x) );
		
		int y = 0;
		
		x = 4;
		y = 2;
		System.out.println( x + " / " + y + " = " + divide(x,y) );
	}
	
	public static int divide(int n, int d) {
		return n & (d - 1);
	}
	
	public static boolean power(int v) {
		if ( v == 0 ) {
			return false;
		}
		return (v & (v - 1)) == 0;
	}
	
	public static int log2(int v) {
		int r = 0;
		while (v > 1) // unroll for more speed...
		{
			v >>= 1;
		  r++;
		}
		return r;
	}

}
