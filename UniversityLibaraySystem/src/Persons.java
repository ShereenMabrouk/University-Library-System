// Nourhan Mohamed Ahmed Ismail          7153
// Shereen Mostafa Hassan Mabrouk  6844
public class Persons {

	private String id;
	private String name;
	private String password;
	private String em;
	private String city;
	private String contactNo;
	private String address;

	public Persons(String id, String name, String password, String em, String address, String city, String contactNo) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.em = em;
		this.city = city;
		this.contactNo = contactNo;
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public String getEm() {
		return em;
	}

	public String getCity() {
		return city;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getId() {
		return id;
	}

}
