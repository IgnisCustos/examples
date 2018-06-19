package com.example.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employee {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty surName;
	private SimpleDoubleProperty salery;
	
	
	public Employee(int id, String name, String surName, double salery) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.surName = new SimpleStringProperty(surName);
		this.salery = new SimpleDoubleProperty(salery);
	}
	
		
	
	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}
	public String getSurName() {
		return surName.get();
	}
	public void setSurName(String surName) {
		this.surName = new SimpleStringProperty(surName);
	}
	public double getSalery() {
		return salery.get();
	}
	public void setSalery(double salery) {
		this.salery = new SimpleDoubleProperty(salery);
	}
	
	
	
	@Override
	public String toString(){
		String tmp = String.format("%-20s %-20s %-20s %-20s", id, name, surName, salery);
		return tmp;
	}
	

	
	

}
