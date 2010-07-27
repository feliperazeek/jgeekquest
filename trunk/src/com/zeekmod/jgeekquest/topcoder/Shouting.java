package com.zeekmod.jgeekquest.topcoder;

// TODO: Auto-generated Javadoc
/**
 * Problem Statement for Shouting
 * 
 * 
 * Problem Statement Two people are within "shouting distance" if one can hear
 * the other one shout. We have a group of identical people located across the
 * countryside. We want to know how small the shouting distance can be and still
 * allow a message to originate with anyone and be heard by everyone else by a
 * sequence of shouts. The locations of the people are given by int[]'s x and y,
 * with the location of the i-th person given by the i-th element of x and the
 * i-th element of y. Create a class Shouting that contains a method shout that
 * is given x and y and that returns the smallest shouting distance that will
 * allow complete communication.
 * 
 * 
 * Definition
 * 
 * Class: Shouting Method: shout Parameters: int[], int[] Returns: double Method
 * signature: double shout(int[] x, int[] y) (be sure your method is public)
 * 
 * 
 * Notes - The returned value must be accurate to within a relative or absolute
 * value of 1E-9.
 * 
 * Constraints - x and y will contain the same number of elements, between 1 and
 * 50 inclusive. - Each element of x and y will be between -10,000 and 10,000
 * inclusive.
 * 
 * Examples 0)
 * 
 * {-2000,-2000} {3000,3000} Returns: 0.0 These two people are standing in the
 * same spot, so there is no need to shout. 1)
 * 
 * {3,3,3,3,3,3,3} {2,3,4,3,9,8,1} Returns: 4.0 These people are standing in a
 * line, and the biggest gap is between (3,4) and (3,8) which can be bridged by
 * a shout of length 4. 2)
 * 
 * {5,0,-5,0} {0,5,0,-5} Returns: 7.0710678118654755 These people are standing
 * in a square. Shouting around the edges of the square is the best way to
 * communicate, and each edge has a length of 5*sqrt(2) 3)
 * 
 * {17} {1912} Returns: 0.0
 */
public class Shouting {

	/**
	 * Shout.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * 
	 * @return the double
	 */
	public double shout(int[] x, int[] y) {
		return 0.0;
	}

	/**
	 * Run.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param r
	 *            the r
	 */
	private static void run(int[] x, int[] y, double r) {
		Shouting s = new Shouting();
		double p = s.shout(x, y);
		if (p != r) {
			throw new RuntimeException("Problem! Expected: " + r
					+ " - Actual: " + p);
		} else {
			System.out.println("Match! Expected: " + r + " - Actual: " + p);
		}
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		int[] x1 = { 5, 0, -5, 0 };
		int[] y1 = { 0, 5, 0, -5 };
		double r1 = 7.0710678118654755;
		run(x1, y1, r1);
	}

}