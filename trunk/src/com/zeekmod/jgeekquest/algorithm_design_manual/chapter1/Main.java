package com.zeekmod.jgeekquest.algorithm_design_manual.chapter1;

public class Main {
	
	public static void main(String[] args) {
		divide(2, 2);
		divide(100, 0);
		divide(3, 1);
		divide(4, 1);
	}
	
	static int divide(int num, int denom)
	{
	  int a=0, b=0;
	  int i= 31; // CAREFUL: works only on int=32-bit machine!
	  /* Work from leftmost to rightmost bit in numerator */
	  while(i>=0) {
	    /* appends one bit from numerator to a */
	    a = (a << 1) + ((num & (1 << i)) >> i); 
	    b = b << 1;
	    System.out.println("After shifting a=" + a + " and b=" + b);
	    if (a >= denom) {
	      a -= denom;
	      b++;
	    }
	    System.out.println("After subtraction a=" + a + " and b=" + b);
	  i--;
	  }
	  System.out.println(num + " / " + denom + " = " + b);
	  return b;
	}

	
	int div3 (int x) {
	     int two_third = 0, four_third = 0;
	     for (int power = 0; power < 31; power += 2) {
	        four_third += x >> power;
	        two_third += x >> (power + 1);
	     }
	     return (four_third - two_third) >> 2;
	}

}
