package ru.spbstu.coursework.services;

import ru.spbstu.coursework.enteties.Work;

import java.util.List;

public interface WorkService {
    List<Work> listWorks();
    Work findWork(Integer id);
    Work addWork(Work work);
    void deleteWork(Integer id);
}
