import java.sql.*;
/**
 * Definition of a class user
 * @author Long
 *
 */
public class User implements UserInterface{
    int SID;
    String name;
    String Password;
    String email;
    String address;
    String city;
    String contact;
    boolean librarian;
    boolean admin;
    /**
     * Constructer of an object base on an Argument from user login.
     * @param SID 
     */
    public User(int SID) {
        try{
        Connection con = DB.getConnection();
        PreparedStatement ps= con.prepareStatement("SELECT * FROM USER WHERE STUDENTID='"+SID+"';");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            this.SID=rs.getInt(2);
            this.name=rs.getString(3);
            this.Password=rs.getString(4);
            this.email=rs.getString(5);
            this.address=rs.getString(6);
            this.city=rs.getString(7);
            this.contact=rs.getString(8);
            this.librarian=rs.getBoolean(9);
            this.admin=rs.getBoolean(10);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /**
     * modify personal information in database and database.
     * @param studentid: student new student id 
     * @param name: new name of the user
     * @param password: new password of user
     * @param email: new email of user
     * @param address: user new address
     * @param city: user new address
     * @param contact: new user contact 
     * @param librarian: user is the librarian or not
     * @param admin: user is the admin or not 
     */
    public int Update(String studentid, String name, String password, String email, String address, String city, String contact, boolean librarian, boolean admin) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("update user set studentid=?, name=?, password=?, email=?, address=?, city=?, contact=?, librarian=?, admin=? where studentid=?");
            ps.setString(1, studentid);
            ps.setString(2, name);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setString(6, city);
            ps.setString(7, contact);
            ps.setBoolean(8, librarian);
            ps.setBoolean(9, admin);
            ps.setInt(10,this.SID);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    /**
     * view books that issued by user
     * @param con: open connection to database
     */
    public ResultSet issue(Connection con) {//view issued book
        ResultSet rs = null;
        try {
            //Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ISSUE WHERE STUDENTID=?");
            ps.setInt(1,this.SID);
            rs = ps.executeQuery();
            //con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
/**
 * view books in database
 *	@param con: open connection to database
 */
    public ResultSet ViewBook(Connection con){
        ResultSet rs = null;
        try {
            //Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM BOOKS");
            rs = ps.executeQuery();
            //con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

}
