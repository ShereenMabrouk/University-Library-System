
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
public class IssueBooksData {

	private String bCallNo;
	private String studID;
	private String studName;
	private String studContact;
	private String issueDate;

	public IssueBooksData(String bCallNo, String studID, String studName, String studContact, String issueDate) {

		this.bCallNo = bCallNo;
		this.studID = studID;
		this.studName = studName;
		this.studContact = studContact;
		this.issueDate = issueDate;
	}

	public String getbCallNo() {
		return bCallNo;
	}

	public String getStudID() {
		return studID;
	}

	public String getStudName() {
		return studName;
	}

	public String getStudContact() {
		return studContact;
	}

	public String getIssueDate() {
		return issueDate;
	}

}
