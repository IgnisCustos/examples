package com.example.algo;

/**
 * Class defining the nodes (vertices) in a graph 
 * 
 * Attributes: id ... (uniquely) identifying the node, String value 
 * marker .... used for marking nodes with a number while processing the graph
 * 
 * @author Ignis
 * 
 */
public class Vertex implements IVisitable {
	private String id; // identifies the node
	private int marker; // used for marking nodes while processing the graph

	/**
	 * Create a node with a given id
	 * 
	 * @param id
	 */
	public Vertex(String id) {
		this.id = id;
		this.marker = 0;
	}

	/**
	 * Getter method for id attribute
	 * @return id of node
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Check if Vertex has id
	 * @param id 
	 * @return
	 */
	public boolean hasId(String id) {
		return this.id.compareTo(id)==0;
	}

	/**
	 * Setter method for id attribute
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter method for marker attribute
	 * @return
	 */
	public int getMarker() {
		return marker;
	}

	/**
	 * Setter method for marker attribute
	 * @param mark
	 */
	public void setMarker(int marker) {
		this.marker = marker;
	}

	/**
	 * accept method for visitor pattern
	 */
//	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}



}
