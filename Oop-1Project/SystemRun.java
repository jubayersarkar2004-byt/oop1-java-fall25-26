
//library managemant system 

interface ILoanable { 

    double calculateFine(int daysLate); 
} 

abstract class Book { 

    protected String isbn; 

    protected String title; 

    Book() {} 

    Book(String isbn, String title) { 

        this.isbn = isbn; 

        this.title = title; 

    } 

    abstract void showInfo(); 

} 

class ReferenceBook extends Book { 

    protected boolean restricted; 

    ReferenceBook() {} 

    ReferenceBook(String isbn, String title, boolean restricted) { 

        super(isbn, title); 

        this.restricted = restricted; 
} 

void showInfo() { 

    System.out.println("Reference Book: " + title + ", Restricted: " + restricted); 
} 

} 

class BorrowableBook extends Book implements ILoanable { 

    protected int borrowedDays; 

    BorrowableBook() {} 

    BorrowableBook(String isbn, String title, int borrowedDays) { 

        super(isbn, title); 

        this.borrowedDays = borrowedDays; 

    } 

    public double calculateFine(int daysLate) { 

        if (daysLate > 7) 

            return daysLate * 5; 

            else 


                return daysLate * 2; 

            } 

            void showInfo() { 

                System.out.println("Borrowable Book: " + title + ", Borrowed Days: " + 

                borrowedDays); 

            } 

        } 
class Library { 

    protected String name; 

    protected Book[] books; 

    protected int count = 0; 

    Library() {} 

    Library(String name, int size) { 

        this.name = name; 

        books = new Book[size]; 

    } 

    void addBook(Book b) { 

        if (count < books.length) 

            books[count++] = b; 

        } 

        void showBooks() { 

            for (int i = 0; i < count; i++) 

                books[i].showInfo(); 

            } 

        } 

        public class SystemRun { 

            public static void main(String[] args) { 

                Book b1 = new ReferenceBook("111", "Java Reference", true); 

                Book b2 = new BorrowableBook("222", "OOP Concepts", 10); 

                Library lib = new Library("City Library", 5); 

                lib.addBook(b1); 

                lib.addBook(b2); 

                lib.showBooks(); 

                BorrowableBook bb = (BorrowableBook) b2; 

                System.out.println("Fine: " + bb.calculateFine(8)); 

            } 

        }