package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class POST_account_id_checkout extends APIStart{

	public void POST_account_id_checkout_UnAuthorized() throws Exception
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
				String Post_account_id_checkout_wallet = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_wallet.json");
				Response accountIdCheckoutWallet = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout_wallet).when().post("/account/"+id+"/checkout").then().statusCode(401).extract().response();
				String asString = "["+accountIdCheckoutWallet.asString()+"]";
				System.out.println("API - POST /account/{id}/billing");
				System.out.println("Response:"+accountIdCheckoutWallet.asString());
				System.out.println("Status Code:"+accountIdCheckoutWallet.statusCode());

	}
	
	public void POST_account_id_checkout_Wallet_ValidFieldsProvided() throws Exception
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
				String Post_account_id_checkout_wallet = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_wallet.json");
				Response accountIdCheckoutWallet = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout_wallet).queryParam("token", token).when().post("/account/"+id+"/checkout").then().statusCode(200).body("status", is("complete")).extract().response();
				String asString = "["+accountIdCheckoutWallet.asString()+"]";
				System.out.println("API - POST /account/{id}/billing");
				System.out.println("Response:"+accountIdCheckoutWallet.asString());
				System.out.println("Status Code:"+accountIdCheckoutWallet.statusCode());
	}
	public void POST_account_id_checkout_Wallet_invalidFieldsProvided() throws Exception
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
				String Post_account_id_checkout_wallet = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_wallet_InvalidFields.json");
				Response accountIdCheckoutWallet = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout_wallet).queryParam("token", token).when().post("/account/"+id+"/checkout").then().statusCode(400).body("errors", hasItem("invalidWallet")).extract().response();
				String asString = "["+accountIdCheckoutWallet.asString()+"]";
				System.out.println("API - POST /account/{id}/billing");
				System.out.println("Response:"+accountIdCheckoutWallet.asString());
				System.out.println("Status Code:"+accountIdCheckoutWallet.statusCode());
	}
	public void POST_account_id_checkout_BoltOn_ValidFieldsProvided() throws Exception{
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
				String Post_account_id_checkout_bolton = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_bolton.json");
				Response accountIdCheckoutBolton = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout_bolton).queryParam("token", token).when().post("/account/"+id+"/checkout").then().statusCode(200).body("status", is("complete")).extract().response();
				String asString = "["+accountIdCheckoutBolton.asString()+"]";
				System.out.println("API - POST /account/{id}/checkout");
				System.out.println("Response:"+accountIdCheckoutBolton.asString());
				System.out.println("Status Code:"+accountIdCheckoutBolton.statusCode());
	}
	public void POST_account_id_checkout_BoltOn_InvalidFieldsProvided() throws Exception{
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
				String Post_account_id_checkout_bolton = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_bolton_InvalidFields.json");
				Response accountIdCheckoutBolton = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout_bolton).queryParam("token", token).when().post("/account/"+id+"/checkout").then().statusCode(400).body("errors", hasItem("invalidBoltOn")).extract().response();
				String asString = "["+accountIdCheckoutBolton.asString()+"]";
				System.out.println("API - POST /account/{id}/checkout");
				System.out.println("Response:"+accountIdCheckoutBolton.asString());
				System.out.println("Status Code:"+accountIdCheckoutBolton.statusCode());
	}
	public void POST_account_id_checkout_Recharge_ValidFieldsProvided() throws Exception{
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
				String Post_account_id_checkout_recharge = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_recharge.json");
				Response accountIdCheckoutRecharge = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout_recharge).queryParam("token", token).when().post("/account/"+id+"/checkout").then().body("status", is("complete")).extract().response();
				String asString = "["+accountIdCheckoutRecharge.asString()+"]";
				System.out.println("API - POST /account/{id}/checkout");
				System.out.println("Response:"+accountIdCheckoutRecharge.asString());
				System.out.println("Status Code:"+accountIdCheckoutRecharge.statusCode());
		
	}
	public void POST_account_id_checkout_Plan_ValidFieldsProvided() throws Exception{
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
				String Post_account_id_checkout_plan = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_plan.json");
				Response accountIdCheckoutPlan = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout_plan).queryParam("token", token).when().post("/account/"+id+"/checkout").then().statusCode(200).body("status", is("complete")).extract().response();
				String asString = "["+accountIdCheckoutPlan.asString()+"]";
				System.out.println("API - POST /account/{id}/checkout");
				System.out.println("Response:"+accountIdCheckoutPlan.asString());
				System.out.println("Status Code:"+accountIdCheckoutPlan.statusCode());
		
	}
	public void POST_account_id_checkout_Plan_InvalidFieldsProvided() throws Exception{
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
				String Post_account_id_checkout_plan = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_plan_InvalidFields.json");
				Response accountIdCheckoutPlan = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout_plan).queryParam("token", token).when().post("/account/"+id+"/checkout").then().statusCode(400).body("errors", hasItem("invalidPlan")).extract().response();
				String asString = "["+accountIdCheckoutPlan.asString()+"]";
				System.out.println("API - POST /account/{id}/checkout");
				System.out.println("Response:"+accountIdCheckoutPlan.asString());
				System.out.println("Status Code:"+accountIdCheckoutPlan.statusCode());
		
	}
	public void POST_account_id_checkout_InvalidItem() throws Exception{
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
				String Post_account_id_checkout = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_InvalidItem.json");
				Response accountIdCheckout = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout).queryParam("token", token).when().post("/account/"+id+"/checkout").then().statusCode(400).body("errors", hasItem("invalidItem")).extract().response();
				String asString = "["+accountIdCheckout.asString()+"]";
				System.out.println("API - POST /account/{id}/checkout");
				System.out.println("Response:"+accountIdCheckout.asString());
				System.out.println("Status Code:"+accountIdCheckout.statusCode());
		
	}
	public void POST_account_id_checkout_wallet_denied() throws Exception
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
				System.out.println(JSONasstring);
				JSONArray JSONArray = new JSONArray(JSONasstring);
				String id=JSONArray.getJSONObject(0).get("id").toString();
				String token=JSONArray.getJSONObject(0).get("token").toString();
				
				// Second Request - POST /account/{id}/billing
				String Post_account_id_checkout_wallet = generateStringFromJSON(userdir+"/POST_InputData/POST_account_id_checkout/POST_account_id_checkout_wallet_denied.json");
				Response accountIdCheckoutWallet = given().baseUri(BaseURI).contentType(ContentType.JSON).with().body(Post_account_id_checkout_wallet).queryParam("token", token).when().post("/account/"+id+"/checkout").then().statusCode(200).body("status", is("denied")).body("reason", is("unableChargeCC")).extract().response();
				String asString = "["+accountIdCheckoutWallet.asString()+"]";
				System.out.println("API - POST /account/{id}/billing");
				System.out.println("Response:"+accountIdCheckoutWallet.asString());
				System.out.println("Status Code:"+accountIdCheckoutWallet.statusCode());
	}
}
