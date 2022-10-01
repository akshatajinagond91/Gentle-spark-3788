package dao;

import java.util.List;

import bean.Complain;
import bean.Employee;
import bean.EngineerComplain;
import exceptions.ComplainException;
import exceptions.EmployeeException;

public interface EmployeeDao {
	
	
	public String registerEmployee(String name, String username, String password);

	public String registerEmployee2(Employee employee);
	
	public String loginEmployee(String username, String password)throws EmployeeException;
	
	public String registerComplain(String complainname,String category);
	
	public List<EngineerComplain> ComplainStatus(int EcomplainId)throws ComplainException;
	
	public List<Complain> getComplainHistory(int empid);
	
	public String changePassword(String password,int empid);
	
	
}
