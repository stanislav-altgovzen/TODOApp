package com.yotpo.todoapp.repositories;

import com.yotpo.todoapp.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
}
