/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeekmod.jgeekquest.careercup;

/**
 *
 * @author flipflop
 */
public class BinarySearch {

    public static String binarySearch(String[] s, String item) {
        return binarySearch(s, item, 0, s.length-1);
    }

    public static String binarySearch(String[] s, String item, int start, int end) {
        System.out.println("1");
        if ( end <= start ) {
            return null;
        }
        String med = s[end-start/2];
        if ( med.equals(item) ) {
            return item;
        }

        if ( item.compareTo(med) < -1 ) {
            start++;
        } else {
            end--;
        }
        return binarySearch(s, item, start, end);

    }

    public static void main(String[] args) {
        String[] s = {"1", "2", "3", "6", "5", "9"};
        System.out.println(binarySearch(s, "5"));
    }

}
