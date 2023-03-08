
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddLibrarian {

	private JFrame frame;
	private JTextField name;
	private JTextField password;
	private JTextField em;
	private JTextField address;
	private JTextField contactNo;
	private JTextField id;

	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLibrarian window = new AddLibrarian();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddLibrarian() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 642, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Add Librarian");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		id = new JTextField();
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

		name = new JTextField();
		name.setColumns(10);

		password = new JTextField();
		password.setColumns(10);

		em = new JTextField();
		em.setColumns(10);
		JLabel citylab = new JLabel("City :");
		address = new JTextField();
		address.setColumns(10);

		JTextField city = new JTextField();
		city.setColumns(10);
		JLabel check = new JLabel("");
		JButton addLibrarian = new JButton("Add Librarian");
		addLibrarian.setBackground(new Color(219, 112, 147));
		addLibrarian.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		addLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check.setText("");
				String idL;
				String nameL;
				String passwordL;
				String emL;
				String cityL;
				String contactNoL;
				String addressL;

				idL = id.getText();
				nameL = name.getText();
				passwordL = password.getText();
				emL = em.getText();
				cityL = city.getText();
				contactNoL = contactNo.getText();
				addressL = address.getText();
				LogicLibrarian l = new LogicLibrarian();
				if (nameL.equals("") || passwordL.equals("") || emL.equals("") || addressL.equals("")
						|| cityL.equals("") || contactNoL.equals(""))
					check.setText("All fields are needed");
				else {
					ValidationOfData valid = new ValidationOfData();
					String validData = valid.checkValidity(idL, nameL, passwordL, emL, addressL, cityL, contactNoL);
					if (validData.equals("add")) {
						int x = l.add(idL, nameL, passwordL, emL, addressL, cityL, contactNoL);
						if (x == 1)

							JOptionPane.showMessageDialog(null, "Added succesfully");
						else if (x == 2)
							check.setText("Wrong Email");
						else
							check.setText("ID already exisits");
					} else
						check.setText(validData);

				}
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSection.newScreen();
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));

		contactNo = new JTextField();
		contactNo.setColumns(10);

		citylab.setFont(new Font("Times New Roman", Font.BOLD, 21));

		check.setForeground(Color.RED);
		check.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));

		JLabel idlabel = new JLabel("ID:");
		idlabel.setBackground(new Color(248, 248, 255));
		idlabel.setFont(new Font("Times New Roman", Font.BOLD, 21));

		id.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(210)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE).addGap(219))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel_1_3, GroupLayout.DEFAULT_SIZE, 104,
														Short.MAX_VALUE)
												.addGap(79))
										.addGroup(
												groupLayout.createSequentialGroup()
														.addComponent(citylab, GroupLayout.DEFAULT_SIZE, 104,
																Short.MAX_VALUE)
														.addGap(79))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel_1_4, GroupLayout.DEFAULT_SIZE, 179,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 179,
																Short.MAX_VALUE)
														.addComponent(id2, GroupLayout.DEFAULT_SIZE, 179,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout
												.createSequentialGroup()
												.addComponent(
														lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
										.createSequentialGroup()
										.addComponent(addLibrarian, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
										.addGap(53)
										.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
										.addGap(24))
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(name, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 314,
														Short.MAX_VALUE)
												.addComponent(password, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														314, Short.MAX_VALUE)
												.addComponent(address, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
												.addComponent(contactNo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														314, Short.MAX_VALUE)
												.addComponent(city, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
												.addComponent(em, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
												.addGap(121))))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(check, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(idlabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(id, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE).addGap(121)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(21)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel).addGap(35))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(idlabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(id, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, Alignment.TRAILING).addComponent(name, Alignment.TRAILING,
								GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(em, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addComponent(id2))
				.addGap(25)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1_3)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(citylab).addComponent(city,
						GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addGap(34)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1_4)
						.addComponent(contactNo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addGap(24)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addLibrarian, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
				.addGap(18).addComponent(check, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
