
// Nourhan Mohamed Ahmed Ismail          7153
// Shereen Mostafa Hassan Mabrouk  6844
import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LogicStudents {
	static ArrayList<Students> studArry = new ArrayList<Students>();
	public static String studentId;

	public static void readFile() throws FileNotFoundException {
		File f = new File("Students.txt");
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
				Students student = new Students(id, name, password, em, address, city, contactNo);
				studArry.add(student);

			}
		}
	}

	public int add(String id, String name, String password, String em, String address, String city, String contactNo) {
		Students stud = new Students(id, name, password, em, address, city, contactNo);
		int i;
		int x = 1;

		for (i = 0; i < studArry.size(); i++) {

			if (id.equals(studArry.get(i).getId())) {

				x = -1;
				break;

			} else {

				x = 1;
			}

		}
		if (x == 1)
			studArry.add(stud);

		return x;

	}

	public String[] studentData()
	{
		int i;
		
		for (i = 0; i < studArry.size(); i++)
		{
			if(studentId.equals(studArry.get(i).getId()))
			{
			String	id =studArry.get(i).getId();
			String name =studArry.get(i).getName();
			String pass = studArry.get(i).getPassword();
			String email =studArry.get(i).getEm();
			String Address=studArry.get(i).getAddress();
			String city =studArry.get(i).getCity();
			String contactNo =studArry.get(i).getContactNo();
			String x[] = {id,name,pass,email,Address,city,contactNo};
			return x;
			
			
				
			}
					
		}
		return null;
	}
	
	public boolean checkStudData(String id, String name, String contactNo) {
		int i;
		for (i = 0; i < studArry.size(); i++) {
			if (id.equals(studArry.get(i).getId()) && name.equals(studArry.get(i).getName())
					&& contactNo.equals(studArry.get(i).getContactNo())) {
				return true;
			}
		}
		return false;

	}

	public boolean checkStud(String id, String name, String pass) {
		int i;
		for (i = 0; i < studArry.size(); i++) {
			if (name.equals(studArry.get(i).getName())) {
				if (pass.equals(studArry.get(i).getPassword()) && id.equals(studArry.get(i).getId())) {
					studentId = id;

					return true;

				}
			}
		}
		return false;

	}

	public boolean delete(String id) {

		boolean x = false;
		int i;
		for (i = 0; i < studArry.size(); i++) {
			if (id.equals(studArry.get(i).getId())) {

				studArry.remove(i);
				x = true;
				break;
			}
		}
		if (x)
			return true;
		return false;

	}

	public static void saveStudents() throws FileNotFoundException {
		File f = new File("Students.txt");
		try (PrintWriter y = new PrintWriter(f)) {
			int i;
			for (i = 0; i < studArry.size(); i++) {
				y.println(
						studArry.get(i).getId() + "," + studArry.get(i).getName() + "," + studArry.get(i).getPassword()
								+ "," + studArry.get(i).getEm() + "," + studArry.get(i).getAddress() + ","
								+ studArry.get(i).getCity() + "," + studArry.get(i).getContactNo());

			}
			y.close();
		}

	}

	public String[] view(int i) {
		String id = studArry.get(i).getId();
		String name = studArry.get(i).getName();
		String password = studArry.get(i).getPassword();
		String em = studArry.get(i).getEm();
		String city = studArry.get(i).getCity();
		String contactNo = studArry.get(i).getContactNo();
		String address = studArry.get(i).getAddress();
		String x[] = { id, name, password, em, address, city, contactNo };
		return x;

	}

}
