package com.ex.blog.controllers;

import com.ex.blog.repository.models.Blog;
import com.ex.blog.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.Map;

@Controller

public class BlogController {
    @Autowired
    private BlogsService blogsService;
    @GetMapping("/")
    public Page<Blog> HomePage(@PageableDefault(sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,Model model) {
        return blogsService.getBlogs(pageable);
    }
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @PostMapping(path="/createBlog",produces = "application/json")
    public Blog createBlog(@RequestBody Blog newBlog){
        newBlog.setDateOfPublishing(String.valueOf(LocalDate.now()));
            return blogsService.createBlog(newBlog);
    }
    @PostMapping (path = "/getStats",produces = "application/json")
    public Map<String, Integer> getStatsForAWeek(String date){
        return blogsService.getStatsForAWeek(date);
    }
}
