package wallet.dao;
import java.util.List;

import wallet.models.Artifact;
import wallet.models.BusinessCard;
import wallet.models.User;
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
	public String add(String owner, String merchantName,String name ,String[] numbers,String[] emailIds){
		BusinessCard B = new BusinessCard(owner,merchantName,name,numbers,emailIds,true);
		ds.save(B);
		UserDAO udao = DAOFactory.createUserDAO();
		User user = udao.findByEmailId(owner);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet w = wdao.findbyId(user.getWalletId());
		w.add(B);
		wdao.saveToDB(w);
		return B.getArtifactId();
	}
}
