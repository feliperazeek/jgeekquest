package com.zeekmod.jgeekquest.tmp;

public class BubbleSort {

	public static void main(String[] args) {
		int[] a = { 10, 8, 9, 7, 3, 2, 1, 5 };
		a = sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static int[] sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a = swap(a, i, true);
			for (int j = 0; j < a.length; j++) {
				a = swap(a, j, false);
			}
		}
		return a;
	}

	public static int[] swap(int[] l, int pos, boolean main) {
		if (main)
			System.out.println("-------------------------------------------");
		if (pos + 1 < l.length && l[pos] > l[pos + 1]) {
			for (int ii : l) {
				System.out.print(ii + " ");
			}
			System.out.print("\n");
			int tmp1 = l[pos];
			int tmp2 = l[pos + 1];
			l[pos] = tmp2;
			l[pos + 1] = tmp1;
		}
		if (main)
			System.out.println("-------------------------------------------");
		return l;
	}

}
