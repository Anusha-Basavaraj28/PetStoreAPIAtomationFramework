package com.anusha.endPoints;

//static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.anusha.payload.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

// created to perform CURD operations

public class UserEndPoint {

	public static Response createUser(User payload) {

		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(Routes.postUrl);

		return res;
	}

	public static Response getUser(String userName) {

		Response res = given().pathParam("userName", userName)

				.when().get(Routes.getUrl);

		return res;

	}

	public static Response updateUser(User payload, String userName) {

		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.pathParam("userName", userName)

				.when().put(Routes.putUrl);

		return res;

	}

	public static Response deleteUser(String userName) {

		Response res = given().pathParam("userName", userName)

				.when().delete(Routes.deleteUrl);

		return res;

	}

}
