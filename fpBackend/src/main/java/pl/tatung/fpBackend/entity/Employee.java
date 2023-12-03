package pl.tatung.fpBackend.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.tatung.fpBackend.dto.EmployeeDto;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idEmployee;
    @Column
    public String firstName;
    @Column
    public String lastName;
    @Column
    public String salary;
    @OneToOne(mappedBy = "employee")
    public Operator operator;


    public static Employee of(EmployeeDto dto){
        Employee employee=new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setSalary(dto.getSalary());
        return employee;
    }

    public void updateEmployee(EmployeeDto dto) {
        this.setFirstName(dto.getFirstName());
        this.setLastName(dto.getLastName());
        this.setSalary(dto.getSalary());
    }
}
