package CollectionOfRec;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Put {
	public static String RandomTitle = GetRandomString();
	@Test
	public void M1()
	{
		//Base URL
		RestAssured.baseURI="http://localhost:3000";
		
		//To get details in console 
		Response Resp1 = given().contentType(ContentType.JSON)
				.body(" {\n"
						+"          \"title\": \""+RandomTitle+"\",\n"
						+"           \"author\": \"Aman\"\n" 
						+" }")
				.when().patch("/posts/4");
		
		//Response code of POST request
		assertEquals(Resp1.getStatusCode(), 200);
		assertEquals(Resp1.jsonPath().getString("title"),RandomTitle);
		}
	//Code to generate random String for all the requests
	public static String GetRandomString()
	{
	Random random = new Random();
	String NewTitle = "N1_" + random.nextInt();
	return NewTitle;
}
}