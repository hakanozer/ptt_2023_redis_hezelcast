package com.works.restcontroller;

import com.works.entities.Book;
import com.works.entities.BookAuthorJoin;
import com.works.models.Admin;
import com.works.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BookRestController {

    final BookService bookService;
    final HttpServletRequest request;

    @PostMapping("/bookSave")
    public Object bookSave(@RequestBody Book book){
        boolean status = request.getSession().getAttribute("admin") == null;
        if ( status ) {
            Map<String, Object> hm = new LinkedHashMap<>();
            hm.put("status", false);
            hm.put("message", "Please Login");
            return hm;
        }
        return bookService.save(book);
    }

    @GetMapping("/bookList")
    public Object bookList() {
        boolean status = request.getSession().getAttribute("admin") == null;
        if ( status ) {
            Map<String, Object> hm = new LinkedHashMap<>();
            hm.put("status", false);
            hm.put("message", "Please Login");
            return hm;
        }
        return bookService.books();
    }


    @PostMapping("/login")
    public boolean login(@RequestBody Admin admin) {
        if (  admin.getUsername().equals("ali01") && admin.getPassword().equals("12345")) {
            request.getSession().setAttribute("admin", admin.getUsername());
            return true;
        }
        return false;
    }


}
