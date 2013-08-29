package wallet.models;

import wallet.utils.Utils;

public class LoyaltyCard extends Artifact{
	
	private String cardNumber;
	
	public LoyaltyCard(Integer ownerWalletId, String merchantName, String cardNumber, boolean shareable) {
		super(ownerWalletId, merchantName, shareable);
		this.cardNumber = cardNumber;
		this.artifactId = "LC" + Utils.generateId();
	}

	public LoyaltyCard(Integer ownerWalletId, String merchantName, String description, String cardNumber, boolean shareable) {
		super(ownerWalletId, merchantName, description, shareable);
		this.cardNumber = cardNumber;
		this.artifactId = "LC" + Utils.generateId();
	}

	public String getCardNumber() {
		return cardNumber;
	}

}
