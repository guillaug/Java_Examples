/*
 * verity-rest-api
 * # The REST API for Verity  ## Introduction This is the REST API for Verity - Evernym's platform for Verifiable Credential exchange. With Verity you can enable SSI (Self-sovereign Identity) into your project which is based on Decentralized Identifiers (DIDs) and Verifiable Credentials (VCs).  The Verifiable Credentials data model defines Issuer, Verifier and the Holder. Issuer is an organization that creates and issues Verifiable Credentials to individuals, also known as Holders. Holders typically have a digital wallet app to store credentials securely and control how those credentials are being shared with Verifiers. Verifier is an organization that verifies information from the credentials that Holders have stored on their digital wallet app.  With Verity REST API, you can enable issuing or verifying or both functions into your project and interact with individuals using Connect.Me or some other compatible digital wallet app.  Verity REST API exposes endpoints that enable you to initiate basic SSI protocols such are establishing a DID connection between your organization and individuals, issuing a Verifiable Credential to individual and requesting and validating Proofs from individuals. SSI interactions are asynchronous in its nature, therefore we have decided to that these endpoints follow the same async pattern. Besides SSI protocols, Verity REST API exposes endpoints for writing Schemas and Credential Definitions to the ledger.  ## Authentication In order to use the Verity REST API, you'll need to use API key. API key is currently provisioned by Evernym. Contact Evernym to obtain your API key. In case you are already a Verity SDK user, you may use a method in SDK to create an API key for REST API.  ## How to use REST API After obtaining an endpoint and API key for your from Evernym, there are few API calls that you'll need to make before you can invoke SSI protocols. Firstly you'll need to call the UpdateEndpoint to register a webhook where you'll be receiving callbacks from your Verity Server. If you plan to issue credentials to individuals, you'll also need to set up your Issuer Identity. This you can do by calling IssuerSetup endpoint. The callback that you'll receive contains a DID and Verkey. This DID and Verkey represents your Issuer Identity and must be written to the ledger, using the Sovrin Self-Serve Website (https://selfserve.sovrin.org) for the Sovrin StagingNet. The DID and Verkey must be transferred accurately to the self-serve site. Once that is done, you may want to set your Organizational name and logo that will be shown on the Connect.Me or other compatible wallet apps by calling the UpdateConfigs endpoint and after that you may start to create Schema, Credential Definition and interact with individuals using SSI protocols. Before you can issue credentials to individuals or request proofs from them, you need to establish a DID connection by calling a Relationship endpoint. ## Useful links [Tutorials](https://github.com/evernym/verity-sdk/tree/master/docs/howto)  [Code samples](https://github.com/evernym/verity-sdk/tree/master/samples/rest-api)  [Protocol and message identification](https://github.com/evernym/verity-sdk/blob/master/docs/howto/Protocol-and-Message-Identification-in-Verity.md)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.Body;
import io.swagger.client.model.PostResponse;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelationshipApi {
    private ApiClient apiClient;

    public RelationshipApi() {
        this(Configuration.getDefaultApiClient());
    }

    public RelationshipApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for relationship
     * @param domainDID  (required)
     * @param threadId  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call relationshipCall(String domainDID, UUID threadId, Body body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/api/{domainDID}/relationship/1.0/{threadId}"
            .replaceAll("\\{" + "domainDID" + "\\}", apiClient.escapeString(domainDID.toString()))
            .replaceAll("\\{" + "threadId" + "\\}", apiClient.escapeString(threadId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call relationshipValidateBeforeCall(String domainDID, UUID threadId, Body body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'domainDID' is set
        if (domainDID == null) {
            throw new ApiException("Missing the required parameter 'domainDID' when calling relationship(Async)");
        }
        // verify the required parameter 'threadId' is set
        if (threadId == null) {
            throw new ApiException("Missing the required parameter 'threadId' when calling relationship(Async)");
        }
        
        com.squareup.okhttp.Call call = relationshipCall(domainDID, threadId, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 
     * Initiates Relationship protocol.  At first create a relationship with CreateRelationship. After that invitation is generated with RelationshipInvitationRequest.  RelationshipInvite contains inviteURL which needs to be communicated to individual in out of band manner. Usually this is done as QR code on some frontent individual is interacting with or it can be send as a deeplink in an email or presented on a mobile web view.  Once individual receives inviteURL and accepts using Connect.Me, the Verity will send ConnRequestReceived and ConnResponseSent as callbacks.    Calling RelationshipInvitationRequest or OutOfBandInvitationRequest requires to use value of thid from RelationshipCreated response as threadId
     * @param domainDID  (required)
     * @param threadId  (required)
     * @param body  (optional)
     * @return PostResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PostResponse relationship(String domainDID, UUID threadId, Body body) throws ApiException {
        ApiResponse<PostResponse> resp = relationshipWithHttpInfo(domainDID, threadId, body);
        return resp.getData();
    }

    /**
     * 
     * Initiates Relationship protocol.  At first create a relationship with CreateRelationship. After that invitation is generated with RelationshipInvitationRequest.  RelationshipInvite contains inviteURL which needs to be communicated to individual in out of band manner. Usually this is done as QR code on some frontent individual is interacting with or it can be send as a deeplink in an email or presented on a mobile web view.  Once individual receives inviteURL and accepts using Connect.Me, the Verity will send ConnRequestReceived and ConnResponseSent as callbacks.    Calling RelationshipInvitationRequest or OutOfBandInvitationRequest requires to use value of thid from RelationshipCreated response as threadId
     * @param domainDID  (required)
     * @param threadId  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;PostResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PostResponse> relationshipWithHttpInfo(String domainDID, UUID threadId, Body body) throws ApiException {
        com.squareup.okhttp.Call call = relationshipValidateBeforeCall(domainDID, threadId, body, null, null);
        Type localVarReturnType = new TypeToken<PostResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Initiates Relationship protocol.  At first create a relationship with CreateRelationship. After that invitation is generated with RelationshipInvitationRequest.  RelationshipInvite contains inviteURL which needs to be communicated to individual in out of band manner. Usually this is done as QR code on some frontent individual is interacting with or it can be send as a deeplink in an email or presented on a mobile web view.  Once individual receives inviteURL and accepts using Connect.Me, the Verity will send ConnRequestReceived and ConnResponseSent as callbacks.    Calling RelationshipInvitationRequest or OutOfBandInvitationRequest requires to use value of thid from RelationshipCreated response as threadId
     * @param domainDID  (required)
     * @param threadId  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call relationshipAsync(String domainDID, UUID threadId, Body body, final ApiCallback<PostResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = relationshipValidateBeforeCall(domainDID, threadId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PostResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
