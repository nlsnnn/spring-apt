package com.start.egor.library.service;

import com.start.egor.library.dto.BookRentInfoDTO;
import com.start.egor.library.mapper.BookRentInfoMapper;
import com.start.egor.library.model.BookRentInfo;
import com.start.egor.library.repository.BookRentInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class BookRentInfoService extends GenericService <BookRentInfo, BookRentInfoDTO> {
    protected BookRentInfoService(BookRentInfoRepository bookRentInfoRepository,
                                  BookRentInfoMapper bookRentInfoMapper) {
        super(bookRentInfoRepository, bookRentInfoMapper);
    }
}
