package dabral.rajdeep.springdata.employeeManagement.repository;

import dabral.rajdeep.springdata.employeeManagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee , Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameStartsWith(Character c);
    List<Employee> findByAgeBetween(Integer i1 , Integer i2);

}
