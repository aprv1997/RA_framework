package api.endpoints;

import api.endpoints.Routes.Routes;
import api.payload.stoDetails;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response fetchstodetails(stoDetails Payload)
	{
		Response response = given()
			    .contentType(ContentType.JSON)
			    .accept(ContentType.JSON)
			    .header("apikey", "20985541ab2642868a8748888b3444a8abac26cf05894e0a95a67dc") 	
			    .header("apiowner", "50test1")  
			    .body(Payload)
			.when()
			    .post(Routes.stoDetails);
		System.out.println("checking");
		return response;
		
		
	}
	
	
}
