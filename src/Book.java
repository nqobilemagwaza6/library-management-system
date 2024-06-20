public class Book {
    // This function is responsible for added books in the library
    private String title;
    private String author;


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}
