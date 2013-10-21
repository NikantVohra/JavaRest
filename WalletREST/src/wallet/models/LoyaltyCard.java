package wallet.models;

import wallet.utils.Utils;

public class LoyaltyCard extends Artifact{
	
	private String cardNumber;
	
	public LoyaltyCard(String owner, String merchantName, String cardNumber, boolean shareable) {
		super(owner, merchantName, shareable);
		this.cardNumber = cardNumber;
		this.artifactId = "LC" + Utils.generateId();
	}

	public LoyaltyCard(String owner, String merchantName, String description, String cardNumber, boolean shareable) {
		super(owner, merchantName, description, shareable);
		this.cardNumber = cardNumber;
		this.artifactId = "LC" + Utils.generateId();
	}

	public String getCardNumber() {
		return cardNumber;
	}

}
