package com.zeekmod.jgeekquest.tmp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ShortestPath {

	private final Set<City> settledNodes = new HashSet<City>();

	private final Map<City, Integer> shortestDistances = new HashMap<City, Integer>();

	private final Map<City, City> predecessors = new HashMap<City, City>();

	private final Comparator<City> shortestDistanceComparator = new Comparator<City>() {
		public int compare(City left, City right) {
			int shortestDistanceLeft = getShortestDistance(left);
			int shortestDistanceRight = getShortestDistance(right);

			if (shortestDistanceLeft > shortestDistanceRight) {
				return +1;
			} else if (shortestDistanceLeft < shortestDistanceRight) {
				return -1;
			} else // equal
			{
				return left.compareTo(right);
			}
		}
	};

	private final PriorityQueue<City> unsettledNodes = new PriorityQueue<City>(
			Integer.MIN_VALUE, shortestDistanceComparator);

	public interface RoutesMap {
		int getDistance(City start, City end);

		List<City> getDestinations(City city);
	}

	private boolean isSettled(City v) {
		return settledNodes.contains(v);
	}

	private void setShortestDistance(City city, int distance) {
		shortestDistances.put(city, distance);
	}

	public int getShortestDistance(City city) {
		Integer d = shortestDistances.get(city);
		return (d == null) ? Integer.MAX_VALUE : d;
	}

	private void setPredecessor(City a, City b) {
		predecessors.put(a, b);
	}

	public City getPredecessor(City city) {
		return predecessors.get(city);
	}

	private City extractMin() {
		return unsettledNodes.poll();
	}

	public final class City implements Comparable<City> {
		/**
		 * The largest possible number of cities.
		 */
		public final int MAX_NUMBER = 26;

		private final City[] cities = new City[MAX_NUMBER];

		private int getIndexForName(char name) {
			return name - 'A';
		}

		private char getNameForIndex(int index) {
			return (char) ('A' + index);
		}

		public City valueOf(char name) {
			if (name < 'A' || name > 'Z') {
				throw new IllegalArgumentException("Invalid city name: " + name);
			}

			return cities[getIndexForName(name)];
		}

		/*
		 * Package members only.
		 */
		City valueOf(int n) {
			if (n < 0 || n > 25) {
				throw new IllegalArgumentException("Invalid city number: " + n);
			}

			return valueOf(getNameForIndex(n));
		}

		private final char name;

		/**
		 * Private constructor.
		 * 
		 * @param name
		 */
		private City(char name) {
			this.name = name;
		}

		public char getName() {
			return name;
		}

		/*
		 * Package members only.
		 */
		int getIndex() {
			return getIndexForName(name);
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.valueOf(name);
		}

		/**
		 * Two cities are considered equal if they are the same object, or their
		 * names are the same.
		 * 
		 * @see java.lang.Object#equals(Object)
		 */
		@Override
		public boolean equals(Object o) {
			return this == o || equals((City) o);
		}

		private boolean equals(City c) {
			return this.name == c.name;
		}

		/**
		 * Compare two cities by name.
		 * 
		 * @see java.lang.Comparable#compareTo(Object)
		 */
		public int compareTo(City c) {
			return this.name - c.name;
		}
	}

}
