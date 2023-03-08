
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

public class ViewIssuedBook {

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
					ViewIssuedBook window = new ViewIssuedBook();
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
	public ViewIssuedBook() {
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
		Object[] column = { "ID", "Book Call No", "Student ID", "Student Name", "Student Contact", "Return Date" };

		Object[] row = new Object[100];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		LogicIssueBooks issue = new LogicIssueBooks();
		int i = 0;
		for (i = 0; i < LogicIssueBooks.issueArry.size(); i++) {
			int r = 0;
			row[0] = i + 1;
			String x[] = issue.view(i);
			while (r < 5) {

				row[r + 1] = x[r];
				r++;
			}
			model.addRow(row);

		}
		scrollPane.setViewportView(table);

		back = new JButton("Back");
		back.setBackground(new Color(219, 112, 147));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSection.newScreen();
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

/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * import java.awt.EventQueue;
 * 
 * import javax.swing.JFrame; import javax.swing.JTable; import
 * java.awt.BorderLayout; import javax.swing.table.DefaultTableModel; import
 * javax.swing.JScrollPane; import javax.swing.JButton; import java.awt.Font;
 * 
 * public class ViewIssuedBook {
 * 
 * private JFrame frame; private JTable table; private JButton back;
 * 
 * /** Launch the application.
 */
/*
 * public static void newSource() { EventQueue.invokeLater(new Runnable() {
 * public void run() { try { ViewIssuedBook window = new ViewIssuedBook();
 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
 * } }); }
 * 
 * /** Create the application.
 */
/*
 * public ViewIssuedBook() { initialize(); }
 * 
 * /** Initialize the contents of the frame.
 */
/*
 * private void initialize() { /*frame = new JFrame(); frame.setBounds(100, 100,
 * 893, 423); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * frame.getContentPane().setLayout(null);
 * 
 * JScrollPane viewIssuedBooksTable = new JScrollPane();
 * viewIssuedBooksTable.setBounds(31, 27, 797, 289);
 * frame.getContentPane().add(viewIssuedBooksTable);
 * 
 * table = new JTable(); viewIssuedBooksTable.setViewportView(table);
 * 
 * back = new JButton("Back"); back.setFont(new Font("Times New Roman",
 * Font.BOLD | Font.ITALIC, 29)); back.setBounds(308, 338, 232, 38);
 * frame.getContentPane().add(back); } }
 */