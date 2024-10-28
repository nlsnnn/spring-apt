package com.start.egor.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate createdWhen;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "deleted_when")
    private LocalDate deletedWhen;

    @Column(name = "deleted_by")
    private Integer deletedBy;
}
