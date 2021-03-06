package wallet.dao;

import wallet.models.Artifact;
import wallet.models.Offer;
import wallet.models.User;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

public class OfferDAO extends BasicDAO<Artifact, String> {
	public OfferDAO(Mongo mongo, Morphia morphia, String DBname) {
		super(mongo, morphia, DBname);
	}

	public Offer findbyId(String artifactId) {
		return ds.find(Offer.class, "artifactId ==", artifactId).get();
	}

	public String add(String id, String owner, String merchantName,
			String merchantId, String description, String campaignCode,
			String countryCode, String currency, String title, String imageUrl,
			String termsAndConditions, String status, double amount,
			String startDate, String endDate) {
		UserDAO udao = DAOFactory.createUserDAO();
		User user = udao.findByEmailId(owner);
		System.out.println(id);
		System.out.println("Offer creation");
		System.out.println(this.findbyId("OF"+id));
		if (this.findbyId("OF"+id) == null) {
			Offer O = new Offer(id, owner, merchantName, merchantId,
					description, true, campaignCode, countryCode, currency,
					 title, imageUrl,
					termsAndConditions, status, amount, startDate, endDate);
		//	System.out.println("Offer creation");
			ds.save(O);
			WalletDAO wdao = DAOFactory.createWalletDAO();
			Wallet w = wdao.findbyId(user.getWalletId());
			w.add(O);
			
			wdao.saveToDB(w);
		}
		return id;
	}
}
