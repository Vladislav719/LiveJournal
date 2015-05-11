package com.github.gazizovrim.repository;

import com.github.gazizovrim.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladislav on 10.05.2015.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {

    @Query("from User u where u.login=?1")
    User findByLogin(String login);
}
