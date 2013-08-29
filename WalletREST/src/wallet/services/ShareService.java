package wallet.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import wallet.dao.ShareDAO;
import wallet.models.ShareProperties;
import wallet.utils.DAOFactory;
import wallet.utils.Utils;

//maps this resource to the URL orders
@Path("/share")
public class ShareService {

         // Allows to insert contextual objects into the class
         @Context
         UriInfo uriInfo;
         @Context	
         Request request;
        
         // Return the list of orders for applications with json or xml formats
        @Path("{artifactId}")
		@POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String share(
				@FormParam("from") String emailIdFrom,
				@FormParam("with") String emailIdTo,
				@PathParam("artifactId") String artifactId,
				@FormParam("shareable") boolean shareable,
				@FormParam("numdays") Integer numDays
		) {
			ShareDAO sdao = DAOFactory.createShareDAO();
			boolean status;
			ShareProperties prop = new ShareProperties(shareable, numDays);
			String[] userEmails = emailIdTo.split(";");
        	 if(userEmails.length == 1){
        		status = sdao.share(emailIdFrom, userEmails[0], artifactId, prop);
        	} else {
        		status= sdao.share(emailIdFrom, userEmails, artifactId, prop);
        	}
        	if(status)
        		return "{'Success'}";
        	else
        		return "{'Failure'}";	
		}
		
        @Path("{artifactId}")
		@GET
		public String sharedWith(@PathParam("artifactId") String artifactId){
			ShareDAO sdao = DAOFactory.createShareDAO();
			return Utils.ObjToJSON(sdao.getSharedWith(artifactId));
		}
}
																						