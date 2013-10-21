package wallet.utils;

import java.net.UnknownHostException;

import wallet.dao.UserDAO;
import wallet.dao.WalletDAO;

public class MongoDb {
	public static void main(String[] args) throws UnknownHostException	{
		UserDAO udao = DAOFactory.createUserDAO();
		String[] feed = {"Jack shared with Akshay", "Nikant shared with Aditya"};
		udao.addToFeed("jack@paypal.com", feed);
		System.out.println(udao.findByEmailId("jack@paypal.com"));
	}

}

