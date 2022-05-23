//package com.codeup.springblog.controllers;
//
//
//import com.codeup.springblog.models.Movie;
//import com.codeup.springblog.repositories.MovieRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/movies")
//public class MovieController {
//    private final MovieRepository movieDao;
//
//    public MovieController(MovieRepository movieDao) {
//        this.movieDao = movieDao;
//    }
//
//    @GetMapping
//    public String showMovies (Model model){
//    model.addAttribute("movies", movieDao.findAll());
//    return "movies/index";
//    }
//
//    @GetMapping("movies/create")
//    public String creatMovies (Model model){
//        model.addAttribute("movie", new Movie());
//        return "movies/create";
//    }
//
//    @PostMapping("/create")
//    public String createMovie(@ModelAttribute Movie movie) {
//        movieDao.save(movie);
//        return "movies/index";
//    }
//
//    @GetMapping("/moives/update")
//    public String updateMovies ()
//
//}
