package wallet.dao;

import java.util.ArrayList;

import wallet.models.Artifact;
import wallet.models.DonatedArtifact;
import wallet.models.Offer;
import wallet.models.SharedArtifact;
import wallet.models.User;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;
import wallet.utils.DBAccess;
import wallet.utils.Utils;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.query.Query;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class DonateDAO extends BasicDAO<DonatedArtifact, String> {
	public DonateDAO(Mongo mongo, Morphia morphia, String DBname) {
		super(mongo, morphia, DBname);
	}

	public boolean isPresent(String artifactId) {
		if (ds.find(DonatedArtifact.class, "artifactId ==", artifactId).get() != null)
			return true;
		else
			return false;
	}

	public String getAllDonatedArtifactsAsJSON(){
		ArrayList<Artifact> result = new ArrayList<Artifact>();
		Query<DonatedArtifact> curs = ds.find(DonatedArtifact.class);
		
		for(DonatedArtifact s : curs.asList()){
			Artifact a = DAOFactory.getArtifact(s.getArtifactId());
			if(a != null)
				result.add(a);
		}
		return Utils.ObjToJSON(result.toArray());
	}

	public boolean donate(String artifactId) {
		if(!isPresent(artifactId)){
			ds.save(new DonatedArtifact(artifactId));
			return true;
		}
		return false;
	}
}
