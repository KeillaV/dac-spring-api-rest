package br.edu.ifpb.dac.crud.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.crud.model.entity.Author;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Integer>{

	public Optional<Author> findByName(String name);
	public List<Author> findAllByLiteraryStyle(String literaryStyle);
	public void deleteByName(String name);
}
