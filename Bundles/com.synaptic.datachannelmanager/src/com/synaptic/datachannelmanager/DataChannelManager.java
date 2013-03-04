package com.synaptic.datachannelmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataChannelManager {
	
	private static final HashMap<String, ArrayList<String> > dataChannel = new HashMap<>();
	
	private DataChannelManager(){}
	
	/**
	 * Get topic name by data
	 * @param data Data that must be supported by topic
	 * @return Topic name with all topic data matches or NULL if any topic match 
	 */
	public static String getTopicByData(ArrayList<String> data){
		for (Map.Entry<String, ArrayList<String>> entry : dataChannel.entrySet())
		{
			ArrayList<String> topicData = entry.getValue();
		   
			if (topicData.containsAll(data)){
				return entry.getKey();
			}
		}
		
		return null;
	}
	
	public static boolean putTopicName(String topicName, ArrayList<String> data){
		if (dataChannel.containsKey(topicName)){
			return false;
		}
		
		dataChannel.put(topicName, data);
		
		return true;
	}
	
}
