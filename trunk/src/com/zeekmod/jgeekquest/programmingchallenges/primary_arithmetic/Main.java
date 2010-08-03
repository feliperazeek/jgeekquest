package com.zeekmod.jgeekquest.programmingchallenges.primary_arithmetic;

import java.io.*;
import java.util.*;

class Main implements Runnable{
    static String ReadLn(int maxLength){  // utility function to read from stdin,
                                          // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line [length++] += input;
                if ( "0 0".equals(new String(line)) ) {
                	break;
                }
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}
class myStuff implements Runnable{
    public void run(){
        	String s = "";
        	
        	while (s != null && s.trim().equals("0 0") == false) {
        		
        		s = Main.ReadLn(8);
        		
        		if ( s.trim().equals("0 0") ) {
        			break;
        		}
        		
        	String[] items = s.split(" ");
        	
        	// Integer x = Integer.parseInt( items[0] );
        	// Integer y = Integer.parseInt( items[1] );
        	
        	// System.out.println("s: " + s);
        	
        	String s1 = items[0];
        	String s2 = items[1];
        	
        	char[] i1 = s1.toCharArray();
        	char[] i2 = s2.toCharArray();
        	
        	int count = 0;
        	int results = 0;
        	int rest = 0;
        	
        	int max = i1.length;
        	if ( i2.length > max ) {
        		max = i2.length;
        	}
        	
        	for ( int j = 0; j < max; j++ ) {
        		Integer e1 = 0;
        		Integer e2 = 0;
        		
        		if ( (j+1) <= i1.length ) {
        			e1 = Integer.parseInt( String.valueOf(i1[j]) );
        		}
        		if ( (j+1) <= i2.length ) {
        			e2 = Integer.parseInt( String.valueOf(i2[j]) );
        		}
        		if ( e1 + e2 + rest > 9 ) {
        			results++; 
        			rest = (((e1 + e2) - 10) / 10);
        			// System.out.println( "sum: " + (e1+e2) + ", rest: " + rest + ", results: " + results );
        		} else {
        			rest = 0;
        		}
        		count++;
        	}
        	
	        	if ( results == 0 ) {
	        		System.out.println( "No carry operation." );
	        	} else if ( results == 1 ) {
	        		System.out.println( "1 carry operation." );
	        	} else {
	        		System.out.println( results + " carry operations." );
	        	}
        	}
    	
        	
        }
    
    // You can insert more classes here if you want.
}
