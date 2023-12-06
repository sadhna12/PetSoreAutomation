package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest

{
@Test(priority = 1,dataProvider = "Data",dataProviderClass=DataProviders.class )
	
	public void testPostUser(String userId,String fname,String lname,String userename,String useremail,String pwd,String phone)
	{
		User	userpayload=new User();;
				userpayload.setId(Integer.parseInt(userId));
				userpayload.setUsername(userename);	
				userpayload.setFirstName(fname);
				userpayload.setLastName(lname);
				userpayload.setEmail(useremail);
				userpayload.setPassword(pwd);
				userpayload.setPhone(phone);
				
				Response response=UserEndPoints.createUser(userpayload);
				response.then().log().all();
				Assert.assertEquals(response.getStatusCode(), 200);
				
	}


@Test(priority = 2,dataProvider = "GetuserName",dataProviderClass=DataProviders.class )
public void testGetUserByName( String username)
{
	Response response=	UserEndPoints.readUser(username);

	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
}


//@Test(priority = 3,dataProvider = "DELuserNames",dataProviderClass=DataProviders.class )
//public void testDeleteUserByName( String username)
//{
//	Response response=	UserEndPoints.deleteUser(username);
//
//	response.then().log().all();
//	Assert.assertEquals(response.getStatusCode(), 200);
}

