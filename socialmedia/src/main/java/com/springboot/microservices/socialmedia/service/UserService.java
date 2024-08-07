package com.springboot.microservices.socialmedia.service;

import com.springboot.microservices.socialmedia.exceptions.UserNotFoundException;
import com.springboot.microservices.socialmedia.models.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private static int userCount = 0;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(++userCount, "Ravi", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Shreya", LocalDate.now().minusYears(28)));
        users.add(new User(++userCount, "Surya", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        User retrievedUser =  users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);

        if(retrievedUser==null) throw new UserNotFoundException("id: " +id);

        return retrievedUser;
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User deleteById(int id) {
        User userTobeDeleted = findById(id);
        users.removeIf(user -> user.getId() == id);
        return userTobeDeleted;
    }
}
