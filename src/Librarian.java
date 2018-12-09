import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * define class librarian which implements from LibrarianInterface
 * @author Long
 */
public class Librarian extends User implements LibrarianInterface{

    public Librarian(int SID) {
        super(SID);
    }
    /**
     * method to check for the book in database wherever it exist in database.
     * @param bookid Book ID of the book in database
     */
    public boolean checkBook(int bookid){
        boolean status=false;
        try{
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from books where bookid=?");
            ps.setInt(1,bookid);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    /**
     * method to issue a book to the user.
     * @param bookid Issued Book ID
     * @param studentid Issued Student
     */
    public int save(int bookid,int studentid){//issue book
        int status=0;
        try{
            Connection con=DB.getConnection();

            status=updatebook(bookid);//updating quantity and issue

            if(status>0){
                PreparedStatement ps=con.prepareStatement("insert into issue(bookid,studentid) values(?,?)");
                ps.setInt(1,bookid);
                ps.setInt(2,studentid);
                status=ps.executeUpdate();
            }

            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    /**
     * method to update the status of the book in database
     * @param bookid
     */
    public int updatebook(int bookid){//update in db
        int status=0;
        int quantity=0,issued=0;
        try{
            Connection con=DB.getConnection();

            PreparedStatement ps=con.prepareStatement("select quantity,issued from books where bookid=?");
            ps.setInt(1,bookid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                quantity=rs.getInt("quantity");
                issued=rs.getInt("issued");
            }

            if(quantity>0){
                PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where bookid=?");
                ps2.setInt(1,quantity-1);
                ps2.setInt(2,issued+1);
                ps2.setInt(3,bookid);

                status=ps2.executeUpdate();
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
/**
 * override the  issue class in super class to be used be librarian which remove the identifier (where studentid =?) in the super class.
 */
    @Override
    public ResultSet issue(Connection con) {//view issued book
        ResultSet rs = null;
        try {
            //Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ISSUE");
            rs = ps.executeQuery();
            //con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    /**
     * method to return a book that has been borrowed by a user
     * @param bookid Return Book ID
     * @param studentid Return Student
     */
    public int delete(int bookid,int studentid){//delete from issue
        int status=0;
        try{
            Connection con=DB.getConnection();

            status=returnupdatebook(bookid);//updating quantity and issue

            if(status>0){
                PreparedStatement ps=con.prepareStatement("delete from issue where bookid=? and studentid=?");
                ps.setInt(1,bookid);
                ps.setInt(2,studentid);
                status=ps.executeUpdate();
            }

            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    /**
     * methos to update the status of the book in the database
     * @param bookid Return book ID
     */
    public int returnupdatebook(int bookid){//update in book
        int status=0;
        int quantity=0,issued=0;
        try{
            Connection con=DB.getConnection();

            PreparedStatement ps=con.prepareStatement("select quantity,issued from books where bookid=?");
            ps.setInt(1,bookid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                quantity=rs.getInt("quantity");
                issued=rs.getInt("issued");
            }

            if(issued>0){
                PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where callno=?");
                ps2.setInt(1,quantity+1);
                ps2.setInt(2,issued-1);
                ps2.setInt(3,bookid);

                status=ps2.executeUpdate();
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
}
