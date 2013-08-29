package wallet.utils;

import wallet.dao.BusinessCardDAO;
import wallet.dao.CouponDAO;
import wallet.dao.GiftCardDAO;
import wallet.dao.LoyaltyCardDAO;
import wallet.dao.ReceiptDAO;
import wallet.dao.ShareDAO;
import wallet.dao.UserDAO;
import wallet.dao.WalletDAO;

public class DAOFactory {
	private static DBAccess db = new DBAccess();
	
	public static WalletDAO createWalletDAO(){
	        return new WalletDAO(db.getMongo(), db.getMorphia(), "Wallets");
	}
	public static CouponDAO createCouponDAO(){
        return new CouponDAO(db.getMongo(), db.getMorphia(), "Artifacts");
	}
	public static BusinessCardDAO createBusinessCardDAO(){
        return new BusinessCardDAO(db.getMongo(), db.getMorphia(), "Artifacts");
	}
	public static GiftCardDAO createGiftCardDAO(){
        return new GiftCardDAO(db.getMongo(), db.getMorphia(), "Artifacts");
	}
	public static LoyaltyCardDAO createLoyaltyCardDAO(){
        return new LoyaltyCardDAO(db.getMongo(), db.getMorphia(), "Artifacts");
	}
	public static ReceiptDAO createReceiptDAO(){
        return new ReceiptDAO(db.getMongo(), db.getMorphia(), "Artifacts");
	}
	public static ShareDAO createShareDAO(){
        return new ShareDAO(db.getMongo(), db.getMorphia(), "Shares");
	}
	public static UserDAO createUserDAO(){
        return new UserDAO(db.getMongo(), db.getMorphia(), "Users");
	}

}
