package usecases;



import java.util.Scanner;
import dao.EmployeeDao;
import daoImpl.EmployeeDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;


public class EmployeeUpdatePassword {

	public static void main(String u) throws EmployeeException, MyException, EngineerException, HodException, ComplainException {
		
		  Scanner sc = new Scanner(System.in);
		  EmployeeDao hd = new EmployeeDaoImpl();
		  System.out.println("Enter Employee Id :");
		  int empid = sc.nextInt();
		  System.out.println("Enter New Password :");
		  String password = sc.next();
		  
		  
		  String result;
			try {
				result = hd.changePassword(password,empid);
				System.out.println(result);
				EmployeeDriver.main(result);
			} catch (EmployeeException e) {
				e.printStackTrace();
			}
		  
		  
			EmployeeDriver.main(u);

	}

}
