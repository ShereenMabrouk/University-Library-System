
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
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

public class ReturnBook {

	private JFrame frame;
	private JTextField bookcallno;
	private JTextField studentID;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
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
	public ReturnBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 600, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel returnBook = new JLabel("Return Book");
		returnBook.setFont(new Font("Times New Roman", Font.BOLD, 26));

		JLabel bookCallNo = new JLabel("Book CallNo:");
		bookCallNo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		JLabel lblDate = new JLabel("Date:");
		JLabel studentId = new JLabel("Student Id:");
		studentId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		JLabel datelb = new JLabel("");
		datelb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		datelb.setForeground(new Color(0, 139, 139));
		bookcallno = new JTextField();
		bookcallno.setColumns(10);

		studentID = new JTextField();
		studentID.setColumns(10);
		JLabel errorLabel = new JLabel("");
		errorLabel.setForeground(new Color(255, 0, 0));

		String tDate = GettingCurrentDate.date();
		datelb.setText(tDate);
		JButton returnbook = new JButton("Return Book");
		returnbook.setBackground(new Color(240, 128, 128));
		returnbook.setForeground(new Color(0, 0, 0));
		returnbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");

				String callNo = bookcallno.getText();
				String studID = studentID.getText();

				LogicIssueBooks issue = new LogicIssueBooks();
				boolean penalty = issue.penalty(studID, tDate);
				if (!penalty) {
					String choice = JOptionPane.showInputDialog(
							"The Student must pay a penalty for being late Enter yes to contiue returnting the book else to cancel");
					if (choice.equals("yes")) {
						boolean error = issue.IssueReturn(callNo, studID);
						if (error)
							JOptionPane.showMessageDialog(null, "Returned successfully");
						else
							errorLabel.setText("Invalid Call No or Student ID");

					} else
						errorLabel.setText("Have penalty");
				} else {
					boolean error = issue.IssueReturn(callNo, studID);
					if (error)
						JOptionPane.showMessageDialog(null, "Returned successfully");
					else
						errorLabel.setText("Invalid Call No or Student ID");

				}
			}
		});
		returnbook.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));

		JButton back = new JButton("Back");
		back.setBackground(new Color(0, 191, 255));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSection.newScreen();
				frame.dispose();
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));

		lblDate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(196)
						.addComponent(returnBook, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE).addGap(209))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(bookCallNo, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(bookcallno, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE).addGap(182))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(studentId, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
								.addComponent(lblDate, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 94,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(studentID, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
										.addGap(182))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(datelb, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())))
				.addGroup(
						groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(back, GroupLayout.PREFERRED_SIZE, 128,
														GroupLayout.PREFERRED_SIZE)
												.addGap(51))
										.addGroup(groupLayout
												.createSequentialGroup().addComponent(returnbook,
														GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
												.addGap(34)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(29)
						.addComponent(returnBook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookcallno, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookCallNo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(studentID, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(studentId, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(datelb, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
								.createSequentialGroup()
								.addComponent(returnbook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(back, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGap(20))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(errorLabel, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
										.addContainerGap()))));
		frame.getContentPane().setLayout(groupLayout);
	}
}
