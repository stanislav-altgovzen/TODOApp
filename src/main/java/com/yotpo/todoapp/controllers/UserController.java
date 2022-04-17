package com.yotpo.todoapp.controllers;

import com.yotpo.api.generated.UserApi;
import com.yotpo.generated.model.UserDto;
import com.yotpo.todoapp.entities.User;
import com.yotpo.todoapp.mappers.UserMapper;
import com.yotpo.todoapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) throws Exception {
        User user = userMapper.toUser(userDto);
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(userMapper.toUserDto(newUser));
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long userId) throws Exception {
        Optional<User> user = userService.getUser(userId);
        UserDto userDto = userMapper.toUserDto(user.get());
        return ResponseEntity.ok(userDto);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() throws Exception {
        List<User> users = userService.getAllUsers();
        List<UserDto> usersDto = users.stream()
                .map(u -> userMapper.toUserDto(u))
                .collect(Collectors.toList());
        return ResponseEntity.ok(usersDto);
    }

    @Override
    public ResponseEntity<Void> updateUser(Long userId, UserDto userDto) throws Exception {
        Optional<User> user = userService.getUser(userId);
        User user1 = user.get();
        userMapper.mergeUser(userDto, user1);
        userService.updateUser(user1);
        return ResponseEntity.ok(null);
    }

    // TODO: add exception handler when trying to delete not exist user
    @Override
    public ResponseEntity<Void> deleteUser(Long userId) throws Exception {
        Optional<User> user = userService.getUser(userId);
        userService.deleteUser(user.get());
        return ResponseEntity.ok(null);
    }

}
