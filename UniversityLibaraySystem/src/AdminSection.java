
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminSection {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection window = new AdminSection();
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
	public AdminSection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("G://UniversityLibaraySystem/image/book.png")));
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 481, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);
		JLabel lblNewLabel = new JLabel("Admin Section");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 33));

		JButton add = new JButton("Add Librarian");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLibrarian.newScreen();
				frame.dispose();
			}
		});
		add.setForeground(new Color(128, 0, 0));
		add.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton view = new JButton("View Librarian");
		view.setForeground(new Color(128, 0, 0));
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewLibrarian.newScreen();
				frame.dispose();
			}
		});
		view.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton delete = new JButton("Delete Librarian");
		delete.setForeground(new Color(128, 0, 0));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteLibrarian.newScreen();
				frame.dispose();
			}
		});
		delete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton logout = new JButton("Logout");
		logout.setForeground(new Color(128, 0, 0));
		logout.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LogicLibrarian.saveLibrarian();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					LogicStudents.saveStudents();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "All Actions are saved");
				LibraryManagment.newScreen();
				frame.dispose();

			}
		});

		JButton addStud = new JButton("Add Student");
		addStud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudents.newScreen();
				frame.dispose();
			}
		});
		addStud.setForeground(new Color(128, 0, 0));
		addStud.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton viewStudentsBtn = new JButton("View Students");
		viewStudentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewStudents.newScreen();
				frame.dispose();
			}
		});
		viewStudentsBtn.setForeground(new Color(128, 0, 0));
		viewStudentsBtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton deleteStudents = new JButton("Delete Students");
		deleteStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudents.newScreen();
				frame.dispose();
			}
		});
		deleteStudents.setForeground(new Color(128, 0, 0));
		deleteStudents.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addGap(63).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE).addGap(124))
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addComponent(viewStudentsBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261,
										Short.MAX_VALUE)
								.addComponent(addStud, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261,
										Short.MAX_VALUE)
								.addComponent(delete, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(view, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(add, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
								.addComponent(deleteStudents, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261,
										Short.MAX_VALUE)
								.addComponent(logout, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261,
										Short.MAX_VALUE))
								.addGap(143)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(37)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE).addGap(42)
				.addComponent(add, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(view, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(delete, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(addStud, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(viewStudentsBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(deleteStudents, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(14)
				.addComponent(logout, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE).addGap(41)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
