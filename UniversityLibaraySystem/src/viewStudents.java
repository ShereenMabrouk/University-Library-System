
// Nourhan Mohamed Ahmed Mohamed Ismail  7153
//Shereen Mostafa Hassan Mabrouk         6844
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class viewStudents {

	private JFrame frame;
	private JTable table;
	static DefaultTableModel model;
	private JButton back;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewStudents window = new viewStudents();
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
	public viewStudents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 858, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = { "ID", "Name", "Password", "E.M..", "Address", "City", "ContactNo" };
		Object[] row = new Object[100];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		LogicStudents s = new LogicStudents();
		int i = 0;
		for (i = 0; i < LogicStudents.studArry.size(); i++) {
			int r = 0;
			String x[] = s.view(i);
			while (r < 7) {
				row[r] = x[r];
				r++;
			}
			model.addRow(row);

		}
		scrollPane.setViewportView(table);

		back = new JButton("Back");
		back.setBackground(new Color(219, 112, 147));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSection.newScreen();
				frame.dispose();
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 29));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE).addGap(10))
				.addGroup(groupLayout.createSequentialGroup().addGap(312)
						.addComponent(back, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE).addGap(300)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
						.addGap(10).addComponent(back, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
