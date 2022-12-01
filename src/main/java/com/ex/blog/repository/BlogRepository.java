package com.ex.blog.repository;

import com.ex.blog.repository.models.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    List<Blog> findBlogsByDateOfPublishing(String date);
}
