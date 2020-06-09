package ru.spbstu.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.spbstu.coursework.enteties.User;
import ru.spbstu.coursework.exceptions.InvalidUserOrPasswordException;
import ru.spbstu.coursework.repositories.UserRepository;
import ru.spbstu.coursework.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/carservice/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody AuthRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();
        User user = userRepository.findUserByUserName(userName).
                orElseThrow(() -> new InvalidUserOrPasswordException("Invalid username or password"));
        Map<Object, Object> model = new HashMap<>();
        if (passwordEncoder.matches(password, user.getPassword())) {
            String token = jwtTokenProvider.createToken(userName, user.getRoles());
            model.put("userName", userName);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } else {
            throw new InvalidUserOrPasswordException("Invalid username or password");
        }

    }
}
