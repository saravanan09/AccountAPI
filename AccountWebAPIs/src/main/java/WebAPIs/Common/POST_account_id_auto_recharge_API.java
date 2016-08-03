package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;

import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class POST_account_id_auto_recharge_API extends APIStart{

	public void POST_account_id_auto_recharge_UnAuthorized() throws Exception
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
				String Post_account_id_info = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_auto-recharge/POST_account_id_auto-recharge.json");
				Response accountIdAutoRecharge = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_info).when().post("/account/"+id+"/auto-recharge").then().statusCode(401).extract().response();
				String asString = "["+accountIdAutoRecharge.asString()+"]";
				System.out.println("API - POST /account/{id}/auto-recharge");
				System.out.println("Response:"+accountIdAutoRecharge.asString());
				System.out.println("Status Code:"+accountIdAutoRecharge.statusCode());

	}
	public void POST_account_id_auto_recharge_ValidFieldsProvided() throws Exception
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
				String Post_account_id_info = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_auto-recharge/POST_account_id_auto-recharge.json");
				Response accountIdAutoRecharge = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_info).queryParam("token", token).when().post("/account/"+id+"/auto-recharge").then().statusCode(200).extract().response();
				String asString = "["+accountIdAutoRecharge.asString()+"]";
				System.out.println("API - POST /account/{id}/auto-recharge");
				System.out.println("Response:"+accountIdAutoRecharge.asString());
				System.out.println("Status Code:"+accountIdAutoRecharge.statusCode());


	}
}
