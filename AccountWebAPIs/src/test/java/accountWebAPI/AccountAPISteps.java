package accountWebAPI;

import cucumber.api.java.en.Given;
import WebAPIs.Common.GET_account_id_API;
import WebAPIs.Common.GET_account_id_auto_recharge_API;
import WebAPIs.Common.GET_account_id_billing_API;
import WebAPIs.Common.GET_account_id_billing_history_API;
import WebAPIs.Common.GET_account_id_calls_API;
import WebAPIs.Common.GET_account_id_info_API;
import WebAPIs.Common.GET_account_id_preferences_API;
import WebAPIs.Common.GET_account_id_wallet_API;
import WebAPIs.Common.POST_account_id_auto_recharge_API;
import WebAPIs.Common.POST_account_id_billing_API;
import WebAPIs.Common.POST_account_id_checkout;
import WebAPIs.Common.POST_account_id_info_API;
import WebAPIs.Common.POST_account_id_preferences_API;

public class AccountAPISteps {
	POST_account_id_billing_API PostBilling = new POST_account_id_billing_API();	
	GET_account_id_billing_API GetBilling= new GET_account_id_billing_API();
	GET_account_id_info_API GetInfo= new GET_account_id_info_API();
	POST_account_id_info_API PostInfo= new POST_account_id_info_API();
	GET_account_id_auto_recharge_API GetAR= new GET_account_id_auto_recharge_API();
	POST_account_id_auto_recharge_API PostAR= new POST_account_id_auto_recharge_API();
	GET_account_id_API GetId= new GET_account_id_API();
	GET_account_id_wallet_API GetWallet= new  GET_account_id_wallet_API();
	POST_account_id_checkout PostCheckout= new POST_account_id_checkout();
	GET_account_id_preferences_API GetPref = new GET_account_id_preferences_API();
	POST_account_id_preferences_API PostPref = new POST_account_id_preferences_API();
	GET_account_id_billing_history_API GetBillingHistory = new GET_account_id_billing_history_API();
	GET_account_id_calls_API GetCalls = new GET_account_id_calls_API();
	
	@Given("^an invalid or missing token and making a POST request to account_ID_billing then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_POST_request_to_account_ID_billing_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    try{
	    	PostBilling.POST_accountIdBilling_Unauthorized();
//	    	test1.log(LogStatus.PASS,"POST /account/{id}/billing - Unauthorized");
//	    }catch(Exception e){
//	    	System.out.println(e.getMessage());
//	    	test1.log(LogStatus.FAIL, e.getMessage());
//	    }
//	    test.appendChild(test1);
//		extent.endTest(test);
//		extent.flush();

	}

	@Given("^invalid fields and making a POST request to account_ID_billing then it should return a (\\d+) and a body of invalid field error$")
	public void invalid_fields_and_making_a_POST_request_to_account_ID_billing_then_it_should_return_a_and_a_body_of_invalid_field_error(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		test2=extent.startTest("API Test");
//		PostBilling = new POST_account_id_billing_API();
//	    try{
	    	PostBilling.POST_accountIdBilling_InvalidFieldsProvided();
//	    	test2.log(LogStatus.PASS,"POST /account/{id}/billing - Invalid Fields");
//	    }catch(Exception e){
//	    	System.out.println(e.getMessage());
//	    	test2.log(LogStatus.FAIL, e.getMessage());
//	    }
	     

	}

	@Given("^valid fields and making a POST request to account_ID_billing with the credit card cant be authorized then it should return a (\\d+) and a body of denied status and reason$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_billing_with_the_credit_card_cant_be_authorized_then_it_should_return_a_and_a_body_of_denied_status_and_reason(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		test3=extent.startTest("API Test");
//	    try{
	    	PostBilling.POST_accountIdBilling_UnableToAuthorizeCCInfo();
//	    	test3.log(LogStatus.PASS,"POST /account/{id}/billing - Unauthorized CC Info");
//	    }catch(Exception e){
//	    	test3.log(LogStatus.FAIL, e.getMessage());
//	    	System.out.println(e.getMessage());
//	    }
	      
	    
	}

	@Given("^valid fields and making a POST request to account_ID_billing then it should return a (\\d+) and an empty body$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_billing_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		test4=extent.startTest("API Test");
//	    try{
	    	PostBilling.POST_accountIdBilling_ValidfieldsProvided();
//	    	test4.log(LogStatus.PASS,"POST /account/{id}/billing - Valid Fields");
//	    }catch(Exception e){
//	    	System.out.println(e.getMessage());
//	    	test4.log(LogStatus.FAIL, e.getMessage());
//	    }
//	    test.appendChild(test1).appendChild(test2).appendChild(test3).appendChild(test4);
//		extent.endTest(test);
//		extent.flush();
	    
//		  extent.flush();
		
		  
	}

