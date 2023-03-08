
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class StudentLogin {

	private JFrame frame;
	private JTextField nameField;
	private JPasswordField passField;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin window = new StudentLogin();
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
	public StudentLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("G://UniversityLibaraySystem//image//keyyy.png")));
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 762, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel problem = new JLabel("");
		problem.setBackground(new Color(248, 248, 255));
		problem.setForeground(Color.RED);
		problem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		JLabel lblNewLabel = new JLabel("Enter Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		frame.setResizable(false);
		nameField = new JTextField();
		nameField.setColumns(10);
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String name, password, id;
				id = idField.getText();
				name = nameField.getText();
				password = passField.getText();
				LogicStudents s = new LogicStudents();
				boolean check = s.checkStud(id, name, password);
				if (check) {
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

					StudentSection.newScreen();
					frame.dispose();
				} else
					problem.setText("Invalid name or password");

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel lblNewLabel_1 = new JLabel("Student Login Form");
		lblNewLabel_1.setBackground(new Color(248, 248, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));

		passField = new JPasswordField();

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryManagment.newScreen();
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		idField = new JTextField();
		idField.setColumns(10);

		JLabel lblEnterId = new JLabel("Enter ID:");
		lblEnterId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(187).addComponent(lblNewLabel_1,
								GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE).addGap(128))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
										.addComponent(problem, GroupLayout.PREFERRED_SIZE, 330,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
												groupLayout.createSequentialGroup().addGap(92)
														.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 126,
																Short.MAX_VALUE)
														.addGap(157))
												.addGroup(
														groupLayout.createSequentialGroup().addGap(82).addComponent(
																btnNewButton_1, GroupLayout.PREFERRED_SIZE, 151,
																GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblEnterPassword, GroupLayout.DEFAULT_SIZE, 261,
																Short.MAX_VALUE)
														.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 261,
																Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblEnterId, GroupLayout.PREFERRED_SIZE, 126,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(idField, Alignment.LEADING)
												.addComponent(nameField, Alignment.LEADING).addComponent(passField,
														Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 400,
														Short.MAX_VALUE))
										.addGap(44)))
								.addGap(33)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(22)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterId, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(idField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterPassword, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(passField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
								.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 37,
										GroupLayout.PREFERRED_SIZE)
								.addGap(29))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(problem, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
										.addContainerGap()))));
		frame.getContentPane().setLayout(groupLayout);
	}

}
