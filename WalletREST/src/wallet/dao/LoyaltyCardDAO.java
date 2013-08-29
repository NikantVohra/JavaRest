package wallet.dao;
import java.util.List;

import wallet.models.Artifact;
import wallet.models.LoyaltyCard;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

public class LoyaltyCardDAO extends BasicDAO<Artifact, String> {

	public LoyaltyCardDAO(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
	}
	
	public List<LoyaltyCard> findbyMerchantName(String name){
	    return ds.find(LoyaltyCard.class,"merchantName ==",name).asList();	
	}
	
	public LoyaltyCard findbyId(String id){
	    return ds.find(LoyaltyCard.class,"artifactId ==",id).get();	
	}
	public String add(Integer owner, String merchantName, String cardNumber){
		LoyaltyCard C = new LoyaltyCard(owner,merchantName,cardNumber,true);
		ds.save(C);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet w = wdao.findbyId(owner);
		w.add(C);
		wdao.saveToDB(w);
		return C.getArtifactId();
	}
	
}
