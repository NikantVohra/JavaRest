package wallet.dao;
import java.util.List;

import wallet.models.Artifact;
import wallet.models.Coupon;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;


public class CouponDAO extends BasicDAO<Artifact, String> {
	public CouponDAO(Mongo mongo,Morphia morphia,String DBname) {
        super(mongo, morphia, DBname);
    }
	
	public List<Coupon> findbyMerchantName(String name){
	    return ds.find(Coupon.class,"merchantName ==",name).asList();	
	}
	
	public Coupon findbyId(String artifactId){
	    return ds.find(Coupon.class,"artifactId ==",artifactId).get();	
	}
	
	public String add(Integer owner, String merchantName, String couponCode, String offerPercentage, String validity){
		Coupon C = new Coupon(owner,merchantName,couponCode,offerPercentage,validity,true);
		ds.save(C);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet w = wdao.findbyId(owner);
		w.add(C);
		wdao.saveToDB(w);
		return C.getArtifactId();
	}
}
