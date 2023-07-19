package com.anusha.endPoints;


/*  Swagger URI----> https://petstore.swagger.io
 * 
 * 
 *  Create User(POST) https://petstore.swagger.io/v2/user
 *  Get USer(GET) https://petstore.swagger.io/v2/user/{userName}
 *  Update User(PUT) https://petstore.swagger.io/v2/user/{userName}
 *  Delete User(DELETE) https://petstore.swagger.io/v2/user/{userName}
 */

public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	// User Module
	
	public static String postUrl=base_url+"/user";
	public static String getUrl=base_url+"/user/{userName}";
	public static String putUrl=base_url+"/user/{userName}";
	public static String deleteUrl=base_url+"/user/{userName}";
	
	
	// Store Module
	
	 // create store module URL's here
	
	// Pet Module
	 // create pet module URL's here
}
