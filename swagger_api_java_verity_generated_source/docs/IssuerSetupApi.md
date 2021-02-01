# IssuerSetupApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiDomainDIDIssuerSetup06ThreadIdPost**](IssuerSetupApi.md#apiDomainDIDIssuerSetup06ThreadIdPost) | **POST** /api/{domainDID}/issuer-setup/0.6/{threadId} | 

<a name="apiDomainDIDIssuerSetup06ThreadIdPost"></a>
# **apiDomainDIDIssuerSetup06ThreadIdPost**
> PostResponse apiDomainDIDIssuerSetup06ThreadIdPost(domainDID, threadId, body)



Initiates IssuerSetup protocol.  Creates Issuer DID and public/private keypair that are going to be used to issue credentials. This DID and public key (Verkey) need to be written to the Sovrin StagingNet (https://selfserve.sovrin.org) before you can create Schemas and Credential Definitions.                                                         

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IssuerSetupApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

IssuerSetupApi apiInstance = new IssuerSetupApi();
String domainDID = "domainDID_example"; // String | 
UUID threadId = new UUID(); // UUID | 
Body3 body = new Body3(); // Body3 | 
try {
    PostResponse result = apiInstance.apiDomainDIDIssuerSetup06ThreadIdPost(domainDID, threadId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IssuerSetupApi#apiDomainDIDIssuerSetup06ThreadIdPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **domainDID** | **String**|  |
 **threadId** | [**UUID**](.md)|  |
 **body** | [**Body3**](Body3.md)|  | [optional]

### Return type

[**PostResponse**](PostResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

