package com.zeekmod.jgeekquest.careercup.bilal;

import java.util.Arrays;
import java.util.BitSet;


/***
 * You have a monochrome screen where each pixel is represented by a single bit
 * (eight pixels = 1 byte), and the entire screen is an array of bytes (you are
 * provided the width). Assuming that the width is divisible by 8 (so that bytes
 * aren't split up across lines). "Draw" a horizontal line.
 * 
 * Assume: height and width are the same (square screen) You're also told start
 * position and end position (in terms of pixel positions) of line
 * 
 * You are provided with a screen width (in number of pixels) and a number of
 * pixels (which is the size of the bytes array * 8)
 * 
 * @author flipflop
 * 
 */

public class MonochromeScreen {
	
	private static final int BITS_IN_A_BYTE = 8; 
	
	public static void drawHorizontalLine(int screenWidth, byte[] data, ScreenPoint start, ScreenPoint stop) {
		// Get Rows Count
		int rows = getSizeInBytes(screenWidth);
		
		// Print
		print("B E F O R E", data, screenWidth, rows);
		
		// Bit Indexes
		int endPaintBit = stop.getX() * stop.getY();
		int startPaintBit = start.getX() * start.getY();
		
		// Byte Indexes
		int startRange = startPaintBit / BITS_IN_A_BYTE;
		int endRange = startRange + (endPaintBit / BITS_IN_A_BYTE);
		
		int currentStart = startPaintBit;
		int currentEnd = endPaintBit;
		
		// Debug
		System.out.println("");
		System.out.println("");
		System.out.println( "Line on Row " + start.getX() + ", Screen Size (bytes): " + screenWidth + "x" + screenWidth + ", Bit(s): " + startPaintBit + "-" + endPaintBit + " Byte(s): " + startRange + "-" + endRange );
		System.out.println("Positions: [" + start.getX() + "," + start.getY() + "] - End @: [" + stop.getX() + "," + stop.getY() + "]");
		
		for (int i = startRange; i <= endRange; i++) {
			System.out.println( "Set Byte " + i );
			
			// int currentStart = startRange * BITS_IN_A_BYTE;
			// int currentEnd = currentStart + BITS_IN_A_BYTE;
			// if ( currentEnd > endRange ) {
				// currentEnd = endRange;
			// }
			
			Integer value = 0;
			int c = 0;
			System.out.println("S: " + currentStart + ", E: " + currentEnd);
			for (currentStart = currentStart; currentStart < currentEnd; currentStart++) {
				value = value | (1 << c);
				System.out.println( "Set Bit " + currentStart );
				c++;
				if ( c >= BITS_IN_A_BYTE-1 ) {
					break;
				}
			}
			data[i] = value.byteValue(); 
		}
		
		/*
			for (int j = startPaintBit; j <= endPaintBit; j++) {
				System.out.println( "Set Bit " + j );
				data[i-1] = setValue;
			} */
	
		
		// Print
		System.out.println("");
		System.out.println("");
		print("A F T E R", data, screenWidth, rows);
	}
	
	private static String printByte(byte b) {
		String s = Integer.toBinaryString(new Integer(b)) ;
		if ( s.length() < BITS_IN_A_BYTE ) {
			for ( int i = 1; i < (BITS_IN_A_BYTE - s.length()); i++ ) {
				s = "0" + s;
			}
		}
		return s;
	}
	
	private static int getSizeInBytes(int screenWidth) {
		return (screenWidth) / BITS_IN_A_BYTE;
	}
	
	public static void print(String label, byte[] data, int screenWidth, int rows) {
		int i = 1;
		for ( byte b: data ) {
			System.out.print( printByte( b ) + " ");
			if (i == rows) {
				System.out.print("\n");
				i = 1;
			} else {
				i++;
			}
		}
	}

	public static class ScreenPoint {

		private int x;

		private int y;

		public ScreenPoint(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

	}

	public static void main(String[] args) {
		int screenWidth = 32;
		byte[] data = MonochromeScreen.generateSampleData(screenWidth);
		int row = 1;
		ScreenPoint start = new ScreenPoint( row, 2 );
		ScreenPoint stop = new ScreenPoint( row, 23 );
		MonochromeScreen.drawHorizontalLine(screenWidth, data, start, stop);
	}
	
	public static byte[] generateSampleData(int width) {
		width = (width / BITS_IN_A_BYTE) * (width / BITS_IN_A_BYTE);
		byte[] data = new byte[width];
		byte clearByte = new Integer(0).byteValue();
		Arrays.fill(data, clearByte);
		System.out.println( "Total number of dot(s)/position(s) on the screen: " + data.length );
		System.out.println("");
		return data;
	}

}
