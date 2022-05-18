package br.com.dani.mentoria_pp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SalaryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer salaryFrom;
    private Integer salaryTo;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SalaryHistory(
            Integer salaryFrom,
            Integer salaryTo,
            LocalDateTime createdAt,
            User user
    ) {
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.createdAt = createdAt;
        this.user = user;
    }

    public SalaryHistory() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getSalaryFrom() {
        return salaryFrom;
    }

    public Integer getSalaryTo() {
        return salaryTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public User getUser() {
        return user;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
