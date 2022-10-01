package bean;

public class Complain {
	
	private int ComplainId;
	private String ComplainName;
	private String Category;
	
	
	public Complain() {
		super();
	}


	public Complain(int complainId, String complainName, String category) {
		super();
		ComplainId = complainId;
		ComplainName = complainName;
		Category = category;
	}


	public int getComplainId() {
		return ComplainId;
	}


	public void setComplainId(int complainId) {
		ComplainId = complainId;
	}


	public String getComplainName() {
		return ComplainName;
	}


	public void setComplainName(String complainName) {
		ComplainName = complainName;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
	}
}