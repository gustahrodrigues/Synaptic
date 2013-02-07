package com.synaptic.rest.sample.sources;

import java.util.LinkedHashMap;

import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;
import com.synaptic.rest.sample.db.Database;
import com.synaptic.rest.sample.model.SampleModel;

public class Resource extends ServerResource {

	@Get
	public String getSampleModel(Representation entity)
	{
		String id = (String) getRequest().getAttributes().get("id");

		SampleModel model = Database.getInstance().getById(Integer.parseInt(id));

		return new Gson().toJson(model);
	}

	@Post("json")
	public Representation postSampleModel(Representation entity)
	{
		try
		{
			JsonRepresentation represent = new JsonRepresentation(entity);
			JSONObject jObject = represent.getJsonObject();

			SampleModel model = new Gson().fromJson(jObject.toString(), SampleModel.class);

			Database.getInstance().save(model);

			LinkedHashMap<String, String> result = new LinkedHashMap<>();
			result.put("result", "Model saved succesfully");
			result.put("model", new Gson().toJson(model));
			
			String jsonString = new Gson().toJson(result);
			
			return new StringRepresentation(jsonString, MediaType.APPLICATION_JSON);
		}
		catch(Exception ex)
		{
			LinkedHashMap<Object, String> list = new LinkedHashMap<Object, String>();
			list.put("service_status", "true");
			list.put("system_status", "true");
			list.put("result", "No Data Found!");
			String jsonString = new Gson().toJson(list);
			ex.printStackTrace();

			return new StringRepresentation(jsonString, MediaType.APPLICATION_JSON);
		}
	}

	@Put("json")
	public Representation putSampleModel(Representation entity)
	{
		try
		{
			JsonRepresentation represent = new JsonRepresentation(entity);
			JSONObject jObject = represent.getJsonObject();

			SampleModel model = new Gson().fromJson(jObject.toString(), SampleModel.class);

			Database.getInstance().update(model);

			LinkedHashMap<String, String> result = new LinkedHashMap<>();
			result.put("result", "Model updated succesfully");
			result.put("model", new Gson().toJson(model));
			
			String jsonString = new Gson().toJson(result);

			return new StringRepresentation(jsonString, MediaType.APPLICATION_JSON);
		}
		catch(Exception ex)
		{
			LinkedHashMap<Object, String> list = new LinkedHashMap<Object, String>();
			list.put("service_status", "true");
			list.put("system_status", "true");
			list.put("result", "No Data Found!");
			String jsonString = new Gson().toJson(list);
			ex.printStackTrace();

			return new StringRepresentation(jsonString, MediaType.APPLICATION_JSON);
		}
	}

	@Delete
	public String getSampleModel()
	{
		String id = (String) getRequest().getAttributes().get("id");

		Database.getInstance().delete(Integer.parseInt(id));

		LinkedHashMap<String, String> result = new LinkedHashMap<>();
		result.put("result", "Model deleted succesfully");

		String jsonString = new Gson().toJson(result);

		return jsonString;
	}
}
