package com.zeekmod.jgeekquest.tmp;

public class Alignment {

	public static void main(String[] args) {
		Alignment a = new Alignment();
		a.r("ABC", "ACE", 100, 4);
	}

	private void r(String A, String B, int x, int y) {
		int r = this.align(A, B, x);
		if (y != r) {
			System.out.println("WRONG - returned: " + r + " - expected: " + y);
		} else {
			System.out.println("GOOD - returned: " + r + " - expected: " + y);
		}
	}

	public int align(String A, String B, int x) {
		// You are given two Strings: A and B. You would like to align these two
		// strings by inserting '-' characters in them so that every character
		// in A lines up with the same character in B or with a '-' in B, and
		// vice versa. Each maximal sequence of consecutive '-' characters
		// costs x, plus an additional 1 per each '-' character. For example,
		// changing "ABC" to "A-B-C" costs x+1+x+1, while changing
		// it to "A--BC" costs x+2. Given, A, B, and x return the minimum cost
		// to align the two strings.

		// Constraints
		// - A and B each contain between 1 and 50 uppercase letters ('A'-'Z'),
		// inclusive.
		// - x will be between 0 and 100, inclusive.

		// "ABC"

		// "ACE"
		// 1

		int count = 0;

		char[] a = A.toCharArray();
		char[] b = B.toCharArray();

		int i1 = 0;
		int i2 = 0;
		int i = 0;
		while (true) {
			java.lang.Character c1 = null;
			java.lang.Character c2 = null;

			String data = "";
			if (i1 < a.length) {
				data = data + "1";
				c1 = a[i1];
			}
			if (i2 < b.length) {
				data = data + "2";
				c2 = b[i2];
			}

			System.out.println(c1 + " - " + c2 + ", data: " + data);
			if (data.length() == 0) {
				break;
			}

			if (c1 != c2 || c1 == null || c2 == null) {
				if (c1 == null) {
					c1 = "-".charAt(0);
				}
				if (c2 == null || c1 != c2) {
					c2 = "-".charAt(0);
				}
			}

			if (c1 == "-".charAt(0) || c1 == null) {
				c1 = null;
			} else {
				i1++;
			}
			if (c2 == "-".charAt(0) || c2 == null) {
				c2 = null;
			} else {
				i2++;
			}

			System.out.println(i + ") " + c1 + " = " + c2);

			if (i == 10) {
				break;
			}

			i++;
		}

		return i;
	}

}
