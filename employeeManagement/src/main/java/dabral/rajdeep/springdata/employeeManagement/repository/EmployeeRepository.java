package dabral.rajdeep.springdata.employeeManagement.repository;

import dabral.rajdeep.springdata.employeeManagement.entities.Employee;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee , Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameStartsWith(Character c);
    List<Employee> findByAgeBetween(Integer i1 , Integer i2);
    List<Employee> findByAgeGreaterThan(Integer i1 , Pageable pageable);
    List<Employee> findByAgeGreaterThan(Integer i1 );
}
