
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;

public class LibrarianLoginForm {

	private JFrame frame;
	private JTextField name;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianLoginForm window = new LibrarianLoginForm();
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
	public LibrarianLoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("G://UniversityLibaraySystem//image//keyyy.png")));
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 730, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel librarianLoginForm = new JLabel("Librarian Login Form");
		librarianLoginForm.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel enterName = new JLabel("Enter Name:");
		enterName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		frame.setResizable(false);
		name = new JTextField();
		name.setColumns(10);

		JLabel enterPassword = new JLabel("Enter Password:");
		enterPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		password = new JPasswordField();
		JLabel error = new JLabel("");
		error.setBackground(new Color(248, 248, 255));
		JButton login = new JButton("Login");
		login.setBackground(SystemColor.activeCaption);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameL = name.getText();
				@SuppressWarnings("deprecation")
				String passL = password.getText();
				LogicLibrarian l = new LogicLibrarian();
				boolean check = l.checkLib(nameL, passL);
				if (check) {

					LibrarianSection.newScreen();
					if (LogicBooks.bookArry.size() == 0) {
						try {
							LogicBooks.readFileBooks();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (LogicIssueBooks.issueArry.size() == 0) {
						try {
							LogicIssueBooks.readFileIssuedBooks();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					frame.dispose();
				} else
					error.setText("Invalid name or password");

			}
		});
		login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));

		JButton back = new JButton("Back");
		back.setBackground(SystemColor.activeCaptionBorder);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryManagment.newScreen();
				frame.dispose();
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		error.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		error.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(36)
						.addComponent(enterName, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE).addGap(16)
						.addComponent(name, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE).addGap(123))
				.addGroup(groupLayout.createSequentialGroup().addGap(15)
						.addComponent(enterPassword, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE).addGap(10)
						.addComponent(password, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE).addGap(123))
				.addGroup(groupLayout.createSequentialGroup().addGap(36)
						.addComponent(error, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(442, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(422)
						.addComponent(back, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE).addGap(52))
				.addGroup(groupLayout.createSequentialGroup().addGap(407)
						.addComponent(login, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE).addGap(38))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(209, Short.MAX_VALUE)
						.addComponent(librarianLoginForm, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addGap(182)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(librarianLoginForm, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(23)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(enterName, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(8)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
				.addGap(29)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(enterPassword, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(8).addComponent(password,
								GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
				.addGap(29)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(error, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(58))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(login, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(18)))
				.addComponent(back, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(28)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
