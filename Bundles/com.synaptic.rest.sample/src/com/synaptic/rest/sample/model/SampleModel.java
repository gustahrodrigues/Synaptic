package com.synaptic.rest.sample.model;

import com.synaptic.messageprotocol.interfacedefinition.ModelBaseClass;

public class SampleModel extends ModelBaseClass{
	
	private int id;
	private String name;
	
	public SampleModel(int id, String name){
		this.id = id;
		this.name = name;				
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SampleModel [id=" + id + ", name=" + name + "]";
	}
}
