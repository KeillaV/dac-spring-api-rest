package br.edu.ifpb.dac.crud.model.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.dac.crud.model.entity.Book;

@Repository
public interface BookDAO extends PagingAndSortingRepository<Book, Integer> {

	public Book findByTitle(String title);
	public List<Book> findAllByGenre(String genre);
	public void deleteByTitle(String title);
}
