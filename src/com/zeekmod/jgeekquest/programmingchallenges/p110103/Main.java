package com.zeekmod.jgeekquest.programmingchallenges.p110103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			while (line != "0") {
				line = reader.readLine();
				if ( line == null || "".equals(line) || "0".equals(line) ) {
					break;
				}
				int testCaseCount = Integer.parseInt(line);
				List<Double> items = new ArrayList<Double>();
				double total = 0;
				for (int i = 0; i < testCaseCount; i++) {
					line = reader.readLine();
					Double item = Double.valueOf(line);
					total = total + item;
					items.add(item);
					// System.out.println("L: " + line);
					// System.out.println("\n");
				}
				// System.out.println("total: " + total);
				Double avg = total / testCaseCount;
				
				Double change = 0.0;
				for ( Double d : items ) {
					if ( d < avg ) {
						change = change + (avg - d);
					}
				}
				DecimalFormat nf = new DecimalFormat("$%.2lf\n");
				System.out.println(nf.format(change));
				
			}
			// System.out.println(result);
		} finally {
			if (reader != null)
				reader.close();
		}

	}

}
