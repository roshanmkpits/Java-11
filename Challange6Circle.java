//1. Write a class with the name Circle. The class needs one field (instance variable) with name radius of type double.
//
//        The class needs to have one constructor with parameter radius of type double and it needs to initialize the fields.
//
//        In case the radius parameter is less than 0 it needs to set the radius field value to 0.
//
//        Write the following methods (instance methods):

 class Circle {
    private double radius;

    public Circle(double radius) {
        if (radius < 0) {
            this.radius = 0;
        } else {
            this.radius = radius;
        }
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
}

// Cylinder Class

class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    public double getHeight() {
        return this.height;
    }

    public double getVolume() {
        return height * getArea();
    }
}

public class Challange6Circle {

    public static void main(String[] args) {

        Circle circle = new Circle(3.75);
        System.out.println("circle.radius= " + circle.getRadius());
        System.out.println("circle.area= " + circle.getArea());
        Cylinder cylinder = new Cylinder(5.55, 7.25);
        System.out.println("cylinder.radius= " + cylinder.getRadius());
        System.out.println("cylinder.height= " + cylinder.getHeight());
        System.out.println("cylinder.area= " + cylinder.getArea());
        System.out.println("cylinder.volume= " + cylinder.getVolume());

    }
}
