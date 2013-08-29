package wallet.models;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import wallet.utils.Shareable;
import wallet.utils.Utils;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Wallet implements Shareable<Wallet>{
	@Id
	private ObjectId Id;
	
	private Integer walletId;
	private ArrayList<String> artifactIds;
	private ArrayList<SharedArtifact> sharedArtifacts;
	
	public Wallet(){
		this.walletId = Utils.generateId();
		artifactIds = new ArrayList<String>();
		sharedArtifacts = new ArrayList<SharedArtifact>();
	}
	
	public Integer getWalletId() {
		return walletId;
	}

	public ArrayList<String> getArtifacts() {
		return artifactIds;
	}

	public ArrayList<SharedArtifact> getSharedArtifacts() {
		return sharedArtifacts;
	}
	
	public ArrayList<String> getArtifactsbyCategory(String category){
		String categoryId = Utils.getCategoryId(category);
		ArrayList<String> categoryArtifacts = new ArrayList<String>();
		for(String s : artifactIds){
			if(s.contains(categoryId)){
				categoryArtifacts.add(s);
			}
		}
		for(SharedArtifact s : sharedArtifacts){
			if(s.getId().contains(categoryId)){
				categoryArtifacts.add(s.getId());
			}
		}
		return categoryArtifacts;
	}
	public boolean add(Artifact a){
		return artifactIds.add(a.getArtifactId());
	}
	
	public boolean add(SharedArtifact a){
		return sharedArtifacts.add(a);
	}
	
	@Override
	public Wallet share(Wallet shareWith, Artifact artifactToShare, ShareProperties prop) {
		if(!contains(artifactToShare) || shareWith.contains(artifactToShare))
			return null;
		
		if(artifactToShare.isShareable()){
			if(!prop.isAllowedSharing()){
				artifactToShare.setShareable(false);
			}
			SharedArtifact sharedArtifact = new SharedArtifact(artifactToShare, prop);
			shareWith.add(sharedArtifact);
			return shareWith;
		}
		return null;
	}
	
	public boolean contains(Artifact toShare){
		return sharedArtifacts.contains(toShare) || artifactIds.contains(toShare.getArtifactId());
	}
	
	@Override
	public Wallet[] share(Wallet[] shareWith, Artifact artifactToShare, ShareProperties prop) {
		Wallet[] walletArray = new Wallet[shareWith.length];
		for(int i = 0; i < shareWith.length; i++){
			walletArray[i] = this.share(shareWith[i], artifactToShare, prop);
		}
		return walletArray;
	}
	
	public String toString(){
		return walletId + " " + artifactIds + " " + sharedArtifacts;
	}
}
