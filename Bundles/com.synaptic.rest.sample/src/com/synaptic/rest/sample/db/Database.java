package com.synaptic.rest.sample.db;

import java.util.HashMap;

import com.synaptic.rest.sample.model.SampleModel;

public class Database {
	
	private HashMap<Integer, SampleModel> models;
	
	private static final Database instance = new Database();
	
	private Database(){
		models = new HashMap<>();
		
		SampleModel sample = new SampleModel(1, "teste1");
		this.save(sample);
	}

	public static Database getInstance(){
		return instance;
	}
	
	public SampleModel getById(int id){
		return models.get(id);
	}
	
	public boolean save(SampleModel model){
		if (models.containsKey(model.getId())){
			return false;
		}
		
		models.put(model.getId(), model);
		
		return true;
	}
	
	public void delete(int id){
		models.remove(id);		
	}
	
	public boolean update(SampleModel model){
		if (!models.containsKey(model.getId())){
			return false;
		}
		
		SampleModel oldModel = models.get(model.getId());
		
		oldModel.setName(model.getName());
		
		return true;
		
	}
	
}
