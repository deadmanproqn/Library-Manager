import java.sql.Connection;
import java.sql.ResultSet;


public interface UserInterface {
    /**
     *  define user method
     *  @param studentid student new student id
     * @param name new name of the user
     * @param password new password of user
     * @param email new email of user
     * @param address user new address
     * @param city user new address
     * @param contact new user contact
     * @param librarian user is the librarian or not
     * @param admin user is the admin or not
     */
    int Update(String studentid, String name, String password, String email, String address, String city, String contact, boolean librarian, boolean admin);

    /**
     * view books that issued by user
     * @param con: open connection to database
     */
    ResultSet issue(Connection con);

    /**
     * view books in database
     *	@param con: open connection to database
     */
    ResultSet ViewBook(Connection con);
}