package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.services.StringService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final com.codeup.springblog.services.EmailService emailService;
    private StringService StringServices;
    private EmailService EmailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/create")
    public String doCreatePost(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
//        emailService.prepareAndSend(post, post.getTitle(), post.getBody());
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String editPost(@PathVariable(name="id") Long id, Model model) {
    model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @PostMapping("/edit")
    public String doEditPost(@ModelAttribute Post post){
        postDao.save(post);
        return "/post" + post.getId();
    }
}
