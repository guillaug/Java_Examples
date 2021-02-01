# ProposedProofAttr

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The name of attribute |  [optional]
**credDefId** | **String** | The optional cred_def_id key maps to the credential definition identifier of the credential with the current attribute |  [optional]
**mimeType** | **String** | The optional mime-type advises the verifier how to render a binary attribute, to judge its content for applicability before accepting a presentation containing it. Its value parses case-insensitively in keeping with MIME type semantics of RFC 2045. If mime-type is missing, then value is string. |  [optional]
**value** | **String** | The optional value of attribute. |  [optional]
**referent** | **String** | The optional referent can be useful in specifying multiple-credential presentations. Its value indicates which credential will supply the attribute in the presentation. Sharing a referent value between multiple attribute specifications indicates that the holder&#x27;s same credential supplies the attribute. |  [optional]
