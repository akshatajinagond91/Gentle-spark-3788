package dao;


import java.util.List;

import bean.EngineerComplain;
import exceptions.ComplainException;
import exceptions.EngineerException;

public interface EngineerDao {
	
	public String loginEngineer(String usersname, String password)throws EngineerException;

	public List<EngineerComplain> ComplainAssignedByHod(int engid)throws ComplainException;
	
	public String updateStatus(int engId)throws ComplainException;
	
	public List<EngineerComplain> AttendedComplain(int engid)throws ComplainException;
	
	public String changePassword(String password,int engid)throws EngineerException;
	
}
