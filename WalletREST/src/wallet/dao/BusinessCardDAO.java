package wallet.dao;
import java.util.List;

import wallet.models.Artifact;
import wallet.models.BusinessCard;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

public class BusinessCardDAO extends BasicDAO<Artifact, String> {

	public BusinessCardDAO(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
	}
	
	public List<BusinessCard> findbyMerchantName(String name){
	    return ds.find(BusinessCard.class,"merchantName ==",name).asList();	
	}
	
	public BusinessCard findbyId(String id){
	    return ds.find(BusinessCard.class,"artifactId ==",id).get();	
	}
	public String add(Integer owner, String merchantName,String name ,String[] numbers,String[] emailIds){
		BusinessCard B = new BusinessCard(owner,merchantName,name,numbers,emailIds,true);
		ds.save(B);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet w = wdao.findbyId(owner);
		w.add(B);
		wdao.saveToDB(w);
		return B.getArtifactId();
	}
}
