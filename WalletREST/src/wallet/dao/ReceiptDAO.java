package wallet.dao;
import java.util.List;

import wallet.models.Artifact;
import wallet.models.Receipt;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;


public class ReceiptDAO extends BasicDAO<Artifact, String>{
	public ReceiptDAO(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
	}
	
	public List<Receipt> findbyMerchantName(String name){
	    return ds.find(Receipt.class,"merchantName ==",name).asList();	
	}
	
	public Receipt findbyId(String id){
	    return ds.find(Receipt.class,"artifactId ==",id).get();	
	}
	public String add(Integer owner, String merchantName, String receiptNumber,Double amount,String receiptDated){
		Receipt C = new Receipt(owner,merchantName,receiptNumber,amount,receiptDated,true);
		ds.save(C);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet w = wdao.findbyId(owner);
		w.add(C);
		wdao.saveToDB(w);
		return C.getArtifactId();
	}
}
