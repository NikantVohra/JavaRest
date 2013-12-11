package wallet.utils;

import java.net.UnknownHostException;

import wallet.dao.DonateDAO;
import wallet.dao.OfferDAO;
import wallet.dao.UserDAO;
import wallet.dao.WalletDAO;

public class MongoDb {
	public static void main(String[] args) throws UnknownHostException	{
		
		DonateDAO odao = DAOFactory.createDonateDAO();
		
		System.out.println(odao.donate("645635434534647"));
	}

}

