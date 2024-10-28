package com.start.egor.library.repository;

import com.start.egor.library.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends GenericRepository<Book> {
}
