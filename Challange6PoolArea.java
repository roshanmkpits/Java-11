//he Swimming Company has asked you to write an application that calculates the volume of cuboid shaped pools.
//
//
//
//        1. Write a class with the name Rectangle. The class needs two fields (instance variable) with name width and length both of type double.
//
//        The class needs to have one constructor with parameters width and length both of type double and it needs to initialize the fields.
//
//        In case the width parameter is less than 0 it needs to set the width field value to 0.
//
//        In case the length parameter is less than 0 it needs to set the length field value to 0.

class Rectangle {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        if (width < 0) {
            this.width = 0;
        } else {
            this.width = width;
        }
        if (length < 0) {
            this.length = 0;
        } else {
            this.length = length;
        }
    }

    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return this.length;
    }

    public double getArea() {
        return width * length;
    }
}

// Class Cuboid

 class Cuboid extends Rectangle {
    private double height;

    public Cuboid(double width, double length, double height) {
        super(width,length);
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
        return getArea() * height;
    }
}
public class Challange6PoolArea {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("rectangle.width= " + rectangle.getWidth());
        System.out.println("rectangle.length= " + rectangle.getLength());
        System.out.println("rectangle.area= " + rectangle.getArea());
        Cuboid cuboid = new Cuboid(5,10,5);
        System.out.println("cuboid.width= " + cuboid.getWidth());
        System.out.println("cuboid.length= " + cuboid.getLength());
        System.out.println("cuboid.area= " + cuboid.getArea());
        System.out.println("cuboid.height= " + cuboid.getHeight());
        System.out.println("cuboid.volume= " + cuboid.getVolume());

    }
}
