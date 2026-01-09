package dev.rishi.ems_backend.service;

import dev.rishi.ems_backend.dto.EmployeeDto;
import dev.rishi.ems_backend.entity.Employee;
import dev.rishi.ems_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // --- Entity ↔ DTO conversion ---

    public EmployeeDto convertToDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public Employee convertToEntity(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        return employee;
    }

    // --- Business logic ---

    // Create or update an employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get all employees as DTOs
    public List<EmployeeDto> getAllEmployeesDto() {
        return getAllEmployees().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Delete employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}