	@Given("^an invalid or missing token and making a GET request to account_ID_billing then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_GET_request_to_account_ID_billing_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetBilling.GET_account_id_billing_Unauthorised();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a GET request to account_ID_billing then it should return a (\\d+) and a body of customer billing details$")
	public void valid_fields_and_making_a_GET_request_to_account_ID_billing_then_it_should_return_a_and_a_body_of_customer_billing_details(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetBilling.GET_account_id_billing_ValidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a GET request to account_ID_billing and the user does not have billing info then it should return a (\\d+) and an empty body$")
	public void valid_fields_and_making_a_GET_request_to_account_ID_billing_and_the_user_does_not_have_billing_info_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetBilling.GET_account_id_billing_CustomerWithNoBillingInfo();
	    try{}catch(Exception e){}
	}

	@Given("^an invalid or missing token and making a GET request to account_ID_info then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_GET_request_to_account_ID_info_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetInfo.GET_account_id_info_UnAuthorized();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a GET request to account_ID_info then it should return a (\\d+) and a body of customer info details$")
	public void valid_fields_and_making_a_GET_request_to_account_ID_info_then_it_should_return_a_and_a_body_of_customer_info_details(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetInfo.GET_account_id_info_ValidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^an invalid or missing token and making a POST request to account_ID_info then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_POST_request_to_account_ID_info_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostInfo.POST_account_id_info_API_UnAuthorized();
	    try{}catch(Exception e){}
	}

	@Given("^invalid fields and making a POST request to account_ID_info then it should return a (\\d+) and a body of invalid field error$")
	public void invalid_fields_and_making_a_POST_request_to_account_ID_info_then_it_should_return_a_and_a_body_of_invalid_field_error(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostInfo.POST_account_id_info_InvalidFieldsProvided();
		try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_info then it should return a (\\d+) and an empty body$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_info_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostInfo.POST_account_id_info_ValidFieldsProvided();
		try{}catch(Exception e){}
	}

	@Given("^an invalid or missing token and making a GET request to account_ID_auto_recharge then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_GET_request_to_account_ID_auto_recharge_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetAR.GET_account_id_auto_recharge_UnAuthorized();
		try{}catch(Exception e){}
	}

	@Given("^valid fields and making a GET request to account_ID_auto_recharge then it should return a (\\d+) and a body of autoRecharge parameter details$")
	public void valid_fields_and_making_a_GET_request_to_account_ID_auto_recharge_then_it_should_return_a_and_a_body_of_autoRecharge_parameter_details(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetAR.GET_account_id_auto_recharge_ValidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^an invalid or missing token and making a POST request to account_ID_auto_recharge then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_POST_request_to_account_ID_auto_recharge_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostAR.POST_account_id_auto_recharge_UnAuthorized();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_auto_recharge then it should return a (\\d+) and an empty body$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_auto_recharge_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostAR.POST_account_id_auto_recharge_ValidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^an invalid or missing token and making a GET request to account_ID then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_GET_request_to_account_ID_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetId.GET_account_id_UnAuthorized();
		try{}catch(Exception e){}
	}

	@Given("^valid fields and making a GET request to account_ID then it should return a (\\d+) and a body of customer ID details$")
	public void valid_fields_and_making_a_GET_request_to_account_ID_then_it_should_return_a_and_a_body_of_customer_ID_details(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetId.GET_account_id_ValidFieldsProvided();
		try{}catch(Exception e){}
	}

