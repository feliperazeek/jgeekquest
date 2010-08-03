package com.zeekmod.jgeekquest.programmingchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Start with an integer n. If n is even, divide by 2. If n is odd, multiply by 3 and add 1. 
// Repeat this process with the new value of n, terminating when n = 1. 
// For example, the following sequence of numbers will be generated for n = 22:

public class Main {
	
	public static int doWork(Integer n) {
		if ( isEven(n) ) {
			System.out.println("even: " + n + ", b: " + Integer.toBinaryString(n));
		} else {
			System.out.println("odd: " + n + ", b: " + Integer.toBinaryString(n));
		}
		return 0;
	}
	
	private static boolean isEven(Integer n) {
		if ( (1 & n) == 0 ) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		doWork(1);
		doWork(200);
		doWork(-2);
		doWork(-1);
		doWork(0);
		
	}
	
	public static void main2(String[] args) throws IOException {
		BufferedReader reader = null;
		StringBuilder result = new StringBuilder("");
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			line = reader.readLine();
			int testCaseCount = Integer.parseInt(line);
			for (int i = 0; i < testCaseCount; i++) {
				line = reader.readLine();
				result.append("\n");
			}
			System.out.println(result);
		} finally {
			if (reader != null)
				reader.close();
		}

	}

}
