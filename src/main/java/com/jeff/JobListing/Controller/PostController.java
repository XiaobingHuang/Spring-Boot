package com.jeff.JobListing.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeff.JobListing.Model.Post;
import com.jeff.JobListing.Repository.PostRepository;
import com.jeff.JobListing.Repository.SearchPostRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchPostRepository searchRepo;

    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value="/welcome")
    public  String welcome() {
        return "Welcome to spring boot heroku demo";
    }

    @CrossOrigin(origins = "https://job-hunting-app-cb9818296d91.herokuapp.com")
    @GetMapping(value="/posts")
    public  List<Post> getAllPosts() {
        return repo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

    @PostMapping("/post/{text}")
    public List<Post> search(@PathVariable String text)
    {
        return searchRepo.findByText(text);
    }
    
    
}
