package br.edu.ifpb.dac.crud.model.dto;

public class AuthorDTO {

	private Integer id;
	private String name;
	private String birthDate;
	private String literaryStyle;
	
	public AuthorDTO(String name, String birthDate, String literaryStyle) {
		super();
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
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getLiteraryStyle() {
		return literaryStyle;
	}
	
	public void setLiteraryStyle(String literaryStyle) {
		this.literaryStyle = literaryStyle;
	}
	
}
