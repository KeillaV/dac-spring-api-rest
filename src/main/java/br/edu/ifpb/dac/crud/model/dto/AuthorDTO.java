package br.edu.ifpb.dac.crud.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AuthorDTO {

	private Integer id;
	@NotBlank(message = "É obrigatório fornecer o nome do autor!")
	@Size(min = 2, max = 255)
	private String name;
	@NotBlank(message = "É obrigatório fornecer a data de nascimento do autor!")
	@Pattern(regexp = "^\\d\\d\\d\\d-\\d\\d-\\d\\d$",
			message = "A data deve estar formatada como 'yyyy-MM-dd'")
	private String birthDate;
	@NotBlank(message = "É obrigatório fornecer o estilo literário do autor!")
	@Size(min = 2, max = 255)
	private String literaryStyle;
	
	public AuthorDTO() {
		
	}
	
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
