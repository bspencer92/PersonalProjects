package com.readinglists.com.repository;

import com.readinglists.com.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   @Query("SELECT S FROM User S WHERE S.email =?1")
    User findByEmail(String email);

   @Query("SELECT U FROM User U WHERE U.email = ?1 AND U.password = ?2")
   User login(String email, String password);
}