package com.zeekmod.jgeekquest.tmp;

public class Euler2 {

	public static void main(String[] args) {
		int x = -1;
		for (int a = 10; a < 1000; a++) {
			for (int b = 10; b < 1000; b++) {
				int y = a * b;
				if (y > x && isPal(String.valueOf(y))) {
					x = y;
				}
			}
		}
		System.out.println(x);
	}

	public static boolean isPal(String word) {
		int left = 0; // index of leftmost unchecked char
		int right = word.length() - 1; // index of the rightmost

		while (left < right) { // continue until they reach center
			if (word.charAt(left) != word.charAt(right)) {
				return false; // if chars are different, finished
			}
			left++; // move left index toward the center
			right--; // move right index toward the center
		}

		return true; // if finished, all chars were same
	}

}
