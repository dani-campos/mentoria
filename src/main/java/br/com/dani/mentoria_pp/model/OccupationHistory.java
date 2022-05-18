package br.com.dani.mentoria_pp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OccupationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "office_from")
    private Office officeFrom;
    @ManyToOne
    @JoinColumn(name = "office_to", nullable = false)
    private Office officeTo;

    public OccupationHistory(LocalDateTime createdAt, Office officeFrom, Office officeTo, User user) {
        this.createdAt = createdAt;
        this.officeFrom = officeFrom;
        this.officeTo = officeTo;
        this.user = user;
    }

    public OccupationHistory() {
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
