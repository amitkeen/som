package com.amit.ems_test.services.impl;

import com.amit.ems_test.dto.EmployeeDto;
import com.amit.ems_test.entity.Employee;
import com.amit.ems_test.exception.ResourceNotFoundException;
import com.amit.ems_test.mapper.EmployeeMapper;
import com.amit.ems_test.repository.EmployeeRepository;
import com.amit.ems_test.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.employee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.employeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

       Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee is not Exit with given id: "+ employeeId));

//                ResourceNotFoundException("Employee is not Exit with given id: "+ employeeId));
        return EmployeeMapper.employeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.employeeDto(employee))
                .collect(Collectors.toUnmodifiableList());

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {

         Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                    () -> new ResourceNotFoundException("Employee yaha exists nhi kar raha is id se: "+ employeeId)
            );

         employee.setFirstName(updateEmployee.getFirstName());
         employee.setLastName(updateEmployee.getLastName());
         employee.setEmail(updateEmployee.getEmail());

         Employee updatedEmployeeObj =  employeeRepository.save(employee);

        return EmployeeMapper.employeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee yaha exists nhi kar raha is id se: "+ employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }


}
