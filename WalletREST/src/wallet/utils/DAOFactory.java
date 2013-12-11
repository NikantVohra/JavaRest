package wallet.utils;

import com.google.code.morphia.Datastore;

import wallet.dao.BusinessCardDAO;
import wallet.dao.CouponDAO;
import wallet.dao.DonateDAO;
import wallet.dao.GiftCardDAO;
import wallet.dao.LoyaltyCardDAO;
import wallet.dao.OfferDAO;
import wallet.dao.ReceiptDAO;
import wallet.dao.ShareDAO;
import wallet.dao.UserDAO;
import wallet.dao.WalletDAO;
import wallet.models.Artifact;

public class DAOFactory {
	private static DBAccess db = new DBAccess();
	
	public static WalletDAO createWalletDAO(){
	        return new WalletDAO(db.getMongo(), db.getMorphia(), "Wallets");
	}
	public static CouponDAO createCouponDAO(){
        return new CouponDAO(db.getMongo(), db.getMorphia(), "Artifacts");
	}
	public static OfferDAO createOfferDAO(){
        return new OfferDAO(db.getMongo(), db.getMorphia(), "Artifacts");
	}
	public static DonateDAO createDonateDAO(){
        return new DonateDAO(db.getMongo(), db.getMorphia(), "DonatedArtifacts");
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
	
	public static Artifact getArtifact(String artifactId){
		String category = Utils.getClassName(artifactId);
		Datastore artifactDS = DBAccess.getDataStore("Artifacts");
		Class categoryClass;
		try {
			categoryClass = Class.forName(category);
		    return (Artifact)artifactDS.find(categoryClass,"artifactId ==",artifactId).get();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
