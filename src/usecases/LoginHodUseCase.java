package usecases;

import java.util.Scanner;

import dao.HODDao;
import daoImpl.HODDaoImpl;
import exceptions.HodException;

public class LoginHodUseCase {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Name");
		String name=sc.next();
		System.out.println("Enter Your Username");
		String username=sc.next();
		System.out.println("Enter Your Password");
		String password=sc.next();
		
		HODDao dao=new HODDaoImpl();
		
		try {
		 boolean x=dao.LoginHOD(name,username, password);
		 	
		 	System.out.println("---------------------------------------");
			System.out.println("Welcome "+ name+" !");
			System.out.println("---------------------------------------");
			if(x==true) {
//				HODDriver.main(args);
				System.out.println(name);
			}
		} catch (HodException e) {
			e.printStackTrace();
		}
		

	}

}
