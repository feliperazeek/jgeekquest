/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeekmod.jgeekquest.programmingchallenges.bicoloring_110901;

import com.zeekmod.jgeekquest.crackingcode.trees_graphs.Edge;
import com.zeekmod.jgeekquest.crackingcode.trees_graphs.Graph;
import com.zeekmod.jgeekquest.crackingcode.trees_graphs.Vertex;

/**
 *
 * @author flipflop
 */

public class Bicoloring {

        Graph<String> g = new Graph<String>();

        public void print() {
            System.out.println( this.g.dfs() );
        }

        private String getVertexName(int i) {
            return "Vertex " + i;
        }
    
        public void loadVertices(int n) {
            for ( int i = 0; i < n; i++ ) {
                g.addVertex(new Vertex<String>(this.getVertexName(i)));
            }
        }

        public void loadEdges(int n) {

        }

        public void loadEdge(int x, int y) {
            g.addEdge(new Edge<String>(g.getVertex(this.getVertexName(x)), g.getVertex(this.getVertexName(y))));
        }

        public boolean ok() {
            boolean ok = true;
            Vertex[] vc = new Vertex[this.g.getVertices().size()];
            // for ( int t = 0; t < this.g.getVertices(); t++ ) {
                // vc[t] = -1;
            // }
            // for ( int v = 0; v < this.g.getVertices(); v++ ) {

            // }

            return ok;
        }
    
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
                Bicoloring b = new Bicoloring();
                b.loadVertices(3);
                b.loadEdge(0, 1);
                b.loadEdge(1, 2);
                b.loadEdge(2, 0);
                b.print();
	}

}
