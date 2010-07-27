package com.zeekmod.jgeekquest.stuff;

public class MultiplyWithoutOperator {

	public static void main(String[] args) {
		System.out.println(booth(2, 2));
		System.out.println(booth(7, 5));
	}

	static long booth(int multiplicant, int multiplier) {
		// step 1 starts
		int A = 0, Q = multiplier;
		boolean lastbit = false; // this is flipflop
		// step 1 ends
		// step 2 starts
		// i is the counter register which counts upto the size of int
		for (int i = 0; i < Integer.SIZE; i++) {
			// step 2a
			if ((Q & 1) == 1 && !lastbit) // case 1
				A = A - multiplicant; // subtract
			else if ((Q & 1) == 0 && lastbit) // case 2
				A = A + multiplicant; // add
			// 2a ends
			// step 2b starts, arithmetic shift right
			lastbit = (Q & 1) == 1; // first shift the last bit of Q to FlipFlop
			Q = Q >>> 1; // shift Q right
			Q = Q | ((A & 1) << Integer.SIZE - 1); // shift last bit of A into
													// MSB of Q
			A = A >> 1; // shift A right
		}
		return ((long) A) << Integer.SIZE | Q; // step 3
	}

}
