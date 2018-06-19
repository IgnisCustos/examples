package com.example.algo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testGraphInt() {
		int maxVertices = 10;
		Graph g = new Graph(maxVertices);

		int noVertices = g.getNoVertices();
		assertEquals("initial value of noVertices ", 0, noVertices);
		checkGraphDimension(g, maxVertices);

	}

	@Test
	public void testGraphStringArray() {
		String[] nodes = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int noVertices = nodes.length;

		Graph g = new Graph(nodes);
		checkGraphDimension(g, noVertices);
		assertEquals("noVertices", noVertices, g.getNoVertices());
		Vertex[] vertices = g.getVertices();
		for (int i = 0; i < noVertices; i++) {
			assertEquals("vertex id " + i, nodes[i], vertices[i].getId());
		}
	}

	@Test
	public void testAddVertex() {
		int maxVertices = 10;
		Graph g = new Graph(maxVertices);
		Vertex[] vertices = g.getVertices();

		for (int i = 0; i < maxVertices; i++) {
			String vId = Integer.toString(i);
			Vertex v = new Vertex(vId);
			if (!g.addVertex(v))
				fail("failed to add vertex " + vId);
			assertEquals("noVertices", i + 1, g.getNoVertices());
			assertEquals("vertex id", vId, vertices[i].getId())
				;
		}
		Vertex v = new Vertex(Integer.toString(maxVertices));
		assertEquals("To many vertices possible", false, g.addVertex(v));
	}

	@Test
	public void testAddEdge() {
		String[] nodes = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		Graph g = new Graph(nodes);
		assertNotEquals("graph object should not be null", null, g);

		int[][] edges = g.getEdges();
		assertNotEquals("edges should not be null", null, edges);

		assertEquals("inital edge value 1-3", 0, edges[0][2]);
		g.addEdge("1", "3");
		assertEquals("edge value 1-3", 1, edges[0][2]);
		assertEquals("inital edge value 5-7", 0, edges[4][6]);
		g.addEdge("5", "7");
		assertEquals("edge value 5-7", 1, edges[4][6]);

	}

	@Test
	public void testDepthFirst() {
		Graph g1 = createTestGraph();
		Graph g2 = createTestGraph();
		Graph g3 = createTestGraph();

		runDepthfirst(g1, "1",
				new String[] { "1", "2", "3", "4", "5", "6", "7" });
		runDepthfirst(g2, "3", new String[] { "3" });
		runDepthfirst(g3, "9", new String[] { "8", "9" });

	}

	public void checkGraphDimension(Graph g, int maxVertices) {

		Vertex[] vertices = g.getVertices();
		int[][] edges = g.getEdges();

		assertNotEquals("vertices array ahould not be null", null, vertices);
		assertEquals("Vertex array dimension ", maxVertices, vertices.length);
		assertNotEquals("edges matrix is null", null, edges);
		assertEquals("edges matrix row count", maxVertices, edges.length);
		for (int row = 0; row < edges.length; row++) {
			assertNotEquals("edges[" + row + "] is null", null, edges[row]);
			assertEquals("edges[" + row + "] length", maxVertices,edges[row].length);
		}
	}

	public Graph createTestGraph() {
		String[] nodes = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		// create a graph from an array of node ids
		Graph g = new Graph(nodes);
		// add the edges between the nodes
		g.addEdge("1", "3");
		g.addEdge("1", "7");
		g.addEdge("1", "2");
		g.addEdge("4", "6");
		g.addEdge("5", "4");
		g.addEdge("6", "6");
		g.addEdge("6", "5");
		g.addEdge("6", "1");
		g.addEdge("7", "5");
		g.addEdge("9", "8");

		return g;
	}

	public void runDepthfirst(Graph g, String s, String[] expectedNodes) {

		// create a visitor for depth-first search
		LinkedList<Vertex> vList = new LinkedList<Vertex>();
		GraphVisitor visitor = new GraphVisitor(vList);

		// run depth first search
		g.depthFirst(s, visitor);

		// check the result of the depth-first search
		assertEquals("number of nodes found", expectedNodes.length,
				vList.size());
		for (String node : expectedNodes) {
			boolean found = false;
			for (Vertex v : vList) {
				if (v.hasId(node)) {
					found = true;
					break;
				}
			}
			assertEquals("vertex " + node + " not found", true, found);
		}
	}

}
