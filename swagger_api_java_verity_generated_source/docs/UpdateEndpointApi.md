# UpdateEndpointApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updateEndpoint**](UpdateEndpointApi.md#updateEndpoint) | **POST** /api/{domainDID}/configs/0.6/ | 

<a name="updateEndpoint"></a>
# **updateEndpoint**
> PostResponse updateEndpoint(domainDID, body)



Updates webhook URL for receiving callbacks from Verity

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UpdateEndpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

UpdateEndpointApi apiInstance = new UpdateEndpointApi();
String domainDID = "domainDID_example"; // String | 
UpdateEndpoint body = new UpdateEndpoint(); // UpdateEndpoint | 
try {
    PostResponse result = apiInstance.updateEndpoint(domainDID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UpdateEndpointApi#updateEndpoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **body** | [**UpdateEndpoint**](UpdateEndpoint.md)|  | [optional]

### Return type

[**PostResponse**](PostResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

