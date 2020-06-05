package ru.spbstu.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spbstu.coursework.enteties.*;
import ru.spbstu.coursework.enteties.Car;
import ru.spbstu.coursework.services.CarService;
import ru.spbstu.coursework.services.MasterService;
import ru.spbstu.coursework.services.ServiceService;
import ru.spbstu.coursework.services.WorkService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carservice")
public class CarServiceController {
    private MasterService masterService;
    private CarService carService;
    private WorkService workService;
    private ServiceService serviceService;

    @PostMapping("/masters/{id}")
    public void editMaster(@PathVariable("id") Integer id, String name) {
        Master master = masterService.findMaster(id);

        if (name != null) {
            master.setName(name);
        }

        masterService.addMaster(master);
    }

    @PostMapping(value = "/masters", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Master> addMaster(@RequestBody Master master) {
        return new ResponseEntity<>(masterService.addMaster(master), HttpStatus.OK);
    }

    @GetMapping("/masters/{id}")
    public ResponseEntity<Master> getMaster(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(masterService.findMaster(id), HttpStatus.OK);
    }

    @GetMapping("/masters")
    public ResponseEntity<List<Master>> getMasters() {
        return new ResponseEntity<>(masterService.listMaster(), HttpStatus.OK);
    }

    @DeleteMapping("/masters/{id}")
    public ResponseEntity<String> deleteMaster(@PathVariable("id") Integer id) {
        masterService.deleteMaster(id);
        return new ResponseEntity<>("Master has deleted", HttpStatus.OK);
    }

    @PutMapping("/works/{id}")
    public void editWork(@PathVariable("id") Integer id, String dateWork, Integer carId, Integer serviceId, Integer masterId) {
        Work work = workService.findWork(id);

        if (dateWork != null) {
            work.setDateWork(dateWork);
        }

        if (carId != null) {
            work.setCar(carService.findCar(carId));
        }

        if (serviceId != null) {
            work.setService(serviceService.findService(serviceId));
        }

        if (masterId != null) {
            work.setMaster(masterService.findMaster(masterId));
        }

        workService.addWork(work);
    }

    @PostMapping(value = "/works", consumes = "application/json", produces = "application/json")
    public ResponseEntity<WorkRequest> addWork(@RequestBody WorkRequest workRequest) {
        Work work = new Work(workRequest.getDateWork(), masterService.findMaster(workRequest.getMasterId()),
                serviceService.findService(workRequest.getServiceId()), carService.findCar(workRequest.getCarId()));
        work.setId(workRequest.getId());
        Work newWork = workService.addWork(work);
        workRequest.setId(newWork.getId());
        return new ResponseEntity<>(workRequest, HttpStatus.OK);
    }

    @GetMapping("/works/{id}")
    public ResponseEntity<WorkRequest> getWork(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(new WorkRequest(workService.findWork(id)), HttpStatus.OK);
    }

    @GetMapping("/works")
    public ResponseEntity<List<WorkRequest>> getWorks() {
        ArrayList<WorkRequest> workRequests = new ArrayList<WorkRequest>();
        workService.listWorks().forEach(work -> workRequests.add(new WorkRequest(work)));
        return new ResponseEntity<>(workRequests, HttpStatus.OK);
    }

    @DeleteMapping("/works/{id}")
    public void deleteWork(@PathVariable("id") Integer id) {
        workService.deleteWork(id);
    }

    @PutMapping("/cars/{id}")
    public void editCar(@PathVariable("id") Integer id, String num, String color, String mark, Boolean isForeign) {
        Car car = carService.findCar(id);

        if (num != null) {
            car.setNum(num);
        }
        if (color != null) {
            car.setColor(color);
        }
        if (mark != null) {
            car.setMark(mark);
        }
        if (isForeign != null) {
            car.setForeign(isForeign);
        }
        carService.addCar(car);
    }

    @PostMapping(value = "/cars", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(carService.findCar(id), HttpStatus.OK);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carService.listCars(), HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
        return new ResponseEntity<>("Car has deleted", HttpStatus.OK);
    }

    @PostMapping("/services/{id}")
    public void editService(@PathVariable("id") Integer id, String name, Double costOur, Double costForeign) {
        Service service = serviceService.findService(id);

        if (name != null) {
            service.setName(name);
        }

        if (costOur != null) {
            service.setCostOur(costOur);
        }

        if (costForeign != null) {
            service.setCostForeign(costForeign);
        }

        serviceService.addService(service);
    }

    @PostMapping(value = "/services", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Service> addMaster(@RequestBody Service service) {
        return new ResponseEntity<>(serviceService.addService(service), HttpStatus.OK);
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<Service> getService(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(serviceService.findService(id), HttpStatus.OK);
    }

    @GetMapping("/services")
    public ResponseEntity<List<Service>> getServices() {
        return new ResponseEntity<>(serviceService.listService(), HttpStatus.OK);
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") Integer id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>("Service has deleted", HttpStatus.OK);
    }

    @Autowired
    public void setMasterService(MasterService masterService) {
        this.masterService = masterService;
    }

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @Autowired
    public void setWorkService(WorkService workService)
    {
        this.workService = workService;
    }

    @Autowired
    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
}
