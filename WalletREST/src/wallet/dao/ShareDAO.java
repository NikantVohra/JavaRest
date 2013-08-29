package wallet.dao;
import java.util.ArrayList;
import java.util.List;

import wallet.models.Artifact;
import wallet.models.Share;
import wallet.models.ShareProperties;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;
import wallet.utils.DBAccess;
import wallet.utils.Utils;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;


public class ShareDAO extends BasicDAO<Share, String>{

	public ShareDAO(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
	}
	
	public boolean share(String shareFrom,String shareWith, String artifactToShare, ShareProperties prop){
		UserDAO udao = DAOFactory.createUserDAO();
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet from = wdao.findbyId(udao.findByEmailId(shareFrom).getWalletId());
		Wallet with = wdao.findbyId(udao.findByEmailId(shareWith).getWalletId());
		Wallet updated;
		String category = Utils.getClassName(artifactToShare);
		Datastore artifactDS = DBAccess.getDataStore("Artifacts");
		Class categoryClass;
		try {
			categoryClass = Class.forName(category);
		    Artifact toShare = (Artifact)artifactDS.find(categoryClass,"artifactId ==",artifactToShare).get();
			updated = from.share(with, toShare, prop);
			if(updated != null)
				wdao.saveToDB(updated);
			else
				return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ds.save(new Share(shareFrom,shareWith,artifactToShare,prop));
		return true;
	}
	
	public boolean share(String shareFrom,String[] shareWith, String artifactToShare, ShareProperties prop){
		boolean status = true;
		for(int i = 0; i < shareWith.length; i++){
			if(!share(shareFrom, shareWith[i], artifactToShare, prop)){
				status = false;
			}
		}
		return status;
	}
	
	public Object[] getSharedWith(String artifactId){
		List<Share> shared = ds.find(Share.class, "toShare ==", artifactId).asList();
		ArrayList<String> sharedWith = new ArrayList<String>();
		for(Share s: shared){
			sharedWith.add(s.getShareWith());
		}
		return sharedWith.toArray();
	}
}
