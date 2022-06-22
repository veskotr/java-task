package com.example.demo.services;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.UnprocessableEntityException;
import com.example.demo.model.User;
import com.example.demo.model.UserStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    private final List<User> userList;

    private static final String emailRegEx = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";

    public UserService() {
        this.userList = new LinkedList<>();
    }

    public List<User> getAll() {
        return userList;
    }

    public User getByEmail(String email) {
        return this.userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElseThrow(EntityNotFoundException::new);
    }

    public void deleteUser(String email) {
        userList.removeIf(user -> user.getEmail().equals(email));
    }

    public User addUser(User user) {
        if (!user.getEmail().matches(emailRegEx)) {
            throw new UnprocessableEntityException("Invalid email");
        }
        userList.add(user);
        return user;
    }

    public User updateUser(User user) {
        if (!user.getEmail().matches(emailRegEx)) {
            throw new UnprocessableEntityException("Invalid email");
        }
        if (!this.userList.contains(user)) {
            throw new EntityNotFoundException("User not found");
        }
        userList.replaceAll(user1 -> user1.getEmail().equals(user.getEmail()) ? user : user1);
        return user;
    }

    public List<User> findAllByStatus(UserStatus status) {
        return userList.stream().filter(user -> user.getUserStatus().equals(status)).toList();
    }
}
