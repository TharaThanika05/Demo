package CollectionOfRec;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Delete {
	public static String title = GetRandomString();
	@Test
	public void TC1() {
	RestAssured.baseURI="http://localhost:3000";
	
	//Creation
	Response Resp1 = given().contentType(ContentType.JSON)
	.body("{\n"
			
			+ "      \"title\": \""+title+"\",\n"
			+ "      \"author\": \"Ram\"\n"
			+ "    }")
			
	.when().post("/posts");
	
	//Display
	assertEquals(Resp1.getStatusCode(), 201);
	given().get("/posts").then().log().all();
	String NewlyaddedPostId = Resp1.jsonPath().getString("id");
	
	//DEletion
	Response RespOfDeletionReg = given().delete("/posts/" + NewlyaddedPostId + "");
	
	//Verify If the above created data is deleted
	assertEquals(RespOfDeletionReg.statusCode(), 200);
	System.out.println("The status code after deletionis as expected:" +RespOfDeletionReg.statusCode());
	
	
	}
	//code to genrate random string for all the requeste
	public static String GetRandomString() {
		Random random = new Random();
		String NewTitle = "New_" + random.nextInt();
		return NewTitle;
	}
	
}
