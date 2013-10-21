package wallet.models;

import java.util.logging.Logger;

import com.google.code.morphia.annotations.Entity;
/*
 * Copyright (c) 2013 PayPal, Inc.
 *
 * All rights reserved.
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 */



/**
 * Offer value object.
 *
 * @author olreyes
 */
@Entity
public class Offer extends Artifact {

    private String campaignCode;
	private String countryCode;
    private String currency;
    private String title;
    private String imageUrl;
    private String termsAndConditions;
    private String status;
    private double amount;
    private String startDate;
    private String endDate;
/*    private String redeemLimit;
 	private List<String> stores;
 	private List<Issuer> issuers;	
    private boolean stackable;   
    private double amountIssued;
    private String transferConstraint;
    private double amountUsed;
    private double amountRemaining;
    private String redemptionChannel;
    private String landingUrl;
    private String restrictions;*/
	
	public Offer(){
		super();
	}
	public Offer(String id,String owner, String merchantName, String description,boolean shareable,String campaignCode,
		String countryCode,String currency, String title,String imageUrl,String termsAndConditions,
		String status,double amount,String startDate,String endDate){
		super(owner, merchantName, description, shareable);	
		this.artifactId = "OF" + id;
		this.campaignCode = campaignCode;
		this.countryCode = countryCode;
		this.currency = currency;
		this.title = title;
		this.imageUrl = imageUrl;
		this.termsAndConditions = termsAndConditions;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.amount = amount;
	}
  

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

/*    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public List<Issuer> getIssuers() {
        return issuers;
    }

    public void setIssuers(List<Issuer> issuers) {
        this.issuers = issuers;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

/*    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }
*/
    public String getCampaignCode() {
        return campaignCode;
    }

    public void setCampaignCode(String campaign_code) {
        this.campaignCode = campaign_code;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String country_code) {
        this.countryCode = country_code;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image_url) {
        this.imageUrl = image_url;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String terms_and_conditions) {
        this.termsAndConditions = terms_and_conditions;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String start_date) {
        this.startDate = start_date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String end_date) {
        this.endDate = end_date;
    }

    
 /*   public double getAmountIssued() {
        return amountIssued;
    }
    	public List<String> getStores() {
		return stores;
	}

	public void setStores(List<String> stores) {
		this.stores = stores;
	}


    public void setAmountIssued(double amount_issued) {
        this.amountIssued = amount_issued;
    }

    public double getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(double amount_used) {
        this.amountUsed = amount_used;
    }

    public double getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(double amount_remaining) {
        this.amountRemaining = amount_remaining;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String start_date) {
        this.startDate = start_date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String end_date) {
        this.endDate = end_date;
    }

    public String getRedemptionChannel() {
        return redemptionChannel;
    }

    public void setRedemptionChannel(String redemption_channel) {
        this.redemptionChannel = redemption_channel;
    }


	public double getEligibilityAmount() {
		return eligibilityAmount;
	}

	public void setEligibilityAmount(double eligibilityAmount) {
		this.eligibilityAmount = eligibilityAmount;
	}

	public String getRedeemLimit() {
		return redeemLimit;
	}

	public void setRedeemLimit(String redeemLimit) {
		this.redeemLimit = redeemLimit;
	}

	public String getTransferConstraint() {
		return transferConstraint;
	}

	public void setTransferConstraint(String transferConstraint) {
		this.transferConstraint = transferConstraint;
	}
    
    public String getLandingUrl() {
		return landingUrl;
	}

    public void setLandingUrl(String landingUrl) {
		this.landingUrl = landingUrl;
	}
*/
}
