package com.synaptic.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class Database {

	private String DB_NAME = "synaptic_database";

	private String collectionName;
	private DB db;

	public Database(String collectionName){
		this.collectionName = collectionName;

		try{
			Mongo mongo = new Mongo();

			db = mongo.getDB(DB_NAME);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get all data from collection name
	 * @param basicDBObject Query to be performed
	 * @return
	 */
	public ArrayList<String> getAllCollectionsData(BasicDBObject basicDBObject){
		ArrayList<String> listEnergyData =  new ArrayList<String>();

		DBCollection items = db.getCollection(collectionName);

		DBCursor cursor = items.find().sort(basicDBObject) ;

		while (cursor.hasNext()) {
			listEnergyData.add(cursor.next().toString());
		}

		return listEnergyData;
	}

	/**
	 * Save on Mongo Dabatase
	 * @param query Query to be saved
	 */
	public void save(BasicDBObject query) {
		DBCollection items = db.getCollection(collectionName);

		items.insert(query);
	}
}
