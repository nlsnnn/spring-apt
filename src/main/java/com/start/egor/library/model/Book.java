package com.start.egor.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "books")
@SequenceGenerator(name = "default-generator", sequenceName = "book_sequence", allocationSize = 1)
public class Book extends GenericModel {
    @Column(name = "title", nullable = false)
    private String bookTitle;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "storage_place", nullable = false)
    private String storagePlace;

    @Column(name = "online_copy_path")
    private String onlineCopyPath;

    @Column(name = "genre", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            foreignKey = @ForeignKey(name = "FK_BOOKS_AUTHORS"),
            inverseJoinColumns = @JoinColumn(name = "author_id"),
            inverseForeignKey = @ForeignKey(name = "FK_AUTHORS_BOOKS"))
    @ManyToMany
    List<Author> authors;
}


