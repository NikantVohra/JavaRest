package wallet.models;
import java.util.Date;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;

@Entity
public abstract class Artifact {
	@Id
	private ObjectId Id;
	
	protected String artifactId;
	private String merchantName;
	private String description;
	private Integer ownerWalletId;
	private String dateAdded;
	private boolean shareable;
	
	public Artifact(){
		
	}
	
	public Artifact(Integer ownerWalletId, String merchantName, String description, boolean shareable){
		this.merchantName = merchantName;
		this.description = description;
		this.ownerWalletId = ownerWalletId;
		dateAdded = new Date().toString();
		this.shareable = shareable;
	}
	
	public Artifact(Integer ownerWalletId, String merchantName, boolean shareable){
		this.merchantName = merchantName;
		this.ownerWalletId = ownerWalletId;
		dateAdded = new Date().toString();
		this.shareable = shareable;
	}
	
	public ObjectId getId(){
		return 	Id;
	}
	
	public String getMerchantName() {
		return merchantName;
	}
	
	public Integer getOwnerWalletId() {
		return ownerWalletId;
	}
	
	public String getDateAdded() {
		return dateAdded;
	}
	
	public boolean isShareable() {
		return shareable;
	}
	
	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}
	
	public String getArtifactId() {
		return artifactId;
	}

	public String getDescription() {
		return description;
	}
	
	public String toString(){
		return artifactId + " " + merchantName + " " + ownerWalletId;
	}
	
}
