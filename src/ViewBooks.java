import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/**
 * ViewBook Frame
 */
public class ViewBooks extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public static void main(User user) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewBooks frame = new ViewBooks(user);
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
    public ViewBooks(User user) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 700, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        String data[][] = null;
        String column[] = null;
        try {
            Connection con = DB.getConnection();
            ResultSet rs=user.ViewBook(con);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();//get no of columns
            column = new String[cols];
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
            con.close();//close connection
        } catch (Exception e) {
            System.out.println(e);
        }

        table = new JTable(data, column);
        JScrollPane sp = new JScrollPane(table);

        contentPane.add(sp, BorderLayout.CENTER);
    }

}
