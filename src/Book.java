import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Book Object
 */
public class Book implements BookInterface {
    int BID;
    String name;
    String author;
    String publisher;
    int quantity;

    /**
     * Constructor to create a book object
     * @param BID Book Id
     * @param name Book Id
     * @param author Book Author
     * @param publisher Book Publisher
     * @param quantity  Book Quantity
     */
    public Book(int BID,String name, String author,String publisher, int quantity){
        this.BID=BID;
        this.name= name;
        this.author=author;
        this.publisher=publisher;
        this.quantity=quantity;
    }

    /**
     * Method to add a book to Book Database
     * @param bookid Book Id
     * @param name Book Id
     * @param author Book Author
     * @param publisher Book Publisher
     * @param quantity Book Quantity
     * @return Status 0 is false, 1 is Success
     */
        public int save(int bookid, String name, String author, String publisher, int quantity) {
            int status = 0;
            try {
                Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO books(bookid,name,author,publisher,quantity) VALUES(?,?,?,?,?)");
                ps.setInt(1, bookid);
                ps.setString(2, name);
                ps.setString(3, author);
                ps.setString(4, publisher);
                ps.setInt(5, quantity);
                status = ps.executeUpdate();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            return status;
        }
    }

