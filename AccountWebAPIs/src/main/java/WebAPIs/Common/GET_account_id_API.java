package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.io.IOException;

import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GET_account_id_API extends APIStart{
	public void GET_account_id_UnAuthorized() throws Exception
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
				Response Get_accountId = given().baseUri(BaseURI).when().get("/account/"+id).then().statusCode(401).extract().response();
					
					System.out.println("API - GET /account/{id}");
					System.out.println("Response:"+Get_accountId.asString());
					System.out.println("Status Code:"+Get_accountId.statusCode());

	}
public void GET_account_id_ValidFieldsProvided() throws Exception
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
//			String test = "["+generateStringFromJSON(userdir+"/GET_account_id_billing_ValidFields.json")+"]";
//			System.out.println(test);
			Response Get_accountId = given().baseUri(BaseURI).queryParam("token", token).when().get("/account/"+id).then().statusCode(200).extract().response();
				System.out.println("API - GET /account/{id}");
				System.out.println("Response:"+Get_accountId.asString());
				System.out.println("Status Code:"+Get_accountId.statusCode());

				assert(Get_accountId.asString().contains("autoRecharge"));
				assert(Get_accountId.asString().contains("firstName"));
				assert(Get_accountId.asString().contains("lastName"));
				assert(Get_accountId.asString().contains("language"));
				assert(Get_accountId.asString().contains("email"));
				assert(Get_accountId.asString().contains("tou"));
				assert(Get_accountId.asString().contains("msisdn"));
				assert(Get_accountId.asString().contains("status"));
				assert(Get_accountId.asString().contains("wallet"));
				assert(Get_accountId.asString().contains("plan"));
				assert(Get_accountId.asString().contains("id"));
				assert(Get_accountId.asString().contains("exp"));
				assert(Get_accountId.asString().contains("nextPlan"));
					System.out.println("happy");
				
}
}
