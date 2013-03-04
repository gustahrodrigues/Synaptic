package com.synaptic.subscriber;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

public class Subscriber {
	
	private String topicName;
	private BundleContext bundleContext;
	
	public Subscriber(String topicName, BundleContext context){
		this.topicName = topicName;
		this.bundleContext = context;
	}
	
	public void setEventHandler(EventHandler handler){
		String[] topics = new String[] {topicName};

		Dictionary<String, String[]> props = new Hashtable<String, String[]>();
		props.put(EventConstants.EVENT_TOPIC, topics);
		bundleContext.registerService(EventHandler.class.getName(), handler , props);
	}
}
