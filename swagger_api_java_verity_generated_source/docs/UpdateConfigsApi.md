# UpdateConfigsApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updateConfigs**](UpdateConfigsApi.md#updateConfigs) | **POST** /api/{domainDID}/update-configs/0.6/{threadId} | 

<a name="updateConfigs"></a>
# **updateConfigs**
> PostResponse updateConfigs(domainDID, threadId, body)



Updates name and logo for the organization.   Name and logo are used when Connecting protocol is used and when connection invite is showed in Connect.Me or other digital wallet apps     

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UpdateConfigsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

UpdateConfigsApi apiInstance = new UpdateConfigsApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
UpdateConfigsRequest body = new UpdateConfigsRequest(); // UpdateConfigsRequest | 
try {
    PostResponse result = apiInstance.updateConfigs(domainDID, threadId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UpdateConfigsApi#updateConfigs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **body** | [**UpdateConfigsRequest**](UpdateConfigsRequest.md)|  | [optional]

### Return type

[**PostResponse**](PostResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

