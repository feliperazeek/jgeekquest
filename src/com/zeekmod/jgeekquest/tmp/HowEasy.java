package com.zeekmod.jgeekquest.tmp;

import java.util.StringTokenizer;

public class HowEasy {

	public int pointVal(String s) {
		int avg = 0;
		if (s != null && s.length() > 0) {
			int total = 0;
			int count = 0;
			StringTokenizer t = new StringTokenizer(s);
			while (t.hasMoreTokens()) {
				String word = t.nextToken();
				System.out.println("Found the word " + word);
				if (this.isWord(word)) {
					total = total + word.length();
					count++;
				}
			}
			avg = total / count;
		}
		return this.getProblem(avg);
	}

	private boolean isWord(String s) {
		if (s == null) {
			return false;
		}
		char dot = '.';
		if (s.indexOf(dot) > 0 && s.charAt(s.length() - 1) != dot) {
			return false;
		}
		return true;
	}

	private int getProblem(int avg) {
		if (avg <= 3) {
			return 250;
		} else if (avg == 4 || avg == 5) {
			return 500;
		} else if (avg > 6) {
			return 1000;
		} else {
			throw new RuntimeException("Invalid average: " + avg);
		}
	}

	public static void main(String[] args) {
		HowEasy he = new HowEasy();
		int i = he.pointVal("fe b.b.b");
		System.out.println(i);
	}

}
