package wallet.dao;
import java.util.ArrayList;
import java.util.Set;

import wallet.models.Artifact;
import wallet.models.SharedArtifact;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;
import wallet.utils.DBAccess;
import wallet.utils.Utils;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;


public class WalletDAO extends BasicDAO<Wallet, String>{

	public WalletDAO(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
	}
	
	public Set<String> getCategories(){
		Mongo db = ds.getMongo();
		return db.getDB("Artifacts").getCollectionNames();
	}
	
	public Wallet findbyId(Integer id){
	    return ds.find(Wallet.class,"walletId ==",id).get();	
	}
	
	public String getOwnedArtifactsAsJSON(Integer walletId){
		Wallet w = findbyId(walletId);
		return Utils.ObjToJSON(w.getArtifacts().toArray());
	}
	
	public String getSharedArtifactsAsJSON(Integer walletId){
		Wallet w = findbyId(walletId);
		return Utils.ObjToJSON(w.getSharedArtifacts().toArray());
	}
	public String getAllSharedArtifactsAsJSON(Integer walletId){
		Wallet w = findbyId(walletId);
		ArrayList<Artifact> result = new ArrayList<Artifact>();
		ArrayList<SharedArtifact> sharedArtifacts= w.getSharedArtifacts();
		for(SharedArtifact s : sharedArtifacts){
			Artifact a = DAOFactory.getArtifact(s.getId());
			result.add(a);
		}
		return Utils.ObjToJSON(result.toArray());
	}
	
	public String getArtifactByCategoryAsJSON(Integer walletId, String category){
		Wallet w = findbyId(walletId);
		return Utils.ObjToJSON(w.getArtifactsbyCategory(category).toArray());
	}
	
	public void saveToDB(Wallet w){
		ds.save(w);
	}
}
