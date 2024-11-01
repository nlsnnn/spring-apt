package com.start.egor.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public abstract class GenericModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default-generator")
    private Long id;

    @Column(name = "created_when")
    private LocalDateTime createdWhen;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "deleted_when")
    private LocalDateTime deletedWhen;

    @Column(name = "deleted_by")
    private Integer deletedBy;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
