package usecases;



import java.util.Scanner;

import dao.HODDao;
import daoImpl.HODDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.MyException;

public class assignedComplain {

	public static void main(String[] args) throws EmployeeException, MyException, EngineerException, ComplainException {
		  
		
		  HODDao hd = new HODDaoImpl();
		  Scanner sc = new Scanner(System.in);
		
		  System.out.println("Enter Engineer Id :- ");
		  int engid = sc.nextInt();
		  System.out.println("Enter Engineer Name :- ");
		  String name = sc.next();
		  System.out.println("Enter Engineer Category (Software/Hardware) :- ");
		  String category = sc.next();
		  System.out.println("Enter Complain Id :- ");
		  int complainid = sc.nextInt();
		  System.out.println("Enter Complain Status :- ");
		  String status = sc.next();
		  String rs2 = hd.assignedComplain(engid,name,category,complainid,status);
		  System.out.println(rs2);
		  HODDriver.main(args);

	}

}
