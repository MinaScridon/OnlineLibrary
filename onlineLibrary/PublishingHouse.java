package com.howtodoinjava.hibernate.test.dto.practicalproject;

import jakarta.persistence.*;

@Entity
@Table(name = "PublishingHouse")

public class PublishingHouse {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name = "PublishingHouseID")
    private Integer id;

    @Column ( name = "PublishingHouseName", nullable = false)
    private String publishingHouseName;

    @Column ( name = "YearOfAppearance", nullable = false)
    private Integer yearOfAppearance;

    @Column ( name = "Ranking", nullable = false)
    private Integer ranking;

    @OneToOne
    private Book book;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublishingHouseName() {
        return publishingHouseName;
    }

    public void setPublishingHouseName(String publishingHouseName) {
        this.publishingHouseName = publishingHouseName;
    }

    public Integer getYearOfAppearance() {
        return yearOfAppearance;
    }

    public void setYearOfAppearance(Integer yearOfAppearance) {
        this.yearOfAppearance = yearOfAppearance;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "id=" + id +
                ", publishingHouseName='" + publishingHouseName + '\'' +
                ", yearOfAppearance=" + yearOfAppearance +
                ", ranking=" + ranking +
                ", book=" + book +
                '}';
    }
}
