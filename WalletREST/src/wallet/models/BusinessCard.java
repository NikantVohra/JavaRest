package wallet.models;

import wallet.utils.Utils;

public class BusinessCard extends Artifact {
	
	private String name;
	private String[] numbers;
	private String[] emails;
	
	public BusinessCard(){
		super();
	}
	
	public BusinessCard(Integer ownerWalletId, String merchantName, String name, String[] numbers, String[] emails, boolean shareable) {
		super(ownerWalletId, merchantName, shareable);
		this.artifactId = "BC" + Utils.generateId();
		this.name = name;
		this.numbers = numbers;
		this.emails = emails;
	}

	public BusinessCard(Integer ownerWalletId, String merchantName, String description, String name, String[] numbers, String[] emails, boolean shareable) {
		super(ownerWalletId, merchantName, description, shareable);
		this.artifactId = "BC" + Utils.generateId();
		this.name = name;
		this.numbers = numbers;
		this.emails = emails;
	}

	public String getName() {
		return name;
	}

	public String[] getNumbers() {
		return numbers;
	}

	public String[] getEmails() {
		return emails;
	}

}
