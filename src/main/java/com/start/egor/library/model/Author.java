package com.start.egor.library.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import java.time.LocalDate;

@Entity
@Table (name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default-generator", sequenceName = "authors_sequence", allocationSize = 1)
public class Author extends GenericModel {
    @Column(name = "name", nullable = false)
    private String authorName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "description")
    private String description;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "books_authors",
                joinColumns = @JoinColumn(name = "author_id"),
                foreignKey = @ForeignKey(name = "FK_AUTHORS_BOOKS"),
                inverseJoinColumns = @JoinColumn(name = "book_id"),
                inverseForeignKey = @ForeignKey(name = "FK_BOOK_AUTHORS"))
    List<Book> books;
}
