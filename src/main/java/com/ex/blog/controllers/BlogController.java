package com.ex.blog.controllers;

import com.ex.blog.repository.models.Blog;
import com.ex.blog.repository.models.User;
import com.ex.blog.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
public class BlogController {
    @Autowired
    private BlogsService blogsService;
    @GetMapping("/")
    public Page<Blog> HomePage(@PageableDefault(sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable) {
        return blogsService.getBlogs(pageable);
    }
    @PostMapping(path="/createBlog",produces = "application/json")
    public Blog createBlog(@RequestBody Blog newBlog){
        newBlog.setDateOfPublishing(String.valueOf(LocalDate.now()));
            return blogsService.createBlog(newBlog);
    }
    @GetMapping (path = "/getStats",produces = "application/json")
    public Map<String, Integer> getStatsForAWeek(String date){
        return blogsService.getStatsForAWeek(date);
    }
    @PostMapping(path="/login",produces = "application/json")
    public User login(User user){
        return user;
    }
}
