import java.sql.Connection;
import java.sql.ResultSet;

/**
 *Define Admin’s method
 */
public interface AdminInterface {
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
    int save(String studentid, String name, String password, String email, String address, String city, String contact, boolean librarian, boolean admin);

    /**
     * Method to delete a user
     * @param studentid argument use in this method to delete a user
     * @return Status 0 is false, 1 is true
     */
    int delete(int studentid);

    /**
     * Method to view all users in database
     * @param con Connection to database
     * @return Result set to process into table in another method
     */
    ResultSet view(Connection con);
}
