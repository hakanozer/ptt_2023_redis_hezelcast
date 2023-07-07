package com.works.services;

import com.works.entities.Book;
import com.works.entities.BookAuthorJoin;
import com.works.projections.IBook;
import com.works.repositories.BookAuthorJoinRepository;
import com.works.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional
public class BookService {

    final BookRepository bookRepository;
    final BookAuthorJoinRepository bookAuthorJoinRepository;

    @CacheEvict(value = "bookLists", allEntries = true)
    public Book save( Book book ) {
        return bookRepository.save(book);
    }

    @Cacheable("bookLists")
    public List<BookAuthorJoin> books() {
        return bookAuthorJoinRepository.allBook();
    }

}
