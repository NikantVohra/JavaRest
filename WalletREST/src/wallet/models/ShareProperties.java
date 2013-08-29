package wallet.models;


public class ShareProperties {
	private boolean allowedSharing;
	private Integer numDaysSharing;
	
	ShareProperties(boolean allowedSharing){
		this.allowedSharing = allowedSharing;
	}
	
	ShareProperties(){
		this.allowedSharing = true;
	}
	
	public ShareProperties(boolean allowedSharing, Integer numDaysSharing){
		this.allowedSharing = allowedSharing;
		this.numDaysSharing = numDaysSharing;
	}
	
	public Integer getNumDaysSharing() {
		return numDaysSharing;
	}

	public boolean isAllowedSharing() {
		return allowedSharing;
	}	
}
