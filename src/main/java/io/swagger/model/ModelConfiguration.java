package io.swagger.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ModelConfiguration
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-16T21:07:28.234Z[GMT]")
@Entity
@Table(name = "ModelConfiguration")
public class ModelConfiguration   {
  @JsonProperty("maxReminders")
  private Integer maxReminders = 4;

  public ModelConfiguration maxReminders(Integer maxReminders) {
    this.maxReminders = maxReminders;
    return this;
  }

  /**
   * Número máximo de recordatorios a realizar
   * @return maxReminders
  **/
  @ApiModelProperty(example = "3", required = true, value = "Número máximo de recordatorios a realizar")
      @NotNull

    public Integer getMaxReminders() {
    return maxReminders;
  }
  @Id
  @GeneratedValue
  private Integer version;

  public void setMaxReminders(Integer maxReminders) {
    this.maxReminders = maxReminders;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelConfiguration _configuration = (ModelConfiguration) o;
    return Objects.equals(this.maxReminders, _configuration.maxReminders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxReminders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelConfiguration {\n");
    
    sb.append("    maxReminders: ").append(toIndentedString(maxReminders)).append("\n");
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
