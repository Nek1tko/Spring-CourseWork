package ru.spbstu.coursework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spbstu.coursework.enteties.User;
import ru.spbstu.coursework.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }
}
