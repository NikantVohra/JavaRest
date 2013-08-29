package wallet.models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

import wallet.utils.Utils;


public class GiftCard extends Artifact{
	
	private Double amount;
	private String cardNumber;
	private Date validUpto;
	
	private final static Logger LOGGER = Logger.getLogger(GiftCard.class.getName());
	
	public GiftCard(){
		super();
	}
	
	public GiftCard(Integer ownerWalletId, String merchantName, String cardNumber, Double amount, String validity, boolean shareable) {
		super(ownerWalletId, merchantName, shareable);
		this.cardNumber = cardNumber;
		this.artifactId = "GC" + Utils.generateId();
		this.amount = amount;
		try {
			this.validUpto = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(validity);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.warning("Invalid Validity for Coupon");
		}
	}
	
	public GiftCard(Integer ownerWalletId, String merchantName, String description, String cardNumber, Double amount, String validity, boolean shareable) {
		super(ownerWalletId, merchantName, description, shareable);
		this.cardNumber = cardNumber;
		this.artifactId = "GC" + Utils.generateId();
		this.amount = amount;
		try {
			this.validUpto = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(validity);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.warning("Invalid Validity for Coupon");
		}
	}
	
	public Double getAmount(){
		return amount;
	}
	
	public String getCardNumber(){
		return cardNumber;
	}
	
	public String validUpto(){
		return validUpto.toString();
	}
}
