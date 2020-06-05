package ru.spbstu.coursework.enteties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="serviceGenerator")
    @SequenceGenerator(name="serviceGenerator", sequenceName="serviceSeq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cost_our", nullable = false)
    private Double costOur;

    @Column(name = "cost_foreign", nullable = false)
    private Double costForeign;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
    private Set<Work> works = new HashSet<>();

    protected Service(){}

    public Service(String name, Double costOur, Double costForeign) {
        this.name = name;
        this.costOur = costOur;
        this.costForeign = costForeign;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCostForeign() {
        return costForeign;
    }

    public void setCostForeign(Double costForeign) {
        this.costForeign = costForeign;
    }

    public Double getCostOur() {
        return costOur;
    }

    public void setCostOur(Double costOur) {
        this.costOur = costOur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costOur=" + costOur +
                ", costForeign=" + costForeign +
                '}';
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }
}
