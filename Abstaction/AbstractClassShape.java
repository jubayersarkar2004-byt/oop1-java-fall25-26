package Abstaction;

abstract class Shape {
    String color;
    
    //abstract methodn
    abstract double calculateArea();
    abstract String displayShape();
    
    public Shape(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color; 
  
    }

  }


class Rectangle extends Shape {

    double length;
    double width;

    //constructor

    public Rectangle(String color, double length,double width ){
     
         super(color);
         this.length=length;
         this.width=width;   }

    @Override
     double calculateArea(){
     
        return length * width ;
    }

    
    @Override 
    String displayShape(){
        
     return "Circle color is " + super.getColor()
        + "and area is : " + calculateArea();
       }   



    }


 class Circle extends Shape {

    double radius;
   public Circle(String color, double radius){

        super(color);
        this.radius = radius;
    }

   @Override 
   double calculateArea(){
        
        return Math.PI * radius * radius;
    }

    String displayShape(){

        return "Circle color is " + super.getColor()
       + "and area is : " + calculateArea();
    }



         }     


public class AbstractClassShape {

    public static void main(String[] args){


        Shape s1 = new Rectangle("Yellow", 3, 05);
        Shape s2 = new Circle("Black", 3.5);



        System.out.println(s1.displayShape());
        System.out.println(s2.displayShape());



    }
    
}
