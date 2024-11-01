package com.start.egor.library.mapper;

import com.start.egor.library.dto.AuthorDTO;
import com.start.egor.library.model.Author;
import com.start.egor.library.model.GenericModel;
import com.start.egor.library.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AuthorMapper
                extends GenericMapper<Author, AuthorDTO> {

    private final BookRepository bookRepository;

    public AuthorMapper(ModelMapper modelMapper, BookRepository bookRepository){
        super(Author.class, AuthorDTO.class, modelMapper);
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    protected void setupMapper(){
        modelMapper.createTypeMap(Author.class, AuthorDTO.class)
                .addMappings(mapping -> mapping.skip(AuthorDTO::setBookIds)).setPostConverter(toDTOConverter());
    }

    @Override
    protected void mapSpecificFields(AuthorDTO source, Author destination){
        if (!Objects.isNull(source.getBookIds())) {
            destination.setBooks(bookRepository.findAllById(source.getBookIds()));
        } else {
            destination.setBooks(Collections.emptyList());
        }
    }

    @Override
    protected void mapSpecificFields(Author source, AuthorDTO destination){
        destination.setBookIds(getIds(source));
    }

    @Override
    protected List<Long> getIds(Author source){
        return Objects.isNull(source) || Objects.isNull(source.getBooks())
                ? Collections.emptyList()
                : source.getBooks().stream()
                    .map(GenericModel::getId)
                    .collect(Collectors.toList());
    }
}
