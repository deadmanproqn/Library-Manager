import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * IssueBookForm Frame
 */
public class IssueBookForm extends JFrame {

	private JFrame frame;
	private JTextField SIDField;
	private JTextField BIDField;

	/**
	 * Launch the GUI.
	 */
	public static void main(Librarian librarian) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBookForm window = new IssueBookForm(librarian);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the GUI.
	 */
	public IssueBookForm(Librarian librarian) {
		initialize(librarian);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Librarian librarian) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 450, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookName = new JLabel("Book ID:");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookName.setBounds(39, 78, 100, 14);
		frame.getContentPane().add(lblBookName);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentId.setBounds(39, 136, 100, 14);
		frame.getContentPane().add(lblStudentId);
		
		SIDField = new JTextField();
		SIDField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SIDField.setColumns(10);
		SIDField.setBounds(157, 133, 172, 20);
		frame.getContentPane().add(SIDField);
		
		BIDField = new JTextField();
		BIDField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BIDField.setColumns(10);
		BIDField.setBounds(157, 75, 172, 20);
		frame.getContentPane().add(BIDField);
		
		JLabel lblNewLabel_1 = new JLabel("Note: Please check Student ID Carefully before issuing book!");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(39, 259, 345, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookid=Integer.parseInt(BIDField.getText());
				int studentid=Integer.parseInt(SIDField.getText());

				if(librarian.checkBook(bookid)){

					int i=librarian.save(bookid, studentid);
					if(i>0){
						JOptionPane.showMessageDialog(IssueBookForm.this,"Book issued successfully!");
						LibrarianMenu.main(String.valueOf(librarian.SID));
						frame.dispose();

					}else{
						JOptionPane.showMessageDialog(IssueBookForm.this,"Sorry, unable to issue!");
					}//end of save if-else

				}else{
					JOptionPane.showMessageDialog(IssueBookForm.this,"Sorry, Book ID doesn't exist!");
				}//end of checkbook if-else

			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIssueBook.setBounds(184, 196, 145, 31);
		frame.getContentPane().add(btnIssueBook);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LibrarianMenu.main(String.valueOf(librarian.SID));
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(39, 196, 81, 34);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Issue Book ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(175, 10, 94, 22);
		frame.getContentPane().add(lblNewLabel);
	}

	

}
