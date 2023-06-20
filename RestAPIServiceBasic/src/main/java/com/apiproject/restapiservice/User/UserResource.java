package com.apiproject.restapiservice.User;


import org.springframework.web.bind.annotation.*;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user=userDaoService.findOne(id);
        if(user==null)
            try {
                throw new UserPrincipalNotFoundException("id"+id);
            } catch (UserPrincipalNotFoundException e) {
                throw new RuntimeException(e);
            }
        return user;
    }

    @GetMapping("/user")
    public void createUser(@RequestBody User user) {
        userDaoService.save(user);
    }
}
