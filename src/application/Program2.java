package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1: department insert ======");
		Department newDepartment = new Department(null, "Bomb");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());
		
		
		System.out.println("\n=== TEST 2: department update ======");
		Department dep2 = departmentDao.findById(12);
		dep2.setName("Juice");
		departmentDao.update(dep2);
		System.out.println("Update complete!");
		
		
		System.out.println("=== TEST 3: findById =======");
		Department dep = departmentDao.findById(7);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 4: findAll =======");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
