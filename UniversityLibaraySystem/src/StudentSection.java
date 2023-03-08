
// Nourhan Mohamed Ahmed Ismail          7153
// Shereen Mostafa Hassan Mabrouk  6844
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StudentSection {

	private JFrame frame;

	/**
	 * Launch the application.
	 * 
	 * @param id
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSection window = new StudentSection();
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
	public StudentSection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("G://UniversityLibaraySystem//image//book.png")));
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 364, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);
		JButton btnNewButton = new JButton("View all books");
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooksStudents.newScreen();

				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel lblNewLabel = new JLabel("Student Section");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));

		JButton btnViewMyBooks = new JButton("View my books");
		btnViewMyBooks.setForeground(new Color(128, 0, 0));
		btnViewMyBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ViewMyBooks.newScreen();
				frame.dispose();
			}
		});
		btnViewMyBooks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton btnNewButton_1_1 = new JButton("Penalty Dates");
		btnNewButton_1_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPenaltyDates.newScreen();
				frame.dispose();

			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton btnNewButton_1_1_1 = new JButton("Logout");
		btnNewButton_1_1_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryManagment.newScreen();
				frame.dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JButton profile = new JButton("Profile");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile.newScreen();
				frame.dispose();
			}
		});
		profile.setForeground(new Color(139, 0, 0));
		profile.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(101)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnViewMyBooks, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(profile, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addGap(28)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnViewMyBooks, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(profile, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
