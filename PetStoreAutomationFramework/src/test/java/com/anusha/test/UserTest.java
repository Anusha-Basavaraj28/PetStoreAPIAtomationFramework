package com.anusha.test;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.anusha.endPoints.UserEndPoint;
import com.anusha.endPoints.UserEndPoint2;
import com.anusha.payload.User;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User userPayload;
	Logger logger;
	
	@BeforeClass
	public void setUpData() {
		
		faker=new Faker(new Locale("en-IND"));
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		// logs
		
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		logger.info("**********Creating user**********");
		
	Response res=UserEndPoint.createUser(userPayload);
	
	res.then().log().all();
	Assert.assertEquals(res.getStatusCode(), 200);
	logger.info("**********User created**********");
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		
		logger.info("**********Reading user**********");
		
	Response res=UserEndPoint.getUser(userPayload.getUsername());
	
	String userName=res.jsonPath().getString("username");
	int id=res.jsonPath().getInt("id");
	
	res.then().log().all();
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(userName, userPayload.getUsername());
	Assert.assertEquals(id, userPayload.getId());
	
	logger.info("**********User info displayed**********");

	}
	
	
	
	@Test(priority = 3)
	public void testPutUser() {
		logger.info("**********updating user**********");
		
	userPayload.setUserStatus(1);
		
	Response res=UserEndPoint.updateUser(userPayload,userPayload.getUsername());
	
	//int userStatus=res.jsonPath().getInt("userStatus");
	
	res.then().log().all();
	Assert.assertEquals(res.getStatusCode(), 200);
	//Assert.assertEquals(userStatus, userPayload.getUserStatus());	
	
	// checking the data after updating 
	
	Response resAfterPut=UserEndPoint.getUser(userPayload.getUsername());
	
	int userStatus=resAfterPut.jsonPath().getInt("userStatus");
	
	resAfterPut.then().log().all();
	Assert.assertEquals(resAfterPut.getStatusCode(), 200);
	Assert.assertEquals(userStatus, userPayload.getUserStatus());	
	logger.info("**********user updated**********");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		logger.info("**********deleting user**********");
		
	Response res=UserEndPoint.deleteUser(userPayload.getUsername());
	
	res.then().log().all();
	Assert.assertEquals(res.getStatusCode(), 200);
		
	logger.info("**********user deleted**********");
	}

}
