package com.ex.blog.services;

import com.ex.blog.repository.UserRepository;
import com.ex.blog.repository.models.Role;
import com.ex.blog.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println(user.getUsername());
        return userRepository.findByUsername(username);
    }
    public void addUser(String username,String password){
        User user=new User();
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(password);
        user.setUsername(username);
        userRepository.save(user);
    }
}
