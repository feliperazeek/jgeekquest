package com.zeekmod.jgeekquest.spoj.eboxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * * N large empty boxes (assume they are of type:1) are initially placed on a
 * table. An unknown number of boxes (type:1) are selected and in each of them K
 * smaller boxes (type:2) are placed. Again an unknown number of type:2 boxes
 * are selected and K boxes of type:3 are placed inside. This process is
 * repeated T times. Now a box is assumed to be empty when it has no smaller
 * boxes inside it. Finally after all the processes are complete let there be F
 * empty boxes in total.
 * 
 * 11 boxes are on the table. ? of boxes are selected and in each of them 8
 * boxes are placed inside. ? of those 8 are selected and
 * 
 * 115 boxes. each big box will have 8 boxes each one having 8 boxes.
 * 
 * Input: N,K,T,F
 * 
 * Output
 * 
 * Each line should contain the total number of boxes on the table.
 * 
 * Example
 * 
 * Input: 11 8 2 102
 * 
 * Output: 115
 */

public class Main {

	/** The al. */
	static ArrayList<String> al = new ArrayList<String>();

	/** The logger. */
	private static Logger logger = Logger.getLogger("log");

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		work("11 8 2 102");
	}

	/**
	 * Work.
	 * 
	 * @param s
	 *            the s
	 */
	public static void work(String s) {
		String[] ii = s.split(" ");
		int n = Integer.valueOf(ii[0]); // large boxes
		int k = Integer.valueOf(ii[1]); // smaller boxes
		int t = Integer.valueOf(ii[2]); // boxes
		int f = Integer.valueOf(ii[3]);

		logger.info("n: " + n + ", k: " + k + ", t: " + t + ", f: " + f);

	}

	/**
	 * Main2.
	 * 
	 * @param args
	 *            the args
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static void main2(String args[]) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int i;

		for (i = 0; i < cases; i++) {
			String word = br.readLine();
			al.clear();
		}
	}

}
