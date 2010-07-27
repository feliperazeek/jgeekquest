package com.zeekmod.jgeekquest.crackingcode.trees_graphs;

import java.io.Serializable;
import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class Vertex.
 */
public class Vertex<DATA extends Serializable> implements
		Comparator<Vertex<DATA>> {

	/**
	 * Instantiates a new vertex.
	 * 
	 * @param data
	 *            the data
	 */
	public Vertex(DATA data) {
		super();
		this.data = data;
	}

	/** The data. */
	DATA data;

	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public DATA getData() {
		return this.data;
	}

	/**
	 * Sets the data.
	 * 
	 * @param data
	 *            the new data
	 */
	public void setData(DATA data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getData().toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Vertex<DATA> v1, Vertex<DATA> v2) {
		if (v1 == null || v1.getData() == null) {
			return 0;
		}
		if (v1 == null || v1.getData() == null) {
			return 1;
		}
		return (v1.getData().toString().compareTo(v2.getData().toString()));
	}

}
