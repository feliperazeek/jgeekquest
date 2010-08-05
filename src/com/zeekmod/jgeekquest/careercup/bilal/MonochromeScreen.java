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
		int endPaintBit = stop.getY() * stop.getX();
		int startPaintBit = start.getY() * start.getY();
		
		// Byte Indexes
		int startRange = startPaintBit / 8;
		if ( startPaintBit % 8 != 0 ) {
			startRange++;
		}
		int endRange = endPaintBit / 8;
		if ( endPaintBit % 8 != 0 ) {
			endRange++;
		}
		
		// Debug
		System.out.println("");
		System.out.println("");
		System.out.println( "Line on Row " + start.getX() + ", Screen Size (bytes): " + screenWidth + "x" + screenWidth + ", Bit(s): " + startPaintBit + "-" + endPaintBit + " Byte(s): " + startRange + "-" + endRange );
		System.out.println("Start @: [" + start.getX() + "," + start.getY() + "] - End @: [" + stop.getX() + "," + stop.getY() + "]");
		
		// Paint
		byte setValue = (byte)1;
		int currentStart = startPaintBit;
		int currentEnd = endPaintBit;
		
		int mask = 0x000000FF;
		for (int i = startRange; i <= endRange; i++) {
			System.out.println( "Set Byte " + i );
			Integer value = 0;
			int j = 0;
			if ( currentEnd > (currentStart+7) ) {
				currentEnd = currentStart+7;
			} else {
				currentEnd = endPaintBit;
			}
			for (j = currentStart; j <= currentEnd; j++) {
				System.out.println( "Set Bit " + j );
				value = mask ^ (value  >> 1);
			}
			currentStart = currentStart + j;
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
	
	private static int getSizeInBytes(int screenWidth) {
		return (screenWidth) / 8;
	}
	
	public static void print(String label, byte[] data, int screenWidth, int rows) {
		System.out.println( label );
		int i = 1;
		for ( byte b: data ) {
			System.out.print( Integer.toBinaryString(new Integer(b)) + " ");
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
		byte clearByte = (byte)0;
		Arrays.fill(data, clearByte);
		System.out.println( "Total number of dot(s)/position(s) on the screen: " + data.length );
		System.out.println("");
		return data;
	}

}
