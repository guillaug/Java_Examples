# CommittedAnswerApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCommittedAnswerStatus**](CommittedAnswerApi.md#getCommittedAnswerStatus) | **GET** /api/{domainDID}/committedanswer/1.0/{threadId} | 
[**question**](CommittedAnswerApi.md#question) | **POST** /api/{domainDID}/committedanswer/1.0/{threadId} | 

<a name="getCommittedAnswerStatus"></a>
# **getCommittedAnswerStatus**
> QuestionStatusReport getCommittedAnswerStatus(domainDID, threadId, forRelationship, familyQualifier)



Returns CommittedAnswer protocol.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommittedAnswerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

CommittedAnswerApi apiInstance = new CommittedAnswerApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
String forRelationship = "forRelationship_example"; // String | DID returned from CreateRelationship
String familyQualifier = "BzCbsNYhMrjHiqZDTUASHg"; // String | msg family qualifier
try {
    QuestionStatusReport result = apiInstance.getCommittedAnswerStatus(domainDID, threadId, forRelationship, familyQualifier);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommittedAnswerApi#getCommittedAnswerStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **forRelationship** | **String**| DID returned from CreateRelationship |
 **familyQualifier** | **String**| msg family qualifier | [default to BzCbsNYhMrjHiqZDTUASHg]

### Return type

[**QuestionStatusReport**](QuestionStatusReport.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="question"></a>
# **question**
> PostResponse question(domainDID, threadId, body)



Initiates CommittedAnswer protocol.  Prerequisite for CommittedAnswer protocol is that you established a Connection with individual.  Sends CommittedAnswer message to individual where you specify a question and set of valid responses . 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommittedAnswerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

CommittedAnswerApi apiInstance = new CommittedAnswerApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
AskQuestion body = new AskQuestion(); // AskQuestion | 
try {
    PostResponse result = apiInstance.question(domainDID, threadId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommittedAnswerApi#question");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **body** | [**AskQuestion**](AskQuestion.md)|  | [optional]

### Return type

[**PostResponse**](PostResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

