package br.com.dani.mentoria_pp.service;

import br.com.dani.mentoria_pp.dto.EmployeeDto;
import br.com.dani.mentoria_pp.model.Employee;
import br.com.dani.mentoria_pp.model.Office;
import br.com.dani.mentoria_pp.model.User;
import br.com.dani.mentoria_pp.repository.EmployeeRepository;
import br.com.dani.mentoria_pp.repository.OfficeRepository;
import br.com.dani.mentoria_pp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private OfficeRepository officeRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEmployee() {
        var employeeDto = new EmployeeDto(
                "Teste",
                LocalDate.of(2022, 05, 18),
                "Domingos de Moraes",
                "123456",
                "teste.com.br",
                30000,
                1,
                1
                );
        var office = new Office(1,"Programador", "teste");
        var user = new User(1,"teste@email.com", "1234");
        var employee = new Employee(
                "teste",
                LocalDate.of(2022, 05, 18),
                "Domingos de Moraes",
                "123456",
                "teste.com.br",
                30000,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST,
                office
        );
        Mockito.when(officeRepository.findById(1)).thenReturn(Optional.of(office));
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));
        Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employee);
        employeeService.createEmployee(employeeDto);
    }

    @Test
    void uploadPhoto() {
    }

    @Test
    void consultaEmployee() {
    }
}