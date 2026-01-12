package Interface;

// We use interfaces to achieve full abstraction in Java.
// An interface is a blueprint of a class. It has static constants and abstract methods.
// The interface is declared using the interface keyword.
// By default, all methods in an interface are abstract and public.
// A class implements an interface using the implements keyword.
// A class that implements an interface must override all abstract methods of the interface.

// Interface
interface Animal {
    void sound(); // abstract method
}

// Class implementing the interface
class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // interface reference
        animal.sound();
    }
}
 