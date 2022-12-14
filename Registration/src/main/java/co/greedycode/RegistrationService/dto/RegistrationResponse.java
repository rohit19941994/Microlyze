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
import co.greedycode.RegistrationService.dto.ErrorResponseData;
import co.greedycode.RegistrationService.dto.SuccessResponseData;
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
 * Request model for person and service information
 */
@ApiModel(description = "Request model for person and service information")
@lombok.Builder @lombok.AllArgsConstructor @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class RegistrationResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_SUCCESS_RESPONSE_DATA = "SuccessResponseData";
  @SerializedName(SERIALIZED_NAME_SUCCESS_RESPONSE_DATA)
  private SuccessResponseData successResponseData;

  public static final String SERIALIZED_NAME_ERROR_RESPONSE_DATA = "ErrorResponseData";
  @SerializedName(SERIALIZED_NAME_ERROR_RESPONSE_DATA)
  private ErrorResponseData errorResponseData;

  public RegistrationResponse() { 
  }

  public RegistrationResponse successResponseData(SuccessResponseData successResponseData) {
    
    this.successResponseData = successResponseData;
    return this;
  }

   /**
   * Get successResponseData
   * @return successResponseData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SuccessResponseData getSuccessResponseData() {
    return successResponseData;
  }


  public void setSuccessResponseData(SuccessResponseData successResponseData) {
    this.successResponseData = successResponseData;
  }


  public RegistrationResponse errorResponseData(ErrorResponseData errorResponseData) {
    
    this.errorResponseData = errorResponseData;
    return this;
  }

   /**
   * Get errorResponseData
   * @return errorResponseData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ErrorResponseData getErrorResponseData() {
    return errorResponseData;
  }


  public void setErrorResponseData(ErrorResponseData errorResponseData) {
    this.errorResponseData = errorResponseData;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationResponse registrationResponse = (RegistrationResponse) o;
    return Objects.equals(this.successResponseData, registrationResponse.successResponseData) &&
        Objects.equals(this.errorResponseData, registrationResponse.errorResponseData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(successResponseData, errorResponseData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrationResponse {\n");
    sb.append("    successResponseData: ").append(toIndentedString(successResponseData)).append("\n");
    sb.append("    errorResponseData: ").append(toIndentedString(errorResponseData)).append("\n");
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

