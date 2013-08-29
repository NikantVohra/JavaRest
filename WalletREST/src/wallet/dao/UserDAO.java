package wallet.dao;

import wallet.models.User;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;
import wallet.utils.DBAccess;
import wallet.utils.Utils;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;


public class UserDAO extends BasicDAO<User, String> {
	public UserDAO(Mongo mongo,Morphia morphia,String DBname) {
        super(mongo, morphia, DBname);
    }
	
	public User findByName(String name){
	    return ds.find(User.class,"name ==",name).get();	
	}
	public User findByEmailId(String emailId){
	    return ds.find(User.class,"emailId ==",emailId).get();	
	}
	public User findByWalletId(Integer walletId){
	    return ds.find(User.class,"walletId ==",walletId).get();	
	}
	
	public Integer createUser(String name,String emailId){
		Wallet W = new Wallet();
		DBAccess.getDataStore("Wallets").save(W);
		User U = new User(name,emailId,W.getWalletId());
		ds.save(U);	
		return W.getWalletId();
	}
	
	public String getWalletasJSON(String emailId){
		User U = findByEmailId(emailId);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet w = wdao.findbyId(U.getWalletId());
		return Utils.ObjToJSON(w);
	}

}
