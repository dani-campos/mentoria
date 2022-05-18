package br.com.dani.mentoria_pp.repository;

import br.com.dani.mentoria_pp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
