
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DeleteStudents {

	private JFrame frame;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudents window = new DeleteStudents();
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
	public DeleteStudents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 520, 278);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Delete Student");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

		JLabel lblName = new JLabel("ID:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));

		id = new JTextField();
		id.setColumns(10);
		JLabel errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		JButton Delete = new JButton("Delete ");
		Delete.setBackground(new Color(219, 112, 147));
		Delete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idL = id.getText();

				LogicStudents s = new LogicStudents();
				boolean error = s.delete(idL);
				if (error)
					JOptionPane.showMessageDialog(null, "Deleted successfully");
				else
					errorLabel.setText("Invalid ID Not Found");

			}
		});

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSection.newScreen();
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup().addGap(174)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(196))
						.addGroup(groupLayout.createSequentialGroup().addGap(23).addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addGap(30)
										.addComponent(id, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE).addGap(122))
								.addGroup(Alignment.LEADING,
										groupLayout.createSequentialGroup()
												.addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 316,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 0,
														Short.MAX_VALUE)
												.addGap(95))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(326)
								.addComponent(Delete, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addGap(74)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(24)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(id, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
						.addGap(31).addComponent(Delete, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE))));
		frame.getContentPane().setLayout(groupLayout);
	}

}
