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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
/**
 * define GUI of view user form
 * @author Long
 *
 */
public class DeleteUser extends JFrame {
    static DeleteUser frame;
    private JPanel contentPane;
    private JTextField textField;

    /**
     * main method of deleteUser class.
     * @param admin : set argument as admin
     */
    public static void main(Admin admin) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new DeleteUser(admin);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame and function allow admin to delete users in user database.
     * @param admin : set argument as admin
     */
    public DeleteUser(final Admin admin) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblEnterId = new JLabel("Enter Student Id:");
        lblEnterId.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setColumns(10);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sid = textField.getText();
                if (sid == null || sid.trim().equals("")) {
                    JOptionPane.showMessageDialog(DeleteUser.this, "Id can't be blank");
                } else {
                    int id = Integer.parseInt(sid);
                    int i = admin.delete(id);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(DeleteUser.this, "Record deleted successfully!");
                        AdminMenu.main(String.valueOf(admin.SID));
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(DeleteUser.this, "Unable to delete given id!");
                    }
                }
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminMenu.main(String.valueOf(admin.SID));
                frame.dispose();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblDeleteUser = new JLabel("Delete User");
        lblDeleteUser.setForeground(Color.RED);
        lblDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(24)
                                                .addComponent(lblEnterId)))
                                .addGap(80)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblDeleteUser)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(74, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblDeleteUser)
                                .addGap(44)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblEnterId))
                                .addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton)
                                        .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(54))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
