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
	private String owner;
	private String dateAdded;
	private boolean shareable;
	
	public Artifact(){
		
	}
	
	public Artifact(String owner, String merchantName, String description, boolean shareable){
		this.merchantName = merchantName;
		this.description = description;
		this.owner = owner;
		dateAdded = new Date().toString();
		this.shareable = shareable;
	}
	
	public Artifact(String owner, String merchantName, boolean shareable){
		this.merchantName = merchantName;
		this.owner = owner;
		dateAdded = new Date().toString();
		this.shareable = shareable;
	}
	
	public ObjectId getId(){
		return 	Id;
	}
	
	public String getMerchantName() {
		return merchantName;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
		return artifactId + " " + merchantName + " " + owner;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Artifact){
			return artifactId.equals(((Artifact)o).getArtifactId());
		} else if(o instanceof SharedArtifact){
			return artifactId.equals(((SharedArtifact)o).getId());
		}
		return false;
	}
}
