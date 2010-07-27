package com.zeekmod.jgeekquest.tmp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private Map<String, Vertex> cityNameMap = new HashMap<String, Vertex>();

	private Vertex[] cities;

	private boolean useFile = false;

	private DataInputStream dis = null;

	private java.io.BufferedReader r = null;

	public Map<String, Integer> cache = null;

	public void l(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.doWork();
	}

	public void cleanup() throws IOException {
		cityNameMap = new HashMap<String, Vertex>();
		cities = null;
		dis = null;
		cache = null;
	}

	public String getLine() throws IOException {
		if (useFile) {
			return dis.readLine();
		} else {
			return r.readLine();
		}
	}

	public void doWork() throws Exception {
		try {
			if (useFile) {
				File file = new File("/tmp/SHPATH.txt");
				FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				dis = new DataInputStream(bis);
			} else {
				r = new java.io.BufferedReader(new java.io.InputStreamReader(
						System.in));
			}

			int numberOfCases = Integer.parseInt(getLine());
			// l("Cases: " + numberOfCases);

			for (int caseCount = 0; caseCount < numberOfCases; caseCount++) {
				{
					// Cities Array
					int n = Integer.parseInt(getLine());
					// l("Cities: " + n);
					cities = new Vertex[n];

					// Start Cache
					cache = new HashMap<String, Integer>();

					// City Loop - Vertices
					for (int i = 0; i < n; i++) {
						// Get City Name
						String cityName = getLine();

						// Number of Edges
						int edges = Integer.parseInt(getLine());

						// Init Edges Array
						Edge[] myEdges = new Edge[edges];

						// Bind City
						cities[i] = new Vertex(cityName, edges, i);
						cityNameMap.put(cityName, cities[i]);

						// Define Edges
						for (int j = 0; j < edges; j++) {
							String line = getLine();
							String[] lineItems = line.split(" ");
							int connectTo = Integer.parseInt(lineItems[0]);
							int cost = Integer.parseInt(lineItems[1]);
							myEdges[j] = new Edge(connectTo, cost);
						}

						// Bind Edges
						cities[i].edges = myEdges;
					}

					// Calculate Paths
					{
						for (Vertex v : cities) {
							v.minDistance = 0;
							computePaths();
						}
					}

					// Ok Let's query this thing
					int query = Integer.parseInt(getLine());
					while (query > 0) {
						query--;
						String line = getLine();
						String[] lineItems = line.split(" ");
						String from = lineItems[0];
						String to = lineItems[1];
						System.out.println(getShortestPath(from, cityNameMap
								.get(to)));
					}

					// Read empty line if we have another test
					if (caseCount < numberOfCases - 1) {
						getLine();
					}
				}

				// Cleanup
				this.cleanup();
			}

		} finally {
			if (r != null) {
				r.close();
			}
			if (dis != null) {
				dis.close();
			}
		}
	}

	public void computePaths() {
		// l("Cities Length: " + cities.length);
		int count = 0;
		for (Vertex u : cities) {
			// Visit each edge exiting u
			// l("City: " + u + " has " + u.getEdges().length + " edge(s)");
			for (Edge e : u.getEdges()) {
				Vertex v = e.getTargetVertex();
				int weight = e.weight;

				// Relax Edge
				int distance = u.minDistance + weight;
				if (distance < v.minDistance
						|| v.minDistance == Integer.MAX_VALUE) {
					// l("**** To: " + v.name + " - Weight: " + distance +
					// " - Previous: " + u.name);
					v.minDistance = distance;
					v.previous = u;
					cities[count] = v;
				}
			}
			count++;
		}
	}

	public int getShortestPath(String from, Vertex target) {
		Integer results = this.cache.get(from);
		if (results != null) {
			return results;
		}
		boolean add = false;
		int total = 0;
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
			if (vertex.name.equals(target.name)) {
				add = true;
			}
			if (vertex.name.equals(from)) {
				break;
			}
			if (add) {
				total += vertex.minDistance;
			}
		}
		cache.put(from, total);
		return total;
	}

	class Edge {

		public Integer targetIndex;

		public Integer weight;

		public Edge(Integer targetIndex, int weight) {
			this.targetIndex = targetIndex;
			this.weight = weight;
		}

		public Vertex getTargetVertex() {
			return cities[targetIndex - 1];
		}

		@Override
		public String toString() {
			return "Edge: " + this.targetIndex + " - Weight: " + this.weight
					+ " - Target Index: " + this.targetIndex;
		}
	}

	class Vertex {

		public String name;

		public int maxEdges;

		public Edge[] edges;

		public Vertex previous;

		public int index;

		public Integer minDistance = Integer.MAX_VALUE;

		public Vertex(String name, int maxEdges, int index) {
			this.name = name;
			this.maxEdges = maxEdges;
			this.edges = new Edge[maxEdges];
		}

		public Edge[] getEdges() {
			return this.edges;
		}

		@Override
		public String toString() {
			return this.name + " - distance: " + this.minDistance;
		}
	}

}
