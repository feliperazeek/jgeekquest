package com.zeekmod.jgeekquest.spoj.addrev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		StringBuilder result = new StringBuilder("");
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			line = reader.readLine();
			int testCaseCount = Integer.parseInt(line);
			for (int i = 0; i < testCaseCount; i++) {
				line = reader.readLine();
				result.append(ripZeros((reverseAdd(split(line).get(0), split(
						line).get(1)))));
				result.append("\n");
			}
			System.out.println(result);
		} finally {
			if (reader != null)
				reader.close();
		}

	}

	public static String reverseAdd(String arg1, String arg2) {
		char[] arg1Chars = arg1.toCharArray();
		char[] arg2Chars = arg2.toCharArray();
		String resultString = "";
		int length = arg1.length() < arg2.length() ? arg1.length() : arg2
				.length();
		int carry = 0;
		int i;
		for (i = 0; i < length; i++) {
			int operand1 = arg1Chars[i] - '0';
			int operand2 = arg2Chars[i] - '0';
			int result = operand1 + operand2 + carry;
			if (result >= 10) {
				carry = 1;
				result = result - 10;
			} else
				carry = 0;
			resultString += result;
		}
		for (; i < arg1.length(); i++) {
			int result = arg1Chars[i] - '0' + carry;
			if (result >= 10) {
				carry = 1;
				result = result - 10;
			} else
				carry = 0;
			resultString += result;
		}
		for (; i < arg2.length(); i++) {
			int result = arg2Chars[i] - '0' + carry;
			if (result >= 10) {
				carry = 1;
				result = result - 10;
			} else
				carry = 0;
			resultString += result;
		}
		if (carry == 1)
			resultString += carry;

		return resultString;
	}

	public static List<String> split(String s) {
		char[] charArr = s.toCharArray();
		List<String> list = new ArrayList<String>();

		String num = "";
		for (char c : charArr) {
			if (c == ' ') {
				list.add(num);
				num = "";
			} else
				num += c;
		}
		if (!"".equals(num))
			list.add(num);
		return list;
	}

	public static String ripZeros(String s) {
		char[] carr = s.toCharArray();
		int i = 0;
		while (carr[i++] == '0' && i < carr.length)
			;
		return s.substring(i - 1);
	}

}
