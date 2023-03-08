
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Profile {

	private JFrame frame;

	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
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
	public Profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 642, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("student Profile");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 21));

		JLabel lblNewLabel_1_1 = new JLabel(" Password :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 21));

		JLabel id2 = new JLabel("E.m.. :");
		id2.setFont(new Font("Times New Roman", Font.BOLD, 21));

		JLabel lblNewLabel_1_3 = new JLabel("Address :");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 21));

		JLabel lblNewLabel_1_4 = new JLabel("Contact No :");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 21));
		JLabel citylab = new JLabel("City :");

		JButton btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));

		citylab.setFont(new Font("Times New Roman", Font.BOLD, 21));

		JLabel idlabel = new JLabel("ID:");
		idlabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		
		JLabel id = new JLabel("k");
		id.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		JLabel name = new JLabel("New label");
		name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		JLabel pass = new JLabel("k");
		pass.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		JLabel email = new JLabel("k");
		email.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		JLabel city = new JLabel("k");
		city.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		JLabel address = new JLabel("k");
		address.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		JLabel contactNo = new JLabel("k");
		contactNo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		btnBack.setBackground(new Color(0, 255, 255));
		
	
		LogicStudents l =new LogicStudents();
		String x[] = l.studentData();
		id.setText(x[0]);
		name.setText(x[1]);
		pass.setText(x[2]);
		email.setText(x[3]);
		address.setText(x[4]);
		city.setText(x[5]);
		contactNo.setText(x[6]);
		
		
		
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSection.newScreen();
				frame.dispose();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(210)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
					.addGap(219))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_3, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
							.addGap(79))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(citylab, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
							.addGap(79))
						.addComponent(lblNewLabel_1_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addComponent(id2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(idlabel, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
							.addGap(3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(id, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(contactNo, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
							.addGap(73))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(city, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
							.addGap(73))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pass, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
							.addGap(76))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(name, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
							.addGap(76))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(email, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
							.addGap(76))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(address, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
							.addGap(76)))
					.addGap(67))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(300)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(571, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(id, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(idlabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(pass, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(email, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(id2, Alignment.TRAILING))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(citylab)
						.addComponent(city, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_4)
						.addComponent(contactNo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnBack)
					.addGap(88))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
