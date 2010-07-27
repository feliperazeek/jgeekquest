package com.zeekmod.jgeekquest.topcoder;

// TODO: Auto-generated Javadoc
/**
 * The Class BinaryCode.
 */
public class BinaryCode {

	/**
	 * Gets the encrypted digit.
	 * 
	 * @param s
	 *            the s
	 * @param pos
	 *            the pos
	 * 
	 * @return the encrypted digit
	 */
	private String getEncryptedDigit(String s, int pos) {
		int e1 = 0;
		int e2 = 0;
		int e3 = 0;
		char[] chars = s.toCharArray();
		if ((pos - 1) >= 0) {
			e1 = Integer.parseInt(String.valueOf(chars[pos - 1]));
		}
		e2 = Integer.parseInt(String.valueOf(chars[pos]));
		if (pos + 1 <= (chars.length - 1)) {
			e3 = Integer.parseInt(String.valueOf(chars[pos + 1]));
		}

		String x = String.valueOf(e1 + e2 + e3);
		// System.out.println( "pos: " + pos + " -> e1: " + e1 + ", e2: " + e2 +
		// ", e3: " + e3 + " - result: " + x);
		return x;
	}

	/**
	 * Gets the clear integer.
	 * 
	 * @param s
	 *            the s
	 * @param pos
	 *            the pos
	 * 
	 * @return the clear integer
	 */
	private Integer getClearInteger(String s, int pos) {
		char[] chars = s.toCharArray();
		int e = Integer.parseInt(String.valueOf(chars[pos]));

		int prev = 0;
		if (pos > 0) {
			prev = this.getClearInteger(s, pos - 1);
		}

		int clear = e;
		if (pos > 0) {
			clear = clear + this.getClearInteger(s, pos - 1);
		}
		// System.out.println( "pos: " + pos + " -> " + clear + " - prev: " +
		// prev);
		return clear;
	}

	/**
	 * Valid.
	 * 
	 * @param encrypted
	 *            the encrypted
	 * @param clear
	 *            the clear
	 * 
	 * @return true, if successful
	 */
	private boolean valid(String encrypted, String clear) {
		// int pos = 0;
		// char[] chars = encrypted.toCharArray();
		// for ( int i = 0; i < encrypted.length(); i++ ) {
		// System.out.println( "Pos: " + pos );
		// System.out.println( "Encrypted: " + this.getEncryptedDigit(clear, i)
		// + " - Clear: " + this.getClearInteger(encrypted, i) );
		// System.out.println( "" );
		// }

		Integer q8 = Integer.parseInt(encrypted
				.substring(encrypted.length() - 1));
		Integer p7 = Integer.parseInt(clear.substring(encrypted.length() - 2,
				encrypted.length() - 1));
		Integer p8 = Integer.parseInt(clear.substring(clear.length() - 1));
		System.out.println("q8: " + q8 + ", p7: " + p7 + ", p8: " + p8);

		return true;
	}

	/**
	 * Decode.
	 * 
	 * @param message
	 *            the message
	 * 
	 * @return the string[]
	 */
	public String[] decode(String message) {
		char[] chars = message.toCharArray();
		String r1 = "";
		String r2 = "";
		int pos = 0;
		for (char c : chars) {
			r1 = r1 + this.getEncryptedDigit(message, pos);
			pos++;
		}

		System.out.println("R1: " + r1);
		this.valid(r1, message);

		message = "1" + message.substring(1);
		chars = message.toCharArray();
		pos = 0;
		for (char c : chars) {
			r2 = r2 + this.getEncryptedDigit(message, pos);
			pos++;
		}

		System.out.println("R2: " + r2);
		this.valid(r2, message);

		String[] res = { r1, r2 };
		return res;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		BinaryCode b = new BinaryCode();
		b.decode("011100011");
	}

}
