/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeekmod.jgeekquest.programmingchallenges.jollyjumpers_110201;

import java.util.Arrays;

/**
 *
 * @author flipflop
 */
public class Main {
    
    public static boolean isJollyJumper(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        String[] items = s.split(" ");
        int results = 0;
        Integer last = null;
        for ( String item  : items ) {
            Integer number = Integer.parseInt(item);
            if ( number != null && last != null ) {
                Integer x = number - last;
                if ( x < 0 ) {
                    x = x * -1;
                }
                if ( findNumber(items, x) == false ) {
                    return false;
                }
                System.out.println("Number: " + number + ", Last: " + last + ", Results = " + x);
            }
            
            last = number;
            
        }
        return true;
    }

    public static boolean findNumber(String[] x, Integer n) {
        for ( String y : x ) {
            if ( new Integer(y).equals(n) ) {
                return true;
            }
        }
        System.out.println( "not found: " + n + " on list: " + Arrays.toString(x));
        return false;

    }
    
    public static void print(String s) {
        System.out.println("");
        if ( isJollyJumper(s) ) {
            System.out.println("Jolly");
        } else {
            System.out.println("Not Jolly");
        }
    }

    public static void main(String[] args) {
        print("1 4 2 3");
        print("1 4 2 -1 6");
        print("1");
        print("6 1 6 7 11 13 16");
        print("1 2");
    }

}
