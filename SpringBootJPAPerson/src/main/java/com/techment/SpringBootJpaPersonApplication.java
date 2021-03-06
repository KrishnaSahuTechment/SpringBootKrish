package com.techment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techment.dao.IEmployeeDao;
import com.techment.entity.Employee;

@SpringBootApplication
public class SpringBootJpaPersonApplication implements CommandLineRunner{

	@Autowired
	IEmployeeDao iEmployeeDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaPersonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Employee emp1 =new Employee("Krishna", 50000, "HR");
//		Employee emp2 =new Employee("Anmol", 40000, "Developer");
//		Employee emp3 =new Employee("Devesh", 60000, "Network Engineer");
//		Employee emp4 =new Employee("Prateek", 30000, "Developer");
//		Employee emp5 =new Employee("Angesh", 50000, "QA");
//		Employee emp6 =new Employee("Durgesh", 50000, "QA");
//		
//		iEmployeeDao.save(emp1);
//		iEmployeeDao.save(emp2);
//		iEmployeeDao.save(emp3);
//		iEmployeeDao.save(emp4);
//		iEmployeeDao.save(emp5);
//		iEmployeeDao.save(emp6);
//		
//		System.out.println("inserted");
//		
//		
//		System.out.println("=========findAll Employees=======================");
//		
//		List<Employee> employees = iEmployeeDao.findAll();
//		
//		employees.forEach(System.out::println);
//		
//		
		
		
//		System.out.println("=========find by name=======================");
//		List<Employee> empListByName = iEmployeeDao.findByName("Devesh");
//		System.out.println("empListByName :"+empListByName);
	
//		System.out.println("=========find by name and dept=======================");
//		List<Employee> empListByNameAndDept = iEmployeeDao.findByNameAndDept("krishna", "HR");
//		System.out.println("empListByNameAndDept :"+ empListByNameAndDept);
		
//		System.out.println("=========find by name or dept========");
//		List<Employee> empListByNameOrEmpId = iEmployeeDao.findByNameOrEmpId("Anmol", 3);
//		System.out.println("empListByNameOrEmpId :"+ empListByNameOrEmpId);
		
		
//		System.out.println("=========find by using between ========");
//		List<Employee> empListBetween = iEmployeeDao.findBySalaryBetween(40000, 60000);
//		System.out.println("empListBetween :"+ empListBetween);
		
//		System.out.println("=========find by using Less Than ========");
//		List<Employee> empListLessThan = iEmployeeDao.findBySalaryLessThan(50000);
//		System.out.println("empListLessThan  :"+ empListLessThan );
		
//		System.out.println("=========find by using Less Than Equal ========");
//		List<Employee> empListLessThanEqual = iEmployeeDao.findBySalaryLessThanEqual(60000);
//		System.out.println("empListLessThanEqual  :"+ empListLessThanEqual );
		
		
//		System.out.println("=========find by using Greater Than ========");
//		List<Employee> empListGreaterThan = iEmployeeDao.findBySalaryGreaterThan(40000);
//		System.out.println("empListGreaterThan  :\n"+ empListGreaterThan );
		
//		public List<Employee>
		
//		System.out.println("=========find by using Greater Than Equal ========");
//		List<Employee> empListGreaterThanEqual = iEmployeeDao.findBySalaryGreaterThanEqual(40000);
//		System.out.println("empListGreaterThanEqual  :\n"+ empListGreaterThanEqual );
		
		
		System.out.println("=========find by using IsNull ========");
		
		List<Employee> empListIsnull = iEmployeeDao. findByNameIsNull("Krishna");
		System.out.println("empListGreaterThanEqual  :\n"+ empListIsnull  );
		
		
	}

}
