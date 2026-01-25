package entity;

public class Library {

    private String bookName;
    private String author;
    private String volume;

    // constructor

    public Library(String bookName, String author, String volume) {
        this.bookName = bookName;
        this.author = author;
        this.volume = volume;

    }

    // getter methods
    public String getBookName() {
        return bookName;
    }
                                          
    public String getAuthor() {
        return author;
    }

    public String getVolume() {
        return volume;
    }



    // For file saving
    public String toFileString() {
        return bookName + "," + author + "," + volume;
    }

    @Override
    public String toString() {
        return bookName + " ," + author + " ," + volume;
    }

    // Convert file line to object
    public static Library fromFileString(String line) {
        String[] data = line.split(",");

        String bookName = data[0];
        String author = data[1];
        String volume = " NO VOLUME";

        if (data.length > 2) { // Ensures if Book has volume or not
            volume = data[2];
        }

        return new Library(bookName, author, volume);

    }

}
