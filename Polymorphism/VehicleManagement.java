package Polymorphism;

class Vehicle {
   //instance varible 
    String brand;
    double baseFare = 0.0;

    //constructor overloading

    public Vehicle(){}
    
    public Vehicle(String brand){

        this.brand = brand;
    }

    public Vehicle(String brand , double baseFare){

        this.brand=brand;
        this.baseFare = baseFare;
    }

    //method overloading

    double calculateFare(){
       
        return baseFare;

    }

    double calculateFare(int distance){

        return distance * baseFare;
    }


}

 class Car extends Vehicle {

    //constructor 

    public Car(String brand , double baseFare)
    {
        super(brand,baseFare);
    }

    @Override
    double calculateFare(){

        return baseFare + 200;

    }
    
 }

 class Bike extends Vehicle {


    //constructor
    public Bike(String brand , double baseFare){

        super(brand, baseFare);
    }

    @Override
    double calculateFare(){

        return baseFare + 50;
    }


 }

public class VehicleManagement {

    public static void main(String[] args) {

        System.out.println("==>Car subClass implementation<==");
       
        Vehicle v1 = new Car("Toyota", 700);

        System.out.println("Car Brand:" + v1.brand);
        System.out.println("Fare:" + v1.calculateFare());

        System.out.println("==>Bike subclass implementation<==");
        
        Vehicle v2 = new Bike("Suzuki", 200);

        System.out.println("Bike Brand:" + v2.brand);
        System.out.println("Base fare: " + v2.baseFare);

    }
    
}
