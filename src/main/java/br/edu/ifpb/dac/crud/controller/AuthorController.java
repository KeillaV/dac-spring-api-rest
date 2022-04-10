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

import br.edu.ifpb.dac.crud.model.dto.AuthorDTO;
import br.edu.ifpb.dac.crud.model.entity.Author;
import br.edu.ifpb.dac.crud.model.service.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	@Autowired
	private ConverterService converterService;
	
	
	@GetMapping
	public ResponseEntity getAll() {
		List<Author> authorList = authorService.findAll();
		
		if (authorList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		List<AuthorDTO> authorDtoList = converterService.authorToDto(authorList);
		
		return ResponseEntity.ok().body(authorDtoList);
	}
	
	@GetMapping("/{authorId}")
	public ResponseEntity findById(@PathVariable Integer authorId) {
		
		if (!authorService.existsById(authorId)) {
			return ResponseEntity.notFound().build();
		}
		
		Author authorEntity = authorService.findById(authorId).get();
		AuthorDTO authorDTO = converterService.authorToDto(authorEntity);
		
		return ResponseEntity.ok().body(authorDTO);
	}
	
	
	@PostMapping
	public ResponseEntity save(@RequestBody AuthorDTO authorDTO) {
		try {
			Author authorEntity = converterService.dtoToAuthor(authorDTO);
			authorEntity = authorService.create(authorEntity);
			authorDTO = converterService.authorToDto(authorEntity);
			
			return new ResponseEntity(authorDTO, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("An error occurred while saving author, please try again");
		}
	}
	
	@PutMapping("/{authorId}")
	public ResponseEntity update(@PathVariable Integer authorId, @RequestBody AuthorDTO authorDTO) {
		
		if (!authorService.existsById(authorId)) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			authorDTO.setId(authorId);
			Author authorEntity = converterService.dtoToAuthor(authorDTO);
			authorEntity = authorService.update(authorEntity);
			authorDTO = converterService.authorToDto(authorEntity);
			
			return ResponseEntity.ok().body(authorDTO);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("An error occurred while updating author, please try again");
		}
	}
	
	@DeleteMapping("/{authorId}")
	public ResponseEntity delete(@PathVariable Integer authorId) {
		
		if (!authorService.existsById(authorId)) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			
			authorService.deleteById(authorId);
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("An error occurred while deleting author, please try again");
		}
	}
}