package usecases;



import java.util.List;
import java.util.Scanner;

import bean.EngineerComplain;
import dao.EmployeeDao;
import daoImpl.EmployeeDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;

public class ComplainStatusCheck {

	public static void main(String[] args) throws EmployeeException, MyException, EngineerException, HodException {
		
		Scanner sc = new Scanner(System.in);
		EmployeeDao hd = new EmployeeDaoImpl();
		
		System.out.println("Enter Complain Id :");
		 int name = sc.nextInt();
		 List<EngineerComplain> s;
		try {
			s = hd.ComplainStatus(name);
			s.forEach(se -> System.out.println(se));
			 EmployeeDriver.main(null);
		} catch (ComplainException e1) {
			e1.printStackTrace();
		}
		 
//		 EmployeeDriver.main(null);

	}

}
