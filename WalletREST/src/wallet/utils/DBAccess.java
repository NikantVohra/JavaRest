package wallet.utils;
import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;


public class DBAccess {
	private static Mongo mongo;
	private static Morphia morphia;
	
	public DBAccess(){
		try {
			mongo = new Mongo("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		morphia = new Morphia();
	}

	public Morphia getMorphia() {
		return morphia;
	}

	public Mongo getMongo() {
		return mongo;
	}
	
	public static Datastore getDataStore(String dbName){
		return morphia.createDatastore(mongo, dbName);
	}
}
