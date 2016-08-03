Feature: Account WebAPI validation

@POST_billingUnauthorized
Scenario: To validate POST /account/{ID}/billing - Unauthorized

Given an invalid or missing token and making a POST request to account_ID_billing then it should return a 401 and an empty body

@POST_billingInvalidField
Scenario: To validate POST /account/{ID}/billing - Invalid Fields Provided

Given invalid fields and making a POST request to account_ID_billing then it should return a 400 and a body of invalid field error

@POST_billingUnableToAuthorizeCCInfo
Scenario: To validate POST /account/{ID}/billing - Unable to Authorize CC Info

Given valid fields and making a POST request to account_ID_billing with the credit card cant be authorized then it should return a 402 and a body of denied status and reason

@POST_billingValidFields
Scenario: To validate POST /account/{ID}/billing - Valid Fields Provided

Given valid fields and making a POST request to account_ID_billing then it should return a 200 and an empty body

@GET_billingUnauthorized
Scenario: To validate GET /account/{ID}/billing - Unauthorized

Given an invalid or missing token and making a GET request to account_ID_billing then it should return a 401 and an empty body

@GET_billingValidFields
Scenario: To validate GET /account/{ID}/billing - Valid Fields Provided

Given valid fields and making a GET request to account_ID_billing then it should return a 200 and a body of customer billing details

@GET_billingCustomerWithNoBillingInfo
Scenario: To validate GET /account/{ID}/billing - Customer With No Billing Info

Given valid fields and making a GET request to account_ID_billing and the user does not have billing info then it should return a 404 and an empty body

@GET_infoUnauthorized
Scenario: To validate GET /account/{ID}/info - Unauthorized

Given an invalid or missing token and making a GET request to account_ID_info then it should return a 401 and an empty body

@GET_infoValidFields
Scenario: To validate GET /account/{ID}/info - Valid Fields Provided

Given valid fields and making a GET request to account_ID_info then it should return a 200 and a body of customer info details

@POST_infoUnauthorized
Scenario: To validate POST /account/{ID}/info - Unauthorized

Given an invalid or missing token and making a POST request to account_ID_info then it should return a 401 and an empty body

@POST_infoInvalidFields
Scenario: To validate POST /account/{ID}/info - Invalid Fields Provided

Given invalid fields and making a POST request to account_ID_info then it should return a 400 and a body of invalid field error

@POST_infoValidFields
Scenario: To validate POST /account/{ID}/info - Valid Fields Provided

Given valid fields and making a POST request to account_ID_info then it should return a 200 and an empty body

@GET_autorechargeUnauthorized
Scenario: To validate GET /account/{ID}/auto-recharge - Unauthorized

Given an invalid or missing token and making a GET request to account_ID_auto_recharge then it should return a 401 and an empty body

@GET_autorechargeValidFields
Scenario: To validate GET /account/{ID}/auto-recharge - Valid Fields Provided

Given valid fields and making a GET request to account_ID_auto_recharge then it should return a 200 and a body of autoRecharge parameter details

@POST_autorechargeUnauthorized
Scenario: To validate POST /account/{ID}/auto-recharge - Unauthorized

Given an invalid or missing token and making a POST request to account_ID_auto_recharge then it should return a 401 and an empty body

@POST_autorechargeValidFields
Scenario: To validate POST /account/{ID}/auto-recharge - Valid Fields Provided

Given valid fields and making a POST request to account_ID_auto_recharge then it should return a 200 and an empty body

@GET_idUnauthorized
Scenario: To validate GET /account/{ID} - Unauthorized

Given an invalid or missing token and making a GET request to account_ID then it should return a 401 and an empty body

@GET_idValidFields
Scenario: To validate GET /account/{ID} - Valid Fields Provided

Given valid fields and making a GET request to account_ID then it should return a 200 and a body of customer ID details

@GET_walletUnauthorized
Scenario: To validate GET /account/{ID}/wallet - Unauthorized

Given an invalid or missing token and making a GET request to account_ID_wallet then it should return a 401 and an empty body

@GET_walletValidFields
Scenario: To validate GET /account/{ID}/wallet - Valid Fields Provided

Given valid fields and making a GET request to account_ID_wallet then it should return a 200 and a body of wallet amount in cents

@POST_checkoutUnauthorized
Scenario: To validate POST /account/{ID}/checkout - Unauthorized

Given an invalid or missing token and making a POST request to account_ID_checkout then it should return a 401 and an empty body

@POST_checkoutValidFields_WalletItem
Scenario: To validate POST /account/{ID}/checkout Wallet - Valid Fields Provided

