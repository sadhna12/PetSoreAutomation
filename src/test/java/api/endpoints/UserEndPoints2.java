package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//created for perform CRUD operation user api


//user ened points .java
//created for perform create,read,update and delete request the user API

public class UserEndPoints2 
{

	//method creadted for getting urls from proprerties file
  static ResourceBundle	getUrl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");// name of the properties file
		return routes;
	
	}
	
	
	
	public static Response createUser(User payload)
	  {
		
		//https://petstore.swagger.io/v2/user
	String posr_url=getUrl().getString("post_url");
	Response res=	  given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
		  .when()
		  .post(posr_url);
	 return res;
	  
	  }
	
	
	public static Response readUser(String username)
	  {
		String get_url=	getUrl().getString("get_url");
		
	Response res=	  given()
	.pathParam("username", username)
		  .when()
		  .get(get_url);
	 return res;
	  
	  }
	
	
	public static Response updateUser(String usenameUser,User payload)
	  {
		
		String  update_url=	getUrl().getString("update_url");

	Response res=	  given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.pathParam("username", usenameUser)
	.body(payload)
		  .when()
		  .put( update_url);
	 return res;
	  
	  }
	
	public static Response deleteUser(String username)
	  {
		String  delete_url=	getUrl().getString("delete_url");

	Response res=	  given()
	.pathParam("username", username)
		  .when()
		  .delete(delete_url);
	 return res;
	  
	  }
}
