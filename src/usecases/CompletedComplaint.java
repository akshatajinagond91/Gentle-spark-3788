package usecases;



import java.util.List;
import java.util.Scanner;

import bean.Complain;
import dao.EmployeeDao;
import daoImpl.EmployeeDaoImpl;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;

public class CompletedComplaint {

	public static void main(String[] args) throws MyException, EngineerException, HodException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		EmployeeDao hd = new EmployeeDaoImpl();
		  System.out.println("Enter Employee Id :-");
		  int id = sc.nextInt();
		  
			try {
				List<Complain> eclist = hd.getComplainHistory(id);
				eclist.forEach(e -> System.out.println(e));
				EmployeeDriver.main(null);
			} catch (EmployeeException e) {
				e.printStackTrace();
			}


	}

}
