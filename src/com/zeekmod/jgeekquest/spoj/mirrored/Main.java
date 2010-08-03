package com.zeekmod.jgeekquest.spoj.mirrored;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void work(String s) {
		List<String> m = new ArrayList<String>();
		m.add("bd");
		m.add("db");
		m.add("pq");
		m.add("qp");
		System.out.println("line: " + s);
		
		s = s.trim();
		if ( m.contains(s) ) {
			System.out.println("Mirrored Pair");
		} else {
			System.out.println("Ordinary Pair");
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		StringBuilder result = new StringBuilder("");
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ready!");
			while(true) {
				String line = reader.readLine();
				if ( line == null || line.trim().length() == 0 ) {
					work(line);
					break;
				}
			}
			
		} finally {
			if (reader != null)
				reader.close();
		}

	}

}
