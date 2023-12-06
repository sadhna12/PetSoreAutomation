package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//created for perform CRUD operation user api


//user ened points .java
//created for perform create,read,update and delete request the user API

public class UserEndPoints 
{
	public static Response createUser(User payload)
	  {
	Response res=	  given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
		  .when()
		  .post(Routes.post_url);
	 return res;
	  
	  }
	
	
	public static Response readUser(String username)
	  {
	Response res=	  given()
	.pathParam("username", username)
		  .when()
		  .get(Routes.get_url);
	 return res;
	  
	  }
	
	
	public static Response updateUser(String usenameUser,User payload)
	  {
	Response res=	  given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.pathParam("username", usenameUser)
	.body(payload)
		  .when()
		  .put(Routes.update_url);
	 return res;
	  
	  }
	
	public static Response deleteUser(String username)
	  {
	Response res=	  given()
	.pathParam("username", username)
		  .when()
		  .delete(Routes.delete_url);
	 return res;
	  
	  }
}
