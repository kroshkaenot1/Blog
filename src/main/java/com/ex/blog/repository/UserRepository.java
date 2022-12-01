package com.ex.blog.repository;

import com.ex.blog.repository.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    @Query("select u from User u where u.username=?1")
    User findByUsername(String username);
}
