package me.flyray.search.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import me.flyray.search.service.BookService;
import me.flyray.search.Book;
import me.flyray.search.repository.BookRepository;

public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> findByNameAndPrice(String name, Float price) {
		return bookRepository.findByNameAndPrice(name, price);
	}

	@Override
	public List<Book> findByNameOrPrice(String name, Float price) {
		return bookRepository.findByNameOrPrice(name, price);
	}

	@Override
	public Page<Book> findByName(String name, Pageable page) {
		return bookRepository.findByName(name, page);
	}

	@Override
	public Page<Book> findByNameNot(String name, Pageable page) {
		return bookRepository.findByNameNot(name, page);
	}

	@Override
	public Page<Book> findByPriceBetween(Float price, Pageable page) {
		return bookRepository.findByPriceBetween(price, page);
	}

	@Override
	public Page<Book> findByNameLike(String name, Pageable page) {
		return bookRepository.findByNameLike(name, page);
	}

	@Override
	public Page<Book> findByPrice(Float price, Pageable pageable) {
		return bookRepository.findByPrice(price, pageable);
	}

	
}
