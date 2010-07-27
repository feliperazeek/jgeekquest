package com.zeekmod.jgeekquest.tmp;

// https://br.spoj.pl/problems/ENCOTEL/
public class Encontre_Telefone {

	private static String getDigit(String letter) {
		if (letter.equals('A'))
			return "2";
		if (letter.equals('B'))
			return "2";
		if (letter.equals('C'))
			return "2";
		if (letter.equals('D'))
			return "3";
		if (letter.equals('E'))
			return "3";
		if (letter.equals('F'))
			return "3";
		if (letter.equals('G'))
			return "4";
		if (letter.equals('H'))
			return "4";
		if (letter.equals('I'))
			return "4";
		if (letter.equals('J'))
			return "5";
		if (letter.equals('K'))
			return "5";
		if (letter.equals('L'))
			return "5";
		if (letter.equals('M'))
			return "6";
		if (letter.equals('N'))
			return "6";
		if (letter.equals('O'))
			return "6";
		if (letter.equals('P'))
			return "7";
		if (letter.equals('Q'))
			return "7";
		if (letter.equals('R'))
			return "7";
		if (letter.equals('S'))
			return "7";
		if (letter.equals('T'))
			return "8";
		if (letter.equals('U'))
			return "8";
		if (letter.equals('V'))
			return "8";
		if (letter.equals('W'))
			return "9";
		if (letter.equals('X'))
			return "9";
		if (letter.equals('Y'))
			return "9";
		if (letter.equals('X'))
			return "9";
		return letter;
	}

	private static String convert(String orig) {
		StringBuffer sb = new StringBuffer();
		char[] chars = orig.toCharArray();
		String s;
		for (char c : chars) {
			s = getDigit(String.valueOf(c));
			sb.append(s);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// System.out.println("1-4663-79338-4663".equals(convert("1-HOME-SWEET-HOME")));
		// System.out.println("69-647372253-562".equals(convert("MY-MISERABLE-JOB")));
		System.out.println(convert("1-HOME-SWEET-HOME"));
		System.out.println(convert("MY-MISERABLE-JOB"));
	}

}
