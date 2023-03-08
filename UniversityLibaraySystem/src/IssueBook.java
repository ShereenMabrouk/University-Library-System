
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

public class IssueBook {

	private JFrame frame;
	private JTextField bookcatNo;
	private JTextField studentId;
	private JTextField studentname;
	private JTextField studentcontact;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook window = new IssueBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IssueBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 609, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel issueBook = new JLabel("Issue Book");
		issueBook.setFont(new Font("Times New Roman", Font.BOLD, 27));

		JLabel bookCatNo = new JLabel("BookCall No:");
		bookCatNo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel studentID = new JLabel("Student ID:");
		studentID.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel studentName = new JLabel("Student Name:");
		studentName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel studentContact = new JLabel("Student Contact:");
		studentContact.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel issuedDate = new JLabel("Return Date:");
		issuedDate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		bookcatNo = new JTextField();
		bookcatNo.setColumns(10);

		studentId = new JTextField();
		studentId.setColumns(10);
		studentname = new JTextField();
		studentname.setColumns(10);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		studentcontact = new JTextField();
		studentcontact.setColumns(10);
		JLabel error = new JLabel("");
		JButton issuebook = new JButton("Issue Book");
		issuebook.setBackground(new Color(240, 128, 128));
		issuebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

				String tDate = GettingCurrentDate.date();

				if (dateChooser.getDate() == null)
					error.setText("Incorrect Date");
				else {
					ValidationOfData v = new ValidationOfData();
					String issueDate = df.format(dateChooser.getDate());
					error.setText("");
					if (v.validDate(tDate, issueDate)) {

						String bCallNo = bookcatNo.getText();
						String studID = studentId.getText();
						String studName = studentname.getText();
						String studContact = studentcontact.getText();

						if (bCallNo.equals("") || studID.equals("") || studName.equals("") || studContact.equals("")
								|| issueDate.equals("")) {
							error.setText("This Call number already exists");
						} else {
							LogicIssueBooks book = new LogicIssueBooks();
							boolean limit = book.limit3Books(studID);
							if (limit) {
								int check = book.add(bCallNo, studID, studName, studContact, issueDate);
								if (check == 2)
									JOptionPane.showMessageDialog(null, "Book issued Succesfully");

								else
									error.setText("Error finding the book or the student");
							} else
								error.setText("Student has issued 3 books can't issue again ");
						}
					} else
						error.setText("Return Date has passed ");
				}
			}
		});
		issuebook.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton back = new JButton("Back");
		back.setBackground(new Color(0, 255, 255));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSection.newScreen();
				frame.dispose();
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		error.setForeground(Color.RED);
		error.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(190)
						.addComponent(issueBook, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE).addGap(225))
				.addGroup(groupLayout.createSequentialGroup().addGap(21)
						.addComponent(bookCatNo, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE).addGap(7)
						.addComponent(bookcatNo, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE).addGap(146))
				.addGroup(groupLayout.createSequentialGroup().addGap(21)
						.addComponent(studentID, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE).addGap(7)
						.addComponent(studentId, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE).addGap(146))
				.addGroup(groupLayout.createSequentialGroup().addGap(21)
						.addComponent(studentName, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE).addGap(10)
						.addComponent(studentname, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE).addGap(143))
				.addGroup(groupLayout.createSequentialGroup().addGap(21)
						.addComponent(studentContact, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE).addGap(7)
						.addComponent(studentcontact, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE).addGap(146))
				.addGroup(groupLayout.createSequentialGroup().addGap(269)
						.addComponent(issuebook, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE).addGap(23)
						.addComponent(back, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(21)
										.addComponent(issuedDate, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 190,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout
										.createSequentialGroup().addGap(33).addComponent(error,
												GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
										.addGap(57)))
						.addGap(233)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(26)
				.addComponent(issueBook, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(20)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bookCatNo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(3)
								.addComponent(bookcatNo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
				.addGap(37)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(studentID, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(3)
								.addComponent(studentId, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
				.addGap(25)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(studentName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(3)
								.addComponent(studentname, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
				.addGap(23)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(studentContact, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(studentcontact,
								GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
				.addGap(27)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(issuedDate, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(32).addComponent(error, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(29)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(issuebook, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(back, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(71, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
