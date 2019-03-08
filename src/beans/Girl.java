package beans;

public class Girl {

	private String code;
	private String name;
	private int year;
	private String address;
	
	public Girl() {
	}

	public Girl(String code, String name, int year, String address) {
		super();
		this.code = code;
		this.name = name;
		this.year = year;
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
