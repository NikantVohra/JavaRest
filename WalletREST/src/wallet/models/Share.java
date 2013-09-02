package wallet.models;
import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Share {
	@Id
	private ObjectId Id;
	
	private String shareFrom;
	private String shareWith;
	private String toShare;
	private String sharedAt;
	private ShareProperties prop;
	private boolean newShare;
	
	public Share(){
		
	}
	
	public Share(String shareFrom, String shareWith, String toShare, ShareProperties prop){
		this.shareFrom = shareFrom;
		this.shareWith = shareWith;
		this.toShare = toShare;
		this.prop = prop;
		this.sharedAt = new Date().toString();
		this.newShare = true;
	}

	public String getShareFrom() {
		return shareFrom;
	}

	public String getShareWith() {
		return shareWith;
	}

		public String getToShare() {
		return toShare;
	}

	public String getSharedAt() {
		return sharedAt;
	}

	public ShareProperties getProp() {
		return prop;
	}

	public boolean isNewShare() {
		return newShare;
	}

	public void setNewShare(boolean newShare) {
		this.newShare = newShare;
	}

}
