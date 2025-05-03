package net.imad.user_demo_tp2.web;


import net.imad.user_demo_tp2.entities.User;
import net.imad.user_demo_tp2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserControler {
    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}")
    public User user(@PathVariable  String username){
        User user = userService.findUserByUserName(username);
        return user;
    }
}
