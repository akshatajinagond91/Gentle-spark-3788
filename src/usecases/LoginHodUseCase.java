package usecases;



import java.util.Scanner;

import dao.HODDao;
import daoImpl.HODDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;
import com.mysql.cj.jdbc.Driver;

public class LoginHodUseCase {

	public static void main(String[] args) throws EmployeeException, MyException, EngineerException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username:");
		String username = sc.next();
		
		System.out.println("Enter Password:");
		String password = sc.next();
		
		HODDao d = new HODDaoImpl();
		
		
		String result;
		try {
			result = d.LoginHOD(username, password);
			System.out.println(result);
			HODDriver.main(args);
		} catch (HodException e) {
			e.printStackTrace();
		}
		
	}

}
