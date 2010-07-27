package com.zeekmod.jgeekquest.crackingcode.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Chapter1.
 */
public class Chapter1 {

	/**
	 * Exercise_1_3.
	 * 
	 * @param s
	 *            the s
	 * 
	 * @return the string
	 */
	public static String exercise_1_3(String s) {
		if (s == null) {
			return null;
		}
		if (s.length() < 2) {
			return s;
		}
		List<Character> l = new ArrayList<Character>();
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (!l.contains(c)) {
				l.add(c);
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * Exercise_1_4.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * 
	 * @return true, if successful
	 */
	public static boolean exercise_1_4(String a, String b) {
		char[] x = a.toCharArray();
		char[] y = b.toCharArray();
		for (char c : x) {
			for (char z : y) {
				if (c == z) {

				}
			}
		}
		return false;
	}

	/**
	 * Exercise_1_5.
	 * 
	 * @param s
	 *            the s
	 * 
	 * @return the string
	 */
	public static String exercise_1_5(String s) {
		if (s == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		char from = ' ';
		String to = "%20";
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (c == from) {
				sb.append(to);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * Exercise_1_6.
	 * 
	 * @param matrix
	 *            the matrix
	 */
	public static void exercise_1_6(int[][] matrix) {
		int last;
		int tmp;
		if (matrix.length > 0 && matrix[0].length > 0) {
			last = matrix[matrix.length - 1][matrix[0].length - 1];
		} else {
			return;
		}
		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[0];
			l("== Row: " + i);
			for (int j = 0; j < row.length; j++) {
				tmp = matrix[i][j];
				matrix[i][j] = last;
				last = tmp;
				l("- Row " + i + " Column " + j + " = " + matrix[i][j]);
			}
		}
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		int n = 2;
		Random r = new Random();
		int[][] matrix;
		matrix = new int[n][n];
		for (int row = 0; row < n; row++) {
			l("-- Row " + row);
			for (int column = 0; column < n; column++) {
				matrix[row][column] = r.nextInt();
				l("Row " + row + " Column " + column + " = "
						+ matrix[row][column]);
			}
		}
		exercise_1_6(matrix);
		// System.out.println(s1 + " -> " + r1);
	}

	/**
	 * Bitcount.
	 * 
	 * @param n
	 *            the n
	 * 
	 * @return the int
	 */
	int bitcount(int n) {
		int count = 0;
		while (n > 0) {
			count += n & 0x1;
			n >>= 1;
		}
		return count;
	}

	/**
	 * Main exercise_1_3.
	 * 
	 * @param args
	 *            the args
	 */
	public static void mainExercise_1_3(String[] args) {
		String s1 = "abbbabcbb";
		String r1 = exercise_1_3(s1);
		System.out.println(s1 + " -> " + r1);
	}

	/**
	 * L.
	 * 
	 * @param o
	 *            the o
	 */
	public static void l(Object o) {
		System.out.println(o);
	}

}
