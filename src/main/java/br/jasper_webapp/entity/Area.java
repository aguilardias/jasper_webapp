package br.jasper_webapp.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * If you are using Glassfish then remove the strategy attribute
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;

	@NotNull
	//@Size(min = 1, message = "{required.field}")
	private String area;

	/*@NotNull
	@Size(min = 1, message = "{required.field}")
	@Pattern(regexp = "^|([a-zA-Z]+://)(\\w+\\.\\w+)(.+)?$", message = "{invalid.url}")
	private String link;*/

	public Area() {
	}
	
	public Area(String area) {
		this.area = area;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
