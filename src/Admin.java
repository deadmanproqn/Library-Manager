import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *Admin Object inherited from User
 */
public class Admin extends User implements AdminInterface {
    public Admin(int SID) {
        super(SID);
    }

    /**
     * Method to add a user to user database
     * @param studentid New user studentid
     * @param name New user name
     * @param password New user password
     * @param email New user email
     * @param address New user address
     * @param city New user city
     * @param contact New user contact
     * @param librarian New user is librarian?
     * @param admin New user is admin?
     * @return Status 0 is false, 1 is true
     */
    public int save(String studentid, String name, String password, String email, String address, String city, String contact, boolean librarian, boolean admin) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into user(studentid,name,password,email,address,city,contact,librarian,admin) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, studentid);
            ps.setString(2, name);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setString(6, city);
            ps.setString(7, contact);
            ps.setBoolean(8, librarian);
            ps.setBoolean(9, admin);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    /**
     * Method to delete a user
     * @param studentid argument use in this method to delete a user
     * @return Status 0 is false, 1 is true
     */
    public int delete(int studentid) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from user where studentid=?");
            ps.setInt(1, studentid);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    /**
     * Method to view all users in database
     * @param con Connection to database
     * @return Result set to process into table in another method
     */
    public ResultSet view(Connection con) {
        ResultSet rs=null;
        try {
            PreparedStatement ps = con.prepareStatement("select * from user", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

    } catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }
}
