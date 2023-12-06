package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 
{
	Faker faker;//=new Faker();;
	User userpayload;//=new User();
	Logger logger;
	@BeforeClass
  public void setUpData() 
	{
	faker=new Faker();
	 userpayload=new User();;
	userpayload.setId(faker.idNumber().hashCode());
	userpayload.setUsername(faker.name().username());	
	userpayload.setFirstName(faker.name().firstName());
	userpayload.setLastName(faker.name().lastName());
	userpayload.setEmail(faker.internet().safeEmailAddress());
	userpayload.setPassword(faker.internet().password(5,10));
	userpayload.setPhone(faker.phoneNumber().cellPhone());
	//logs
	
	logger=LogManager.getLogger(this.getClass());
	
	//Response response;
	}
	
	
	@Test(priority = 1)
	
	public void testPostUser()
	{
		//logger.info("...........creating user.........");
		Response response=UserEndPoints2.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
				
}
	
@Test(priority = 2)
	
	public void testGetUser()
	{
	logger.info("...........reading user info.........");

		Response response=UserEndPoints2.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
				
		
		
		
	}

@Test(priority = 3)

public void testUpdtaeUser()
{
	logger.info("...........updating user.........");

	System.out.println("updated");
	
	userpayload.setFirstName(faker.name().firstName());
	userpayload.setLastName(faker.name().lastName());
	userpayload.setEmail(faker.internet().safeEmailAddress());
	Response response=UserEndPoints2.updateUser(this.userpayload.getUsername(), userpayload);
	response.then().log().body();
	Assert.assertEquals(response.getStatusCode(), 200);
	
	//checking after update data
	
	Response responseAfetupdate=UserEndPoints2.readUser(this.userpayload.getUsername());
	responseAfetupdate.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	
}


@Test(priority = 4)

public void testDeleteUser()
{
	Response response=UserEndPoints2.deleteUser(this.userpayload.getUsername());
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
			


}
	
}
