package com.howtodoinjava.hibernate.test.dto.practicalproject;

import jakarta.persistence.*;

@Entity
@Table (name = "Author")
public class Author {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "AuthorID")
    private Integer id;

    @Column (name = "SurnameAuthor", nullable = false, unique = true)
    private String surnameAuthor;

    @Column ( name = "NameAuthor", nullable = false, unique = true)
    private String nameAuthor;

    @Column ( name = "AgeAuthor", nullable = false)
    private Integer ageAuthor;

    @Column ( name = "ExperienceYears", nullable = false)
    private Integer experienceYears;

    @Column ( name = "Genre", nullable = false)
    private String genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurnameAuthor() {
        return surnameAuthor;
    }

    public void setSurnameAuthor(String surnameAuthor) {
        this.surnameAuthor = surnameAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Integer getAgeAuthor() {
        return ageAuthor;
    }

    public void setAgeAuthor(Integer ageAuthor) {
        this.ageAuthor = ageAuthor;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", surnameAuthor='" + surnameAuthor + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", ageAuthor=" + ageAuthor +
                ", experienceYears=" + experienceYears +
                ", genre='" + genre + '\'' +
                '}';
    }
}