	@Given("^an invalid or missing token and making a GET request to account_ID_wallet then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_GET_request_to_account_ID_wallet_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetWallet.GET_account_id_wallet_UnAuthorized();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a GET request to account_ID_wallet then it should return a (\\d+) and a body of wallet amount in cents$")
	public void valid_fields_and_making_a_GET_request_to_account_ID_wallet_then_it_should_return_a_and_a_body_of_wallet_amount_in_cents(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetWallet.GET_account_id_wallet_ValidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^an invalid or missing token and making a POST request to account_ID_checkout then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_POST_request_to_account_ID_checkout_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_UnAuthorized();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_checkout with item wallet then it should return a (\\d+) and a body with status complete$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_checkout_with_item_wallet_then_it_should_return_a_and_a_body_with_status_complete(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_Wallet_ValidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_checkout with item bolton then it should return a (\\d+) and a body with status complete$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_checkout_with_item_bolton_then_it_should_return_a_and_a_body_with_status_complete(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_BoltOn_ValidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_checkout with item recharge then it should return a (\\d+) and a body with status complete$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_checkout_with_item_recharge_then_it_should_return_a_and_a_body_with_status_complete(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_Recharge_ValidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_checkout with item plan then it should return a (\\d+) and a body with status complete$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_checkout_with_item_plan_then_it_should_return_a_and_a_body_with_status_complete(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_Plan_ValidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_checkout with invalid wallet amount then it should return a (\\d+) and a body with invalid Wallet error$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_checkout_with_invalid_wallet_amount_then_it_should_return_a_and_a_body_with_invalid_Wallet_error(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_Wallet_invalidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_checkout with invalid bolton then it should return a (\\d+) and a body with invalid Bolton error$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_checkout_with_invalid_bolton_then_it_should_return_a_and_a_body_with_invalid_Bolton_error(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_BoltOn_InvalidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_checkout with invalid plan then it should return a (\\d+) and a body with invalid Plan error$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_checkout_with_invalid_plan_then_it_should_return_a_and_a_body_with_invalid_Plan_error(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_Plan_InvalidFieldsProvided();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_checkout with invalid item then it should return a (\\d+) and a body with invalid Item error$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_checkout_with_invalid_item_then_it_should_return_a_and_a_body_with_invalid_Item_error(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_InvalidItem();
	    try{}catch(Exception e){}
	}

	@Given("^valid fields and making a POST request to account_ID_checkout wallet then it should return a (\\d+) and a body with denied status and reason$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_checkout_wallet_then_it_should_return_a_and_a_body_with_denied_status_and_reason(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostCheckout.POST_account_id_checkout_wallet_denied();
	    try{}catch(Exception e){}
	    
	}
	
	@Given("^an invalid or missing token and making a GET request to account_ID_preferences then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_GET_request_to_account_ID_preferences_then_it_should_return_a_and_an_empty_body(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   GetPref.Get_account_id_preferences_Unauthorised();
	}

	@Given("^valid fields and making a GET request to account_ID_preferences then it should return a (\\d+) and a body of language and promo parameter details$")
	public void valid_fields_and_making_a_GET_request_to_account_ID_auto_preferences_then_it_should_return_a_and_a_body_of_language_and_promo_parameter_details(int StatusCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetPref.Get_account_id_preferences_ValidFieldsProvided();
	}
	@Given("^an invalid or missing token and making a POST request to account_ID_preferences then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_POST_request_to_account_ID_preferences_then_it_should_return_a_and_an_empty_body(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   PostPref.Post_account_id_preferences_Unauthorised();
	}

	@Given("^valid fields and making a POST request to account_ID_preferences then it should return a (\\d+) and a empty body$")
	public void valid_fields_and_making_a_POST_request_to_account_ID_preferences_then_it_should_return_a_and_a_empty_body(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostPref.Post_account_id_preferences_ValidFieldsProvided();
	}

	@Given("^invalid fields and making a POST request to account_ID_preferences then it should return a (\\d+) and a body invalid error$")
	public void invalid_fields_and_making_a_POST_request_to_account_ID_preferences_then_it_should_return_a_and_a_body_invalid_error(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PostPref.Post_account_id_preferences_InvalidFieldsProvided();
	}

	@Given("^an invalid or missing token and making a GET request to account_ID_billing_history then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_GET_request_to_account_ID_billing_history_then_it_should_return_a_and_an_empty_body(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetBillingHistory.GET_account_id_billing_history_Unauthorised();
	}

	@Given("^valid fields and making a GET request to account_ID_billing_history then it should return a (\\d+) and a body of billing history details$")
	public void valid_fields_and_making_a_GET_request_to_account_ID_billing_history_then_it_should_return_a_and_a_body_of_billing_history_details(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetBillingHistory.GET_account_id_billing_history_ValidFieldsProvided();
	}

	@Given("^invalid fields and making a GET request to account_ID_billing_history then it should return a (\\d+) and a body with error parameter$")
	public void invalid_fields_and_making_a_GET_request_to_account_ID_billing_history_then_it_should_return_a_and_a_body_with_error_parameter(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetBillingHistory.GET_account_id_billing_history_InvalidFieldsProvided();
	}
	@Given("^an invalid or missing token and making a GET request to account_ID_calls then it should return a (\\d+) and an empty body$")
	public void an_invalid_or_missing_token_and_making_a_GET_request_to_account_ID_calls_then_it_should_return_a_and_an_empty_body(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    GetCalls.GET_account_id_calls_Unauthorised();
	}

	@Given("^valid fields and making a GET request to account_ID_calls then it should return a (\\d+) and a body of billing history details$")
	public void valid_fields_and_making_a_GET_request_to_account_ID_calls_then_it_should_return_a_and_a_body_of_billing_history_details(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetCalls.GET_account_id_calls_ValidFieldsProvided();
	}

	@Given("^invalid fields and making a GET request to account_ID_calls then it should return a (\\d+) and a body with error parameter$")
	public void invalid_fields_and_making_a_GET_request_to_account_ID_calls_then_it_should_return_a_and_a_body_with_error_parameter(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GetCalls.GET_account_id_calls_InvalidFieldsProvided();
	}

}
