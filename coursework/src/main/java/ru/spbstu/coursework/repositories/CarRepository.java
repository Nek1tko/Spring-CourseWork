package ru.spbstu.coursework.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.spbstu.coursework.enteties.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
