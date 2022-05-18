package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
//import com.codeup.springblog.repositories.AdRepository;
import com.codeup.springblog.models.PostDetails;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
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
        List<Post> allPosts = generatePosts();
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/create")
    public String creatPostForm() {
        return "/posts/create";
    }


    @PostMapping("/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/update/{id}")
    public String returnPostUpdateView(@PathVariable long id, Model model) {
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @PostMapping("/posts/update/{id}")
    public String updatePost(@PathVariable long id, @RequestParam String topic) {
        Post post = postDao.getById(id);
        PostDetails pd = post.getPostDetails();
        pd.setTopicDescription(topic);
        post.setPostDetails(pd);
        postDao.save(post);
        return "redirect:/posts";
    }
}

