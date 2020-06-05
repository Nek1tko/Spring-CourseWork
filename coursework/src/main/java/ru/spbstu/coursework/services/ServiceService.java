package ru.spbstu.coursework.services;

import ru.spbstu.coursework.enteties.Service;

import java.io.Serializable;
import java.util.List;

public interface ServiceService {
    List<Service> listService();
    Service findService(Integer id);
    Service addService(Service service);
    void deleteService(Integer id);
}
