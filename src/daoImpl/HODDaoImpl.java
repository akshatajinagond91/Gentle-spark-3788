package daoImpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Complain;
import bean.Engineer;
import dao.HODDao;
import exceptions.ComplainException;
import exceptions.EngineerException;
import exceptions.HodException;
import utility.DBUtil;

public class HODDaoImpl implements HODDao{
	
	@Override
	public boolean LoginHOD(String name ,String username, String password) throws HodException {
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
		PreparedStatement ps = conn.prepareStatement("select * from LoginHOD where name = ? AND username = ? AND password = ?");
		
		ps.setString(1, name);
		ps.setString(2, username);
		ps.setString(3, password);
		
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Login Succesfull !");
				return true;
			} else {
				throw new HodException("Invalid Credentials");
	
			}
			
		} catch (SQLException e) {
			
			throw new HodException(e.getMessage());
			
		}

	}

	@Override
	public String registerEngineer(Engineer engineer) {
		
		String message = "Engineer Not Registered....";
		
		
		try(Connection conn =  DBUtil.provideConnection()) {
			
		PreparedStatement ps = conn.prepareStatement
								("insert into Register_Engineer(name,username,password,category) values(?,?,?,?)");
		
		ps.setString(1, engineer.getName());
		ps.setString(2, engineer.getUsername());
		ps.setString(3, engineer.getPassword());
		ps.setString(4, engineer.getCategory());
		
		int x = ps.executeUpdate();
		
		if(x > 0) {
			message = "Engineer Registered Sucessfully !";
		}
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		return message;
		
		
	}

	@Override
	public List<Engineer> getAllEngineerDetails() throws EngineerException {
		
		List<Engineer> list = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Register_Engineer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int engid = rs.getInt("engid");
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String category = rs.getString("category");
				list.add(new Engineer(engid,name, username, password, category));
			}
		} catch (SQLException se) {
			throw new EngineerException(se.getMessage());
		}
		if (list.size() == 0) {
			throw new EngineerException("No Engineer Found !!!!");
		}
		return list;
	}

	@Override
	public String DeleteEngineer(int engId) {

		String delete = "Engineer Not Found !!!!";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("delete from Register_Engineer where engId= ? ");
			ps.setInt(1, engId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				delete = "Engineer Deleted Sucessfully...!";
			}
			
			
		} catch (SQLException e) {
			delete = e.getMessage();
		}
		
		return delete;
	}

	@Override
	public List<Complain> getAllComplain() throws ComplainException {
		
		List<Complain> com = new ArrayList<>();
		
		
		try (Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Register_Complain");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int id =rs.getInt("ComplainId");
				String name = rs.getString("ComplainName");
				String category = rs.getString("Category");
				
				Complain c = new Complain(id,name,category);
				com.add(c);
				
			}
			
			
			
		} catch (SQLException e) {			
			throw new ComplainException(e.getMessage());
	
		}
		if(com.size()==0) {
			throw new ComplainException("No Complains Found!");
		}
	
	
	
		return com;
	}

	@Override
	public String assignedComplain(int engid, String name, String category, int id, String status) {
		
		String message = "Complain Not Assigned... ! ";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
		PreparedStatement ps= conn.prepareStatement
			("insert into EngineerComplainDTO(engid,name,category,EcomplainId,ComplainStatus) values(?,?,?,?,?)");
		
		ps.setInt(1, engid);
		ps.setString(2, name);
		ps.setString(3, category);
		ps.setInt(4, id);
		ps.setString(5, status);
				
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Complain Assigned To Engineer " +name+ " Sucessfully... !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
		
	}



}
