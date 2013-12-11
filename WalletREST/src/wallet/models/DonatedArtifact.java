package wallet.models;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class DonatedArtifact {
	@Id
	private ObjectId Id;
	private String artifactId;
	
	public DonatedArtifact(){
	}
	
	public DonatedArtifact(String artifactId){
		this.artifactId = artifactId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
}
