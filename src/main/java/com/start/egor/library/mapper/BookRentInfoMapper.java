package com.start.egor.library.mapper;

import com.start.egor.library.dto.BookRentInfoDTO;
import com.start.egor.library.model.BookRentInfo;
import com.start.egor.library.repository.BookRepository;
import com.start.egor.library.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Objects;

@Component
public class BookRentInfoMapper
        extends GenericMapper<BookRentInfo, BookRentInfoDTO> {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    protected BookRentInfoMapper(ModelMapper mapper,
                                 BookRepository bookRepository,
                                 UserRepository userRepository) {
        super(BookRentInfo.class, BookRentInfoDTO.class, mapper);
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void setupMapper() {
        super.modelMapper.createTypeMap(BookRentInfo.class, BookRentInfoDTO.class)
                .addMappings(m -> m.skip(BookRentInfoDTO::setUserId))
                .addMappings(m -> m.skip(BookRentInfoDTO::setBookId))
                .setPostConverter(toDTOConverter());

        super.modelMapper.createTypeMap(BookRentInfoDTO.class, BookRentInfo.class)
                .addMappings(m -> m.skip(BookRentInfo::setUser))
                .addMappings(m -> m.skip(BookRentInfo::setBook))
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(BookRentInfoDTO source, BookRentInfo destination) {
        destination.setBook(bookRepository.findById(source.getBookId()).orElseThrow(() ->
                new NotFoundException("Книги не найдено")));
        destination.setUser(userRepository.findById(source.getUserId()).orElseThrow(() ->
                new NotFoundException("Пользователя не найдено")));
    }

    @Override
    protected void mapSpecificFields(BookRentInfo source, BookRentInfoDTO destination) {
        destination.setUserId(source.getUser().getId());
        destination.setBookId(source.getBook().getId());
    }

    @Override
    protected List<Long> getIds(BookRentInfo entity) {
        throw new UnsupportedOperationException("Метод недоступен");
    }
}