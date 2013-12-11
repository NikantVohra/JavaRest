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

	public boolean createUser(String name,String emailId,Double balance){
		
		if(findByEmailId(emailId) == null){
			Wallet W = new Wallet();
			DBAccess.getDataStore("Wallets").save(W);
			User U = new User(name,emailId,W.getWalletId(),balance);
			ds.save(U);	
			return true;
		}	
		return false;
	}
	
	public String getWalletasJSON(String emailId){
		User U = findByEmailId(emailId);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet w = wdao.findbyId(U.getWalletId());
		return Utils.ObjToJSON(w);
	}

	public boolean addToFeed(String emailId, String[] feedArray) {
		User U = findByEmailId(emailId);
		for(String s : feedArray){
			U.addToFeed(s);
		}
		ds.save(U);
		return true;
	}

}
