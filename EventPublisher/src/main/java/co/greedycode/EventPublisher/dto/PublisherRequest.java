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


package co.greedycode.EventPublisher.dto;

import java.util.Objects;
import java.util.Arrays;
import co.greedycode.EventPublisher.dto.ServiceInfo;
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
public class PublisherRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_EVENT_LOG = "eventLog";
  @SerializedName(SERIALIZED_NAME_EVENT_LOG)
  private Object eventLog;

  public static final String SERIALIZED_NAME_SERVICE_INFO = "serviceInfo";
  @SerializedName(SERIALIZED_NAME_SERVICE_INFO)
  private ServiceInfo serviceInfo;

  public PublisherRequest() { 
  }

  public PublisherRequest eventLog(Object eventLog) {
    
    this.eventLog = eventLog;
    return this;
  }

   /**
   * Get eventLog
   * @return eventLog
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "object Scalar", value = "")

  public Object getEventLog() {
    return eventLog;
  }


  public void setEventLog(Object eventLog) {
    this.eventLog = eventLog;
  }


  public PublisherRequest serviceInfo(ServiceInfo serviceInfo) {
    
    this.serviceInfo = serviceInfo;
    return this;
  }

   /**
   * Get serviceInfo
   * @return serviceInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ServiceInfo getServiceInfo() {
    return serviceInfo;
  }


  public void setServiceInfo(ServiceInfo serviceInfo) {
    this.serviceInfo = serviceInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublisherRequest publisherRequest = (PublisherRequest) o;
    return Objects.equals(this.eventLog, publisherRequest.eventLog) &&
        Objects.equals(this.serviceInfo, publisherRequest.serviceInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventLog, serviceInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublisherRequest {\n");
    sb.append("    eventLog: ").append(toIndentedString(eventLog)).append("\n");
    sb.append("    serviceInfo: ").append(toIndentedString(serviceInfo)).append("\n");
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

