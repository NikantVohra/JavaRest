package wallet.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import wallet.dao.LoyaltyCardDAO;
import wallet.dao.UserDAO;
import wallet.models.User;
import wallet.utils.DAOFactory;
import wallet.utils.Utils;

//maps this resource to the URL orders
@Path("/loyaltycard")
public class LoyaltyCardService {

	// Allows to insert contextual objects into the class
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@Path("{artifactId}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String get(@PathParam("artifactId") String artifactId) {
		System.out.println(artifactId);
		LoyaltyCardDAO cdao = DAOFactory.createLoyaltyCardDAO();
		System.out.println(Utils.ObjToJSON(cdao.findbyId(artifactId)));
		return Utils.ObjToJSON(cdao.findbyId(artifactId));
	}

	@Path("add/{emailId}")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String add(@PathParam("emailId") String emailId,
			@FormParam("merchant") String merchant,
			@FormParam("cardnumber") String cardNumber

	) {
		UserDAO udao = DAOFactory.createUserDAO();
		User U = udao.findByEmailId(emailId);
		LoyaltyCardDAO cdao = DAOFactory.createLoyaltyCardDAO();
		return Utils.ObjToJSON(cdao.add(U.getWalletId(), merchant, cardNumber));
	}
}
