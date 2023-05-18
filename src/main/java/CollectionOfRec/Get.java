package CollectionOfRec;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get {

	@Test
	public void TC1()
	{
		//Base URL
		RestAssured.baseURI="http://localhost:3000";
		
		//To get details in console
		given().get("/posts/1").then().log().all();
		//send the request  and get the response
		Response Resp = given().get("/posts/1").then().statusCode(200).extract().response();
		
		//Response is in Json Format
		//Change Response to String
		assertEquals(Resp.getStatusCode(), 200);
		assertEquals(Resp.jsonPath().getString("id"), "1");
		assertEquals(Resp.jsonPath().getString("title"), "Author1");
	}

	
}
