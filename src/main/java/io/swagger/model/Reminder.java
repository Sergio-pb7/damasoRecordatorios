package io.swagger.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Reminder
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-16T21:07:28.234Z[GMT]")
@Entity
@Table(name = "Reminder")
public class Reminder   {
	@Id
	@JsonProperty("id")
	private Long id = null;

	/**
	 * Tipo de recordatorio
	 */
	
	public enum TypeEnum {
		MEDICINE("medicine"),

		FOOD("food"),

		INACTIVITY("inactivity");

		private String value;

		TypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TypeEnum fromValue(String text) {
			for (TypeEnum b : TypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

    @Enumerated(EnumType.STRING)
	@JsonProperty("type")
	private TypeEnum type = null;

	@JsonProperty("date")
	private OffsetDateTime date = null;

	@JsonProperty("complete")
	private Boolean complete = false;

	public Reminder id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * ID del recordatorio
	 * @return id
	 **/
	@ApiModelProperty(example = "124132", required = true, value = "ID del recordatorio")
	@NotNull

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reminder type(TypeEnum type) {
		this.type = type;
		return this;
	}

	/**
	 * Tipo de recordatorio
	 * @return type
	 **/
	@ApiModelProperty(example = "food", required = true, value = "Tipo de recordatorio")
	@NotNull

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public Reminder date(OffsetDateTime date) {
		this.date = date;
		return this;
	}

	/**
	 * Fecha en la que se realizará el recordatorio
	 * @return date
	 **/
	@ApiModelProperty(required = true, value = "Fecha en la que se realizará el recordatorio")
	@NotNull

	@Valid
	public OffsetDateTime getDate() {
		return date;
	}

	public void setDate(OffsetDateTime date) {
		this.date = date;
	}

	public Reminder complete(Boolean complete) {
		this.complete = complete;
		return this;
	}

	/**
	 * Indica si el recordatorio está completo o no
	 * @return complete
	 **/
	@ApiModelProperty(example = "false", value = "Indica si el recordatorio está completo o no")

	public Boolean isComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Reminder reminder = (Reminder) o;
		return Objects.equals(this.id, reminder.id) &&
				Objects.equals(this.type, reminder.type) &&
				Objects.equals(this.date, reminder.date) &&
				Objects.equals(this.complete, reminder.complete);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type, date, complete);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Reminder {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
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
