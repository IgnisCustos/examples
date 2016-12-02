package com.example.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Example for partial picking from an storage or warehouse
 * @author Stefan Jodl
 *
 */
public class PartialPickingExample {

	private int count = 0;
	List<Unit> units = new ArrayList<Unit>();;

	public static void main(String[] args) {
		PartialPickingExample partialPickingExample = new PartialPickingExample();
		partialPickingExample.start();
	}

	private void start() {

		// Set up a megasimple fictitious storage
		units.add(new Unit(2));
		units.add(new Unit(0));
		units.add(new Unit(4));
		units.add(new Unit(10));
		units.add(new Unit(10));

		listStock(units);
		outAction(units, 4);
		listStock(units);
		outAction(units, 6);
		listStock(units);

	}

	/*
	 * picking items from storage/warehouse
	 */
	public void outAction(List<Unit> units, int demandedQuantity) {
		count=0; // reseting for example (because next method call is like a new quering to data fake database)
		if (demandedQuantity>overallStock(units)){
			throw new IllegalArgumentException("Not enough stock available!\nDemanded: "+demandedQuantity+" aviable: " + overallStock(units));
		}
		
		int remainingQuantity = demandedQuantity;
		int stockQuantity = 0;
		int partialQuantity = 0;
		do {
			Unit unit = getNextUnit();
			stockQuantity = unit.getStock();

			if (stockQuantity > remainingQuantity) {
				partialQuantity = remainingQuantity;
			} else {
				partialQuantity = stockQuantity;
			}
			unit.removeStock(partialQuantity);

			remainingQuantity = remainingQuantity - partialQuantity;

		} while (remainingQuantity > 0);
	}

	/*
	 * Simulating a jpa query for next possible unit
	 */
	private Unit getNextUnit() {
		return units.get(count++);
	}

	public void inAction(int quantity) {
		// not implemented in this example
	}

	/*
	 * list the stock for every unit to console
	 */
	private void listStock(List<Unit> units) {
		for (int i = 0; i < units.size(); i++) {
			System.out.println("Stock of " + i + " :" + units.get(i).getStock());
		}
		System.out.println("\n----------\n");
	}

	
	/*
	 * Simulating a jpa-query for getting all the stuff from a specific unit in storage/warehouse
	 */
	private int overallStock(List<Unit> units) {
		int result = 0;
		for (Unit unit : units) {
			result = result + unit.getStock();
		}
		return result;
	}

	/**
	 * Nested class UNITS
	 * 
	 * @author Stefan Jodl
	 *
	 */
	class Unit {

		private int stock;

		public Unit(int stock) {
			setStock(stock);
		}

		public int getStock() {
			return stock;
		}

		/*
		 * 
		 */
		public void setStock(int stock) {
			this.stock = stock;
		}

		public void removeStock(int quantity) {
			this.stock = stock - quantity;
		}

	}

}
