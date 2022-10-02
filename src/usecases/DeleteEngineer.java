package usecases;


import java.util.Scanner;

import dao.HODDao;
import daoImpl.HODDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.MyException;

public class DeleteEngineer {

	public static void main(String[] args) throws EmployeeException, MyException, ComplainException {
		
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter Engineer Id To Delete :");
		  int eid = sc.nextInt();
		  HODDao hd = new HODDaoImpl();
		  
		  
		  try {	
			  String del = hd.DeleteEngineer(eid);
			  System.out.println(del);
			  HODDriver.main(args);
			  
			}catch(EngineerException se) {
				se.printStackTrace();
			}

	}

}
