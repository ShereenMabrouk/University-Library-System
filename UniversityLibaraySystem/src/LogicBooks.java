
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LogicBooks {

	static ArrayList<Books> bookArry = new ArrayList<Books>();

	public static void readFileBooks() throws FileNotFoundException {
		File f = new File("Books.txt");
		try (Scanner s = new Scanner(f)) {
			String callNo = "";
			String name = "";
			String author = "";
			String publisher = "";
			String quantity = "";
			String avaliable = "";
			String addedDate = "";

			while (s.hasNextLine()) {
				String x = s.nextLine();
				String tokens[] = x.split(",");
				callNo = tokens[0];

				name = tokens[1];
				author = tokens[2];
				publisher = tokens[3];
				quantity = tokens[4];
				avaliable = tokens[5];
				addedDate = tokens[6];

				Books book = new Books(callNo, name, author, publisher, avaliable, quantity, addedDate);
				bookArry.add(book);

			}
		}
	}

	public static void saveBooks() throws FileNotFoundException {
		File f = new File("Books.txt");
		try (PrintWriter y = new PrintWriter(f)) {
			int i;
			for (i = 0; i < bookArry.size(); i++) {
				y.println(bookArry.get(i).getCallNo() + "," + bookArry.get(i).getName() + ","
						+ bookArry.get(i).getAuthor() + "," + bookArry.get(i).getPublisher() + ","
						+ bookArry.get(i).getQuantity() + "," + bookArry.get(i).getConstQuantity() + ","
						+ bookArry.get(i).getAddedDate());
			}
			y.close();
		}

	}

	public int add(String callNo, String name, String author, String publisher, String quantity, String avaliable,
			String addedDate) {
		Books book = new Books(callNo, name, author, publisher, avaliable, quantity, addedDate);
		int i;
		int x = 2;
		for (i = 0; i < bookArry.size(); i++) {

			if (callNo.equals(bookArry.get(i).getCallNo()) == true) {
				if (callNo.equals(bookArry.get(i).getCallNo()) == true && name.equals(bookArry.get(i).getName()) == true
						&& author.equals(bookArry.get(i).getAuthor()) == true
						&& publisher.equals(bookArry.get(i).getPublisher()) == true) {
					incCallQuantity(callNo, quantity);
					x = 1;
					break;
				} else {
					x = -1;
					break;
				}

			} else {
				if (x == -1)
					break;

				x = 2;
			}

		}
		if (x == 2)
			bookArry.add(book);

		return x;

	}


	public String[] view(int i) {
		String callNo = bookArry.get(i).getCallNo();
		String name = bookArry.get(i).getName();
		String author = bookArry.get(i).getAuthor();
		String publisher = bookArry.get(i).getPublisher();
		String avaliable = bookArry.get(i).getQuantity();
		String quantity = bookArry.get(i).getConstQuantity();
		String issued = Integer.toString((Integer.parseInt(bookArry.get(i).getConstQuantity()))
				- (Integer.parseInt(bookArry.get(i).getQuantity())));
		String addedDate = bookArry.get(i).getAddedDate();
		String x[] = { callNo, name, author, publisher, avaliable, quantity, issued, addedDate };

		return x;

	}

	public boolean checkQant(String quantity) {
		if (tryParse(quantity) == null) {

			return false;
		}

		return true;

	}

	public static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public boolean checkBook(String callNo) {
		int i, x;
		for (i = 0; i < bookArry.size(); i++) {
			if (callNo.equals(bookArry.get(i).getCallNo()) == true) {
				if (Integer.parseInt(bookArry.get(i).getQuantity()) > 0) {
					x = (Integer.parseInt(bookArry.get(i).getQuantity()) - 1);
					String quant = Integer.toString(x);
					bookArry.get(i).setQuantity(quant);

					return true;
				}
			}
		}
		return false;

	}

	public void incCallQuantity(String callNo, String Qantity) {
		int i;
		for (i = 0; i < bookArry.size(); i++) {
			if (callNo.equals(bookArry.get(i).getCallNo()) == true) {

				int y = (Integer.parseInt(bookArry.get(i).getConstQuantity()) + Integer.parseInt(Qantity));
				String quant1 = Integer.toString(y);
				bookArry.get(i).setConstQuantity(quant1);
				int x = (Integer.parseInt(bookArry.get(i).getQuantity()) + Integer.parseInt(Qantity));
				String quant = Integer.toString(x);
				bookArry.get(i).setQuantity(quant);

			}
		}

	}

	public void incCallNo(String callNo) {
		int i;
		for (i = 0; i < bookArry.size(); i++) {
			if (callNo.equals(bookArry.get(i).getCallNo()) == true) {
				int x = (Integer.parseInt(bookArry.get(i).getQuantity()) + 1);
				String quant = Integer.toString(x);
				bookArry.get(i).setQuantity(quant);

			}
		}

	}
}