package usecases;



import java.util.Scanner;

import dao.EngineerDao;
import daoImpl.EngineerDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;

public class UpdatePasswordUseCases {

	public static void main(String u) throws EmployeeException, MyException, HodException, ComplainException {
		  Scanner sc = new Scanner(System.in);
		  EngineerDao hd = new EngineerDaoImpl();
		  System.out.println("Enter Engineer Id :");
		  int engid = sc.nextInt();
		  System.out.println("Enter New Password :");
		  String password = sc.next();
		  
		  
		  String result;
			try {
				result = hd.changePassword(password,engid);
				System.out.println(result);
				EngineerDriver.main(result);
			} catch (EngineerException e) {
				e.printStackTrace();
			}
		  
		  
		  EngineerDriver.main(u);

	}

}
