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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
/**
 * User user form.
 * @author Long
 *
 */
public class UserMenu extends JFrame {
    static UserMenu frame;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String args) {
		User user = new User(Integer.parseInt(args));//make a User object with role as admin
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new UserMenu(user);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @param user : set argument as user
     * 
     */
    public UserMenu(User user) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
    	
    	JLabel lblUserMenu = new JLabel("User Menu");
    	lblUserMenu.setForeground(Color.RED);
    	lblUserMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	
    	JButton btnChangeInfo = new JButton("Change Info");
    	btnChangeInfo.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
                UserInfo.main(user);
    			frame.dispose();
    		}
    	});
    	btnChangeInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	
    	JButton button = new JButton("View Book");
    	button.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    		    ViewBooks.main(user);
    			frame.dispose();
    		}
    	});
    	button.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	
    	JButton button_1 = new JButton("View Issued Book");
    	button_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		    ViewIssued.main(user);
    			frame.dispose();
    		}
    	});
    	button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	
    	JButton button_2 = new JButton("Log Out");
    	button_2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			Library.main(new String[]{});
    			frame.dispose();
    		}
    	});
    	button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	GroupLayout groupLayout = new GroupLayout(getContentPane());
    	groupLayout.setHorizontalGroup(
    		groupLayout.createParallelGroup(Alignment.TRAILING)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(171)
    				.addComponent(lblUserMenu)
    				.addContainerGap(179, Short.MAX_VALUE))
    			.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
    				.addGap(120)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addGroup(groupLayout.createSequentialGroup()
    						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    						.addContainerGap())
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    							.addComponent(button, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
    							.addComponent(btnChangeInfo, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
    							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
    						.addGap(114))))
    	);
    	groupLayout.setVerticalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addContainerGap()
    				.addComponent(lblUserMenu)
    				.addGap(45)
    				.addComponent(btnChangeInfo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
    				.addGap(45)
    				.addComponent(button, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
    				.addGap(44)
    				.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
    				.addGap(45)
    				.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
    				.addContainerGap(47, Short.MAX_VALUE))
    	);
    	getContentPane().setLayout(groupLayout);

    }
}