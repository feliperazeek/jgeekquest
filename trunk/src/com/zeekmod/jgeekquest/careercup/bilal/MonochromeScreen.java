package com.zeekmod.jgeekquest.careercup.bilal;

import java.util.Arrays;


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
		int rows = getRowsCount(screenWidth);
		print("B E F O R E", data, screenWidth, rows);
		
		int startRange = (start.getX()/8);
		if ( start.getX() % 8 != 0 ) {
			startRange++;
		}
		startRange = startRange * rows;
		startRange = startRange + (start.getY()/8);
		if ( start.getY() % 8 != 0 ) {
			startRange++;
		}
		
		int endRange = (stop.getX()/8);
		if ( stop.getX() % 8 != 0 ) {
			endRange++;
		}
		endRange = endRange * rows;
		endRange = endRange + (stop.getY()/8);
		if ( stop.getY() % 8 != 0 ) {
			endRange++;
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("Rows: " + rows);
		System.out.println("Start Array Index: " + startRange + " - End Array Index: " + endRange);
		System.out.println("Start Position: [" + start.getX() + "," + start.getY() + "] - End Position: [" + stop.getX() + "," + stop.getY() + "]");
		
		byte setValue = (byte)1;
		for (int i = startRange; i <= endRange; i++) {
			int index = i;
			System.out.println("Paint " + index);
			data[index-1] = setValue;
		}
		
		System.out.println("");
		System.out.println("");
	
		print("A F T E R", data, screenWidth, rows);
	}
	
	private static int getRowsCount(int screenWidth) {
		return (screenWidth) / 8;
	}
	
	public static void print(String label, byte[] data, int screenWidth, int rows) {
		System.out.println( label );
		int i = 1;
		int rowCount = 1;
		for ( byte b: data ) {
			System.out.print( "(" + rowCount + "/" + i + ") " + b + " ");
			if (i == rows) {
				System.out.print("\n");
				i = 1;
				rowCount++;
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
		int x = 2;
		ScreenPoint start = new ScreenPoint( x, 1 );
		ScreenPoint stop = new ScreenPoint( x, 32 );
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
