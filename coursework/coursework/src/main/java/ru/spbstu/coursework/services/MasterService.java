package ru.spbstu.coursework.services;

import ru.spbstu.coursework.enteties.Master;

import java.util.List;

public interface MasterService {
    List<Master> listMaster();
    Master findMaster(Integer id);
    Master addMaster(Master master);
    void deleteMaster(Integer id);
}
