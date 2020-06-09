package ru.spbstu.coursework.web;

import ru.spbstu.coursework.enteties.Work;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Date;

public class WorkRequest implements Serializable {
    private Integer id;
    private Date dateWork;
    private Integer carId;
    private Integer masterId;
    private Integer serviceId;

    protected WorkRequest() {};

    public WorkRequest(Date dateWork, Integer carId, Integer masterId, Integer serviceId) {
        this.dateWork = dateWork;
        this.carId = carId;
        this.masterId = masterId;
        this.serviceId = serviceId;
    }

    public WorkRequest(Work work) {
        this.id = work.getId();
        this.dateWork = work.getDateWork();
        this.carId = work.getCar().getId();
        this.masterId = work.getMaster().getId();
        this.serviceId = work.getService().getId();
    }

    public Date getDateWork() {
        return dateWork;
    }

    public void setDateWork(Date dateWork) {
        this.dateWork = dateWork;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
