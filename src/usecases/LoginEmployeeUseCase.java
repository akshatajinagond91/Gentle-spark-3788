package usecases;



import java.util.Scanner;

import dao.EngineerDao;
import daoImpl.EngineerDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;

public class LoginEmployeeUseCase {
	
	public static void main(String[] args) throws EmployeeException, MyException, HodException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Username :-");
		String username = sc.next();
		
		System.out.println("Enter Your Password :-");
		String password = sc.next();
		
		EngineerDao d = new EngineerDaoImpl();
		
		String result;
		try {
			result = d.loginEngineer(username, password);
			System.out.println(result);
			EmployeeDriver.main(username);
		} catch (EngineerException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
