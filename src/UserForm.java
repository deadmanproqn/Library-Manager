import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
/**
 * define a user form GUI
 * @author Long
 *
 */
public class UserForm extends JFrame {
    static UserForm frame;
    private JPanel contentPane;
    private JTextField cityField;
    private JTextField NameField;
    private JTextField mailField;
    private JTextField addrField;
    private JTextField contactField;
    private JPasswordField passwordField;
    private JTextField SIDField;


    /**
     * main method of  userForm.
     * @param admin : set argument as admin
     */
    public static void main(Admin admin) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new UserForm(admin);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     *  define GUI elements and functions.
     * @param admin1  set argument as admin
     */
    public UserForm(final Admin admin1) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 580);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel label = new JLabel("Password:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel label_1 = new JLabel("Name:");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel label_2 = new JLabel("Email:");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel label_3 = new JLabel("Address:");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel label_4 = new JLabel("City:");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel label_5 = new JLabel("Contact No:");
        label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));

        cityField = new JTextField();
        cityField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cityField.setColumns(10);

        NameField = new JTextField();
        NameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        NameField.setColumns(10);

        mailField = new JTextField();
        mailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        mailField.setColumns(10);

        addrField = new JTextField();
        addrField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addrField.setColumns(10);

        contactField = new JTextField();
        contactField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contactField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblStudentId = new JLabel("Student ID:");
        lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 15));

        SIDField = new JTextField();
        SIDField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        SIDField.setColumns(10);

        JLabel label_6 = new JLabel("Add User");
        label_6.setForeground(Color.RED);
        label_6.setFont(new Font("Tahoma", Font.PLAIN, 22));

        JCheckBox checkLibrarian = new JCheckBox("Librarian");
        checkLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));


        JCheckBox checkBox = new JCheckBox("Admin");
        checkBox.setFont(new Font("Tahoma", Font.PLAIN, 15));


        JButton Addbutton = new JButton("Add User");
        Addbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Addbutton.setForeground(Color.DARK_GRAY);
        Addbutton.addActionListener(new ActionListener() {
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

                int i = admin1.save(studentid, name, password, email, address, city, contact, librarian, admin);
                if (i > 0) {
                    JOptionPane.showMessageDialog(UserForm.this, "User added successfully!");
                    AdminMenu.main(String.valueOf(admin1.SID));
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(UserForm.this, "Sorry, unable to save!");
                }

            }
        });

        JButton Backbutton = new JButton("Back");
        Backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminMenu.main(String.valueOf(admin1.SID));
                frame.dispose();
            }
        });


        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(27)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(label_5)
                                        .addComponent(label_4)
                                        .addComponent(label_3)
                                        .addComponent(label_2)
                                        .addComponent(label)
                                        .addComponent(label_1)
                                        .addComponent(lblStudentId))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(SIDField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(NameField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(mailField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(addrField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(cityField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(contactField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                .addGap(49))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(174, Short.MAX_VALUE)
                                .addComponent(label_6)
                                .addGap(162))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Backbutton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(Addbutton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(checkLibrarian)))
                                .addGap(116))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_6)
                                .addGap(15)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblStudentId)
                                        .addComponent(SIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_1))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_2)
                                        .addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_3)
                                        .addComponent(addrField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_4)
                                        .addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(label_5)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(contactField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18)
                                .addComponent(checkLibrarian)
                                .addGap(18)
                                .addComponent(checkBox)
                                .addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Addbutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Backbutton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(27))
        );
        contentPane.setLayout(gl_contentPane);

    }


}