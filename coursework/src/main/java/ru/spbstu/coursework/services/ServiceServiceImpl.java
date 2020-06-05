package ru.spbstu.coursework.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.spbstu.coursework.InvalidIdException;
import ru.spbstu.coursework.enteties.Car;
import ru.spbstu.coursework.enteties.Service;
import ru.spbstu.coursework.repositories.ServiceRepository;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository repository;

    @Override
    public List<Service> listService() {
        return (List<Service>) repository.findAll();
    }

    @Override
    public Service findService(Integer id) {
        Optional<Service> service = repository.findById(id);
        if (service.isPresent()) {
            return service.get();
        }
        else {
            throw new InvalidIdException(id);
        }
    }

    @Override
    public Service addService(Service service) {
        return repository.save(service);
    }

    @Override
    public void deleteService(Integer id) {
        repository.delete(findService(id));
    }
}
