/**
 * Define Admin’s method
 */
public interface BookInterface {
    /**
     * Method to add a book to Book Database
     * @param bookid Book Id
     * @param name Book Id
     * @param author Book Author
     * @param publisher Book Publisher
     * @param quantity Book Quantity
     * @return Status 0 is false, 1 is Success
     */
    int save(int bookid, String name, String author, String publisher, int quantity);
}
