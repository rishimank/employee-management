// an interface that extends Spring Data JPA's JpaRepository
// talks to the database via Spring Data JPA

package dev.rishi.ems_backend.repository;

import dev.rishi.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// annotation marks the interface as a Spring Bean so that it can be injected into other layers (like Service layer)
@Repository
// SD JPA automatically provides all the common databases for the Employee entity
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
