package com.start.egor.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRentInfoDTO extends GenericDTO {
    private long userId;
    private long bookId;
    private LocalDateTime rentDate;
    private LocalDateTime returnDate;
    private Integer rentPeriod;
    private boolean returned;

}
