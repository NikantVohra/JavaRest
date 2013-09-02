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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import wallet.dao.GiftCardDAO;
import wallet.dao.UserDAO;
import wallet.models.User;
import wallet.utils.DAOFactory;
import wallet.utils.Utils;

//maps this resource to the URL orders
@Path("/giftcard")
public class GiftCardService {

	// Allows to insert contextual objects into the class
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@Path("{artifactId}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response get(@PathParam("artifactId") String artifactId) {
		System.out.println(artifactId);
		GiftCardDAO cdao = DAOFactory.createGiftCardDAO();
		System.out.println(Utils.ObjToJSON(cdao.findbyId(artifactId)));
		return Utils.buildResponse(Utils.ObjToJSON(cdao.findbyId(artifactId)));
	}

	@Path("add/{emailId}")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response add(@PathParam("emailId") String emailId,
			@FormParam("merchant") String merchant,
			@FormParam("cardnumber") String cardNumber,
			@FormParam("amount") Double amount,
			@FormParam("validity") String validity) {
		UserDAO udao = DAOFactory.createUserDAO();
		User U = udao.findByEmailId(emailId);
		GiftCardDAO cdao = DAOFactory.createGiftCardDAO();
		return Utils.buildResponse(Utils.ObjToJSON(cdao.add(U.getWalletId(), merchant, cardNumber,
				amount, validity)));
	}
}
