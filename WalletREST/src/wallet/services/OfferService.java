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

import wallet.dao.OfferDAO;
import wallet.utils.DAOFactory;
import wallet.utils.Utils;

//maps this resource to the URL orders
@Path("offer")
public class OfferService {

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
		OfferDAO odao = DAOFactory.createOfferDAO();
		System.out.println(Utils.ObjToJSON(odao.findbyId(artifactId)));
		return Utils.buildResponse(Utils.ObjToJSON(odao.findbyId(artifactId)));
	}

	@Path("add/{emailId}")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response add(@PathParam("emailId") String emailId,
			@FormParam("id") String id,
			@FormParam("merchant") String merchant,
			@FormParam("description") String description,
			@FormParam("campaigncode") String campaignCode,
			@FormParam("countrycode") String countryCode,
			@FormParam("currency") String currency,
			@FormParam("title") String title,
			@FormParam("imageurl") String imageUrl,
			@FormParam("termsandconditions") String termsAndConditions,
			@FormParam("status") String status,
			@FormParam("amount") double amount,
			@FormParam("startdate") String startDate,
			@FormParam("enddate") String endDate){
		OfferDAO odao = DAOFactory.createOfferDAO();
		System.out.println("here");
		return Utils.buildResponse("{\"OfferId\" : \"" + (odao.add(id, emailId, merchant, description, campaignCode, 
				countryCode, currency, title, imageUrl, termsAndConditions, status, amount, startDate, endDate))+"\" }");
	}
}
