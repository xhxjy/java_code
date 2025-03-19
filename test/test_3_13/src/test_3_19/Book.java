package test_3_19;

public class Book {
    private String id;
    private String bookName;

    public Book() {
    }

    public Book(String id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
