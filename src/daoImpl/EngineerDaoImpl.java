package daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EngineerComplain;
import dao.EngineerDao;
import exceptions.ComplainException;
import exceptions.EngineerException;
import utility.DBUtil;

public class EngineerDaoImpl implements EngineerDao {

	@Override
	public String loginEngineer(String username, String password) throws EngineerException {
		
		String comment = "Invalid Credentials";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Register_Engineer where username = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				comment = "Welcome "+ name;
			}else {
				comment = "Wrong Credentials";
			}
			
			
		} catch (SQLException e) {
			e.getStackTrace();
			throw new EngineerException("Engineer Not Found !!!!");
		}
			
		return comment;
	}

	@Override
	public List<EngineerComplain> ComplainAssignedByHod(int id) throws ComplainException {

		
		List<EngineerComplain> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from EngineerComplain where engid = ?");
			ps.setInt(1, id);
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				
				int engid = rs.getInt("engid");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int EcomplainId = rs.getInt("EcomplainId");
				String ComplainStatus = rs.getString("ComplainStatus");
				
				list.add(new EngineerComplain(engid, name, category,EcomplainId,ComplainStatus));
			}
			
			
		} catch (SQLException se) {
			throw new ComplainException("Complain Not Assigned !!!!");
		}
		
		if(list.size()==0) {
			throw new  ComplainException("No Complain Assigned !!!!");
		}
		return list;
		
		
	}

	@Override
	public String updateStatus(int engId) {
		
		String message = "Complain Status Not Updated !!!!";
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement
					("Update EngineerComplain set ComplainStatus = 'Resolved' where EcomplainId = ?");
			
			ps.setInt(1, engId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Complain Status Updated Sucessfull... !";
			}
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
		
	}

	@Override
	public List<EngineerComplain> AttendedComplain(int engid) throws ComplainException {
			
		List<EngineerComplain> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement
					("select * from EngineerComplain where engid = ? AND ComplainStatus = 'Resolved'");
			ps.setInt(1, engid);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				int engId = rs.getInt("engid");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int EcomplainId = rs.getInt("EcomplainId");
				String ComplainStatus = rs.getString("ComplainStatus");
				
				list.add(new EngineerComplain(engId, name, category,EcomplainId,ComplainStatus ));
				
				
			}
			
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ComplainException("No Complain Found !!!!");
			}
			
			return list;
	}

	@Override
	public String changePassword(String password, int engid) {
		
		String message = "Password Not Changed !!!!";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement
					("Update Register_Engineer set password = ? where engid = ?");
			ps.setString(1, password);
			ps.setInt(2, engid);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Password Updated Sucessfull...";
			}
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}
	

}
