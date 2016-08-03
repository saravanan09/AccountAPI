package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;

import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GET_account_id_wallet_API extends APIStart{
	
	public void GET_account_id_wallet_UnAuthorized() throws Exception
	{
		String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
		System.out.println(Post_Login);
				System.out.println(Authorizationtoken);
				// First Request - POST /login
				Response login =given().baseUri(BaseURI).header("Authorization",Authorizationtoken).contentType(ContentType.JSON).with().body(Post_Login).when().post("/login").then().extract().response();
				
				System.out.println("API - /login");
				System.out.println("Response:"+login.asString());
				System.out.println("Status Code:"+login.statusCode());
				
				
				String JSONasstring = "["+login.asString()+"]";
				JSONArray JSONArray = new JSONArray(JSONasstring);
				String id=JSONArray.getJSONObject(0).get("id").toString();
				String token=JSONArray.getJSONObject(0).get("token").toString();
//				String test = "["+generateStringFromJSON(userdir+"/GET_account_id_billing_ValidFields.json")+"]";
//				System.out.println(test);
				Response Get_accountIdWallet = given().baseUri(BaseURI).when().get("/account/"+id+"/wallet").then().statusCode(401).extract().response();
					
					System.out.println("API - POST /account/{id}/info");
					System.out.println("Response:"+Get_accountIdWallet.asString());
					System.out.println("Status Code:"+Get_accountIdWallet.statusCode());

	}
	public void GET_account_id_wallet_ValidFieldsProvided() throws Exception
	{
		String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
		System.out.println(Post_Login);
				System.out.println(Authorizationtoken);
				// First Request - POST /login
				Response login =given().baseUri(BaseURI).header("Authorization",Authorizationtoken).contentType(ContentType.JSON).with().body(Post_Login).when().post("/login").then().extract().response();
				
				System.out.println("API - /login");
				System.out.println("Response:"+login.asString());
				System.out.println("Status Code:"+login.statusCode());
				
				
				String JSONasstring = "["+login.asString()+"]";
				JSONArray JSONArray = new JSONArray(JSONasstring);
				String id=JSONArray.getJSONObject(0).get("id").toString();
				String token=JSONArray.getJSONObject(0).get("token").toString();
//				String test = "["+generateStringFromJSON(userdir+"/GET_account_id_billing_ValidFields.json")+"]";
//				System.out.println(test);
				Response Get_accountIdWallet = given().baseUri(BaseURI).queryParam("token", token).when().get("/account/"+id+"/wallet").then().statusCode(200).extract().response();
					
					System.out.println("API - POST /account/{id}/info");
					System.out.println("Response:"+Get_accountIdWallet.asString());
					System.out.println("Status Code:"+Get_accountIdWallet.statusCode());
					assert(Get_accountIdWallet.asString().contains("amount"));

	}
}
