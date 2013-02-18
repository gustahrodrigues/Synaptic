package com.synaptic.messageprotocol.json;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.synaptic.messageprotocol.interfacedefinition.MessageProtocolBaseClass;
import com.synaptic.messageprotocol.interfacedefinition.ModelBaseClass;

public class JSONBuilder extends MessageProtocolBaseClass {

	@Override
	public String serialize(Object modelInstance, Type modelClass) {
		return new Gson().toJson(modelInstance, modelClass);
	}
	
	@Override
	public ModelBaseClass deserialize(String data, Type modelClass) {
		return new Gson().fromJson(data, modelClass);
	}
	
}
