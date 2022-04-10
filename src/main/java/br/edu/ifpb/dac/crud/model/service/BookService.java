package br.edu.ifpb.dac.crud.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.crud.model.dao.BookDAO;
import br.edu.ifpb.dac.crud.model.entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	public Book create(Book book) {
		return bookDAO.save(book);
	}
	
	public boolean existsById(Integer id) {
		return bookDAO.existsById(id);
	}
	
	public Book findByTitle(String title) {
		return bookDAO.findByTitle(title);
	}
	
	public List<Book> findAll() {
		return (List<Book>) bookDAO.findAll();
	}
	
	public Optional<Book> findById(Integer id) {
		return bookDAO.findById(id);
	}
	
	public List<Book> findAllByGenre(String genre) {
		return bookDAO.findAllByGenre(genre);
	}
	
	public Book update(Book book) {
		return bookDAO.save(book);
	}
	
	public void delete(Book book) {
		bookDAO.delete(book);
	}
	
	public void deleteById(Integer id) {
		bookDAO.deleteById(id);
	}

	public void deleteByTitle(String title) {
		bookDAO.deleteByTitle(title);
	}
	
	public void deleteAll() {
		bookDAO.deleteAll();
	}
}
