package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.io.IOException;

import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class POST_account_id_info_API extends APIStart{

	public void POST_account_id_info_API_UnAuthorized() throws Exception
	{
		String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
		System.out.println(Post_Login);
				System.out.println(Authorizationtoken);
				// First Request - POST /login
				Response login =given().baseUri(BaseURI).header("Authorization",Authorizationtoken).contentType(ContentType.JSON).with().body(Post_Login).when().post("/login").then().extract().response();
				
//				System.out.println("API - /login");
//				System.out.println("Response:"+login.asString());
//				System.out.println("Status Code:"+login.statusCode());
				
				
				String JSONasstring = "["+login.asString()+"]";
				JSONArray JSONArray = new JSONArray(JSONasstring);
				String id=JSONArray.getJSONObject(0).get("id").toString();
				String token=JSONArray.getJSONObject(0).get("token").toString();
				
				// Second Request - POST /account/{id}/billing
				String Post_account_id_info = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_info/POST_account_id_info_ValidFields.json");
				Response accountIdInfo = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_info).when().post("/account/"+id+"/billing").then().statusCode(401).extract().response();
				String asString = "["+accountIdInfo.asString()+"]";
				System.out.println("API - POST /account/{id}/billing");
				System.out.println("Response:"+accountIdInfo.asString());
				System.out.println("Status Code:"+accountIdInfo.statusCode());

	}
	public void POST_account_id_info_InvalidFieldsProvided() throws Exception{
		String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
		System.out.println(Post_Login);
				System.out.println(Authorizationtoken);
				// First Request - POST /login
				Response login =given().baseUri(BaseURI).header("Authorization",Authorizationtoken).contentType(ContentType.JSON).with().body(Post_Login).when().post("/login").then().extract().response();
				
//				System.out.println("API - /login");
//				System.out.println("Response:"+login.asString());
//				System.out.println("Status Code:"+login.statusCode());
				
				
				String JSONasstring = "["+login.asString()+"]";
				JSONArray JSONArray = new JSONArray(JSONasstring);
				String id=JSONArray.getJSONObject(0).get("id").toString();
				String token=JSONArray.getJSONObject(0).get("token").toString();
				
				// Second Request - POST /account/{id}/billing
				String Post_account_id_info = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_info/POST_account_id_info_InvalidFields.json");
				Response accountIdInfo = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_info).queryParam("token", token).when().post("/account/"+id+"/info").then().statusCode(400).body("errors", hasItems("invalidFirstName","invalidLastName","invalidEmail","invalidPassword")).extract().response();
				String asString = "["+accountIdInfo.asString()+"]";
				System.out.println("API - POST /account/{id}/billing");
				System.out.println("Response:"+accountIdInfo.asString());
				System.out.println("Status Code:"+accountIdInfo.statusCode());

	}
	public void POST_account_id_info_ValidFieldsProvided() throws Exception{
		String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
		System.out.println(Post_Login);
				System.out.println(Authorizationtoken);
				// First Request - POST /login
				Response login =given().baseUri(BaseURI).header("Authorization",Authorizationtoken).contentType(ContentType.JSON).with().body(Post_Login).when().post("/login").then().extract().response();
				
//				System.out.println("API - /login");
//				System.out.println("Response:"+login.asString());
//				System.out.println("Status Code:"+login.statusCode());
				
				
				String JSONasstring = "["+login.asString()+"]";
				JSONArray JSONArray = new JSONArray(JSONasstring);
				String id=JSONArray.getJSONObject(0).get("id").toString();
				String token=JSONArray.getJSONObject(0).get("token").toString();
				
				// Second Request - POST /account/{id}/billing
				String Post_account_id_info = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_info/POST_account_id_info_ValidFields.json");
				Response accountIdInfo = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_info).queryParam("token", token).when().post("/account/"+id+"/info").then().statusCode(200).extract().response();
				String asString = "["+accountIdInfo.asString()+"]";
				System.out.println("API - POST /account/{id}/billing");
				System.out.println("Response:"+accountIdInfo.asString());
				System.out.println("Status Code:"+accountIdInfo.statusCode());

	}
}
