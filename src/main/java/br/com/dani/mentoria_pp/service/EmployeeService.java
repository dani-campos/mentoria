package br.com.dani.mentoria_pp.service;

import br.com.dani.mentoria_pp.dto.EmployeeDto;
import br.com.dani.mentoria_pp.error.exception.EmployeeNotFoundException;
import br.com.dani.mentoria_pp.error.exception.OfficeNotFoundException;
import br.com.dani.mentoria_pp.error.exception.UserNotFoundException;
import br.com.dani.mentoria_pp.model.*;
import br.com.dani.mentoria_pp.repository.EmployeeRepository;
import br.com.dani.mentoria_pp.repository.OfficeRepository;
import br.com.dani.mentoria_pp.repository.UserRepository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;
    private final UserRepository userRepository;
    private final AmazonS3 amazonS3;


    public EmployeeService(
            EmployeeRepository employeeRepository,
            OfficeRepository officeRepository,
            UserRepository userRepository,
            AmazonS3 amazonS3) {
        this.employeeRepository = employeeRepository;
        this.officeRepository = officeRepository;
        this.userRepository = userRepository;
        this.amazonS3 = amazonS3;
    }


    public void createEmployee(EmployeeDto employeeDto) {

        var officeEntity = getOfficeEntity(employeeDto.getOfficeId());
        var userEntity = getUserEntity(employeeDto.getUserId());

        var salaryHistories = Arrays.asList(new SalaryHistory(
                null,
                employeeDto.getSalary(),
                LocalDateTime.now(),
                userEntity
        ));


        var occupationHistories = Arrays.asList(new OccupationHistory(
                LocalDateTime.now(),
                null,
                officeEntity,
                userEntity
        ));
        var employeeEntity = new Employee(
                employeeDto.getFullName(),
                employeeDto.getBirthDate(),
                employeeDto.getAddress(),
                employeeDto.getDocument(),
                employeeDto.getPhoto(),
                employeeDto.getSalary(),
                salaryHistories,
                occupationHistories,
                officeEntity
        );

        employeeRepository.save(employeeEntity);

    }

    public String uploadPhoto(Integer id, MultipartFile multipartFile) throws Exception {
        var employee = employeeRepository.findById(id);

        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee V??zio");
        }

        // TODO Colocar valida????o se o employer existe.
        var file = buildFile(multipartFile);
        var random = UUID.randomUUID().toString();
        amazonS3.putObject(new PutObjectRequest("employeephoto", random, file));
        var urlPhoto = "http://localhost:4566/employeephoto/"+random;
        employee.get().setPhoto(urlPhoto);
        employeeRepository.save(employee.get());

        return urlPhoto;
    }

    public Employee consultaEmployee(Integer id) {
        var employee = employeeRepository.findById(id);

        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee V??zio");
        }

        return employee.get();
    }

    private File buildFile(MultipartFile multipartFile) throws Exception {
        var file = new File(multipartFile.getOriginalFilename());
        try(var outputStream = new FileOutputStream(file)){
            outputStream.write(multipartFile.getBytes());
        }

        return file;
    }

    private Office getOfficeEntity(Integer officeId) {

        var office = officeRepository.findById(officeId);
        if (office.isEmpty()) {
            throw new OfficeNotFoundException("Office not found.");
        }

        return office.get();

    }

    private User getUserEntity(Integer userId) {
        var user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found.");
        }

        return user.get();
    }


}
