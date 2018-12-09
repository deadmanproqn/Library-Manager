import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Define DB's methods
 */
public interface DBInterface {
    /**
     * Method To connect to database
     * @return Connection to the database
     */
    static Connection getConnection(){
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
    static boolean validate(String name, String password, int type) {
        return false;
    }
}
