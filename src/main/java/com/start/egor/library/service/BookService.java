package com.start.egor.library.service;

import com.start.egor.library.dto.BookDTO;
import com.start.egor.library.mapper.BookMapper;
import com.start.egor.library.model.Author;
import com.start.egor.library.model.Book;
import com.start.egor.library.repository.AuthorRepository;
import com.start.egor.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class BookService extends GenericService<Book, BookDTO> {
    private final AuthorRepository authorRepository;

    protected BookService(BookRepository repository,
                          BookMapper mapper,
                          AuthorRepository authorRepository) {
        super(repository, mapper);
        this.authorRepository = authorRepository;
    }

    public BookDTO addAuthor(final Long bookId,
                             final Long authorId) {
        BookDTO book = getOne(bookId);
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new NotFoundException("Автор не найден"));
        book.getAuthorIds().add(author.getId());
        update(book);
        return book;
    }
}
