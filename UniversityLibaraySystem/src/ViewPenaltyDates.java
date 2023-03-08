
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

public class ViewPenaltyDates {

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
					ViewPenaltyDates window = new ViewPenaltyDates();
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
	public ViewPenaltyDates() {
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
		Object[] column = { "ID", "Call No ", "return Date" };
		Object[] row = new Object[100];
		model.setColumnIdentifiers(column);
		table.setModel(model);

		LogicIssueBooks bL = new LogicIssueBooks();
		int i = 0, l = 0;
		for (i = 0; i < LogicIssueBooks.issueArry.size(); i++) {
			if (LogicStudents.studentId.equals(LogicIssueBooks.issueArry.get(i).getStudID())) {

				row[0] = l + 1;
				String x[] = bL.view(i);
				row[1] = LogicIssueBooks.issueArry.get(i).getbCallNo();
				row[2] = x[4];
				l++;
				model.addRow(row);
			}

		}
		scrollPane.setViewportView(table);

		back = new JButton("Back");
		back.setBackground(new Color(219, 112, 147));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSection.newScreen();
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
