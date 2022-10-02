package usecases;



import java.util.Scanner;

import dao.EmployeeDao;
import daoImpl.EmployeeDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;

public class RegisterComplain {

	public static void main(String[] args) throws EmployeeException, MyException, EngineerException, HodException {
		
		Scanner sc = new Scanner(System.in);
		EmployeeDao hd = new EmployeeDaoImpl();
		
		System.out.println("Enter Category (Hardware/Software) :- ");
		String com = sc.next();
		System.out.println("Enter Complain Name :- ");
		String cname = sc.next();
		
		String result;
		try {
			result =hd.registerComplain(cname,com);
			System.out.println(result);
			EmployeeDriver.main(result);
		} catch (ComplainException e) {
			e.printStackTrace();
		}

	}

}
