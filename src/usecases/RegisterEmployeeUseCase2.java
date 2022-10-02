package usecases;



import java.util.Scanner;

import Driver.Driver;
import bean.Employee;
import dao.EmployeeDao;
import daoImpl.EmployeeDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;


public class RegisterEmployeeUseCase2 {

	public static void main(String[] args) throws EmployeeException, MyException, EngineerException, HodException, ComplainException {
		
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
		
		try {
			Driver.main(args);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		
	}

}
