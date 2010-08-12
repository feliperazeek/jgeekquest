/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeekmod.jgeekquest.careercup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flipflop
 */
public class PascalTriangle {

    private List<List<Integer>> list = new ArrayList<List<Integer>>();

    public void build(int levels) {
        this.buildHead();
    }

    public void buildLevel(int max, int level, List<Integer> p) {
        if (level == max) {
            return;
        }
        if (p != null) {
            if (p.size() == 1) {
            }
        }
    }

    public void print() {
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }

    private void buildHead() {
        List<Integer> h = new ArrayList<Integer>();
        h.add(1);
        this.list.add(h);
    }

    public static void main(String args[]) {
        int x = 6;
        int triangle[][] = new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                triangle[i][j] = 0;
            }
        }
        for (int i = 0; i < x; i++) {
            triangle[i][0] = 1;
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < x; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
