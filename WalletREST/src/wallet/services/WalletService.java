package wallet.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import wallet.dao.UserDAO;
import wallet.dao.WalletDAO;
import wallet.models.User;
import wallet.models.Wallet;
import wallet.utils.DAOFactory;
import wallet.utils.Utils;

//maps this resource to the URL orders
@Path("/wallet")
public class WalletService {

	// Allows to insert contextual objects into the class
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@Path("{emailid}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getWallet(@PathParam("emailid") String emailId) {
		UserDAO udao = DAOFactory.createUserDAO();
		User U = udao.findByEmailId(emailId);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		Wallet w = wdao.findbyId(U.getWalletId());
		return Utils.buildResponse(Utils.ObjToJSON(w));
	}

	@Path("{emailid}/owned")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOwned(@PathParam("emailid") String emailId) {
		UserDAO udao = DAOFactory.createUserDAO();
		User U = udao.findByEmailId(emailId);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		return Utils.buildResponse(wdao.getOwnedArtifactsAsJSON(U.getWalletId()));
	}

	@Path("{emailId}/shared")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShared(@PathParam("emailId") String emailId) {
		UserDAO udao = DAOFactory.createUserDAO();
		User U = udao.findByEmailId(emailId);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		return Utils.buildResponse(wdao.getSharedArtifactsAsJSON(U.getWalletId()));
	}

	@Path("{emailId}/{category}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOwned(@PathParam("emailId") String emailId,
			@PathParam("category") String category) {
		UserDAO udao = DAOFactory.createUserDAO();
		User U = udao.findByEmailId(emailId);
		WalletDAO wdao = DAOFactory.createWalletDAO();
		return Utils.buildResponse(wdao.getArtifactByCategoryAsJSON(U.getWalletId(), category));
	}

}
