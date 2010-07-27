package com.zeekmod.jgeekquest.crackingcode.trees_graphs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Graph.
 */
public class Graph<DATA extends Serializable> {

	/** The vertices. */
	List<Vertex<DATA>> vertices = new ArrayList<Vertex<DATA>>();

	/** The edges. */
	List<Edge<DATA>> edges = new ArrayList<Edge<DATA>>();

	/** The visited list. */
	List<Vertex<DATA>> visitedList = new ArrayList<Vertex<DATA>>();

	/**
	 * Display vertex.
	 * 
	 * @param v
	 *            the v
	 */
	public void displayVertex(Vertex<DATA> v) {
		System.out.println("Visiting Vertex " + v + "...");
		this.visitedList.add(v);
	}

	/**
	 * Gets the next vertex.
	 * 
	 * @param v
	 *            the v
	 * 
	 * @return the next vertex
	 */
	public Vertex<DATA> getNextVertex(Vertex<DATA> v) {
		for (Edge<DATA> e : this.edges) {
			// System.out.println( e + " - x: " + e.getX() + ", y: " + e.getY()
			// + " - visited: " + this.visitedList.contains(e.getY()) );
			if (e != null && e.getX() != null && e.getX().equals(v)
					&& !this.visitedList.contains(e.getY())) {
				System.out.println("---- Using vertex to link " + e.getX()
						+ " to " + e.getY() + " ----");
				return e.getY();
			}
		}
		return null;
	}

	/**
	 * Dfs.
	 * 
	 * @return the int
	 */
	public int dfs() {
		int visits = 0;

		if (this.vertices == null || this.vertices.size() == 0) {
			System.out.println("No vertices available!");
			return visits;
		}

		Vertex<DATA> v = this.vertices.get(0);
		this.displayVertex(v);
		visits++;
		while (true) {
			v = this.getNextVertex(v);
			if (v != null) {
				this.displayVertex(v);
				visits++;
			} else {
				break;
			}
		}

		System.out.println("Done - Visits: " + visits);
		return visits;
	}

	/**
	 * Gets the vertices.
	 * 
	 * @return the vertices
	 */
	public List<Vertex<DATA>> getVertices() {
		return this.vertices;
	}

	/**
	 * Sets the vertices.
	 * 
	 * @param vertices
	 *            the new vertices
	 */
	public void setVertices(List<Vertex<DATA>> vertices) {
		this.vertices = vertices;
	}

	/**
	 * Gets the edges.
	 * 
	 * @return the edges
	 */
	public List<Edge<DATA>> getEdges() {
		return this.edges;
	}

	/**
	 * Sets the edges.
	 * 
	 * @param edges
	 *            the new edges
	 */
	public void setEdges(List<Edge<DATA>> edges) {
		this.edges = edges;
	}

	/**
	 * Adds the edge.
	 * 
	 * @param e
	 *            the e
	 */
	public void addEdge(Edge<DATA> e) {
		this.edges.add(e);
	}

	/**
	 * Adds the vertex.
	 * 
	 * @param v
	 *            the v
	 */
	public void addVertex(Vertex<DATA> v) {
		this.vertices.add(v);
	}

	/**
	 * Gets the vertex.
	 * 
	 * @param name
	 *            the name
	 * 
	 * @return the vertex
	 */
	public Vertex<DATA> getVertex(String name) {
		for (Vertex<DATA> v : this.vertices) {
			if (v != null && v.getData() != null && v.getData().equals(name)) {
				return v;
			}
		}
		return null;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Graph<String> g1 = new Graph<String>();
		g1.addVertex(new Vertex<String>("A"));
		g1.addVertex(new Vertex<String>("B"));
		g1.addVertex(new Vertex<String>("C"));
		g1.addVertex(new Vertex<String>("D"));
		g1.addVertex(new Vertex<String>("E"));

		g1.addEdge(new Edge<String>(g1.getVertex("A"), g1.getVertex("B")));
		g1.addEdge(new Edge<String>(g1.getVertex("A"), g1.getVertex("C")));
		g1.addEdge(new Edge<String>(g1.getVertex("B"), g1.getVertex("D")));
		g1.addEdge(new Edge<String>(g1.getVertex("B"), g1.getVertex("E")));

		g1.dfs();
	}

}
