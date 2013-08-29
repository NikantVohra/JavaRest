package wallet.models;

import com.google.code.morphia.annotations.Entity;
import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Id;

@Entity
public class User {
	@Id
	private ObjectId Id;
	private String name;
	private String emailId;
	private Integer walletId;
	
	public User(){
	}
	
	public  User(String name,String emailId,Integer walletId){
		this.name = name;
		this.emailId = emailId;
		this.walletId = walletId;
	}

	public String getName() {
		return name;
	}

	public String toString(){
		return "Name: " + name + "Email: " + emailId + "WalletID: " + walletId;
	}

	public String getEmailId() {
		return emailId;
	}


	public Integer getWalletId() {
		return walletId;
	}


	

}
