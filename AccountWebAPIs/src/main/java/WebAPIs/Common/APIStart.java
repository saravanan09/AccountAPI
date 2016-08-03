package WebAPIs.Common;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;

import com.jayway.restassured.response.Response;

public class APIStart {
	public static String brand ="ultra";
	public static String BaseURI="http://web-qa-08.ultra.local:3004/v1/"+brand;
	public static Response Authorization=given().get("http://web-qa-08.ultra.local:3002/generate.json").then().extract().response();
	public static String AuthtokenasString = "["+Authorization.asString()+"]";
	public static JSONArray JSONArray = new JSONArray(AuthtokenasString);
	public static String JSONArraytoString=JSONArray.getJSONObject(0).get("token").toString();
	public static String Authorizationtoken="Bearer "+JSONArraytoString;
	public String userdir=System.getProperty("user.dir");
	
	public String generateStringFromJSON(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}

	}
