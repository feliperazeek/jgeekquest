package com.zeekmod.jgeekquest.tmp;

public class AdvertisingAgency {

	public static void main(String[] args) {
		AdvertisingAgency a = new AdvertisingAgency();

		int[] i = { 1, 2, 3 };
		a.r(i, 0);

		int[] i2 = { 1, 1, 1, };
		a.r(i2, 2);

		int[] i3 = { 1, 2, 1, 2 };
		a.r(i3, 2);

		int[] i4 = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100 };
		a.r(i4, 49);

	}

	private void r(int[] i, int x) {
		int y = numberOfRejections(i);
		if (y != x) {
			System.out.println("WRONG - returned: " + y + " - expected: " + x);
		} else {
			System.out.println("GOOD - returned: " + y + " - expected: " + x);
		}
	}

	public int numberOfRejections(int[] requests) {
		// sort array
		// requests will contain between 1 and 50 elements, inclusive.
		// Each element of requests will be between 1 and 100, inclusive.

		int rejected = 0;
		java.util.List<Integer> list = new java.util.ArrayList<Integer>();
		for (int i = 0; i < requests.length; i++) {
			int key = requests[i];
			if (list.contains(key) == false) {
				list.add(key);
			} else {
				rejected++;
			}
		}
		return rejected;
	}

}
