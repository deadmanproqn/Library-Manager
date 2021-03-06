import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
/**
 * define GUI of view user form 
 * @author Long
 *
 */
public class ViewUser extends JFrame {

    private JPanel contentPane;
    private JTable table;
/**
 *  main method of viewUser class
 * @param admin : set argument as admin
 */
    public static void main(Admin admin) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewUser frame = new ViewUser(admin);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame and function allow admin to view users in user database.
     * @param admin : set argument as admin
     */
    public ViewUser(Admin admin) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 700, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        String data[][] = null;
        String column[] = null;
        try {
            Connection con = DB.getConnection();//must have connection before getting result set
            ResultSet rs = admin.view(con);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();//get no of columns
            column = new String[cols];//get column name
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = rsmd.getColumnName(i);//assign column name
            }

            rs.last();//cursor to last row
            int rows = rs.getRow();//get no of rows
            rs.beforeFirst();

            data = new String[rows][cols];//prepare table to write data
            int count = 0;
            while (rs.next()) {//for each row
                for (int i = 1; i <= cols; i++) {//get data from each column
                    data[count][i - 1] = rs.getString(i);
                }
                count++;
            }
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        table = new JTable(data, column);
        JScrollPane sp = new JScrollPane(table);

        contentPane.add(sp, BorderLayout.CENTER);
    }

}
