package usecases;


import java.util.Scanner;

import dao.EngineerDao;
import daoImpl.EngineerDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.HodException;
import exceptions.MyException;

public class updateComplainStatus {

	public static void main(String u) throws EmployeeException, MyException, HodException, ComplainException {
		 
		Scanner sc = new Scanner(System.in);
		EngineerDao hd = new EngineerDaoImpl();
		
		 System.out.println("Enter Engineer Id To Update Problem Status :");
		 int num = sc.nextInt();
		 String s = hd.updateStatus(num);
		 System.out.println(s);
		 EngineerDriver.main(u);

	}

	

}
