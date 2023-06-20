package com.apiproject.restapiservice.User;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Mila", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Rita", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Nila", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll() {

        return users;
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {

        Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
        return users.stream().filter(predicate).findFirst().get();
    }
}
