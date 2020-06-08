package ru.spbstu.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.spbstu.coursework.enteties.User;
import ru.spbstu.coursework.repositories.UserRepository;
import ru.spbstu.coursework.security.JwtTokenProvider;
import ru.spbstu.coursework.services.UserService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/carservice")
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void register(@RequestBody AuthRequest request) {
        userService.addUser(new User(request.getUserName(), passwordEncoder.encode(request.getPassword()),
                Collections.singletonList("ROLE_USER")));
    }
}
