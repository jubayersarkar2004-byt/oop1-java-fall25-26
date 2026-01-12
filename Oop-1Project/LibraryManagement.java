public interface ILoanable {
    double calculateFine(int daysLate);
}

abstract class Book {
    String isbn;
    String title;

    public Book() {
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    abstract void showInfo();
}

class ReferenceBook extends Book {
    boolean restricted;

    public ReferenceBook() {
        super();
    }

    public ReferenceBook(String isbn, String title, boolean restricted) {
        super(isbn, title);
        this.restricted = restricted;
    }

    @Override
    void showInfo() {
        System.out.println("Reference Book - ISBN: " + isbn + ", Title: " + title + ", Restricted: " + restricted);
    }
}

class BorrowableBook extends Book implements ILoanable {
    int borrowedDays;

    public BorrowableBook() {
        super();
    }

    public BorrowableBook(String isbn, String title, int borrowedDays) {
        super(isbn, title);
        this.borrowedDays = borrowedDays;
    }

    @Override
    void showInfo() {
        System.out.println("Borrowable Book - ISBN: " + isbn + ", Title: " + title + ", Borrowed Days: " + borrowedDays);
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate > 7) {
            return daysLate * 5;
        } else {
            return daysLate * 2;
        }
    }
}

class Library {
    String name;
    Book books[];
    private int bookCount = 0;

    public Library() {
    }

    public Library(String name, int size) {
        this.name = name;
        this.books = new Book[size];
    }

    public void addBook(Book b) {
        if (bookCount < books.length) {
            books[bookCount++] = b;
            System.out.println("Added book to library: " + b.title);
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    public void showBooks() {
        System.out.println("\n--- Books in " + name + " Library ---");
        for (int i = 0; i < bookCount; i++) {
            books[i].showInfo();
        }
        System.out.println("----------------------------------\n");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library myLibrary = new Library("City Library", 10);

        Book b1 = new ReferenceBook("978-0134041548", "Clean Code", true);
        Book b2 = new BorrowableBook("978-0132350884", "Effective Java", 0);
        Book b3 = new BorrowableBook("978-0321765723", "The Clean Coder", 10);

        myLibrary.addBook(b1);
        myLibrary.addBook(b2);
        myLibrary.addBook(b3);

        myLibrary.showBooks();

        if (b2 instanceof BorrowableBook) {
            BorrowableBook bb2 = (BorrowableBook) b2;
            System.out.println("Fine for '" + bb2.title + "' if 5 days late: $" + bb2.calculateFine(5));
            System.out.println("Fine for '" + bb2.title + "' if 10 days late: $" + bb2.calculateFine(10));
        }

        if (b3 instanceof BorrowableBook) {
            BorrowableBook bb3 = (BorrowableBook) b3;
            System.out.println("Fine for '" + bb3.title + "' if 5 days late: $" + bb3.calculateFine(5));
        }
    }
}
