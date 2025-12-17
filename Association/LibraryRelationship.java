package Association;

//Write a Java program to represent the following relationships:

//🔹 Scenario:

//A Library has many Books

//A Member has an Address

//🔹 Requirements:

//Use association relationship

//Use fixed-size arrays

//Each class must have:

//private data members

//constructors

//necessary methods

//Display output from the main() method

//Do NOT use ArrayList

//Do NOT use inheritance


//Library has many books(one to many)

class Book {

    private String title;

    public void setTitle(String title){

        this.title = title;
    }

    public String getTitle(){

        return title;
    }

    //constructor

    public Book(String title){

        this.title = title;
    }
    
}


class Library {
    private String libraryName;
    private Book[] books;
    private int count = 0;

    //constructor
    public Library(String libraryName , int numberOfBooks){

      this.libraryName = libraryName;
      books = new Book[numberOfBooks];

    }

    //add method 

    public void addBook(Book b){
      
        if(count<books.length){
       
        books[count] = b;
        count++;

       }
    
    }

    public void showLibrary(){

        System.out.println("Library Name:" + libraryName);
        System.out.println("Books");
        
        for(int i = 0;i<count ;i++){

            System.out.println("=>" + books[i].getTitle());

        }

    }
   
    }

    //A member has an Address (one to one)


    class Address {

        //filed 

        private String  road;
        private String city;

        //getter

        public String getRoad(){

            return road;

        }
        public String getCity(){

            return city;

        }

        //constructor

        public Address(String road , String city ){

            this.road = road;
            this.city = city;


        }

        //clean code

     public String toString() {

        return road +","+city;

     }


    }

    class Member {
 private String name;
 private Address address;

 public String getName(){

    return name;
 }

 public Address getAddress(){

    return address;
 }

 public Member(String name , Address address){

    this.name = name;
    this.address = address;
 }

 public void showMemberInfo(){

    System.out.println("Member Name:" + name);
    System.out.println("Address:" + getAddress().toString());

 }

    }
    


public class LibraryRelationship {
    
    public static void main(String[] args) {
        
        Library l1 = new Library("Apana college", 3);
        l1.addBook(new Book("Java Programming"));
        l1.addBook(new Book("Data Structures"));
        l1.addBook(new Book("OOp concepts"));
        l1.showLibrary();

        Member m1 = new Member("Sarkar,Jubayer", new Address("B-10", "Dhaka"));
        m1.showMemberInfo();
    }
}
