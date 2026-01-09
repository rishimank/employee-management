// public entry point to the backend
// controller between HTTP (JSON, URLs, verbs) and Java
// basically handles HTTP Requests/responses
    // keeps API entry points separate from business logic

// what it does:
// 1. converts HTTP requests to Java objects
// 2. routes URLs to methods
// 3. calls business logic
// 4. converts java objects to HTTP responses

package dev.rishi.ems_backend.controller;

import dev.rishi.ems_backend.dto.EmployeeDto;
import dev.rishi.ems_backend.entity.Employee;
import dev.rishi.ems_backend.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // --- CREATE ---
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.convertToEntity(employeeDto);
        Employee savedEmployee = employeeService.saveEmployee(employee);
        EmployeeDto responseDto = employeeService.convertToDto(savedEmployee);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // --- READ ALL ---
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployeesDto();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // --- READ BY ID ---
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
        EmployeeDto dto = employeeService.convertToDto(employee);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // --- DELETE ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
