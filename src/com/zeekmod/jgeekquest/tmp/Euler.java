package com.zeekmod.jgeekquest.tmp;

import java.util.ArrayList;
import java.util.List;

public class Euler {

	static long iii = new Integer(13195).longValue();
	static long ii = 600851475143l;

	public static void main2(String[] args) {
		printPrimes(2000000);
	}
	
	public static void main(String[] args) {
        Integer bitmask = 0x000F;
	  Integer val = 0x2222;
	  System.out.println(bitmask + " = " + Integer.toBinaryString(bitmask) ); 
	  System.out.println(val + " = " + Integer.toBinaryString(val) ); 
	  Integer r = val & bitmask;
	  System.out.println(r + " = " + Integer.toBinaryString(r));  // prints "2"
	  
	  System.out.println(2^10);
	  // 02 = 0010
	  // 10 = 1010
	  // 0010 ^ 1010 = 1000 (8 in base 10)
	  
	  System.out.println(2^Integer.parseInt("10",2));
   }


	public static void foo() {
		int y = 0;
		String list = "731671765313306249192251196744265747423553491949349698352031277450632623957831801698480186947885184385861560789112949495459501737958331952853208805511125406987471585238630507156932909632952274430435576689664895044524452316173185640309871112172238311622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		char[] chars = list.toCharArray();
		for (int i = 0; i < chars.length - 5; i++) {
			int z = 1;
			String str = "";
			for (int j = i; j < (i + 5); j++) {
				str = str + String.valueOf(chars[j]) + " ";
				z = z * Integer.valueOf(String.valueOf(chars[j]));
			}
			str = str + "= " + z;
			if (z > y) {
				System.out.println(str);

				y = z;
			}
		}
		System.out.println("y: " + y);

	}

	public static void printPrimes(long max) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < max; i++) {
			if (i >= 2) {
				boolean good = true;
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						good = false;
						break;
					}
				}
				System.out.println(i + " - " + good);
				if (good) {
					list.add(i);
				}
			}
		}
		int add = 0;
		for (Integer p : list) {
			add = add + p;
			System.out.println(p + " ");
		}
		System.out.println(add);
	}

}
