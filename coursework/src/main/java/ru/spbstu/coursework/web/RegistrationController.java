package ru.spbstu.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.spbstu.coursework.enteties.User;
import ru.spbstu.coursework.exceptions.InvalidUserOrPasswordException;
import ru.spbstu.coursework.services.UserService;

import java.util.Collections;


@Controller
@RequestMapping("/carservice")
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody AuthRequest request) {
        if (request.getUserName() == null || request.getPassword() == null) {
            throw new InvalidUserOrPasswordException("Fields can not be null.");
        }
        userService.addUser(new User(request.getUserName(), passwordEncoder.encode(request.getPassword()),
                Collections.singletonList("ROLE_USER")));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
