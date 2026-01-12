

interface Payment {
    void pay(double amount);
}

abstract class Student {
    protected String name;
    protected int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract void displayInfo();
}

class UndergraduateStudent extends Student implements Payment {

    public UndergraduateStudent(String name, int id) {
        super(name, id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Undergraduate Student: " + name + " (ID: " + id + ")");
    }

    @Override
    public void pay(double amount) {
        System.out.println("Undergraduate payment processed: " + amount);
    }
}

class GraduateStudent extends Student implements Payment {

    public GraduateStudent(String name, int id) {
        super(name, id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Graduate Student: " + name + " (ID: " + id + ")");
    }

    @Override
    public void pay(double amount) {
        System.out.println("Graduate payment processed: " + amount);
    }
}

class University {

    public void processPayment(Student s, Payment p, double amount) {
        s.displayInfo();
        p.pay(amount);
        System.out.println();
    }
}

public class UniversityPaymentSystem {
    public static void main(String[] args) {

        System.out.println("\n==>Payment<==");

        Student s1 = new UndergraduateStudent("Rahim", 101);
        Student s2 = new GraduateStudent("Karim", 201);
        Student s3 = new UndergraduateStudent("Abdullah", 62064);
        Student s4 = new GraduateStudent("Jubayer", 6262);

        University u = new University();

        u.processPayment(s1, (Payment) s1, 50000);
        u.processPayment(s2, (Payment) s2, 80000);
        u.processPayment(s3, (Payment)s3, 70000);
        u.processPayment(s3, (Payment)s4, 600000);
    }
}
