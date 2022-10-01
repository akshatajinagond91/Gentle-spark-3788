package utility;


import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		
		Connection conn =  DBUtil.provideConnection();

		
		if(conn==null) {
			System.out.println("not connected");
		}else {
			System.out.println("connected");
		}
	}

}
