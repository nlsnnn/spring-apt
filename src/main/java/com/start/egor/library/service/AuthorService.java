package com.start.egor.library.service;

import com.start.egor.library.dto.AuthorDTO;
import com.start.egor.library.mapper.AuthorMapper;
import com.start.egor.library.model.Author;
import com.start.egor.library.model.Book;
import com.start.egor.library.repository.AuthorRepository;
import com.start.egor.library.repository.BookRepository;
import org.webjars.NotFoundException;

public class AuthorService extends GenericService<Author, AuthorDTO> {
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository,
                         AuthorMapper authorMapper,
                         BookRepository bookRepository) {
        super(authorRepository, authorMapper);
        this.bookRepository = bookRepository;
    }

    public AuthorDTO addBook(Long bookId,
                             Long authorId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Книга не найдена!"));
        AuthorDTO author = getOne(authorId);
        author.getBookIds().add(book.getId());
        update(author);
        return author;
    }
}
