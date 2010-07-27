package com.zeekmod.jgeekquest.tmp;

import java.util.Arrays;

public class MergeSortWrong {

	public static void main(String[] args) {
		String[] expected = { "A", "B", "C", "D", "E" };
		String[] actual = { "E", "D", "A", "B", "C" };
		String[] end = mergeSort(actual);
	}

	public static String[] mergeSort(String[] arr) {
		while (true) {
			int start1 = 0;
			int end1 = arr.length / 2;
			int size1 = (end1 - start1) + 1;

			int start2 = end1 + 1;
			int end2 = arr.length - 1;
			int size2 = (end2 - start2) + 1;

			System.out.println("L [" + start1 + "-" + end1 + "-" + size1
					+ "] - R [" + start2 + "-" + end2 + "-" + size2 + "]");

			// Divide
			String[] leftArray = new String[size1];
			String[] rightArray = new String[size2];
			System.arraycopy(arr, start1, leftArray, 0, size1);
			System.arraycopy(arr, start2, rightArray, 0, size2);

			// Log Debug
			printArray("L", leftArray);
			printArray("R", rightArray);

			// Sort
			leftArray = sort(leftArray);
			rightArray = sort(rightArray);

			// Log Debug
			printArray("L", leftArray);
			printArray("R", rightArray);

			break;

		}

		printArray("Final", arr);
		return arr;
	}

	public static void printArray(String label, String[] a) {
		System.out.println(label + ": " + Arrays.asList(a) + " - size: "
				+ a.length);
	}

	public static String[] sort(String[] a) {
		Arrays.sort(a);
		return a;
	}

}