Given valid fields and making a POST request to account_ID_checkout with item wallet then it should return a 200 and a body with status complete

@POST_checkoutValidFields_BoltOnItem
Scenario: To validate POST /account/{ID}/checkout BoltOn - Valid Fields Provided

Given valid fields and making a POST request to account_ID_checkout with item bolton then it should return a 200 and a body with status complete

#@POST_checkoutValidFields_RechargeItem
#Scenario: To validate POST /account/{ID}/checkout Recharge - Valid Fields Provided

#Given valid fields and making a POST request to account_ID_checkout with item recharge then it should return a 200 and a body with status complete

#@POST_checkoutValidFields_PlanItem
#Scenario: To validate POST /account/{ID}/checkout Plan - Valid Fields Provided

#Given valid fields and making a POST request to account_ID_checkout with item plan then it should return a 200 and a body with status complete

@POST_checkoutInvalidFields_WalletItem
Scenario: To validate POST /account/{ID}/checkout Wallet - Invalid Fields Provided

Given valid fields and making a POST request to account_ID_checkout with invalid wallet amount then it should return a 400 and a body with invalid Wallet error

@POST_checkoutInvalidFields_BoltOnItem
Scenario: To validate POST /account/{ID}/checkout BoltOn - Invalid Fields Provided

Given valid fields and making a POST request to account_ID_checkout with invalid bolton then it should return a 400 and a body with invalid Bolton error

#@POST_checkoutInvalidFields_PlanItem
#Scenario: To validate POST /account/{ID}/checkout Plan - Invalid Fields Provided

#Given valid fields and making a POST request to account_ID_checkout with invalid plan then it should return a 400 and a body with invalid Plan error

@POST_checkoutInvalidFields_Item
Scenario: To validate POST /account/{ID}/checkout Invalid - Invalid Fields Provided

Given valid fields and making a POST request to account_ID_checkout with invalid item then it should return a 400 and a body with invalid Item error

@POST_checkoutWallet_denied
Scenario: To validate POST /account/{ID}/checkout Wallet - Denied

Given valid fields and making a POST request to account_ID_checkout wallet then it should return a 200 and a body with denied status and reason

@GET_preferencesUnauthorised
Scenario: To validate GET /account/{ID}/preferences - Unauthorised

Given an invalid or missing token and making a GET request to account_ID_preferences then it should return a 401 and an empty body

@GET_preferencesValidFields
Scenario: To validate GET /account/{ID}/preferences - Valid Fields Provided

Given valid fields and making a GET request to account_ID_preferences then it should return a 200 and a body of language and promo parameter details

@POST_preferencesUnauthorised
Scenario: To validate POST /account/{ID}/preferences - Unauthorised

Given an invalid or missing token and making a POST request to account_ID_preferences then it should return a 401 and an empty body

@POST_preferencesValidFields
Scenario: To validate POST /account/{ID}/preferences - Valid Fields Provided

Given valid fields and making a POST request to account_ID_preferences then it should return a 200 and a empty body

@POST_preferencesInvalidFields
Scenario: To validate POST /account/{ID}/preferences - Invalid Fields Provided

Given invalid fields and making a POST request to account_ID_preferences then it should return a 400 and a body invalid error

@GET_billingHistoryUnauthorised
Scenario: To validate GET /account/{ID}/billing/history - Unauthorised

Given an invalid or missing token and making a GET request to account_ID_billing_history then it should return a 401 and an empty body

@GET_billingHistoryValidFields
Scenario: To validate GET /account/{ID}/billing/history - Valid Fields Provided

Given valid fields and making a GET request to account_ID_billing_history then it should return a 200 and a body of billing history details

@GET_billingHistoryInvalidFields
Scenario: To validate GET /account/{ID}/billing/history - Invalid Fields Provided

Given invalid fields and making a GET request to account_ID_billing_history then it should return a 400 and a body with error parameter

@GET_billingCallsUnauthorised
Scenario: To validate GET /account/{ID}/calls - Unauthorised

Given an invalid or missing token and making a GET request to account_ID_calls then it should return a 401 and an empty body

@GET_billingCallsValidFields
Scenario: To validate GET /account/{ID}/calls - Valid Fields Provided

Given valid fields and making a GET request to account_ID_calls then it should return a 200 and a body of billing history details

@GET_billingCallsInvalidFields
Scenario: To validate GET /account/{ID}/calls - Invalid Fields Provided

Given invalid fields and making a GET request to account_ID_calls then it should return a 400 and a body with error parameter
	