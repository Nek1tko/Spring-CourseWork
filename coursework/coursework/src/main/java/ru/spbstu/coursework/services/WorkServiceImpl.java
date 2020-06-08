package ru.spbstu.coursework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spbstu.coursework.exceptions.InvalidIdException;
import ru.spbstu.coursework.enteties.Work;
import ru.spbstu.coursework.repositories.WorkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository repository;

    @Override
    public List<Work> listWorks() {
        return (List<Work>)repository.findAll();
    }

    @Override
    public Work findWork(Integer id) {
        Optional<Work> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        else {
            throw new InvalidIdException(id);
        }
    }

    @Override
    public Work addWork(Work work) {
        return repository.save(work);
    }

    @Override
    public void deleteWork(Integer id) {
        repository.delete(findWork(id));
    }
}
