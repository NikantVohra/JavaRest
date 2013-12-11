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
         @Path("wallet/name/{emailid}")
         @GET
         @Produces({MediaType.APPLICATION_JSON})
         public Response getname(@PathParam("emailid") String emailId) {
        	 UserDAO udao = DAOFactory.createUserDAO();
        	 return Utils.buildResponse("{ \"name\" : \"" + udao.findByEmailId(emailId).getName() + "\"}");
         }
         
         @Path("wallet/balance/{emailid}")
         @GET
         @Produces({MediaType.APPLICATION_JSON})
         public Response getBalance(@PathParam("emailid") String emailId) {
        	 UserDAO udao = DAOFactory.createUserDAO();
        	 return Utils.buildResponse("{ \"balance\" : \"" + udao.findByEmailId(emailId).getBalance() + "\"}");
         }
         
         @Path("{emailid}")
         @GET
         @Produces({MediaType.APPLICATION_JSON})
         public Response getWalletFeed(@PathParam("emailid") String emailId) {
        	 UserDAO udao = DAOFactory.createUserDAO();
        	 return Utils.buildResponse(Utils.ObjToJSON(udao.findByEmailId(emailId)));
         }
         
        @Path("add")
		@POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        
		public Response createUser(
				@FormParam("name") String name,
				@FormParam("email") String emailId,
				@FormParam("balance") Double balance

		) {
        	UserDAO udao = DAOFactory.createUserDAO();
        	if(udao.createUser(name, emailId, balance))
        		return Utils.buildResponse("{\"status\" : \"Success\"}");
        	else
        		return Utils.buildResponse("{\"status\" :\"Failure\"}");		
		}
        @Path("feed/{emailid}")
		@POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces({MediaType.APPLICATION_JSON})

		public Response addToFeed(
				@PathParam("emailid") String emailId,
				@FormParam("feed") String feed

		) {
			String[] feedArray = feed.split(";");
        	UserDAO udao = DAOFactory.createUserDAO();
        	if(udao.addToFeed(emailId,feedArray))
        		return Utils.buildResponse("{\"status\" : \"Success\"}");
        	else
        		return Utils.buildResponse("{\"status\" :\"Failure\"}");	
        		
		}
}
																						