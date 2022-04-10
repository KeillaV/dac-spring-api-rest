package br.edu.ifpb.dac.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.crud.model.dto.BookDTO;
import br.edu.ifpb.dac.crud.model.entity.Book;
import br.edu.ifpb.dac.crud.model.service.BookService;
import br.edu.ifpb.dac.crud.model.service.ConverterService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private ConverterService converterService;
	
	@GetMapping
	public ResponseEntity getAll() {
		List<Book> bookList = bookService.findAll();
		
		if (bookList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		List<BookDTO> bookDtoList = converterService.bookToDto(bookList);
		
		return ResponseEntity.ok().body(bookDtoList);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity findById(@PathVariable Integer bookId) {
		
		if (!bookService.existsById(bookId)) {
			return ResponseEntity.notFound().build();
		}
		
		Book bookEntity = bookService.findById(bookId).get();
		BookDTO bookDTO = converterService.bookToDto(bookEntity);
		
		return ResponseEntity.ok().body(bookDTO);
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody BookDTO bookDTO) {
		try {
			Book bookEntity = converterService.dtoToBook(bookDTO);
			bookEntity = bookService.create(bookEntity);
			bookDTO = converterService.bookToDto(bookEntity);
			
			return new ResponseEntity(bookDTO, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("An error occurred while saving book, please try again");
		}
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity update(@PathVariable Integer bookId, @RequestBody BookDTO bookDTO) {
		
		if (!bookService.existsById(bookId)) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			bookDTO.setId(bookId);
			Book bookEntity = converterService.dtoToBook(bookDTO);
			bookEntity = bookService.update(bookEntity);
			bookDTO = converterService.bookToDto(bookEntity);
			
			return ResponseEntity.ok().body(bookDTO);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("An error occurred while updating book, please try again");
		}
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity delete(@PathVariable Integer bookId) {
		
		if (!bookService.existsById(bookId)) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			
			bookService.deleteById(bookId);
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("An error occurred while deleting book, please try again");
		}
	}
	
	
}
