package com.yotpo.todoapp.services;

import com.yotpo.todoapp.entities.User;
import com.yotpo.todoapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
            }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {

        return userRepository.findById(id);
    }

    public void deleteUser(User userId) {
        userRepository.delete(userId);
    }

    //TODO: add error handler according to Optional return value
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
