package wallet.models;

public class SharedArtifact{
	private String sharedArtifactId;
	private ShareProperties prop;
	
	public SharedArtifact(){
		
	}
	
	SharedArtifact(Artifact a){
		sharedArtifactId = a.getArtifactId();
		prop = new ShareProperties();
	}
	
	SharedArtifact(Artifact a, ShareProperties prop){
		sharedArtifactId = a.getArtifactId();
		this.prop = prop;
	}
	
	public String getId() {
		return sharedArtifactId;
	}
	
	public ShareProperties getProp() {
		return prop;
	}
	
	public String toString(){
		return sharedArtifactId + " " + prop.getNumDaysSharing() + " " + prop.isAllowedSharing();
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Artifact){
			return sharedArtifactId.equals(((Artifact)o).getArtifactId());
		} else if(o instanceof SharedArtifact){
			return sharedArtifactId.equals(((SharedArtifact)o).getId());
		}
		return false;
	}
}
