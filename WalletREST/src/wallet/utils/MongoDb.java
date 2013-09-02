package wallet.utils;

import java.net.UnknownHostException;

import wallet.dao.WalletDAO;

public class MongoDb {
	public static void main(String[] args) throws UnknownHostException	{
		WalletDAO wdao = DAOFactory.createWalletDAO();
		System.out.println(Utils.ObjToJSON(wdao.getOwnedArtifactsAsJSON(78710944)));
	}

}

