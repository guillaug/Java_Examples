# SendOffer

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_atType** | **String** |  | 
**_atId** | [**UUID**](UUID.md) | random id | 
**forRelationship** | **String** | DID returned from CreateRelationship request | 
**credDefId** | **String** | id of credential definition used | 
**credentialValues** | **Map&lt;String, String&gt;** | JSON, key-value pairs of credential values | 
**price** | **String** | price of credential |  [optional]
**comment** | **String** | comment |  [optional]
**autoIssue** | **Boolean** | Enable auto issue when other party accepts credential offer. AskAccept message would not be received. |  [optional]
**byInvitation** | **Boolean** | Initiate Out-Of-Band protocol for credential issuance. Receive InviteURL that can be converted into QR code and that contains Credential Offer |  [optional]
