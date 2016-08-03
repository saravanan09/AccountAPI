package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
//import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import java.io.IOException;

import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GET_account_id_billing_API extends APIStart{
	
	public void GET_account_id_billing_Unauthorised() throws Exception
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
		
				Response Get_accountIdBilling = given().baseUri(BaseURI).when().get("/account/"+id+"/billing").then().statusCode(401).extract().response();
					
					System.out.println("API - POST /account/{id}/billing");
					System.out.println("Response:"+Get_accountIdBilling.asString());
					System.out.println("Status Code:"+Get_accountIdBilling.statusCode());

	}
	
	public void GET_account_id_billing_CustomerWithNoBillingInfo() throws Exception
	{
		String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFieldsWithNoBillingInfo.json");		
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
		
				Response Get_accountIdBilling = given().baseUri(BaseURI).queryParam("token", token).when().get("/account/"+id+"/billing").then().statusCode(404).extract().response();
					
					System.out.println("API - POST /account/{id}/billing");
					System.out.println("Response:"+Get_accountIdBilling.asString());
					System.out.println("Status Code:"+Get_accountIdBilling.statusCode());

	}
	public void GET_account_id_billing_ValidFieldsProvided() throws Exception
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
				Response Get_accountIdBilling = given().baseUri(BaseURI).queryParam("token", token).when().get("/account/"+id+"/billing").then().statusCode(200).extract().response();
					
					System.out.println("API - POST /account/{id}/billing");
					System.out.println("Response:"+Get_accountIdBilling.asString());
					System.out.println("Status Code:"+Get_accountIdBilling.statusCode());
					
					assert(Get_accountIdBilling.asString().contains("lastFour"));
					assert(Get_accountIdBilling.asString().contains("exp"));
					assert(Get_accountIdBilling.asString().contains("month"));
					assert(Get_accountIdBilling.asString().contains("year"));
	}

}
