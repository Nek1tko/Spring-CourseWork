package ru.spbstu.coursework.enteties;

import org.springframework.format.annotation.DateTimeFormat;
import ru.spbstu.coursework.enteties.Car;
import ru.spbstu.coursework.enteties.Master;
import ru.spbstu.coursework.enteties.Service;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Work {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_work", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateWork;

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

    public Work(Date dateWork, Master master, Service service, Car car) {
        this.dateWork = dateWork;
        this.master = master;
        this.service = service;
        this.car = car;
    }

    public Date getDateWork() {
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

    public void setDateWork(Date dateWork) {
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
