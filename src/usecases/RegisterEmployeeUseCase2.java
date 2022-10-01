package usecases;


import java.util.Scanner;

import bean.Employee;
import dao.EmployeeDao;
import daoImpl.EmployeeDaoImpl;

public class RegisterEmployeeUseCase2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Employee Name :- ");
		String name  = s.next();
		
		System.out.println("Enter Employee Username :- ");
		String username  = s.next();
		
		System.out.println("Enter Employee Password :- ");
		String password  = s.next();

		EmployeeDao dao = new EmployeeDaoImpl();
		
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setUsername(username);
		employee.setPassword(password);
		
		
		String reasult = dao.registerEmployee2(employee);	
		
		System.out.println(reasult);
		
	}

}
