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

import wallet.dao.UserDAO;
import wallet.utils.DAOFactory;
import wallet.utils.Utils;

//maps this resource to the URL orders
@Path("/user")
public class UserService {

         // Allows to insert contextual objects into the class
         @Context
         UriInfo uriInfo;
         @Context	
         Request request;
        
         // Return the list of orders for applications with json or xml formats
         
         @Path("wallet/{emailid}")
         @GET
         @Produces({MediaType.APPLICATION_JSON})
         public Response getWallet(@PathParam("emailid") String UserName) {
        	 UserDAO udao = DAOFactory.createUserDAO();
        	 return Utils.buildResponse(udao.getWalletasJSON(UserName));
         }
         
        @Path("add")
		@POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response createUser(
				@FormParam("name") String name,
				@FormParam("email") String emailId
		) {
        	UserDAO udao = DAOFactory.createUserDAO();
        	return Utils.buildResponse(Utils.ObjToJSON(udao.createUser(name, emailId)));
		}            
}
																						