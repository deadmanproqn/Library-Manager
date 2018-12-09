import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * DB Object
 */
public class DB implements DBInterface {
    /**
     * Method To connect to database
     * @return Connection to the database
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    /**
     * Method to validate user Login Arguments
     * @param name User StudentID
     * @param password User Password
     * @param type User type of account
     * @return Boolean false if user validate false, true otherwise
     */
    public static boolean validate(String name, String password, int type) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps;
            if (type == 1) {//
                ps = con.prepareStatement("select * from user L where L.studentid=? and L.password=? and L.admin=TRUE");
            } else if (type == 2) {
                ps = con.prepareStatement("select * from user L where L.studentid=? and L.password=? and L.librarian=TRUE");
            } else {
                ps = con.prepareStatement("select * from user L where L.studentid=? and L.password=?");
            }
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
