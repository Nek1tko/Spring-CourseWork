package ru.spbstu.coursework.enteties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Master {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "master")
    private Set<Work> works = new HashSet<>();

    protected Master() {}

    public Master(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }
}
