# WriteCredDefApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**writeCredDef**](WriteCredDefApi.md#writeCredDef) | **POST** /api/{domainDID}/write-cred-def/0.6/{threadId} | 

<a name="writeCredDef"></a>
# **writeCredDef**
> PostResponse writeCredDef(domainDID, threadId, body)



Create Credential Definition. Creates Credential Definition in the wallet and on the ledger.  In order to issue credentials to individuals, Credentail Definition needs to be created first. Credential Definition can be created out of Schema you have previously created or by using already existing Schema on the ledger                                                           

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WriteCredDefApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

WriteCredDefApi apiInstance = new WriteCredDefApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
WriteCredDefRequest body = new WriteCredDefRequest(); // WriteCredDefRequest | 
try {
    PostResponse result = apiInstance.writeCredDef(domainDID, threadId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WriteCredDefApi#writeCredDef");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **body** | [**WriteCredDefRequest**](WriteCredDefRequest.md)|  | [optional]

### Return type

[**PostResponse**](PostResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

