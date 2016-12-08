package com.example.tests;

import java.util.LinkedList;

import com.example.algo.IVisitor;
import com.example.algo.Vertex;

/**
 * Graph visitor for printing all node ids
 * 
 * @author Ignis
 * 
 */
public class GraphVisitor implements IVisitor {

	LinkedList<Vertex> vList;

	/**
	 * Create a visitor that only prints the node ids
	 */
	public GraphVisitor() {
		this.vList = null;
	}

	/**
	 * Create a visitor that adds the visited nodes to a linked list
	 * 
	 * @param vList
	 *            ... linked list of nodes
	 */
	public GraphVisitor(LinkedList<Vertex> vList) {
		this.vList = vList;
	}

	/**
	 * If a linked list is available the visited node is added to the list, or
	 * printed otherwise
	 */
//	@Override
	public void visit(Vertex v) {
		if (vList != null) {
			vList.add(v);
		} else {
			System.out.print(v.getId() + " ");
		}
	}

}
