/*
 * Your Service Definition Using Internal JSON Schema
 * This is user Service API definition to enable its consumers to create, query, update details, and delete resource.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package co.greedycode.RegistrationService.dto;

import java.util.Objects;
import java.util.Arrays;
import co.greedycode.RegistrationService.dto.RegisterUser;
import co.greedycode.RegistrationService.dto.SignInUser;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.io.Serializable;

/**
 * Data
 */
@lombok.Builder @lombok.AllArgsConstructor @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Data implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_REGISTER_USER = "registerUser";
  @SerializedName(SERIALIZED_NAME_REGISTER_USER)
  private RegisterUser registerUser;

  public static final String SERIALIZED_NAME_SIGN_IN_USER = "signInUser";
  @SerializedName(SERIALIZED_NAME_SIGN_IN_USER)
  private SignInUser signInUser;

  public Data() { 
  }

  public Data registerUser(RegisterUser registerUser) {
    
    this.registerUser = registerUser;
    return this;
  }

   /**
   * Get registerUser
   * @return registerUser
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public RegisterUser getRegisterUser() {
    return registerUser;
  }


  public void setRegisterUser(RegisterUser registerUser) {
    this.registerUser = registerUser;
  }


  public Data signInUser(SignInUser signInUser) {
    
    this.signInUser = signInUser;
    return this;
  }

   /**
   * Get signInUser
   * @return signInUser
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignInUser getSignInUser() {
    return signInUser;
  }


  public void setSignInUser(SignInUser signInUser) {
    this.signInUser = signInUser;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Data data = (Data) o;
    return Objects.equals(this.registerUser, data.registerUser) &&
        Objects.equals(this.signInUser, data.signInUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registerUser, signInUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Data {\n");
    sb.append("    registerUser: ").append(toIndentedString(registerUser)).append("\n");
    sb.append("    signInUser: ").append(toIndentedString(signInUser)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

