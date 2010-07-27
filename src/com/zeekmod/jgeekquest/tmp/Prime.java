package com.zeekmod.jgeekquest.tmp;

import java.util.ArrayList;
import java.util.List;

public class Prime {

	public static void printPrimes(int max) {
		long cc = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < max; i++) {
			if (i >= 2) {
				boolean good = true;
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						good = false;
						break;
					}
				}
				// System.out.println(i + " - " + good);
				if (good) {
					if (i >= 2000000) {
						System.out.println("x: " + cc);
						System.exit(1);
					}
					cc = cc + i;
					System.out.println("total: " + cc + " - current prime: "
							+ i);
					list.add(i);
				}
			}
		}
		for (Integer p : list) {
			// System.out.println(p + " ");
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		// 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
		// 67, 71, 73, 79, 83, 89, 97.
		printPrimes(2000000);
	}

}
