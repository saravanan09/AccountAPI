package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import static org.hamcrest.Matchers.*;
import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class POST_account_id_preferences_API extends APIStart{

	public void Post_account_id_preferences_Unauthorised() throws Exception
	{
		String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
		System.out.println(Post_Login);
				System.out.println(Authorizationtoken);
				System.out.println(BaseURI);
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
				String Post_account_id_preferences = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_preferences/POST_account_id_preferences_ValidFields.json");
				Response accountIdPreferences = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_preferences).when().post("/account/"+id+"/preferences").then().statusCode(401).extract().response();
//				String asString = "["+accountIdBilling.asString()+"]";
				System.out.println("API - POST /account/{id}/billing");
				System.out.println("Response:"+accountIdPreferences.asString());
				System.out.println("Status Code:"+accountIdPreferences.statusCode());

	}
	public void Post_account_id_preferences_ValidFieldsProvided() throws Exception
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
				String Post_account_id_preferences = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_preferences/POST_account_id_preferences_ValidFields.json");
				Response accountIdpreferences = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_preferences).queryParam("token", token).when().post("/account/"+id+"/preferences").then().statusCode(200).extract().response();
				String asString = "["+accountIdpreferences.asString()+"]";
				System.out.println("API - POST /account/{id}/preferences");
				System.out.println("Response:"+accountIdpreferences.asString());
				System.out.println("Status Code:"+accountIdpreferences.statusCode());

	}
	public void Post_account_id_preferences_InvalidFieldsProvided() throws Exception
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
				String Post_account_id_preferences = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_preferences/POST_account_id_preferences_InvalidFields.json");
				Response accountIdPreferences = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_preferences).queryParam("token", token).when().post("/account/"+id+"/preferences").then().statusCode(400).body("errors", hasItem("invalidLanguage")).extract().response();
				String asString = "["+accountIdPreferences.asString()+"]";
				System.out.println("API - POST /account/{id}/preferences");
				System.out.println("Response:"+accountIdPreferences.asString());
				System.out.println("Status Code:"+accountIdPreferences.statusCode());

	}

}
