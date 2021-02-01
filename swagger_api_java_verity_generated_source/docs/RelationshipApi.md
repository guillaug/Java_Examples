# RelationshipApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**relationship**](RelationshipApi.md#relationship) | **POST** /api/{domainDID}/relationship/1.0/{threadId} | 

<a name="relationship"></a>
# **relationship**
> PostResponse relationship(domainDID, threadId, body)



Initiates Relationship protocol.  At first create a relationship with CreateRelationship. After that invitation is generated with RelationshipInvitationRequest.  RelationshipInvite contains inviteURL which needs to be communicated to individual in out of band manner. Usually this is done as QR code on some frontent individual is interacting with or it can be send as a deeplink in an email or presented on a mobile web view.  Once individual receives inviteURL and accepts using Connect.Me, the Verity will send ConnRequestReceived and ConnResponseSent as callbacks.    Calling RelationshipInvitationRequest or OutOfBandInvitationRequest requires to use value of thid from RelationshipCreated response as threadId

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RelationshipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

RelationshipApi apiInstance = new RelationshipApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
Body body = new Body(); // Body | 
try {
    PostResponse result = apiInstance.relationship(domainDID, threadId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RelationshipApi#relationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **body** | [**Body**](Body.md)|  | [optional]

### Return type

[**PostResponse**](PostResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

