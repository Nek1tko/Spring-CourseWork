package ru.spbstu.coursework.enteties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="carGenerator")
    @SequenceGenerator(name="carGenerator", sequenceName="carSeq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "num", nullable = false)
    private String num;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "mark", nullable = false)
    private String mark;

    @Column(name = "is_foreign", nullable = false)
    private Boolean isForeign;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private Set<Work> works = new HashSet<>();

    protected Car(){}

    public Car(String num, String color, String mark, Boolean isForeign) {
        this.num = num;
        this.color = color;
        this.mark = mark;
        this.isForeign = isForeign;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setForeign(boolean isForeign) {
        this.isForeign = isForeign;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", color='" + color + '\'' +
                ", mark='" + mark + '\'' +
                ", isForeign=" + isForeign +
                '}';
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }
}
