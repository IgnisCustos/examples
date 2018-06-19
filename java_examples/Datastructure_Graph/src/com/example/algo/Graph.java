package com.example.algo;

/**
 * Class representing a graph
 * 
 * @author Ignis
 * 
 */
public class Graph
{

    private Vertex[] vertices; // ... Vertices of the graph
    private int[][] edges; // ... Edges of the graph
    private int noVertices; // ...Number of vertices

    /**
     * Create a graph for up to maxVertices nodes
     * 
     * @param maxVertices
     *            ... max number of nodes
     */
    public Graph(int maxVertices)
    {
	this.vertices = new Vertex[maxVertices];
	this.noVertices = 0;
	// initial every Edge with 0
	this.edges = new int[maxVertices][maxVertices];
	for (int i = 0; i < this.edges.length; i++)
	{
	    for (int j = 0; j < this.edges[0].length; j++)
	    {
		this.edges[i][j] = 0;
	    }
	}

    }

    /**
     * Create a graph from an array of node ids
     * 
     * @param vIds
     *            ... array of node ids
     */
    public Graph(String[] vIds)
    {
	this.vertices = new Vertex[vIds.length];
	this.noVertices = vIds.length;
	for (int i = 0; i < vIds.length; i++)
	{
	    vertices[i] = new Vertex(vIds[i]);
	}
	// initial every Edge with 0
	this.edges = new int[vIds.length][vIds.length];
	for (int i = 0; i < this.edges.length; i++)
	{
	    for (int j = 0; j < this.edges[0].length; j++)
	    {
		this.edges[i][j] = 0;
	    }
	}
    }

    /**
     * Add a node to the graph
     * 
     * @param v
     *            ... node to add
     * @return
     */
    public boolean addVertex(Vertex v)
    {
	boolean jobDone = false;
	for (int i = 0; i < this.vertices.length; i++)
	{
	    if (this.vertices[i] == null)
	    {
		this.vertices[i] = v;
		this.noVertices = i + 1;
		jobDone = true;
		break;
	    }
	}
	return jobDone;
    }

    /**
     * Add an edge from node fromId to node toId
     * 
     * @param fromId
     *            ... id of source node of the edge
     * @param toId
     *            ... id of target node of the edge
     * @return true if successful, false otherwise
     * 
     */
    public boolean addEdge(String fromId, String toId)
    {
	boolean jobDone = false;

	for (int i = 0; i < this.vertices.length; i++)
	{
	    if (this.vertices[i].getId().equals(fromId))
	    {
		for (int j = 0; j < this.vertices.length; j++)
		{
		    if (this.vertices[j].getId().equals(toId))
		    {
			this.edges[i][j] = 1;
			jobDone = true;
		    }
		}
	    }
	}
	return jobDone;
    }

    /**
     * Print all
     * 
     * @param startId
     */
    public void depthFirst(String startId, IVisitor visitor)
    {
	for (int i = 0; i < vertices.length; i++)
	{
	    if (this.vertices[i].getId().equals(startId) && this.vertices[i].getMarker() != 1)
	    {
		this.vertices[i].accept(visitor);
		this.vertices[i].setMarker(1);
		for (int j = 0; j < edges.length; j++)
		{
		    if (this.edges[i][j] == 1)
		    {
			depthFirst(this.vertices[j].getId(), visitor);
		    }
		}
	    }
	}
    }

    /**
     * Getter for vertices array attribute
     * 
     * @return Vertex array
     */
    public Vertex[] getVertices()
    {
	return vertices;
    }

    /**
     * Getter for edges matrix attribute
     * 
     * @return edge Matrix
     */
    public int[][] getEdges()
    {
	return edges;
    }

    /**
     * Getter for number of vertices attribute
     * 
     * @return
     */
    public int getNoVertices()
    {
	return noVertices;
    }

}
