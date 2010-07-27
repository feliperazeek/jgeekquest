package com.zeekmod.jgeekquest.tmp;

public class Fib {

	public static void main(String[] args) {
		printFibs(100);
		// fib(10);

		// F0 F1 F2 F3 F4 F5 F6 F7 F8 F9 F10 F11 F12 F13 F14 F15 F16 F17 F18 F19
		// F20
		// 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
	}

	public static void printFibs(int max) {
		for (int i = 0; i < max; i++) {
			System.out.print(fib(i) + " ");
		}
	}

	public static boolean isFib(int i) {
		return false;
	}

	public static int fib(int i) {
		if (i <= 1) {
			return i;
		} else {
			return fib(i - 1) + fib(i - 2);
		}
	}

}
