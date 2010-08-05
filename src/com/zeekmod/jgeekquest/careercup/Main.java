package com.zeekmod.jgeekquest.careercup;

public class Main {

	public static void main(String[] args) {
		double num = 0.0;
		double den = 1.0;
		boolean found = false;
		double n = 0.75;
		while (!found) {
			if (n == num / den) {
				found = true;
			} else if (n < num / den) {
				den++;
			} else {
				num++;
			}
		}
		System.out.println((int) num + "/" + (int) den);
	}

}
