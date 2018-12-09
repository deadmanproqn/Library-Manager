

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Define the GUI of user infor
 * @author Long
 *
 */
public class UserInfo extends JFrame{

	private JFrame frame;		
	private JTextField SIDField;
	private JTextField NameField;
	private JPasswordField passwordField;
	private JTextField mailField;
	private JTextField addrField;
	private JTextField cityField;
	private JTextField contactField;

	/**
	 * main method of  UserInfor.
	 * @param user : set argument as user
	 */
	public static void main(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo window = new UserInfo(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Define GUI elements and Functions
	 * @param user : set argument as user
	 */
	public UserInfo(User user) {
		initialize(user);
	}

	/**
	 * Define GUI elements and Functions
	 */
	private void initialize(User user) {
	    String[] args=new String[1];
	    args[0]= String.valueOf(user.SID);
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);


		JPanel panel = new JPanel();
		panel.setBorder(null);
        setContentPane(getContentPane());

		JLabel label = new JLabel("Contact No:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("City:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("Address:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_4 = new JLabel("Password:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_5 = new JLabel("Name:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_6 = new JLabel("Student ID:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		SIDField = new JTextField();
		SIDField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SIDField.setColumns(10);
		SIDField.setText(String.valueOf(user.SID));
		
		NameField = new JTextField();
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NameField.setColumns(10);
		NameField.setText(user.name);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setText(user.Password);

		mailField = new JTextField();
		mailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mailField.setColumns(10);
		mailField.setText(user.email);

		addrField = new JTextField();
		addrField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addrField.setColumns(10);
		addrField.setText(user.address);
		
		cityField = new JTextField();
		cityField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cityField.setColumns(10);
		cityField.setText(user.city);

		contactField = new JTextField();
		contactField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contactField.setColumns(10);
		contactField.setText(user.contact);

		JLabel label_7 = new JLabel("User Information");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserMenu.main(String.valueOf(user.SID));
				frame.dispose();
			}
		});
		
		
		
		JCheckBox checkBox = new JCheckBox("Admin");
		checkBox.setEnabled(false);
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkBox.setSelected(user.admin);

		JCheckBox checkLibrarian = new JCheckBox("Librarian");
		checkLibrarian.setEnabled(false);
		checkLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkLibrarian.setSelected(user.librarian);

		JButton button_1 = new JButton("Change Information");
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentid = SIDField.getText();
                String name = NameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String email = mailField.getText();
                String address = addrField.getText();
                String city = cityField.getText();
                String contact = contactField.getText();
                Boolean librarian = checkLibrarian.isSelected();
                Boolean admin = checkBox.isSelected();

                int i = user.Update(studentid, name, password, email, address, city, contact, librarian, admin);
                if (i > 0) {
                    JOptionPane.showMessageDialog(UserInfo.this, "Information changed successfully!");
                    UserMenu.main(String.valueOf(user.SID));
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(UserInfo.this, "Sorry, unable to save!");
                }
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addComponent(checkLibrarian))
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
					.addGap(116))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(label_6))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cityField)
						.addComponent(addrField)
						.addComponent(mailField)
						.addComponent(passwordField)
						.addComponent(NameField)
						.addComponent(SIDField, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
						.addComponent(contactField))
					.addContainerGap(181, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(224, Short.MAX_VALUE)
					.addComponent(label_7)
					.addGap(201))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addComponent(label_7)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(SIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(addrField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(contactField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(checkLibrarian)
					.addGap(18)
					.addComponent(checkBox)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
