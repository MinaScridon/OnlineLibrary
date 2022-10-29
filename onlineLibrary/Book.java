package com.howtodoinjava.hibernate.test.dto.practicalproject;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name = "BookId")
    private Integer id;

    @Column ( name = "Title", nullable = false, unique = true)
    private String title;

    @Column ( name = "PublishingYear", nullable = false)
    private Integer publishingYear;

    @Column ( name = "Genre", nullable = false)
    private String genre;

    @Column ( name = "NumberOfPages", nullable = false)
    private Integer numberOfPages;

    @Column ( name = "Status", nullable = false)
    private String status;


    @OneToMany
    private List<Author> authors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Integer publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishingYear=" + publishingYear +
                ", genre='" + genre + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", status='" + status + '\'' +
                ", authors=" + authors +
                '}';
    }
}