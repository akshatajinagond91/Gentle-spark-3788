package usecases;



import java.util.Scanner;

import Driver.Driver;
import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;

public class EmployeeDriver {

	public static void main(String u) throws EmployeeException, MyException, EngineerException, HodException, ComplainException {
		
		while (true) {

			System.out.println("1. Register Complaint");
            System.out.println("2. Check Status of Complaint");
			System.out.println("3. See All Complaints");
            System.out.println("4. Update Password");
			System.out.println("5. Exit To Main Page");
			System.out.println("Please select an option to continue");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				RegisterComplain.main(null);
				break;
			case 2:
				ComplainStatusCheck.main(null);
				break;
			case 3:
				CompletedComplaint.main(null);
				break;
			case 4:
				EmployeeUpdatePassword.main(u);
				break;
			case 5:
				try {
					Driver.main(null);
				} catch (EmployeeException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
