package com.bookstorage.bookdemo.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Calendar year;

    @Column
    private String isbn;

    @Column(name = "image_uri")
    private String imageUri;

    @ManyToMany(mappedBy = "books")
    private List<AuthorEntity> authors;

    @OneToMany(mappedBy = "book")
    private List<UserBookEntityRef> userBookEntityRefs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getYear() {
        return year;
    }

    public void setYear(Calendar year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public List<UserBookEntityRef> getUserBookEntityRefs() {
        return userBookEntityRefs;
    }

    public void setUserBookEntityRefs(List<UserBookEntityRef> userBookEntityRefs) {
        this.userBookEntityRefs = userBookEntityRefs;
    }
}
