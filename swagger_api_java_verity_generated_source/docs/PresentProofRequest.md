# PresentProofRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_atType** | **String** |  | 
**_atId** | [**UUID**](UUID.md) | random id | 
**forRelationship** | **String** |  | 
**name** | **String** | name of proof | 
**proofAttrs** | [**List&lt;ProofAttr&gt;**](ProofAttr.md) | array of proof attributes |  [optional]
**proofPredicates** | [**List&lt;ProofPredicate&gt;**](ProofPredicate.md) |  |  [optional]
**revocationInterval** | [**RevocationInterval**](RevocationInterval.md) |  |  [optional]
**byInvitation** | **Boolean** | Initiate Out-Of-Band protocol for Proof presentation. Receive InviteURL that can be converted into QR code and that contains Proof request |  [optional]
