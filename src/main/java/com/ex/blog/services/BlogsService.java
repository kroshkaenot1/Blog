package com.ex.blog.services;

import com.ex.blog.repository.BlogRepository;
import com.ex.blog.repository.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class BlogsService {
    @Autowired
    private BlogRepository blogRepository;

    public Blog createBlog(Blog blog){
        blogRepository.save(blog);
        return blog;
    }
    public Page<Blog> getBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
    public Map<String,Integer> getStatsForAWeek(String date){
        LocalDate dateForCount = LocalDate.parse(date);
        Map<String,Integer> stats = new LinkedHashMap<>();
        for(int i = 0; i<7 ;i++){
            stats.put(String.valueOf(dateForCount),countBlogsPerDate(String.valueOf(dateForCount)));
            dateForCount = dateForCount.plusDays(1);
        }
        return stats;
    }
    public int countBlogsPerDate(String date){
        List<Blog> blogs = blogRepository.findBlogsByDateOfPublishing(date);
        return blogs.size();
    }
}
