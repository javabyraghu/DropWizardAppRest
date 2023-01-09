package com.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="author")
public class Author {
    @Id
    @Column(name="aid")
    @JsonProperty
    private Integer authId;
    @Column(name="aname")
    @JsonProperty
    private String name;

    @ManyToMany
    @JoinTable(name="author_books",
            joinColumns = @JoinColumn(name="aidFk"),
            inverseJoinColumns = @JoinColumn(name="bidFk")
    )
    private List<Book> books;

    public Author() {

    }

    public Integer getAuthId() {
        return authId;
    }

    public String getName() {
        return name;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authId=" + authId +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
