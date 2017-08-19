package me.flyray.search.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import me.flyray.search.Book;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Integer>{

	List<Book> findByNameAndPrice(String name, Float price);

    List<Book> findByNameOrPrice(String name, Float price);

    Page<Book> findByName(String name,Pageable page);

    Page<Book> findByNameNot(String name,Pageable page);

    Page<Book> findByPriceBetween(Float price,Pageable page);

    Page<Book> findByNameLike(String name,Pageable page);

    @Query("{\"bool\" : {\"must\" : {\"term\" : {\"price\" : \"?0\"}}}}")
    Page<Book> findByPrice(Float price, Pageable pageable);
	
}
