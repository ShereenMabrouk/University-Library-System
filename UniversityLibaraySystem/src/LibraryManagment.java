//Nourhan Mohamed Ahmed Mohamed Ismail  7153

//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

public class LibraryManagment {

	private JFrame frame;

	public static void newScreen() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryManagment window = new LibraryManagment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		if (LogicLibrarian.adminArry.size() == 0) {
			try {
				LogicLibrarian.readFileAdmins();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		}
		if (LogicLibrarian.libArry.size() == 0) {
			try {
				LogicLibrarian.readFile();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		}
		if (LogicStudents.studArry.size() == 0) {
			try {
				LogicStudents.readFile();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		}

	}

	public LibraryManagment() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("F:\\library photo\\lib.jpg")));
		frame.setBackground(new Color(245, 255, 250));
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 746, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdminLogin.newScreen();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 38));

		JButton btnNewButton_1 = new JButton("Libarian Login");
		btnNewButton_1.setBackground(new Color(0, 191, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LibrarianLoginForm.newScreen();
				frame.dispose();

			}
		});

		JButton studentloginBtn = new JButton("Student Login");
		studentloginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogin.newScreen();
				frame.dispose();

			}
		});
		studentloginBtn.setFont(new Font("Times New Roman", Font.BOLD, 36));
		studentloginBtn.setBackground(new Color(175, 238, 238));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addGap(77)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(studentloginBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 562,
										Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
						.addGap(93)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(77)
				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE).addGap(49)
				.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE).addGap(33)
				.addComponent(studentloginBtn, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(81, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
