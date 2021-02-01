# IssueCredentialApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getIssueCredentialStatus**](IssueCredentialApi.md#getIssueCredentialStatus) | **GET** /api/{domainDID}/issue-credential/1.0/{threadId} | 
[**issueCredential**](IssueCredentialApi.md#issueCredential) | **POST** /api/{domainDID}/issue-credential/1.0/{threadId} | 

<a name="getIssueCredentialStatus"></a>
# **getIssueCredentialStatus**
> IssueCredentialStatusReport getIssueCredentialStatus(domainDID, threadId, forRelationship, familyQualifier, msgName)



Returns status of Issue Credential ptotocol

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IssueCredentialApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

IssueCredentialApi apiInstance = new IssueCredentialApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
String forRelationship = "forRelationship_example"; // String | DID returned from CreateRelationship request
String familyQualifier = "BzCbsNYhMrjHiqZDTUASHg"; // String | msg family qualifier
String msgName = "status"; // String | msg name
try {
    IssueCredentialStatusReport result = apiInstance.getIssueCredentialStatus(domainDID, threadId, forRelationship, familyQualifier, msgName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IssueCredentialApi#getIssueCredentialStatus");
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

[**IssueCredentialStatusReport**](IssueCredentialStatusReport.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="issueCredential"></a>
# **issueCredential**
> PostResponse issueCredential(domainDID, threadId, body)



Initiates Issue Credential protocol.  Prerequisite for Issue Credential protocol is that you have Issuer Identity set up, that you have created a Schema and Credential Definition and that you have established a Connection with individual.  Issue Credential protocol is performed in two steps.  First you send SendOffer to this endpoint where you specify values for attributes in the Credential you are issuing. Once individual receives Credential Offer and accepts it, you&#x27;ll receive AskAccept message and then you have to send IssueCredential message to this endpoint to issue a credential.                                                                             

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IssueCredentialApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

IssueCredentialApi apiInstance = new IssueCredentialApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
Body1 body = new Body1(); // Body1 | 
try {
    PostResponse result = apiInstance.issueCredential(domainDID, threadId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IssueCredentialApi#issueCredential");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **body** | [**Body1**](Body1.md)|  | [optional]

### Return type

[**PostResponse**](PostResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

