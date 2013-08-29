package wallet.utils;

import java.net.UnknownHostException;

import wallet.dao.CouponDAO;

public class MongoDb {
	public static void main(String[] args) throws UnknownHostException	{
		CouponDAO cdao = DAOFactory.createCouponDAO();
		System.out.println(Utils.ObjToJSON(cdao.findbyId("CP33819220")));
	}

}

