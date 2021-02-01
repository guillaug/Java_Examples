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

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.client.model.Thread;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.UUID;
/**
 * PublicIdentifier
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-12-15T21:51:02.728Z[GMT]")
public class PublicIdentifier {
  @SerializedName("@id")
  private UUID _atId = null;

  @SerializedName("@type")
  private String _atType = null;

  @SerializedName("~thread")
  private Thread thread = null;

  @SerializedName("verKey")
  private String verKey = null;

  @SerializedName("did")
  private String did = null;

  public PublicIdentifier _atId(UUID _atId) {
    this._atId = _atId;
    return this;
  }

   /**
   * random id
   * @return _atId
  **/
  @Schema(example = "0729a580-2240-11e6-9eb5-0002a5d5c51b", description = "random id")
  public UUID getAtId() {
    return _atId;
  }

  public void setAtId(UUID _atId) {
    this._atId = _atId;
  }

  public PublicIdentifier _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

   /**
   * Get _atType
   * @return _atType
  **/
  @Schema(example = "did:sov:123456789abcdefghi1234;spec/issuer-setup/0.6/public-identifier", description = "")
  public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }

  public PublicIdentifier thread(Thread thread) {
    this.thread = thread;
    return this;
  }

   /**
   * Get thread
   * @return thread
  **/
  @Schema(description = "")
  public Thread getThread() {
    return thread;
  }

  public void setThread(Thread thread) {
    this.thread = thread;
  }

  public PublicIdentifier verKey(String verKey) {
    this.verKey = verKey;
    return this;
  }

   /**
   * Get verKey
   * @return verKey
  **/
  @Schema(example = "FRuXtyFNy7fZotLpa6ud7T18xafYu2wwUYQa4YNoi2Yu", description = "")
  public String getVerKey() {
    return verKey;
  }

  public void setVerKey(String verKey) {
    this.verKey = verKey;
  }

  public PublicIdentifier did(String did) {
    this.did = did;
    return this;
  }

   /**
   * Get did
   * @return did
  **/
  @Schema(example = "TUWeK6bhVKqQ3TASQuRB3A", description = "")
  public String getDid() {
    return did;
  }

  public void setDid(String did) {
    this.did = did;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublicIdentifier publicIdentifier = (PublicIdentifier) o;
    return Objects.equals(this._atId, publicIdentifier._atId) &&
        Objects.equals(this._atType, publicIdentifier._atType) &&
        Objects.equals(this.thread, publicIdentifier.thread) &&
        Objects.equals(this.verKey, publicIdentifier.verKey) &&
        Objects.equals(this.did, publicIdentifier.did);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_atId, _atType, thread, verKey, did);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublicIdentifier {\n");
    
    sb.append("    _atId: ").append(toIndentedString(_atId)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
    sb.append("    thread: ").append(toIndentedString(thread)).append("\n");
    sb.append("    verKey: ").append(toIndentedString(verKey)).append("\n");
    sb.append("    did: ").append(toIndentedString(did)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
