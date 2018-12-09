import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * librarian menu form
 * @author Long
 *
 */
public class LibrarianMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		User lib=new Librarian(Integer.parseInt(args));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianMenu window = new LibrarianMenu((Librarian) lib);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param librarian : set argument as librarian
	 */
	public LibrarianMenu(Librarian librarian) {
		initialize(librarian);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param librarian : set argument as librarian
	 */
	private void initialize(Librarian librarian) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLibrarianSection = new JLabel("Librarian Menu");
		lblLibrarianSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLibrarianSection.setBounds(72, 0, 289, 27);
		frame.getContentPane().add(lblLibrarianSection);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setBounds(123, 320, 191, 37);
		frame.getContentPane().add(btnLogout);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.main(librarian);
				frame.dispose();
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReturnBook.setBounds(123, 265, 191, 37);
		frame.getContentPane().add(btnReturnBook);
		
		JButton btnViewIssuedBooks = new JButton("View Issued Books");
		btnViewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssuedLib.main(librarian);
			}
		});
		btnViewIssuedBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnViewIssuedBooks.setBounds(123, 210, 191, 37);
		frame.getContentPane().add(btnViewIssuedBooks);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBookForm.main(librarian);
				frame.dispose();
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIssueBook.setBounds(123, 155, 191, 37);
		frame.getContentPane().add(btnIssueBook);
		
		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooks.main(librarian);
			}
		});
		btnViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnViewBooks.setBounds(123, 100, 191, 37);
		frame.getContentPane().add(btnViewBooks);
		
		JButton btnNewButton = new JButton("Add Books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookForm.main(librarian);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(123, 45, 191, 37);
		frame.getContentPane().add(btnNewButton);
	}

}
