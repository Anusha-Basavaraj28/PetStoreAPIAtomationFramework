package com.anusha.test;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.anusha.endPoints.UserEndPoint;
import com.anusha.payload.User;
import com.anusha.utilities.DataProviders;

import io.restassured.response.Response;

public class DataDrivenTests {
	
    @Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String userId,String userName,String firstName,String lastName,String email,String password,String phone) {
    	
    	User payload=new User();
    	payload.setId(Integer.parseInt(userId));
    	payload.setUsername(userName);
    	payload.setFirstName(firstName);
    	payload.setLastName(lastName);
    	payload.setEmail(email);
    	payload.setPassword(password);
    	payload.setPassword(phone);
    	
    Response res=UserEndPoint.createUser(payload);
    Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
    @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName) {
    	
    	Response res= UserEndPoint.deleteUser(userName);
    	
    	Assert.assertEquals(res.getStatusCode(), 200);
    	
    }
    
    
    
    
    
    
    
    

}
