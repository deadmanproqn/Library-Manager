import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * BookForm Frame
 */
public class BookForm extends JFrame {
    static BookForm frame;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the GUI.
     */
    public static void main(Librarian librarian) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new BookForm(librarian);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BookForm(Librarian librarian) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 404);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblAddBooks = new JLabel("Add Books");
        lblAddBooks.setForeground(Color.RED);
        lblAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblCallNo = new JLabel("Book ID:");
        lblCallNo.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblPublisher = new JLabel("Publisher:");
        lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_4.setColumns(10);

        JButton btnAddBooks = new JButton("Add Books");
        btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int bookid= Integer.parseInt(textField.getText());
                String name=textField_1.getText();
                String author=textField_2.getText();
                String publisher=textField_3.getText();
                int quantity= Integer.parseInt(textField_4.getText());
                Book book=new Book(bookid, name, author, publisher, quantity);

                int i=book.save(bookid, name, author, publisher, quantity);
                if(i>0){
                    JOptionPane.showMessageDialog(BookForm.this,"Books added successfully!");
                    LibrarianMenu.main(String.valueOf(librarian.SID));
                    frame.dispose();

                }else{
                    JOptionPane.showMessageDialog(BookForm.this,"Sorry, unable to save!");
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    LibrarianMenu.main(String.valueOf(librarian.SID));
        	    frame.dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(150)
        					.addComponent(lblAddBooks))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(18)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblPublisher, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        						.addComponent(lblCallNo, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
        						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblAuthor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblQuantity, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(18)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(125, Short.MAX_VALUE))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(161)
        			.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(162, Short.MAX_VALUE))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(359, Short.MAX_VALUE)
        			.addComponent(btnBack)
        			.addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(lblAddBooks)
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCallNo)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblName)
        				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblAuthor)
        				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPublisher)
        				.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblQuantity)
        				.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(30)
        			.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnBack)
        			.addContainerGap(53, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
