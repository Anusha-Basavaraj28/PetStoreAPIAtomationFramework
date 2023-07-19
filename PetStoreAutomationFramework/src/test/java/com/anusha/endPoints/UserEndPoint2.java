package com.anusha.endPoints;

//static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Properties;
import java.util.ResourceBundle;

import com.anusha.payload.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

// created to perform CURD operations

public class UserEndPoint2 {
	
	 static ResourceBundle getURL() {
		 ResourceBundle rb=ResourceBundle.getBundle("routes");
		 return rb;
	 }
	

	public static Response createUser(User payload) {
		
		String postUrl=getURL().getString("post_url");

		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(postUrl);

		return res;
	}

	public static Response getUser(String userName) {
		
		String getUrl=getURL().getString("get_url");

		Response res = given().pathParam("userName", userName)

				.when().get(getUrl);

		return res;

	}

	public static Response updateUser(User payload, String userName) {
		
		String putUrl=getURL().getString("update_url");

		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.pathParam("userName", userName)

				.when().put(putUrl);

		return res;

	}

	public static Response deleteUser(String userName) {
		
		String deleteUrl=getURL().getString("delete_url");

		Response res = given().pathParam("userName", userName)

				.when().delete(deleteUrl);

		return res;

	}

}
