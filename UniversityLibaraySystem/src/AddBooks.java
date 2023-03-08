
// Nourhan Mohamed Ahmed Mohamed Ismail  7153

//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddBooks {

	private JFrame frame;
	private JTextField callno;
	private JTextField namE;
	private JTextField auThor;
	private JTextField pubLisher;
	private JTextField quanTity;

	/**
	 * Launch the application.
	 */
	public static void newSource() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks window = new AddBooks();
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
	public AddBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 250, 240));
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 487, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel addbooks = new JLabel("Add Books");
		addbooks.setBackground(new Color(255, 255, 0));
		addbooks.setFont(new Font("Times New Roman", Font.BOLD, 28));

		JLabel callNo = new JLabel("Call No:");
		callNo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel author = new JLabel("Author:");
		author.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel publisher = new JLabel("Publisher:");
		publisher.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JLabel quantity = new JLabel("Quantity:");
		quantity.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		callno = new JTextField();
		callno.setColumns(10);

		namE = new JTextField();
		namE.setColumns(10);

		auThor = new JTextField();
		auThor.setColumns(10);
		JLabel Datelb = new JLabel("New label");
		Datelb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Datelb.setForeground(new Color(0, 128, 128));
		pubLisher = new JTextField();
		pubLisher.setColumns(10);

		String addedDate = GettingCurrentDate.date();
		Datelb.setText(addedDate);

		quanTity = new JTextField();
		quanTity.setColumns(10);
		JLabel error = new JLabel("");
		JButton addBooks = new JButton("Add Books");
		addBooks.setBackground(new Color(219, 112, 147));

		addBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				error.setText("");
				String callNo = callno.getText();
				String name = namE.getText();
				String author = auThor.getText();
				String publisher = pubLisher.getText();
				String quantity = quanTity.getText();
				if (callNo.equals("") || name.equals("") || author.equals("") || publisher.equals("")
						|| quantity.equals("")) {
					error.setText("This Call number already exists");
				} else {
					LogicBooks book = new LogicBooks();
					// boolean correctQuant = book.checkQant(quantity);
					boolean correctQuant = book.checkQant(quantity);
					if (!correctQuant)
						error.setText("Enter correct quantity number");
					else {
						int check = book.add(callNo, name, author, publisher, quantity, quantity, addedDate);

						if (check != -1)
							JOptionPane.showMessageDialog(null, "Added Succesfully");
						else
							error.setText("This Call Number already exixts with different data ");
					}
				}
			}

		});
		addBooks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		JButton back = new JButton("Back");
		back.setBackground(new Color(0, 255, 255));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSection.newScreen();
				frame.dispose();

			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		error.setForeground(Color.RED);
		error.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		JLabel quantity_1 = new JLabel("Date:");
		quantity_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(125)
						.addComponent(addbooks, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE).addGap(209))
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(callNo, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE).addGap(18)
						.addComponent(callno, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE).addGap(137))
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(name, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE).addGap(18)
						.addComponent(namE, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE).addGap(137))
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(author, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE).addGap(18)
						.addComponent(auThor, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE).addGap(137))
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(publisher, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE).addGap(8)
						.addComponent(pubLisher, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE).addGap(137))
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(quantity, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE).addGap(18)
						.addComponent(quanTity, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE).addGap(137))
				.addGroup(groupLayout.createSequentialGroup().addGap(28)
						.addComponent(error, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(back, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE).addGap(49))
				.addGroup(groupLayout.createSequentialGroup().addGap(319)
						.addComponent(addBooks, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE).addGap(34))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(quantity_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE).addGap(26)
						.addComponent(Datelb, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(176, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(34)
				.addComponent(addbooks, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE).addGap(30)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(callNo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(8)
								.addComponent(callno, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
				.addGap(10)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(8)
								.addComponent(namE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(author, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(8)
								.addComponent(auThor, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
				.addGap(20)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(publisher, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(8)
								.addComponent(pubLisher, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
				.addGap(22)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(quantity, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(9).addComponent(quanTity,
								GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(quantity_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(Datelb, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(9).addComponent(addBooks, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE).addGap(10)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(back, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGap(97))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(error, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGap(107)))));
		frame.getContentPane().setLayout(groupLayout);
	}
}
