package usecases;


import java.util.Scanner;

import bean.Engineer;
import dao.HODDao;
import daoImpl.HODDaoImpl;

public class RegisterEngineerUseCase1 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Engineer Name :- ");
		String name  = s.next();
		
		System.out.println("Enter Engineer Username :- ");
		String username  = s.next();
		
		System.out.println("Enter Engineer Password :- ");
		String password  = s.next();
		
		System.out.println("Enter Engineer Category (Hardware/Software) :- ");
		String category  = s.next();

		HODDao dao = new HODDaoImpl();
		
		
		Engineer engineer = new Engineer();
		engineer.setName(name);
		engineer.setUsername(username);
		engineer.setPassword(password);
		engineer.setCategory(category);
		
		
		String reasult = dao.registerEngineer(engineer);	
		
		System.out.println(reasult);

	}

}




