package Association;


class Student {
    private String name;
    private Contact contact;

    public Student(String name, Contact contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() { return name; }
    public Contact getContact() { return contact; }
}

class Contact {
    private String phone;
    private String email;

    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return phone + ", " + email;
    }
}

class School {
    private String schoolName;
    private Student[] students;
    private int count = 0;

    public School(String schoolName, int capacity) {
        this.schoolName = schoolName;
        students = new Student[capacity];
    }

    public void addStudent(Student s) {
        if (count < students.length) {
            students[count] = s;
            count++;
        }
    }

    public void showStudents() {
        System.out.println("School: " + schoolName);
        System.out.println("Students:");

        for (int i = 0; i < count; i++) {
            System.out.println(" - " + students[i].getName() +
                " | Contact: " + students[i].getContact());
        }
    }
}

public class SchoolRelationship {
    public static void main(String[] args) {

        School school = new School("Greenwood High", 3);

        school.addStudent(new Student("Alice",
                new Contact("01700000001", "alice@mail.com")));

        school.addStudent(new Student("Bob",
                new Contact("01700000002", "bob@mail.com")));

        school.addStudent(new Student("Carl",
                new Contact("01700000003", "carl@mail.com")));

        school.showStudents();
    }
}
 