
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

public class LibrarianSection {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianSection window = new LibrarianSection();
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
	public LibrarianSection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("G://UniversityLibaraySystem/image/book.png")));
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		frame.setBounds(100, 100, 537, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);
		JLabel librariansection = new JLabel("Librarian Section");
		librariansection.setFont(new Font("Times New Roman", Font.BOLD, 24));

		JButton addbooks = new JButton("Add Books");
		addbooks.setForeground(new Color(128, 0, 0));
		addbooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBooks.newSource();
				frame.dispose();
			}
		});
		addbooks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton viewbooks = new JButton("View Books");
		viewbooks.setForeground(new Color(128, 0, 0));
		viewbooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooks.newScreen();
				frame.dispose();
			}

		});
		viewbooks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton issuebook = new JButton("Issue Book");
		issuebook.setForeground(new Color(128, 0, 0));
		issuebook.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		issuebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBook.newScreen();
				frame.dispose();
			}

		});

		JButton viewIssuedBooks = new JButton("View Issued Books");
		viewIssuedBooks.setForeground(new Color(128, 0, 0));
		viewIssuedBooks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		viewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssuedBook.newScreen();
				frame.dispose();
			}
		});

		JButton returnBook = new JButton("Return Book");
		returnBook.setForeground(new Color(128, 0, 0));
		returnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.newScreen();
				frame.dispose();
			}
		});
		returnBook.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton logout = new JButton("Logout");
		logout.setForeground(new Color(128, 0, 0));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LogicBooks.saveBooks();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					LogicIssueBooks.saveIssuedBooks();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "All Actions are saved");

				LibraryManagment.newScreen();

				frame.dispose();
			}
		});
		logout.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(151)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(librariansection, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(addbooks, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(viewbooks, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(issuebook, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(viewIssuedBooks, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(returnBook, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(logout, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
						.addGap(173)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(28)
						.addComponent(librariansection, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(34).addComponent(addbooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(22).addComponent(viewbooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(26).addComponent(issuebook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(23)
						.addComponent(viewIssuedBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(33).addComponent(returnBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(30).addComponent(logout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
