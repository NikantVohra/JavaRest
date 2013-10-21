package wallet.models;

import java.util.ArrayList;

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
	private Double balance;
	private ArrayList<String> WalletFeed;
	
	public User(){
		this.WalletFeed = new ArrayList<String>();
	}
	
	public  User(String name,String emailId,Integer walletId,Double balance){
		this.name = name;
		this.emailId = emailId;
		this.walletId = walletId;
		this.balance = balance;
		this.WalletFeed = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public String toString(){
		return "Name: " + name + " Email: " + emailId + " WalletID: " + walletId + " Feed: " + WalletFeed;
	}

	public String getEmailId() {
		return emailId;
	}


	public Integer getWalletId() {
		return walletId;
	}

	public ArrayList<String> getWalletFeed() {
		return WalletFeed;
	}
	
	
	public void setWalletFeed(ArrayList<String> walletFeed) {
		WalletFeed = walletFeed;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void addToFeed(String S){
		WalletFeed.add(S);
	}
	

}
