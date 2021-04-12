package com.org.testapi;
import org.testng.annotations.Test;

import com.jayway.restassured.path.xml.XmlPath;
import static com.jayway.restassured.RestAssured.*;


public class TestApiWithXML {
	//Validating the whether the user is created
		
			@Test
			public void testGet() {
				given()
				//.header("key", "0123456789012345678901234ab")
				.when()
				.get("https://api.github.com/users/Haja49")
					.then().statusCode(200);
				}
}
