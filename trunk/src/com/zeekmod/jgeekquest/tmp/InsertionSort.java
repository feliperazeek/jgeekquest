package com.zeekmod.jgeekquest.tmp;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = { 10, 8, 9, 7, 3, 2, 1, 5 };
		a = sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static int[] sort(int[] a) {
		// sorted array
		int[] r = new int[a.length];

		// loop on each value
		for (int i = 0; i < a.length; i++) {
			// display the unsorted array
			for (int x : a) {
				// not very clean way to display this thing but...
				System.out.print(x + " ");
			}
			System.out.print(" - current: " + a[i] + "\n");

			for (int x : r) {
				System.out.print(x + " ");
			}
			System.out.print("??? \n");

			// get the one that needs to travel until it finds its place
			int value = a[i];

			// now lets look where it fits in the the sorted array
			Integer pos = null;
			for (int j = 0; j < a.length - 1; j++) {
				// get the element on the sorted
				int element = r[j];

				// check if this is the position the thing needs to stay at
				if (pos == null && value <= element) {
					pos = j;
					System.out.println("Found position " + pos + " bc " + value
							+ " is smaller or equals than " + element);
				}

				// now that we found it push everyone to the right
				if (pos != null) {
					for (int x = (r.length - 1); x > (pos); x--) {
						System.out.println("Pushing pos " + (x - 1)
								+ " with value " + r[x - 1] + " moved to pos "
								+ (x));
						r[x] = r[x - 1];
					}
					System.out.println("Setting value " + (pos)
							+ " with value " + value);
					r[pos] = value;
					break;
				}

				r[i] = value;
			}

			for (int x : r) {
				System.out.print(x + " ");
			}
			System.out.print("!!! \n");

			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
		return r;
	}

}
