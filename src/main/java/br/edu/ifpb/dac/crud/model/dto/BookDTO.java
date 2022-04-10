package br.edu.ifpb.dac.crud.model.dto;

public class BookDTO {
 
	private Integer id;
	private String title;
	private String summary;
	private String genre;
	private String authorName;
	private int pages;
	private int yearOfPublication;
	
	
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
