package restapiautomation.restapiautomation;


import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.*;


public class PostExample {
	public static void main(String args[]) {
		
		//POST
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/create";
		Response resObj=RestAssured.given().body("{\"name\":\"raj\",\"salary\":\"10000\",\"age\":\"33\"}" + "").post();
		
		
		System.out.println(resObj.getStatusCode());
 		System.out.println(resObj.getBody().asString());
 		
			//get = select * from table;
		   //insert into table values("1","name",salary);
 	//GET	
 		 String baseURI="http://dummy.restapiexample.com/api/v1/employee/21";
 		
 		RestAssured.baseURI=baseURI;
 		Response response=RestAssured.given().get();
 		
 		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		 
 		
 		//PUT
 				RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/update/21";
 				
 				JSONObject json=new JSONObject();
 				 json.put("salary","10000");
 				 json.put("age","33");
 				 
 				 
 				Response putObject=RestAssured.given().body(json.toString()).put();
 				
 				 
 				System.out.println(putObject.getStatusCode());
 		 		System.out.println(putObject.getBody().asString());
 		 	
 		 		//delete	 
 		 		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/delete/21";
 				Response putObject1=RestAssured.given().delete();
 				System.out.println(putObject1.getStatusCode());
 		 		System.out.println(putObject1.getBody().asString());
				
	}
}
