package usecases;



import java.util.List;

import bean.Engineer;
import dao.HODDao;
import daoImpl.HODDaoImpl;
import exceptions.EngineerException;

public class GetAllEngineerUseCase {

	public static void main(String[] args) {
		
		HODDao h = new HODDaoImpl();
		try {
			List<Engineer> list = h.getAllEngineerDetails();
			list.forEach(s-> {
					System.out.println("-----------------------------------------");
					System.out.println("Engineer I.D :- "+ s.getEngid());
					System.out.println("Engineer Name :- "+ s.getUsername());
					System.out.println("Engineer Username :- "+ s.getUsername());
					System.out.println("Engineer Password :- "+ s.getPassword());
					System.out.println("Engineer Category :- "+ s.getCategory());
					System.out.println("-----------------------------------------");
			});
		}catch(EngineerException e) {
			System.out.println(e.getMessage());
		}

	}

}
