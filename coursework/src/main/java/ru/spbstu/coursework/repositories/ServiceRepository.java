package ru.spbstu.coursework.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.spbstu.coursework.enteties.Service;

public interface ServiceRepository extends CrudRepository<Service, Integer> {
}
