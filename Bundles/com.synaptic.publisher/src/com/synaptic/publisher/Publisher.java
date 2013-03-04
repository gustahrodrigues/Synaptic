package com.synaptic.publisher;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

public class Publisher {

	private String topicName;
	private EventAdmin eventAdmin;
	
	public Publisher(String topicName, BundleContext context){
		this.topicName = topicName;
		
		ServiceReference ref = context.getServiceReference(EventAdmin.class.getName());
		
		if(ref != null){
			eventAdmin = (EventAdmin) context.getService(ref);
		}else{
			throw new NullPointerException("ServiceReference not found");
		}
	}
	
	public void sendEvent(Dictionary<String, String> properties){
		Event reportGeneratedEvent = new Event(topicName, properties);

		eventAdmin.sendEvent(reportGeneratedEvent);
	}
	
}
