
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LogicLibrarian {

	static ArrayList<Librarian> libArry = new ArrayList<Librarian>();
	static ArrayList<Admins> adminArry = new ArrayList<Admins>();

	public static void readFileAdmins() throws FileNotFoundException {
		File f = new File("Admins.txt");
		try (Scanner s = new Scanner(f)) {
			String name = "";
			String password = "";

			while (s.hasNextLine()) {
				String x = s.nextLine();
				String tokens[] = x.split(",");
				name = tokens[0];
				password = tokens[1];

				Admins admin = new Admins(name, password);
				adminArry.add(admin);

			}
		}
	}

	public static void saveLibrarian() throws FileNotFoundException {
		File f = new File("Librarians.txt");
		try (PrintWriter y = new PrintWriter(f)) {
			int i;
			for (i = 0; i < libArry.size(); i++) {
				y.println(libArry.get(i).getId() + "," + libArry.get(i).getName() + "," + libArry.get(i).getPassword()
						+ "," + libArry.get(i).getEm() + "," + libArry.get(i).getAddress() + ","
						+ libArry.get(i).getCity() + "," + libArry.get(i).getContactNo());

			}
			y.close();
		}

	}

	public static void readFile() throws FileNotFoundException {
		File f = new File("Librarians.txt");
		try (Scanner s = new Scanner(f)) {
			String id = "";
			String name = "";
			String password = "";
			String em = "";
			String city = "";
			String contactNo = "";
			String address = "";
			while (s.hasNextLine()) {
				String x = s.nextLine();
				String tokens[] = x.split(",");
				id = tokens[0];
				name = tokens[1];
				password = tokens[2];
				em = tokens[3];
				address = tokens[4];
				city = tokens[5];
				contactNo = tokens[6];

				Librarian librarian = new Librarian(id, name, password, em, address, city, contactNo);
				libArry.add(librarian);

			}
		}
	}

	public int add(String id, String name, String password, String em, String address, String city, String contactNo) {
		Librarian librarian = new Librarian(id, name, password, em, address, city, contactNo);
		int i;
		int x = 1;

		for (i = 0; i < libArry.size(); i++) {

			if (id.equals(libArry.get(i).getId())) {

				x = -1;
				break;

			} else {

				x = 1;
			}

		}
		if (x == 1)
			libArry.add(librarian);

		return x;

	}

	public String[] view(int i) {
		String id = libArry.get(i).getId();
		String name = libArry.get(i).getName();
		String password = libArry.get(i).getPassword();
		;
		String em = libArry.get(i).getEm();
		;
		String city = libArry.get(i).getCity();
		;
		String contactNo = libArry.get(i).getContactNo();
		;
		String address = libArry.get(i).getAddress();
		String x[] = { id, name, password, em, address, city, contactNo };
		return x;

	}

	public boolean delete(String id) {

		boolean x = false;
		int i;
		for (i = 0; i < libArry.size(); i++) {
			if (id.equals(libArry.get(i).getId())) {

				libArry.remove(i);
				x = true;
				break;
			}
		}
		if (x)
			return true;
		return false;

	}

	public boolean checkLib(String name, String pass) {
		int i;
		for (i = 0; i < libArry.size(); i++) {
			if (name.equals(libArry.get(i).getName()) == true) {
				if (pass.equals(libArry.get(i).getPassword()) == true)
					return true;

			}
		}
		return false;

	}

	public boolean checkAdmin(String name, String pass) {
		int i;
		for (i = 0; i < adminArry.size(); i++) {
			if (name.equals(adminArry.get(i).getName()) == true) {
				if (pass.equals(adminArry.get(i).getPassword()) == true)
					return true;

			}
		}
		return false;

	}

}
