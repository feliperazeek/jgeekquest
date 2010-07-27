package com.zeekmod.jgeekquest.spoj.bishop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static BigInteger getTotal(long n) {
		if (n == 0) {
			return BigInteger.ZERO;
		}
		BigInteger total = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			total = total.multiply(BigInteger.valueOf(n));
		}
		return total;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder("");
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			line = reader.readLine();
			int testCaseCount = Integer.parseInt(line);
			// System.out.println(testCaseCount);
			for (int i = 0; i < testCaseCount; i++) {
				line = reader.readLine();
				if (line != null && line.length() > 0) {
					// System.out.println("q: " + line);
					long n = Long.valueOf(line).longValue();
					if (n > 0) {
						BigInteger total = getTotal(n);
						// System.out.println("Total: " + total);
						sb.append(total.toString());
					}
					sb.append("\n");
				}
			}
			System.out.println(sb);
		} finally {
			if (reader != null)
				reader.close();
		}
	}

}