
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LogicIssueBooks {

	static ArrayList<IssueBooksData> issueArry = new ArrayList<IssueBooksData>();

	public static void readFileIssuedBooks() throws FileNotFoundException {
		File f = new File("IssedBooks.txt");
		try (Scanner s = new Scanner(f)) {
			String bCallNo = "";
			String studID = "";
			String studName = "";
			String studContact = "";
			String issueDate;

			while (s.hasNextLine()) {
				String x = s.nextLine();
				String tokens[] = x.split(",");
				bCallNo = tokens[0];

				studID = tokens[1];
				studName = tokens[2];
				studContact = tokens[3];
				issueDate = tokens[4];

				IssueBooksData book = new IssueBooksData(bCallNo, studID, studName, studContact, issueDate);
				issueArry.add(book);

			}
		}
	}

	public int add(String bCallNo, String studID, String studName, String studContact, String issueDate) {
		IssueBooksData issueBook = new IssueBooksData(bCallNo, studID, studName, studContact, issueDate);

		LogicBooks b = new LogicBooks();
		LogicStudents stud = new LogicStudents();
		boolean correctCallNo = b.checkBook(bCallNo);
		boolean correctstudID = stud.checkStudData(studID, studName, studContact);
		if (!correctCallNo || !correctstudID)
			return 1;
		else {

			issueArry.add(issueBook);
			return 2;
		}
	}

	public String[] view(int i) {

		String bCallNo = issueArry.get(i).getbCallNo();
		String studID = issueArry.get(i).getStudID();
		String studName = issueArry.get(i).getStudName();
		String studContact = issueArry.get(i).getStudContact();
		String issueDate = issueArry.get(i).getIssueDate();

		String x[] = { bCallNo, studID, studName, studContact, issueDate };

		return x;

	}

	public boolean IssueReturn(String callNo, String studID) {

		boolean x = false;
		int i;
		for (i = 0; i < issueArry.size(); i++) {
			if (callNo.equals(issueArry.get(i).getbCallNo())) {
				if (studID.equals(issueArry.get(i).getStudID())) {

					issueArry.remove(i);
					x = true;

					LogicBooks b = new LogicBooks();
					b.incCallNo(callNo);

					break;
				}
			} else
				continue;
		}
		if (x)
			return true;
		return false;

	}

	public boolean limit3Books(String id) {

		int i;
		int book = 0;
		for (i = 0; i < issueArry.size(); i++) {
			if (id.equals(issueArry.get(i).getStudID()))
				book++;

		}
		if (book < 3) {
			return true;

		} else
			return false;
	}

	public boolean penalty(String id, String date) {
		int i;
		String tokens[] = date.split("-");
		int day1 = Integer.parseInt(tokens[0]);
		int month1 = Integer.parseInt(tokens[1]);
		int year1 = Integer.parseInt(tokens[2]);

		for (i = 0; i < issueArry.size(); i++) {
			if (id.equals(issueArry.get(i).getStudID())) {
				String tokens2[] = issueArry.get(i).getIssueDate().split("-");
				int day = Integer.parseInt(tokens2[0]);
				int month = Integer.parseInt(tokens2[1]);
				int year = Integer.parseInt(tokens2[2]);

				if (day1 <= day && month1 <= month && year1 <= year)
					;
				else {
					return false;
				}

			}

		}

		return true;
	}

	public static void saveIssuedBooks() throws FileNotFoundException {
		File f = new File("IssedBooks.txt");
		try (PrintWriter y = new PrintWriter(f)) {
			int i;
			for (i = 0; i < issueArry.size(); i++) {
				y.println(issueArry.get(i).getbCallNo() + "," + issueArry.get(i).getStudID() + ","
						+ issueArry.get(i).getStudName() + "," + issueArry.get(i).getStudContact() + ","
						+ issueArry.get(i).getIssueDate());
			}
			y.close();
		}

	}
}
