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

public class AdminMenu extends JFrame {
    static AdminMenu frame;
    private JPanel contentPane;

    /**
     * Launch the GUI.
     * @param args set to receive Student ID from AdminLogin
     */
    public static void main(String args) {
        User admin = new Admin(Integer.parseInt(args));//make a User object with role as admin
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AdminMenu((Admin) admin);
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
    public AdminMenu(final Admin admin) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 371);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblAdminMenu = new JLabel("Admin Menu");
        lblAdminMenu.setForeground(Color.RED);
        lblAdminMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton btnAddUser = new JButton("Add User");
        btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserForm.main(admin);
                frame.dispose();
            }
        });

        JButton btnViewUser = new JButton("View Users");
        btnViewUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnViewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ViewUser.main(admin);
            }
        });

        JButton btnDeleteUser = new JButton("Delete User");
        btnDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDeleteUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteUser.main(admin);
                frame.dispose();
            }
        });

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Library.main(new String[]{});
                frame.dispose();
            }
        });


        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                .addContainerGap(157, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeleteUser, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnViewUser, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                .addComponent(btnAddUser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblAdminMenu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(157))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAdminMenu)
                                .addGap(18)
                                .addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnViewUser, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnDeleteUser, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);


    }
}