# WriteSchemaApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**writeSchema**](WriteSchemaApi.md#writeSchema) | **POST** /api/{domainDID}/write-schema/0.6/{threadId} | 

<a name="writeSchema"></a>
# **writeSchema**
> PostResponse writeSchema(domainDID, threadId, body)



Create Schema. Creates a Schema on the ledger.  In order to issue credentials to individuals, Schema has to be created and written to the ledger. If you are using Schemas that are already written to the ledger, you don&#x27;t have to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WriteSchemaApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

WriteSchemaApi apiInstance = new WriteSchemaApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
WriteSchemaRequest body = new WriteSchemaRequest(); // WriteSchemaRequest | 
try {
    PostResponse result = apiInstance.writeSchema(domainDID, threadId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WriteSchemaApi#writeSchema");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **body** | [**WriteSchemaRequest**](WriteSchemaRequest.md)|  | [optional]

### Return type

[**PostResponse**](PostResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

