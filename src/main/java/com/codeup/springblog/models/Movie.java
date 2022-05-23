//package com.codeup.springblog.models;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "movies")
//public class Movie {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, length = 100)
//    private String title;
//
//    private String movieCategories;
//    private String description;
//    @Column(nullable = false)
//    private String director;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate releaseDate;
//
//    public Movie() {
//    }
//
//    public Movie(String title, String movieCategories, String description, String director, LocalDate releaseDate) {
//        this.title = title;
//        this.movieCategories = movieCategories;
//        this.description = description;
//        this.director = director;
//        this.releaseDate = releaseDate;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getMovieCategories() {
//        return movieCategories;
//    }
//
//    public void setMovieCategories(String movieCategories) {
//        this.movieCategories = movieCategories;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public LocalDate getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(LocalDate releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//}