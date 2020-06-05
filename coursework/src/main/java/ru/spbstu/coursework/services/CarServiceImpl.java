package ru.spbstu.coursework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spbstu.coursework.InvalidIdException;
import ru.spbstu.coursework.enteties.Car;
import ru.spbstu.coursework.repositories.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository repository;

    @Override
    public List<Car> listCars() {
        return (List<Car>) repository.findAll();
    }

    @Override
    public Car findCar(Integer id) {
        Optional<Car> car = repository.findById(id);
        if (car.isPresent()) {
            return car.get();
        }
        else {
            throw new InvalidIdException(id);
        }
    }

    @Override
    public Car addCar(Car car) {
        return repository.save(car);
    }

    @Override
    public void deleteCar(Integer id) {
        repository.delete(findCar(id));
    }
}
