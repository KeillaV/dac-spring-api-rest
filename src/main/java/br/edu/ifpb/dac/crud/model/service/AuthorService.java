package br.edu.ifpb.dac.crud.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.crud.model.dao.AuthorDAO;
import br.edu.ifpb.dac.crud.model.entity.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorDAO authorDAO;
	
	public Author create(Author author) {
		return authorDAO.save(author);
	}
	
	public Optional<Author> findById(Integer id) {
		return authorDAO.findById(id);
	}
	
	public Author findByName(String name) {
		return authorDAO.findByName(name).orElse(null);
	}
	
	public List<Author> findAll() {
		return (List<Author>) authorDAO.findAll();
	}
	
	public List<Author> findAllByLiteraryStyle(String literaryStyle) {
		return authorDAO.findAllByLiteraryStyle(literaryStyle);
	}
	
	public boolean existsById(Integer id) {
		return authorDAO.existsById(id);
	}
	
	public Author update(Author author) {
		return authorDAO.save(author);
	}
	
	public void delete(Author author) {
		authorDAO.delete(author);
	}
	
	public void deleteById(Integer id) {
		authorDAO.deleteById(id);
	}

	public void deleteByName(String name) {
		authorDAO.deleteByName(name);
	}
	
	public void deleteAll() {
		authorDAO.deleteAll();
	}
}
