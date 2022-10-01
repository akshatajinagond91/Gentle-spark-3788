package dao;

import java.util.List;

import bean.Complain;
import bean.Engineer;
import exceptions.ComplainException;
import exceptions.EngineerException;
import exceptions.HodException;

public interface HODDao {
	
	public boolean LoginHOD(String name ,String username, String password) throws HodException;
	
	public String registerEngineer(Engineer engineer); 
	
	public List<Engineer> getAllEngineerDetails()throws EngineerException;
	
	public String DeleteEngineer(int engId);
	
	public List<Complain> getAllComplain()throws ComplainException;
	
	public String assignedComplain(int engid,String name,String category,int id,String status);
	
	
}
