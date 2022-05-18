package br.com.dani.mentoria_pp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String fullName;
    private LocalDate birthDate;
    private String address;
    private String document;
    private String photo;
    private Integer salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<SalaryHistory> salaryHistories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<OccupationHistory> occupationHistories;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    public Employee(
            String fullName,
            LocalDate birthDate,
            String address,
            String document,
            String photo,
            Integer salary,
            List<SalaryHistory> salaryHistories,
            List<OccupationHistory> occupationHistories,
            Office office
    ) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.document = document;
        this.photo = photo;
        this.salary = salary;
        salaryHistories.forEach(salaryHistory -> salaryHistory.setEmployee(this));
        this.salaryHistories = salaryHistories;
        occupationHistories.forEach(occupationHistory  -> occupationHistory.setEmployee(this));
        this.occupationHistories = occupationHistories;
        this.office = office;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getDocument() {
        return document;
    }

    public String getPhoto() {
        return photo;
    }

    public Integer getSalary() {
        return salary;
    }

    public List<SalaryHistory> getSalaryHistories() {
        return salaryHistories;
    }

    public List<OccupationHistory> getOccupationHistories() {
        return occupationHistories;
    }

    public Office getOffice() {
        return office;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}




