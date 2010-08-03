package com.zeekmod.jgeekquest.programmingchallenges.forinterview;

import java.util.Arrays;

public class Main {

	public static int binarySearch(int[] s, int x) {
		return binarySearch2(s, x, 0, s.length-1);
	}

	static int binarySearch(int arr[], int value, int left, int right) {
		// Iterate for as long as it's necessary
		while (left <= right) {
			// Find indexOf in the middle so we can do our divide
			int middle = (left + right) / 2;
			
			// If the things matches we are good!
			if (arr[middle] == value) {
				return middle;
				
			} else if (arr[middle] > value) {
				// Ok not so luck, looks like the value should be to the left (smaller value) if the array is sorted so let's make "end" shorter so next middle value is closer to the left
				right = middle - 1;
			} else {
				// Pretty much the inverse of the line above
				left = middle + 1;
			}
		}
		return -1;
	}

	public static int binarySearch2(int[] list, int n, int start, int end) {
		if (list == null || list.length == 0) {
			return -1;
		}
		while (start <= end) {
			int med = (start + end) / 2;
			int value = list[med];
			if (value == n) {
				return med;
			}
			if (value > n) {
				end = med - 1;
			} else {
				start = med + 1;
			}
		}
		return -1;
	}

	public static int recursiveBinarySearch(int[] list, int x) {
		System.out.println( "" );
		System.out.println( "---------" );
		return recursiveBinarySearch(list, x, 0, list.length-1);
	}

	public static int recursiveBinarySearch(int[] list, int x, int start,int end) {
		
		// Check if the result is obivous
		if (list == null || list.length == 0) {
			return -1;
		}
		
		// Ok we done here
		if (start < end) {
		
		// Find the middle point
		// int med = (end + start) / 2;
		int med = start + (end + start) / 2;
		if ( (med+1) > list.length ) {
			return med = med - 1;
		}
		// System.out.println( "start: " + start + ", end: " + end + ", med: " + med );
		
		// Get the value for that position
		int currentValue = list[med];
		// System.out.println("currentValue: " + currentValue + ", searchValue: " + x + ", start: " + start + ", end: " + end + ", med: " + med);
		
		// Let's see what we got now...
		if (currentValue == x) {
			// It matches, let's go party
			return med;
		}
		
		// Ok not yet keep going my friend
		if (currentValue < x) {
			// // Ok not so luck, looks like the value should be to the right (greater value) if the array is sorted so let's make "start" a little bigger/newer/meaner so next middle value is closer to the right
			return recursiveBinarySearch(list, x, (start+1), end);
		} else {
			// Opposite
			return recursiveBinarySearch(list, x, start, (end-1));
		}
		
		} else {
			return -1;
		}
	}

	public static String reverseString(String s) {
		if (s == null || s.length() == 1) {
			return s;
		}
		char[] r = new char[s.length()];
		char[] chars = s.toCharArray();
		int n = chars.length;
		for (int i = 0; i < chars.length / 2; i++) {
			char temp = chars[i];
			char temp2 = chars[n - 1 - i];
			r[i] = temp2;
			r[n - 1 - i] = temp;
		}
		String x = new String(r);
		System.out.println("s: " + s + ", x: " + x);
		return x;
	}

	public static void main(String[] args) {
		// Reverse String
		reverseString("felipe");

		// Binary Search - Success Match - average case left side
		int[] list = { 7, 9, 2, -1, 10, 3, 100, 50 };
		int x = 3;
		int r1 = binarySearch(list, x, 0, list.length - 1);
		int r2 = recursiveBinarySearch(list, x);
		System.out.println("list: " + Arrays.toString(list) + ", searchValue: " + x + " -> " + r1 + " = " + r2);
		
		// Binary Search - Success Match - average case right side
		x = 100;
		r1 = binarySearch(list, x, 0, list.length - 1);
		r2 = recursiveBinarySearch(list, x);
		System.out.println("list: " + Arrays.toString(list) + ", searchValue: " + x + " -> " + r1 + " = " + r2);

		// Binary Search - Not Found - worst case
		System.out.println("------------------------------------------------------------------------------");
		x = 101;
		r1 = binarySearch(list, x, 0, list.length - 1);
		r2 = recursiveBinarySearch(list, x);
		System.out.println("list: " + Arrays.toString(list) + ", searchValue: " + x + " -> " + r1 + " = " + r2);
		
		// Binary Search - Found on first element - best case
		System.out.println("------------------------------------------------------------------------------");
		x = list[0];
		r1 = binarySearch(list, x, 0, list.length - 1);
		r2 = recursiveBinarySearch(list, x);
		System.out.println("list: " + Arrays.toString(list) + ", searchValue: " + x + " -> " + r1 + " = " + r2);
	}

}
