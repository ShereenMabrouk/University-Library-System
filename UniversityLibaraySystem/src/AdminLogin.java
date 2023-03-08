
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class AdminLogin {

	private JFrame frame;
	private JTextField nameField;
	private JPasswordField passField;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setContentPane(new JLabel(new ImageIcon("G://UniversityLibaraySystem//image//keyyy.png")));
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 820, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel problem = new JLabel("");
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
				String name, password;
				name = nameField.getText();
				password = passField.getText();
				LogicLibrarian l = new LogicLibrarian();
				boolean check = l.checkAdmin(name, password);
				if (check) {
					AdminSection.newScreen();
					frame.dispose();
				} else
					problem.setText("Invalid name or password");

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel lblNewLabel_1 = new JLabel("Admin Login Form");
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

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout
								.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(27).addComponent(
												lblNewLabel, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addContainerGap()
												.addComponent(lblEnterPassword, GroupLayout.DEFAULT_SIZE, 148,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGap(23)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passField)
										.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
								.addGap(188))
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addGap(31)
										.addComponent(problem, GroupLayout.PREFERRED_SIZE, 206,
												GroupLayout.PREFERRED_SIZE)
										.addGap(85)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 140, Short.MAX_VALUE)
										.addGap(76).addComponent(btnNewButton_1).addGap(64))
								.addGroup(groupLayout.createSequentialGroup().addGap(209).addComponent(lblNewLabel_1,
										GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)))
								.addGap(106)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(24)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(84)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(passField, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEnterPassword, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE))
						.addGap(36)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(problem, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 37,
										GroupLayout.PREFERRED_SIZE))
						.addGap(30)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
