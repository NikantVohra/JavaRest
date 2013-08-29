package wallet.dao;
import java.util.List;

import wallet.models.Artifact;
import wallet.models.GiftCard;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

public class GiftCardDAO extends BasicDAO<Artifact, String> {

	public GiftCardDAO(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
	}
	
	public List<GiftCard> findbyMerchantName(String name){
	    return ds.find(GiftCard.class,"merchantName ==",name).asList();	
	}
	
	public GiftCard findbyId(String id){
	    return ds.find(GiftCard.class,"artifactId ==",id).get();	
	}
	public String add(Integer owner, String merchantName, String cardNumber, Double amount, String validity){
		GiftCard C = new GiftCard(owner,merchantName,cardNumber,amount,validity,true);
		ds.save(C);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet w = wdao.findbyId(owner);
		w.add(C);
		wdao.saveToDB(w);
		return C.getArtifactId();
	}
}
