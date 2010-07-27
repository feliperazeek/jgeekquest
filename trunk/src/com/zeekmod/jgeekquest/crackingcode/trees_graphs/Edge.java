package com.zeekmod.jgeekquest.crackingcode.trees_graphs;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Edge.
 */
public class Edge<DATA extends Serializable> {

	/** The type. */
	EdgeType type;

	/** The x. */
	Vertex<DATA> x;

	/** The y. */
	Vertex<DATA> y;

	/**
	 * Instantiates a new edge.
	 * 
	 * @param type
	 *            the type
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Edge(EdgeType type, Vertex<DATA> x, Vertex<DATA> y) {
		super();
		this.type = type;
		this.x = x;
		this.y = y;
	}

	/**
	 * Instantiates a new edge.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Edge(Vertex<DATA> x, Vertex<DATA> y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public EdgeType getType() {
		return this.type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(EdgeType type) {
		this.type = type;
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public Vertex<DATA> getX() {
		return this.x;
	}

	/**
	 * Sets the x.
	 * 
	 * @param x
	 *            the new x
	 */
	public void setX(Vertex<DATA> x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public Vertex<DATA> getY() {
		return this.y;
	}

	/**
	 * Sets the y.
	 * 
	 * @param y
	 *            the new y
	 */
	public void setY(Vertex<DATA> y) {
		this.y = y;
	}

}
