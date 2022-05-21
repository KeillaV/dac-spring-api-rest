package br.edu.ifpb.dac.crud.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.crud.model.dto.AuthorDTO;
import br.edu.ifpb.dac.crud.model.dto.BookDTO;
import br.edu.ifpb.dac.crud.model.entity.Author;
import br.edu.ifpb.dac.crud.model.entity.Book;


@Service
public class ConverterService {

	@Autowired
	private AuthorService autorService;
	@Autowired
	private ConversorDataService conversorDataService;
	
	
	public Book dtoToBook(BookDTO dto) {
		Author author = autorService.findByName(dto.getAuthorName());
		
		Book book = new Book(dto.getTitle(), dto.getSummary(), dto.getGenre(), author, dto.getPages(), dto.getYearOfPublication());
		book.setId(dto.getId());
		
		return book;
	}
	
	public List<BookDTO> bookToDto(List<Book> books) {
		List<BookDTO> bookDtoList = new ArrayList<>();
		
		BookDTO dto = null;
		for (Book book: books) {
			dto = bookToDto(book);
			bookDtoList.add(dto);
		}
		
		return bookDtoList;
	}
	
	public BookDTO bookToDto(Book book) {
		String authorName = book.getAuthor().getName();
		
		BookDTO dto = new BookDTO(book.getTitle(), book.getSummary(), book.getGenre(), authorName, book.getPages(), book.getYearOfPublication());
		dto.setId(book.getId());
		
		return dto;
	}
	
	public Author dtoToAuthor(AuthorDTO dto) throws Exception {
		Date birthDate = conversorDataService.converterData(dto.getBirthDate());
		
		Author author = new Author(dto.getName(), birthDate, dto.getLiteraryStyle());
		author.setId(dto.getId());
		
		return author;
	}
	
	public List<AuthorDTO> authorToDto(List<Author> authorList) {
		List<AuthorDTO> authorDtoList = new ArrayList<>();
		
		AuthorDTO dto = null;
		for (Author author: authorList) {
			dto = authorToDto(author);
			authorDtoList.add(dto);
		}
		
		return authorDtoList;
	}
	
	public AuthorDTO authorToDto(Author author) {
		String birthDate = author.getBirthDate().toString();
		
		AuthorDTO dto = new AuthorDTO(author.getName(), birthDate, author.getLiteraryStyle());
		dto.setId(author.getId());
		
		return dto;
	}
	
}
