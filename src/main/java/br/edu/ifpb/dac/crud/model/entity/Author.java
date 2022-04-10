package br.edu.ifpb.dac.crud.model.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Date birthDate;
	private String literaryStyle;
	
	public Author() {
		
	}

	public Author(String name, Date birthDate, String literaryStyle) {
		this.name = name;
		this.birthDate = birthDate;
		this.literaryStyle = literaryStyle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getLiteraryStyle() {
		return literaryStyle;
	}

	public void setLiteraryStyle(String literaryStyle) {
		this.literaryStyle = literaryStyle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(id, other.id);
	}
}
