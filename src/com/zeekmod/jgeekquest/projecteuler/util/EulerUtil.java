package com.zeekmod.jgeekquest.projecteuler.util;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class EulerUtil.
 */
public class EulerUtil {

	/**
	 * Power.
	 * 
	 * @param i
	 *            the i
	 * @param power
	 *            the power
	 * 
	 * @return the long
	 */
	public static long power(int i, int power) {
		System.out.println("-----------------------");
		long results = i;
		for (int ii = 1; ii < power; ii++) {
			results = results * Long.valueOf(i);
			// System.out.println( "Results: " + results );
		}
		System.out.println("-----------------------");
		return results;
	}

	/**
	 * Long power.
	 * 
	 * @param i
	 *            the i
	 * @param power
	 *            the power
	 * 
	 * @return the big decimal
	 */
	public static BigDecimal longPower(int i, int power) {
		System.out.println("-----------------------");
		BigDecimal results = BigDecimal.valueOf(Long.valueOf(i));
		for (int ii = 1; ii < power; ii++) {
			results = results.multiply(BigDecimal.valueOf(Long.valueOf(i)));
			// System.out.println( "Results: " + results );
		}
		System.out.println("-----------------------");
		return results;
	}

	/**
	 * Long sum each digit.
	 * 
	 * @param i
	 *            the i
	 * 
	 * @return the long
	 */
	public static long longSumEachDigit(BigDecimal i) {
		System.out.println("Input: " + i);
		long total = 0;
		char[] chars = i.toBigInteger().toString().toCharArray();
		for (char c : chars) {
			total = total + Long.valueOf(String.valueOf(c));
		}
		return total;
	}

	/**
	 * Sum each digit.
	 * 
	 * @param i
	 *            the i
	 * 
	 * @return the long
	 */
	public static long sumEachDigit(long i) {
		System.out.println("Input: " + i);
		long total = 0;
		char[] chars = String.valueOf(i).toCharArray();
		for (char c : chars) {
			total = total + Long.valueOf(String.valueOf(c));
		}
		return total;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		// System.out.println( "Power 2 over 2: " + power(2, 2) );
		// System.exit(0);
		// System.out.println( "Power 2 over 15: " + longPower(2, 1000) );

		System.out.println("Sum - Power 2 over 15 - Digits: "
				+ longSumEachDigit(longPower(2, 15)));
		System.out.println("Sum - Power 2 over 2 - Digits: "
				+ longSumEachDigit(longPower(2, 1000)));

	}

}
