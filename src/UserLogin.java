import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Long
 *User login form 
 */
public class UserLogin extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static UserLogin frame;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
/**
 * create the GUI and define it's function
 */
    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblAdminLoginForm = new JLabel("User Login Form");
        lblAdminLoginForm.setForeground(Color.RED);
        lblAdminLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblEnterName = new JLabel("Enter SID:");
        lblEnterName.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblEnterPassword = new JLabel("Enter Password:");
        lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField = new JTextField();
        textField.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SID = textField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (DB.validate(SID,password,0)) {
                    UserMenu.main(SID);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(UserLogin.this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
                    textField.setText("");
                    passwordField.setText("");
                }
            }
        });


        passwordField = new JPasswordField();

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(42)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(lblEnterPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblEnterName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(passwordField, 195, 195, 195)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(140)
        					.addComponent(lblAdminLoginForm)))
        			.addContainerGap(58, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        			.addContainerGap(274, Short.MAX_VALUE)
        			.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblAdminLoginForm)
        			.addGap(54)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEnterName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(34)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEnterPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(32, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}