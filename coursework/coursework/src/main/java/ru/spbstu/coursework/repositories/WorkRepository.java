package ru.spbstu.coursework.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.spbstu.coursework.enteties.Work;

public interface WorkRepository extends CrudRepository<Work, Integer> {
}
