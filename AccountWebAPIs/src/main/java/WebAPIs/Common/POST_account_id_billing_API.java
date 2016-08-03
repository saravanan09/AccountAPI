package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;

import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class POST_account_id_billing_API extends APIStart 
{
public void POST_accountIdBilling_Unauthorized() throws Exception
{
	String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
	System.out.println(Post_Login);
			System.out.println(Authorizationtoken);
			System.out.println(BaseURI);
			// First Request - POST /login
			Response login =given().baseUri(BaseURI).header("Authorization",Authorizationtoken).contentType(ContentType.JSON).with().body(Post_Login).when().post("/login").then().extract().response();
			
//			System.out.println("API - /login");
//			System.out.println("Response:"+login.asString());
//			System.out.println("Status Code:"+login.statusCode());
			
			
			String JSONasstring = "["+login.asString()+"]";
			JSONArray JSONArray = new JSONArray(JSONasstring);
			String id=JSONArray.getJSONObject(0).get("id").toString();
			String token=JSONArray.getJSONObject(0).get("token").toString();
			
			// Second Request - POST /account/{id}/billing
			String Post_account_id_billing = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_billing/POST_account_id_billing_ValidFields.json");
			Response accountIdBilling = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_billing).when().post("/account/"+id+"/billing").then().statusCode(401).extract().response();
//			String asString = "["+accountIdBilling.asString()+"]";
			System.out.println("API - POST /account/{id}/billing");
			System.out.println("Response:"+accountIdBilling.asString());
			System.out.println("Status Code:"+accountIdBilling.statusCode());

}
public void POST_accountIdBilling_InvalidFieldsProvided() throws Exception
{
	String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
	System.out.println(Post_Login);
			System.out.println(Authorizationtoken);
			// First Request - POST /login
			Response login =given().baseUri(BaseURI).header("Authorization",Authorizationtoken).contentType(ContentType.JSON).with().body(Post_Login).when().post("/login").then().extract().response();
			
//			System.out.println("API - /login");
//			System.out.println("Response:"+login.asString());
//			System.out.println("Status Code:"+login.statusCode());
			
			
			String JSONasstring = "["+login.asString()+"]";
			JSONArray JSONArray = new JSONArray(JSONasstring);
			String id=JSONArray.getJSONObject(0).get("id").toString();
			String token=JSONArray.getJSONObject(0).get("token").toString();
			
			// Second Request - POST /account/{id}/billing
			String Post_account_id_billing = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_billing/POST_account_id_billing_InvalidFields.json");
			Response accountIdBilling = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_billing).queryParam("token", token).when().post("/account/"+id+"/billing").then().statusCode(400).body("errors", hasItems("invalidCardNumber","invalidCvv","invalidAddress1","invalidCity","invalidState","invalidZip","invalidFirstName","invalidLastName","invalidExp")).extract().response();
			String asString = "["+accountIdBilling.asString()+"]";
			System.out.println("API - POST /account/{id}/billing");
			System.out.println("Response:"+accountIdBilling.asString());
			System.out.println("Status Code:"+accountIdBilling.statusCode());

}
public void POST_accountIdBilling_UnableToAuthorizeCCInfo() throws Exception
{
	String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
	System.out.println(Post_Login);
			System.out.println(Authorizationtoken);
			// First Request - POST /login
			Response login =given().baseUri(BaseURI).header("Authorization",Authorizationtoken).contentType(ContentType.JSON).with().body(Post_Login).when().post("/login").then().extract().response();
			
//			System.out.println("API - /login");
//			System.out.println("Response:"+login.asString());
//			System.out.println("Status Code:"+login.statusCode());
			
			
			String JSONasstring = "["+login.asString()+"]";
			JSONArray JSONArray = new JSONArray(JSONasstring);
			String id=JSONArray.getJSONObject(0).get("id").toString();
			String token=JSONArray.getJSONObject(0).get("token").toString();
			
			// Second Request - POST /account/{id}/billing
			String Post_account_id_billing = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_billing/POST_account_id_billing_UnauthorisedCC.json");
			Response accountIdBilling = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_billing).queryParam("token", token).when().post("/account/"+id+"/billing").then().statusCode(402).body("status", is("denied")).body("reason", is("creditCardNotAuthorized")).extract().response();
			String asString = "["+accountIdBilling.asString()+"]";
			System.out.println("API - POST /account/{id}/billing");
			System.out.println("Response:"+accountIdBilling.asString());
			System.out.println("Status Code:"+accountIdBilling.statusCode());

}
public void POST_accountIdBilling_ValidfieldsProvided() throws Exception
{
	String Post_Login = generateStringFromJSON(userdir+"/POST_InputData/Supporting_APIs/POST_login_ValidFields.json");		
	System.out.println(Post_Login);
			System.out.println(Authorizationtoken);
			// First Request - POST /login
			Response login =given().baseUri(BaseURI).header("Authorization",Authorizationtoken).contentType(ContentType.JSON).with().body(Post_Login).when().post("/login").then().extract().response();
			
//			System.out.println("API - /login");
//			System.out.println("Response:"+login.asString());
//			System.out.println("Status Code:"+login.statusCode());
			
			
			String JSONasstring = "["+login.asString()+"]";
			JSONArray JSONArray = new JSONArray(JSONasstring);
			String id=JSONArray.getJSONObject(0).get("id").toString();
			String token=JSONArray.getJSONObject(0).get("token").toString();
			
			// Second Request - POST /account/{id}/billing
			String Post_account_id_billing = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_billing/POST_account_id_billing_ValidFields.json");
			Response accountIdBilling = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_billing).queryParam("token", token).when().post("/account/"+id+"/billing").then().statusCode(200).log().ifError().extract().response();
			String asString = "["+accountIdBilling.asString()+"]";
			System.out.println("API - POST /account/{id}/billing");
			System.out.println("Response:"+accountIdBilling.asString());
			System.out.println("Status Code:"+accountIdBilling.statusCode());
			
}
public void GET_sims_id_billing(String actCode) throws Exception
{
	// To Order SIM - orderNum and serial should be updated in GET_sims_id_billing_orderSIMOnline.json
	String Post_Order = generateStringFromJSON("C:/Users/Saravanan Valliappan/workspace/WebAPIs/POST_InputData/GET_sims_id_billing_orderSIMOnline.json");		
	System.out.println(Post_Order);
			System.out.println(Authorizationtoken);
			// First Request - POST /order
			Response order =
			given().baseUri("http://web-qa-08.ultra.local:3100/v1")
				.contentType(ContentType.JSON)
				.with().body(Post_Order)
			.when()
				.post("/order")
			.then()
				.extract().response();
			
			System.out.println("API - /order");
			System.out.println("Response:"+order.asString());
			System.out.println("Status Code:"+order.statusCode());
			
			// To activate - Actcode need to be updated in Main
	Response activateSIM =
			given().baseUri(BaseURI)
			.header("Authorization",Authorizationtoken).contentType(ContentType.JSON)
			.queryParam("actCode", actCode)
		.when()
			.get("/sims")
		.then()
			.extract().response();
	System.out.println("API - /sims");
	System.out.println("Response:"+activateSIM.asString());
	System.out.println("Status Code:"+activateSIM.statusCode());
	
	
	String JSONasstring = "["+activateSIM.asString()+"]";
	JSONArray JSONArray = new JSONArray(JSONasstring);
	String id=JSONArray.getJSONObject(0).get("id").toString();
	String token=JSONArray.getJSONObject(0).get("token").toString();
	Response Get_simsIdBilling = 
			given().baseUri(BaseURI)
				.queryParam("token", token)
			.when()
			.get("/sims/"+id+"/billing")
			.then().extract().response();
		
		System.out.println("API - GET /sims/{id}/billing");
		System.out.println("Response:"+Get_simsIdBilling.asString());
		System.out.println("Status Code:"+Get_simsIdBilling.statusCode());
		if(Get_simsIdBilling.statusCode()==200)
		{
			assert(Get_simsIdBilling.asString().equals("autoEnroll"));
			assert(Get_simsIdBilling.asString().equals("lastFour"));
			assert(Get_simsIdBilling.asString().equals("firstName"));
			assert(Get_simsIdBilling.asString().equals("lastName"));
			System.out.println("Success");
		}
		else if(Get_simsIdBilling.statusCode()==404)
		{
			System.out.println("No customer info");
		}
		else if(Get_simsIdBilling.statusCode()==401)
		{
			System.out.println("UnauthorizedError: No authorization token was found");
		}

}
public void POST_sims_id_billing(String actCode) throws Exception
{
	// To activate - Actcode need to be updated in Main
		Response activateSIM =
				given().baseUri(BaseURI)
				.header("Authorization",Authorizationtoken).contentType(ContentType.JSON)
				.queryParam("actCode", actCode)
			.when()
				.get("/sims")
			.then()
				.extract().response();
		System.out.println("API - /sims");
		System.out.println("Response:"+activateSIM.asString());
		System.out.println("Status Code:"+activateSIM.statusCode());
		
		
		String JSONasstring = "["+activateSIM.asString()+"]";
		JSONArray JSONArray = new JSONArray(JSONasstring);
		String id=JSONArray.getJSONObject(0).get("id").toString();
		String token=JSONArray.getJSONObject(0).get("token").toString();
		
		String Post_sims_id_msisdn = generateStringFromJSON("C:/Users/Saravanan Valliappan/workspace/WebAPIs/POST_InputData/POST_sims_id_msisdn.json");
		Response POST_sims_id_msisdn= 
				given().baseUri(BaseURI)
				.contentType(ContentType.JSON)
				.with().body(Post_sims_id_msisdn)
					.queryParam("token", token)
				.when()
				.post("/sims/"+id+"/msisdn")
				.then().extract().response();
			
			System.out.println("API - POST /sims/{id}/msisdn");
			System.out.println("Response:"+POST_sims_id_msisdn.asString());
				System.out.println("Status Code:"+POST_sims_id_msisdn.statusCode());
			
			String JSONasstring1 = "["+POST_sims_id_msisdn.asString()+"]";
			JSONArray JSONArray1 = new JSONArray(JSONasstring1);
			String token1=JSONArray1.getJSONObject(0).get("token").toString();

			String Post_sims_id_billing = generateStringFromJSON("C:/Users/Saravanan Valliappan/workspace/WebAPIs/POST_InputData/POST_sims_id_billing.json");
			Response simsIdBilling = 
				given().baseUri(BaseURI)
					.contentType(ContentType.JSON)
					.with()
					.body(Post_sims_id_billing)
					.queryParam("token", token1)
				.when()
				.post("/sims/"+id+"/billing")
				.then().extract().response();
//			String asString = "["+simsIdBilling.asString()+"]";
			System.out.println("API - POST /sims/{id}/billing");
			System.out.println("Response:"+simsIdBilling.asString());
			System.out.println("Status Code:"+simsIdBilling.statusCode());
			
if(simsIdBilling.statusCode()==200)
{
	System.out.println("Success");
}
else if(simsIdBilling.statusCode()==402)
{
	assert(simsIdBilling.asString().equals("status"));
	assert(simsIdBilling.asString().equals("reason"));
	System.out.println("Unable to authorize credit card info");
//	assertThat(asString,matchesJsonSchemaInClasspath("C:/Users/Saravanan Valliappan/workspace/WebAPIs/account_id_billing_UnauthorisedCreditCard.json"));
}
else if(simsIdBilling.statusCode()==400)
{
	assert(simsIdBilling.asString().equals("errors"));
	System.out.println("Invalid field(s) provided");
}
else if(simsIdBilling.statusCode()==401)
{
	System.out.println("UnauthorizedError: No authorization token was found");
}
	
}
}