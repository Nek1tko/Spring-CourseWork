package ru.spbstu.coursework.services;

import ru.spbstu.coursework.enteties.Car;

import java.util.List;

public interface CarService {
    List<Car> listCars();
    Car findCar(Integer id);
    Car addCar(Car car);
    void deleteCar(Integer Id);
}
