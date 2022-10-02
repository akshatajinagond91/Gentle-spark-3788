package Driver;


import java.util.Scanner;

import exceptions.ComplainException;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.HodException;
import exceptions.MyException;
import usecases.LoginEmployeeUseCase;
import usecases.LoginEngineerUseCase;
import usecases.LoginHodUseCase;
import usecases.RegisterEmployeeUseCase2;

public class Driver {

	public static void main(String[] args) throws EmployeeException, MyException ,EngineerException,HodException, ComplainException{
		
		System.out.println("Welcome to Online Hardware and Software Support System");
		System.out.println("1. Login as HOD");
		System.out.println("2. Login as Engineer");
		System.out.println("3. Login as Employee");
		System.out.println("4. Register as Employee");

		Scanner sc=new Scanner(System.in);
		
		int res=sc.nextInt();
		
		if(res==1) {
			
			LoginHodUseCase.main(args);
			
		}
		else if(res==2) {
			LoginEngineerUseCase.main(args);
		}
		else if(res==3) {
			LoginEmployeeUseCase.main(args);
			
		}
		else if(res==4) {
		    RegisterEmployeeUseCase2.main(args);
		}
		
		else {
			throw new MyException("Invalid Input !!!!Please Try Again...");
		}

	}

}
