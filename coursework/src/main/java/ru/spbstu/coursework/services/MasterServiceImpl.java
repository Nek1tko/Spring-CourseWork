package ru.spbstu.coursework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import ru.spbstu.coursework.InvalidIdException;
import ru.spbstu.coursework.enteties.Car;
import ru.spbstu.coursework.enteties.Master;
import ru.spbstu.coursework.repositories.MasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MasterServiceImpl implements MasterService {

    @Autowired
    MasterRepository repository;

    @Override
    public List<Master> listMaster() {
        return (List<Master>) repository.findAll();
    }

    @Override
    public Master addMaster(Master master) {
        return repository.save(master);
    }

    @Override
    public Master findMaster(Integer id) {
        Optional<Master> master = repository.findById(id);
        if (master.isPresent()) {
            return master.get();
        }
        else {
            throw new InvalidIdException(id);
        }
    }

    @Override
    public void deleteMaster(Integer id) {
        repository.delete(findMaster(id));
    }
}
