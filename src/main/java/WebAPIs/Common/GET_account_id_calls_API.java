package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GET_account_id_calls_API extends APIStart{
	public void GET_account_id_calls_Unauthorised() throws Exception
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
		
				Response Get_accountIdCalls = given().baseUri(BaseURI).queryParam("limit", "3").queryParam("start", "1469404800").queryParam("end", "14696242008").when().get("/account/"+id+"/calls").then().statusCode(401).extract().response();
					
					System.out.println("API - POST /account/{id}/billing/history");
					System.out.println("Response:"+Get_accountIdCalls.asString());
					System.out.println("Status Code:"+Get_accountIdCalls.statusCode());

	}
	public void GET_account_id_calls_ValidFieldsProvided() throws Exception
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
				Response Get_accountIdCalls = given().baseUri(BaseURI).queryParam("token", token).queryParam("limit", "3").queryParam("start", "1469404800").queryParam("end", "14696242008").when().get("/account/"+id+"/calls").then().statusCode(200).extract().response();
					
					System.out.println("API - POST /account/{id}/billing");
					System.out.println("Response:"+Get_accountIdCalls.asString());
					System.out.println("Status Code:"+Get_accountIdCalls.statusCode());
					
					assert(Get_accountIdCalls.asString().contains("history"));
//					assert(Get_accountIdBilling.asString().contains("exp"));
//					assert(Get_accountIdBilling.asString().contains("month"));
//					assert(Get_accountIdBilling.asString().contains("year"));
	}
	public void GET_account_id_calls_InvalidFieldsProvided() throws Exception
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
				Response Get_accountIdCalls = given().baseUri(BaseURI).queryParam("token", token).queryParam("limit", "0").queryParam("start", "146").queryParam("end", "14").when().get("/account/"+id+"/calls").then().statusCode(400).body("errors", hasItems("invalidLimit,","invalidStart","invalidEnd")).extract().response();
					
					System.out.println("API - POST /account/{id}/billing/history");
					System.out.println("Response:"+Get_accountIdCalls.asString());
					System.out.println("Status Code:"+Get_accountIdCalls.statusCode());
					
//					assert(Get_accountIdBillingHistory.asString().contains("history"));
//					assert(Get_accountIdBilling.asString().contains("exp"));
//					assert(Get_accountIdBilling.asString().contains("month"));
//					assert(Get_accountIdBilling.asString().contains("year"));
	}

}
