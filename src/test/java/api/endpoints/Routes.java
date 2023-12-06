package api.endpoints;

public class Routes 
{
	//this class is for only storing urls;
public static String base_url="https://petstore.swagger.io/v2";
//user module
public static String post_url=base_url+"/user";

//https://petstore.swagger.io/v2/user
public static String get_url=base_url+"/user/{username}";
public static String update_url=base_url+"/user/{username}";
public static String delete_url=base_url+"/user/{username}";


}
