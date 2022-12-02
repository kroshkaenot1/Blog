package com.ex.blog.services;

import com.ex.blog.BlogApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = BlogApplication.class)
class BlogsServiceTest {
    @Autowired
    private BlogsService blogsService;
    String date = String.valueOf(LocalDate.now());
    @Test
    void getStatsForAWeekNotEmpty() {
        assertFalse(blogsService.getStatsForAWeek(date).isEmpty());
    }
    @Test
    void getStatsForAWeekCorrect(){
        //The method should return the number 2, since 2 blogs are created when the application is launched
        assertEquals(2, (int) blogsService.getStatsForAWeek(date).get(date));
    }
}