package ro.myapp.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.myapp.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}

/*Pentru a obține toată metodele din JpaRepository, am declarat o interfață care
extinde JpaRepository, specificând tipul de domeniu ca Employee și tipul de id ca Long.*/