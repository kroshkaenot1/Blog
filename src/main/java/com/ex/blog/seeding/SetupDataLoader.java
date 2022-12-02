package com.ex.blog.seeding;

import com.ex.blog.repository.BlogRepository;
import com.ex.blog.repository.UserRepository;
import com.ex.blog.repository.models.Blog;
import com.ex.blog.repository.models.Role;
import com.ex.blog.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collections;
@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(userRepository.findByUsername("user")!= null && userRepository.findByUsername("admin")!=null){
            return;
        }
        User user = new User();
        user.setUsername("user");
        user.setPassword("4321");
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        User admin = new User();

        admin.setRoles(Collections.singleton(Role.ADMIN));
        admin.setUsername("admin");
        admin.setPassword("0987");
        userRepository.save(admin);

        Blog blog = new Blog("Nature","Andrey","Bear");
        blogRepository.save(blog);
        Blog blog1 = new Blog("Beautiful creations","Vasiliy","Bee");
        blogRepository.save(blog1);
    }
}
