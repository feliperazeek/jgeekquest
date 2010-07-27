package com.zeekmod.jgeekquest.spoj.samer08f;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static int getTotal(int n) {
		int total = 0;
		if (n <= 1) {
			return n;
		}
		for (int i = 1; i <= n; i++) {
			total += (i * i);
		}
		return total;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader r = new java.io.BufferedReader(
				new java.io.InputStreamReader(System.in));
		while (true) {
			Integer n = Integer.parseInt(r.readLine());
			if (n == 0) {
				break;
			}
			System.out.println(getTotal(n));
		}
	}

}
