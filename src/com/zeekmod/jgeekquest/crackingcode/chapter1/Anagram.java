package com.zeekmod.jgeekquest.crackingcode.chapter1;

import java.util.Arrays;

public class Anagram {
	
	public boolean isAnagram(String a, String b) {
		char[] chars1 = a.toCharArray();
		char[] chars2 = b.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		System.out.println(Arrays.toString(chars1) + " - " + Arrays.toString(chars2) + " = " + chars1.equals(chars2));
		return Arrays.equals(chars1, chars2);
	}
	
	public void check(String s1, String s2) {
		if ( isAnagram(s1, s2) == false ) {
			System.out.println("ERROR! " + s1 + " is NOT an anagram of " + s2);
		} else {
			System.out.println(s1 + " is not an anagram of " + s2);
		}
	}
	
	public static void main(String[] args) {
		Anagram a = new Anagram();
		a.check("asd", "dsa");
		a.check("ass", "dddd");
	}

}
