import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
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
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setContentPane(new JLabel(new ImageIcon("G:\\UniversityLibaraySystem\\image\\welcome.png")));
		frame.setBounds(100, 100, 697, 648);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setResizable(false);
		JButton btnNewButton = new JButton("GO TO LIBRARY");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryManagment.newScreen();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(162, 460, 347, 75);
		frame.getContentPane().add(btnNewButton);

	}
}
