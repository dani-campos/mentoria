package br.com.dani.mentoria_pp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String officeName;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    private List<Employee> employees;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "officeFrom")
    private List<OccupationHistory> occupationHistoriesFrom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "officeTo")
    private List<OccupationHistory> occupationHistoriesTo;

    public Office(Integer id, String officeName, String description) {
        this.id = id;
        this.officeName = officeName;
        this.description = description;
    }

    public Office() {
    }
}
