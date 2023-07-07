package com.works.repositories;

import com.works.entities.BookAuthorJoin;
import com.works.projections.IBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookAuthorJoinRepository extends JpaRepository<BookAuthorJoin, Long> {

    @Query(value = "select b.BID, b.PAGE_NUMBERS, b.TITLE, A.NAME, A.BIO from PUBLIC.BOOK as b inner join PUBLIC.BOOK_AUTHORS as ba on b.BID = ba.BOOK_BID inner join PUBLIC.AUTHOR A on A.AID = ba.AUTHORS_AID", nativeQuery = true)
    List<BookAuthorJoin> allBook();

}