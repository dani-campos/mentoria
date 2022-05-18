package br.com.dani.mentoria_pp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<SalaryHistory> salaryHistories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<OccupationHistory> occupationHistories;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }
}
