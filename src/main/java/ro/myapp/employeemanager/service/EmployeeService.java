package ro.myapp.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.myapp.employeemanager.exception.UserNotFoundException;
import ro.myapp.employeemanager.model.Employee;
import ro.myapp.employeemanager.repo.EmployeeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo; /*am declarat o variabila prin care aduc acel depozit pe care tocmai l-am
     creat*/
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    } //avand depozitul aici, il injectez in aceasta clasa prin constructor cablandu-le automat

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() { //returneaza o lista cu toti angajatii
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) { //actualizeaza angajatul
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
