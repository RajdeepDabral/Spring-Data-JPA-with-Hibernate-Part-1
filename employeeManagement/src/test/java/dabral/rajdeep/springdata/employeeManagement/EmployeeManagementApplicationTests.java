package dabral.rajdeep.springdata.employeeManagement;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import dabral.rajdeep.springdata.employeeManagement.entities.Employee;
import dabral.rajdeep.springdata.employeeManagement.repository.EmployeeRepository;
import javassist.runtime.Desc;
import org.apache.tomcat.jni.Directory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeManagementApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateEmployee(){
		Employee employee = new
				Employee(107, "Deepanshu" ,40  , "Dubai");
		employeeRepository.save(employee);
	}

	@Test
	public void testReadEmployee(){
		Employee employee=employeeRepository.findById(102).get();
		Assertions.assertNotNull(employee);
		System.out.println(employee);
	}

	@Test
	public void testUpdateEmployee(){
		Employee employee=employeeRepository.findById(101).get();
		Assertions.assertNotNull(employee);
		employee.setName("Rajdeep");
		employee.setLocation("Mumbai");
		employeeRepository.save(employee);
	}

	@Test
	public void testDeleteEmployee(){
		employeeRepository.deleteById(101);
	}

	@Test
	public void testTotalEmployeeCount(){
		System.out.println("Total Employee Record in Database : "+employeeRepository.count());
	}


	@Test
	public void testFindByName(){
		List<Employee> list = employeeRepository.findByName("Suraj");
		list.forEach(System.out::println);
	}

	@Test
	public void testFindByNameStartsWith(){
		List<Employee> list = employeeRepository.findByNameStartsWith('A');
		list.forEach(employee -> System.out.println(employee));
	}


	@Test
	public void testFindByAgeBetween(){
		List<Employee> list=employeeRepository.findByAgeBetween(28,32);
		list.forEach(employee -> System.out.println(employee));
	}

	@Test
	public void testFindByAge(){
		PageRequest pageable = PageRequest.of(0,10, Sort.Direction.DESC, "age");
		 employeeRepository
				.findByAgeGreaterThan(25 , pageable).forEach(System.out::println);
	}

	@Test
	public void testFindByAgeGreaterThen20(){
		employeeRepository
				.findByAgeGreaterThan(20 ).forEach(System.out::println);
	}
}


