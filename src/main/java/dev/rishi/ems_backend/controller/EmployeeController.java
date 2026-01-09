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

import dev.rishi.ems_backend.entity.Employee;
import dev.rishi.ems_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // CREATE employee
    // below annotation handles HTTP POST (POST /api/employees)
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // GET all employees
    // handles HTTP GET
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // GET employee by ID
    // handles HTTP DELETE
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);

        return employee
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE employee
    // the base URL
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build(); // converts Java objects to HTTP responses
    }
}


