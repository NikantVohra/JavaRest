package wallet.utils;
import java.io.IOException;
import java.util.Random;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Utils {
	public static Integer generateId() {
		Random r = new Random();
		int min = 10000000;
		int max = 99999999;
		return min + r.nextInt(max-min + 1);
	}
	
	public static String getClassName(String id){
		switch(id.substring(0, 2)){
			case "CP" : return "wallet.models.Coupon";
			case "BC" : return "wallet.models.BusinessCard";
			case "GC" : return "wallet.models.GiftCard";
			case "LC" : return "wallet.models.LoyaltyCard";
			case "RP" : return "wallet.models.Receipt";
			default : return null;
		}
	}
	
	public static String getCategoryId(String category){
		switch(category.toLowerCase()){
			case "coupon" : return "CP";
			case "businesscard" : return "BC";
			case "giftcard" : return "GC";
			case "loyaltycard" : return "LC";
			case "receipt" : return "RP";
			default : return "Invalid Category";
		}
	}
	
	public static String ObjToJSON(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String ObjToJSON(Object[] obj){
		String JSON = "{";
		for(int i = 0; i < obj.length; i++){
			JSON += ObjToJSON(obj[i]);
			if(i!=obj.length-1) JSON += ",";
		}
		return JSON + "}";
	}
	
	public static Integer[] toIntArray(String s){
		String[] sArray = s.split(";");
    	Integer[] iArray = new Integer[sArray.length];
    	for(int i = 0; i < iArray.length; i++){
        	iArray[i] = Integer.parseInt(sArray[i]);
        }
    	return iArray;
	}
	
	public static Response buildResponse(String resp){
		ResponseBuilder builder = Response.ok(resp);
   	 	builder.header("Access-Control-Allow-Origin", "*");
        builder.header("Access-Control-Max-Age", "3600");
        builder.header("Access-Control-Allow-Methods", "GET");
        builder.header("Access-Control-Allow-Headers", "X-Requested-With,Host,User-Agent,Accept,Accept-Language,Accept-Encoding,Accept-Charset,Keep-Alive,Connection,Referer,Origin");
        return builder.build();
	}
}
