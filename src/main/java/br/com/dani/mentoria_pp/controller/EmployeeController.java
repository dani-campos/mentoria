package br.com.dani.mentoria_pp.controller;

import br.com.dani.mentoria_pp.dto.EmployeeDto;
import br.com.dani.mentoria_pp.model.Employee;
import br.com.dani.mentoria_pp.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody EmployeeDto employeeDto) {
        employeeService.createEmployee(employeeDto);
        return ResponseEntity.ok().body(Map.of("message", "Employee Criado com sucesso."));
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> consultaEmployee(@PathVariable("id") Integer id ) {
        var employee = employeeService.consultaEmployee(id);
        return ResponseEntity.ok().body(employee);
    }

    @PatchMapping("upload-photo/{id}")
    public ResponseEntity uploadPhoto(@PathVariable("id") Integer id, @RequestParam("photo")MultipartFile file) throws Exception {
        var photoUrl = employeeService.uploadPhoto(id, file);
        return ResponseEntity.ok().body(Map.of("photo_url", photoUrl));
    }

}
