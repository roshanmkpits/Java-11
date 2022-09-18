//
//Write a class with the name Wall. The class needs two fields (instance variables) with name width and height of type double.
//
////        The class needs to have two constructors. The first constructor does not have any parameters (no-arg constructor). The second constructor has parameters width and height of type double and it needs to initialize the fields. In case the width is less than 0 it needs to set the width field value to 0, in case the height parameter is less than 0 it needs to set the height field value to 0.
public class challange6Wall {
    private double width;
    private double height;

    public challange6Wall() {}

    public challange6Wall(double width, double height) {
        setWidth(width);
        setHeight(height);
    }



    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width < 0){
            this.width = 0;
        }else {
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            this.height = 0;
        }else {
            this.height = height;
        }
    }

    public double getArea(){
        return this.getWidth() * this.getHeight();
    }
    public static void main(String[] args) {
        challange6Wall  wall =new challange6Wall(2,3);
        System.out.println(wall.getArea());
    }
}
