package ru.spbstu.coursework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spbstu.coursework.enteties.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUserName(String userName);
}
