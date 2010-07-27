package com.zeekmod.jgeekquest.crackingcode.chapter5;

// TODO: Auto-generated Javadoc
/**
 * The Class Chapter5.
 */
public class Chapter5 {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		System.out.println(0x11001 << 2);
		System.out.println(Integer.toBinaryString(0x11001 << 2));

		Byte b1 = Byte.parseByte("1100", 2);
		Byte b2 = Byte.parseByte("1010", 2);
		l("a: " + Integer.toBinaryString(b1.intValue() ^ b2.intValue()));

		Byte b = Byte.parseByte("1010", 2);
		l("b: " + Integer.toBinaryString(b.intValue() << 1));

		b = Byte.parseByte("1001", 2);
		l("c: " + Integer.toBinaryString(b.intValue() ^ b.intValue()));

		b = Byte.parseByte("1001", 2);
		b2 = Byte.parseByte("1100", 2);
		l("d: " + Integer.toBinaryString(b.intValue() & b2.intValue()));

		b = Byte.parseByte("1010", 2);
		l("e: " + Integer.toBinaryString(b.intValue() >> 1));

		l("f: "
				+ Integer.toBinaryString(Integer.parseInt("FF", 16)
						- Integer.parseInt("1", 16)));

		// 1010 - 0001 = 1001
		// 1010 + 0110 = 10000
		// 1100 ^ 1010 = 0110 (a)
		// 1010 << 1 = 10100 (b)
		// 1001 ^ 1001 = 0 (c)
		// 1001 & 1100 = 1000 (d)
		// 1010 >> 1 = 101 (e)
		// 0xFF - 1 = 0xFE (f)

	}

	/**
	 * L.
	 * 
	 * @param o
	 *            the o
	 */
	public static void l(Object o) {
		System.out.println(o);
	}

}
