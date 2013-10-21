package wallet.models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

import wallet.utils.Utils;


public class Receipt extends Artifact{
	
	private String receiptNumber;
	private Double amount;
	private Date receiptDated;
	
	private final static Logger LOGGER = Logger.getLogger(Receipt.class.getName());
	
	public Receipt(){
		super();
	}
	public Receipt(String owner, String merchantName, String description, String receiptNumber, Double amount, String receiptDated, boolean shareable) {
		super(owner, merchantName, description, shareable);
		this.amount = amount;
		this.artifactId = "RP" + Utils.generateId();
		this.receiptNumber = receiptNumber;
		try {
			this.receiptDated = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(receiptDated);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.warning("Invalid Receipt Date for Receipt");
		}
	}

	public Receipt(String owner, String merchantName,String receiptNumber, Double amount, String receiptDated, boolean shareable) {
		super(owner, merchantName, shareable);
		this.amount = amount;
		this.artifactId = "RP" + Utils.generateId();
		this.receiptNumber = receiptNumber;
		try {
			this.receiptDated = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(receiptDated);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.warning("Invalid Validity for Coupon");
		}
	}
	
	public String getReceiptNumber(){
		return receiptNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public Date getReceiptDated() {
		return receiptDated;
	}
	
	
}
