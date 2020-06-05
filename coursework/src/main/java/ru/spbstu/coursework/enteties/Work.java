package ru.spbstu.coursework.enteties;

import ru.spbstu.coursework.enteties.Car;
import ru.spbstu.coursework.enteties.Master;
import ru.spbstu.coursework.enteties.Service;

import javax.persistence.*;

@Entity
public class Work {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="workGenerator")
    @SequenceGenerator(name="workGenerator", sequenceName="workSeq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_work", nullable = false)
    private String dateWork;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "master_id")
    private Master master;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "service_id")
    private Service service;

    protected Work(){}

    public Work(String dateWork, Master master, Service service, Car car) {
        this.dateWork = dateWork;
        this.master = master;
        this.service = service;
        this.car = car;
    }

    public String getDateWork() {
        return dateWork;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setDateWork(String dateWork) {
        this.dateWork = dateWork;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", dateWork='" + dateWork + '\'' +
                ", car=" + car +
                ", master=" + master +
                ", service=" + service +
                '}';
    }
}
