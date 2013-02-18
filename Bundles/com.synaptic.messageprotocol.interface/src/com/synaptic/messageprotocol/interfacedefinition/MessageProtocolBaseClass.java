package com.synaptic.messageprotocol.interfacedefinition;

import java.lang.reflect.Type;

public abstract class MessageProtocolBaseClass {

	public abstract String serialize(Object modelInstance, Type modelClass);
	
	public abstract ModelBaseClass deserialize(String data, Type modelClass);
}
