/*
 * starwars-api.com
 * Azure Functions with some Swagger
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package pl.sunflux.swapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Person
 */
@JsonPropertyOrder({
  Person.JSON_PROPERTY_ID,
  Person.JSON_PROPERTY_NAME,
  Person.JSON_PROPERTY_HOME_WORLD_ID,
  Person.JSON_PROPERTY_ALLEGIANCE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2019-10-07T21:01:59.397+02:00[Europe/Belgrade]")
public class Person   {
  public static final String JSON_PROPERTY_ID = "id";
  @JsonProperty(JSON_PROPERTY_ID)
  private BigDecimal id;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonProperty(JSON_PROPERTY_NAME)
  private String name;

  public static final String JSON_PROPERTY_HOME_WORLD_ID = "homeWorldId";
  @JsonProperty(JSON_PROPERTY_HOME_WORLD_ID)
  private Integer homeWorldId;

  public static final String JSON_PROPERTY_ALLEGIANCE = "allegiance";
  @JsonProperty(JSON_PROPERTY_ALLEGIANCE)
  private String allegiance;

  public Person id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier representing a specific person for a given character persona.
   * @return id
   **/
  @JsonProperty("id")
  @ApiModelProperty(value = "Unique identifier representing a specific person for a given character persona.")
  @Valid 
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Person name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Display name of person.
   * @return name
   **/
  @JsonProperty("name")
  @ApiModelProperty(value = "Display name of person.")
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person homeWorldId(Integer homeWorldId) {
    this.homeWorldId = homeWorldId;
    return this;
  }

  /**
   * Indetifier of the planet the person is from.
   * @return homeWorldId
   **/
  @JsonProperty("homeWorldId")
  @ApiModelProperty(value = "Indetifier of the planet the person is from.")
  
  public Integer getHomeWorldId() {
    return homeWorldId;
  }

  public void setHomeWorldId(Integer homeWorldId) {
    this.homeWorldId = homeWorldId;
  }

  public Person allegiance(String allegiance) {
    this.allegiance = allegiance;
    return this;
  }

  /**
   * Which side or team the person has an allegiance.
   * @return allegiance
   **/
  @JsonProperty("allegiance")
  @ApiModelProperty(value = "Which side or team the person has an allegiance.")
  
  public String getAllegiance() {
    return allegiance;
  }

  public void setAllegiance(String allegiance) {
    this.allegiance = allegiance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.id, person.id) &&
        Objects.equals(this.name, person.name) &&
        Objects.equals(this.homeWorldId, person.homeWorldId) &&
        Objects.equals(this.allegiance, person.allegiance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, homeWorldId, allegiance);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    homeWorldId: ").append(toIndentedString(homeWorldId)).append("\n");
    sb.append("    allegiance: ").append(toIndentedString(allegiance)).append("\n");
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

