package CollectionOfRec;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post {
@Test
public void TC1()
{
	//Base URL
			RestAssured.baseURI="http://localhost:3000";
			
			//To get details in console
			Response Resp1 = given()
			.contentType(ContentType.JSON)
			.body("{\n"
					+ "      \"id\": 7,\n"
					+ "      \"title\": \"title7\",\n"
					+ "      \"author\": \"John\"\n"
					+ "    }\n"
					+ "")
			.when().post("/posts");
			
			//Response code for post request
			assertEquals(Resp1.getStatusCode(), 201);
			
			//send the request  and get the response
			Response Resp2 = given().get("/posts").then().extract().response();
			
			//Response is in Json Format
			//Change Response to String
			assertEquals(Resp2.getStatusCode(), 200);
			assertEquals(Resp2.jsonPath().getString("id"), "7");
			assertEquals(Resp2.jsonPath().getString("title"), "title");
}
}
