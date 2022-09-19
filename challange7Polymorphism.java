//For this exercise you will create four classes of vehicles. The first class should be named Car. This will be the base class for three other classes, Mitsubishi, Holden, and Ford.
//
//        The first class contains four member variables, or fields, with these names and conditions:
//
//        engine of type boolean
//
//        cylinders of type int
//
//        name of type String
//
//        wheels of type int
//
//        All four member variables should have private access.
//
//        The constructor should accept two parameters, cylinders and name. Also, all of these cars have an engine and four wheels. So the other two fields should be set to default values.

class Car {

    private boolean engine=true;
    private int cylinders;
    private String name;
    private int  wheels=4;

     public Car(int cylinders, String name) {
         this.cylinders = cylinders;
         this.name = name;
     }

     public Car() {
     }

     public int getCylinders() {
         return cylinders;
     }

     public boolean isEngine() {
         return engine;
     }

     public String getName() {
         return name;
     }

     public int getWheels() {
         return wheels;
     }

     public String startEngine() {
         return " Car -> startEngine() ";
     }

     public String accelerate() {
         return " Car -> accelerate() ";
     }

     public String brake() {
         return " Car -> brake() ";
     }
 }
 class Mitsubishi extends Car {
     public Mitsubishi(int cylinders, String name) {
         super(cylinders, name);
     }
 }
 class Holden extends Car {
     public Holden(int cylinders, String name) {
         super(cylinders, name);
     }
 }


 class Ford extends Car {
     public Ford(int cylinders, String name) {
         super(cylinders, name);
     }
 }

public class challange7Polymorphism {


    public static void main(String[] args) {
        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(6, "Ford Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
    }
}
