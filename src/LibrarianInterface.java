import java.sql.Connection;
import java.sql.ResultSet;
/**
 * Define Librarian’s method
 */

public interface LibrarianInterface {
    boolean checkBook(int bookid);
    int save(int bookid,int studentid);
    int updatebook(int bookid);
    ResultSet issue(Connection con);
    int delete(int bookid,int studentid);
    int returnupdatebook(int bookid);
}
