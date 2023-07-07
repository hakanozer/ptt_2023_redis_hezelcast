package com.works.restcontroller;

import com.works.entities.Book;
import com.works.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookRestController {

    final BookService bookService;

    @PostMapping("/bookSave")
    public Book bookSave(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping("/bookList")
    public Object bookList() {
        return bookService.books();
    }


}
