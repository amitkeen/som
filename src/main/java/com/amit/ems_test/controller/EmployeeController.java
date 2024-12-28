package com.amit.ems_test.controller;

import com.amit.ems_test.dto.EmployeeDto;
import com.amit.ems_test.services.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto, HttpServletRequest request){

        log.info("Recived Request URl: {}", request.getRequestURL());
        log.info("Recived Method: {}", request.getMethod());
        log.info("Resived Body: {}", employeeDto);
           EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee Rest ApI

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId, HttpServletRequest request) {
//        EmployeeDto  employeeDto = new employeeService.getEmployeeById(employeeId);

        log.info("Recived Request URl: {}", request.getRequestURL());
        log.info("Recived Method: {}", request.getMethod());
//        log.info("Resived Body: {}", employeeDto);
      EmployeeDto employeeDto =  employeeService.getEmployeeById(employeeId);
      log.info("Recived get Response: {}", employeeDto);
      return ResponseEntity.ok(employeeDto);
    }


    // Build Get All Employees Rest API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(HttpServletRequest request){
        log.info("Recived Request URl: {}", request.getRequestURL());
        log.info("Recived Method: {}", request.getMethod());
        log.info("Employees List: {}", request.getPathInfo());

       List <EmployeeDto> employees = employeeService.getAllEmployees();
       return ResponseEntity.ok(employees);
    }

    // update
    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
       EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);

       return ResponseEntity.ok(employeeDto);
    }
// delete

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmpployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok("succefully deleted employee");
    }
}
