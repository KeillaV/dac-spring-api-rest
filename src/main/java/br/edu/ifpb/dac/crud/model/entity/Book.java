package br.edu.ifpb.dac.crud.model.entity;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String summary;
	private String genre;
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;
	private int pages;
	private int yearOfPublication;
	
	public Book() {
		
	}

	public Book(String title, String summary, String genre, Author author, int pages, int yearOfPublication) {
		this.title = title;
		this.summary = summary;
		this.genre = genre;
		this.author = author;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
		Book other = (Book) obj;
		return id == other.id;
	}
}
