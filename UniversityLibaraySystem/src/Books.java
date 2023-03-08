// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
public class Books {
	private String callNo;
	private String name;
	private String author;
	private String publisher;
	private String quantity;
	private String constQuantity;
	private String addedDate;

	public Books(String callNo, String name, String author, String publisher, String constQuantity, String quantity,
			String addedDate) {

		this.callNo = callNo;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
		this.constQuantity = constQuantity;
		this.addedDate = addedDate;
	}

	public String getCallNo() {
		return callNo;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getConstQuantity() {
		return constQuantity;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setConstQuantity(String constQuantity) {
		this.constQuantity = constQuantity;
	}

}
