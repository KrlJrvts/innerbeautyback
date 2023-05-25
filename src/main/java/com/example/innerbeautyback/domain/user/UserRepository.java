package com.example.innerbeautyback.domain.user;

import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = ?1 and u.password = ?2 and u.status = ?3")
   Optional <User> findUserBy(String email, String password, String status);

    @Query("select (count(u) > 0) from User u where u.email = ?1 and u.status = ?2")
    boolean activeUserExistsBy(String email, String status);

    @Query("select u from User u where u.id =?1")
    User getUserBy(Integer userId);


}