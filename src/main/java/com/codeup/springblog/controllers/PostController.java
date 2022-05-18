package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
//import com.codeup.springblog.repositories.AdRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }



    public List <Post> generatePosts(){
        List<Post> allPosts = new ArrayList<>();
        Post post1 = new Post(1,"first post", "this is my first post");
        Post post2 = new Post(2, " second post", "This is my second post");
        Post post3 = new Post(3, "third post", "This is my third post");
        allPosts.add(post1);
        allPosts.add(post2);
        allPosts.add(post3);
        return allPosts;
    }

    @GetMapping
    public String allPosts(Model model){
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }


    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model){


        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @GetMapping("/create")
    public String creatPostForm() {
        return "/posts/create";
    }


    @PostMapping("/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        User user = userDao.getById(1l);
        userDao.save(user);
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }
}

