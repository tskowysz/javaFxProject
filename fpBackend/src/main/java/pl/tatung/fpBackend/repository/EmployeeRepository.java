package pl.tatung.fpBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tatung.fpBackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
