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

import wallet.dao.BusinessCardDAO;
import wallet.utils.DAOFactory;
import wallet.utils.Utils;

//maps this resource to the URL orders
@Path("/businesscard")
public class BusinessCardService {

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
		BusinessCardDAO cdao = DAOFactory.createBusinessCardDAO();
		System.out.println(Utils.ObjToJSON(cdao.findbyId(artifactId)));
		return Utils.buildResponse(Utils.ObjToJSON(cdao.findbyId(artifactId)));
	}

	@Path("add/{emailId}")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON })

	public Response add(@PathParam("emailId") String emailId,
			@FormParam("merchant") String merchant,
			@FormParam("name") String name,
			@FormParam("numbers") String numbers,
			@FormParam("emailids") String emailIds) {
		BusinessCardDAO cdao = DAOFactory.createBusinessCardDAO();
		return Utils.buildResponse("{\"BusinessCardId\" : \"" +cdao.add(emailId, merchant, name,
				numbers.split(";"), emailIds.split(";"))+"\"}");
	}
}
