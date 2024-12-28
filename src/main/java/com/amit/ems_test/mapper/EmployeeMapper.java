package com.amit.ems_test.mapper;

import com.amit.ems_test.dto.EmployeeDto;
import com.amit.ems_test.entity.Employee;

public class EmployeeMapper {

    // map the employeedto to employee entity
    public  static EmployeeDto employeeDto(Employee employee){
        return  new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    };

    // map employee entity to employee dto
    public static Employee employee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
