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

import wallet.dao.DonateDAO;
import wallet.dao.ShareDAO;
import wallet.models.ShareProperties;
import wallet.utils.DAOFactory;
import wallet.utils.Utils;

//maps this resource to the URL orders
@Path("/donate")
public class DonateService {

	// Allows to insert contextual objects into the class
	@Context
	UriInfo uriInfo;
	@Context
	Request request;


	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response get() {
		DonateDAO odao = DAOFactory.createDonateDAO();
		return Utils.buildResponse("{ \"donated\": "+odao.getAllDonatedArtifactsAsJSON() + "}");
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response share(@FormParam("id") String artifactId) {
		System.out.println(artifactId);
		DonateDAO odao = DAOFactory.createDonateDAO();

		if (odao.donate(artifactId))
			return Utils.buildResponse("{\"status\" : \"Success\"}");
		else
			return Utils.buildResponse("{\"status\" :\"Failure\"}");
	}

}
