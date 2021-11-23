package com.github.durakin.isdlabs.lab5.repository;

import com.github.durakin.isdlabs.lab5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    Optional<User> findById(Integer integer);

    Optional<User> findByName(String name);


}