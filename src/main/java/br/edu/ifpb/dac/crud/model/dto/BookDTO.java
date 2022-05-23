package br.edu.ifpb.dac.crud.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BookDTO {
 
	private Integer id;
	@NotBlank(message = "É obrigatório fornecer o título do livro!")
	@Size(min = 2, max = 255)
	private String title;
	@NotBlank(message = "É obrigatório fornecer a sipnose do livro!")
	@Size(min = 10, max = 500)
	private String summary;
	@NotBlank(message = "É obrigatório fornecer o gênero do livro!")
	@Size(min = 2, max = 255)
	private String genre;
	@NotBlank(message = "É obrigatório fornecer o nome do autor do livro!")
	private String authorName;
	@Positive(message = "A quantidade de páginas deve ser um valor positivo!")
	private int pages;
	@Positive(message = "Por favor, inserir um ano válido!")
	@Max(value = 9999, message = "Por favor, inserir um ano válido!")
	private int yearOfPublication;
	
	
	public BookDTO() {
		
	}
	
	public BookDTO(String title, String summary, String genre, String authorName, int pages, int yearOfPublication) {
		this.title = title;
		this.summary = summary;
		this.genre = genre;
		this.authorName = authorName;
		this.pages = pages;
		this.yearOfPublication = yearOfPublication;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public int getPages() {
		return pages;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}	
}
