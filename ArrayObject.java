

public class ArrayObject {
    public static void main(String[] args) {
        // Declare the Array
        Student[] students;

        // Allocate Memory for the Array
        students = new Student[3];

        // Initialize Objects and Assign to Array Elements
        students[0] = new Student("Alice", 20);
        students[1] = new Student("Bob", 22);
        students[2] = new Student("Charlie", 21);

        // Access and Manipulate Objects
        System.out.println("Student Details:");
        for (int i = 0; i < students.length; i++) {
            students[i].displayDetails();
        }
    }
}
 