# PresentProofApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPresentProofStatus**](PresentProofApi.md#getPresentProofStatus) | **GET** /api/{domainDID}/present-proof/1.0/{threadId} | 
[**requestProof**](PresentProofApi.md#requestProof) | **POST** /api/{domainDID}/present-proof/1.0/{threadId} | 

<a name="getPresentProofStatus"></a>
# **getPresentProofStatus**
> PresentProofStatusReport getPresentProofStatus(domainDID, threadId, forRelationship, familyQualifier, msgName)



Returs status of Present Proof protocol

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PresentProofApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

PresentProofApi apiInstance = new PresentProofApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
String forRelationship = "forRelationship_example"; // String | DID returned from CreateRelationship request
String familyQualifier = "BzCbsNYhMrjHiqZDTUASHg"; // String | msg family qualifier
String msgName = "status"; // String | msg name
try {
    PresentProofStatusReport result = apiInstance.getPresentProofStatus(domainDID, threadId, forRelationship, familyQualifier, msgName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PresentProofApi#getPresentProofStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **forRelationship** | **String**| DID returned from CreateRelationship request |
 **familyQualifier** | **String**| msg family qualifier | [default to BzCbsNYhMrjHiqZDTUASHg]
 **msgName** | **String**| msg name | [default to status]

### Return type

[**PresentProofStatusReport**](PresentProofStatusReport.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="requestProof"></a>
# **requestProof**
> PostResponse requestProof(domainDID, threadId, body)



Initiates Present Proof protocol.  Prerequisite for Present Proof protocol is that you have established a Connection with individual.   Sends Present Proof request where you specifyng attributes you  want individual to share and optionally restrictions that these attributes have to satisfy (for example attribute has to be issued by certain issuer)

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PresentProofApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

PresentProofApi apiInstance = new PresentProofApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
Body2 body = new Body2(); // Body2 | 
try {
    PostResponse result = apiInstance.requestProof(domainDID, threadId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PresentProofApi#requestProof");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **body** | [**Body2**](Body2.md)|  | [optional]

### Return type

[**PostResponse**](PostResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

