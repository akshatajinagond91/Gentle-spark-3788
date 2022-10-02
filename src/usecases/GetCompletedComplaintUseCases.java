package usecases;



import java.util.List;
import java.util.Scanner;

import bean.EngineerComplain;
import dao.EngineerDao;
import daoImpl.EngineerDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.HodException;
import exceptions.MyException;

public class GetCompletedComplaintUseCases {

	public static void main(String u) throws EmployeeException, MyException, HodException, ComplainException {
		  Scanner sc = new Scanner(System.in);
		  EngineerDao hd = new EngineerDaoImpl();
		  System.out.println("Enter Engineer Id to Get List of All Attended Problem :- ");
		  int engid = sc.nextInt();
		  try {
			List<EngineerComplain> eclist = hd.AttendedComplain(engid);
			eclist.forEach(e -> System.out.println(e));
		} catch (ComplainException e) {
			e.printStackTrace();
		}
		  
		  EngineerDriver.main(u);

	}

}
