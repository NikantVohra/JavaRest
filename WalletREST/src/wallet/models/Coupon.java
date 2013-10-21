package wallet.models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

import wallet.utils.Utils;

public class Coupon extends Artifact{
	
	private String couponCode;
	private String offerPercentage;
	private Date validUpto;
	
	private final static Logger LOGGER = Logger.getLogger(Coupon.class.getName());
	
	public Coupon(){
		super();
	}
	
	public Coupon(String owner, String merchantName, String description, String couponCode, String offerPercentage, String validity, boolean shareable) {
		super(owner, merchantName, description, shareable);
		this.artifactId = "CP" + Utils.generateId();
		this.couponCode = couponCode;
		this.offerPercentage = offerPercentage;
		try {
			validUpto = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(validity);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.warning("Invalid Validity for Coupon");
		}
	}
	
	public Coupon(String owner, String merchantName, String couponCode, String offerPercentage, String validity, boolean shareable) {
		super(owner, merchantName, shareable);
		this.artifactId = "CP" + Utils.generateId();
		this.couponCode = couponCode;
		this.offerPercentage = offerPercentage;
		try {
			validUpto = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(validity);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.warning("Invalid Validity for Coupon");
		}
	}

	public String getValidUpto(){
		return validUpto.toString();
	}
	
	public String getCouponCode() {
		return couponCode;
	}

	public String getOfferPercentage() {
		return offerPercentage;
	}
}
