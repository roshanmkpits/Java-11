//ou have to represent a point in 2D space. Write a class with the name Point. The class needs two fields (instance variables) with name x and y of type int.
//
//        The class needs to have two constructors. The first constructor does not have any parameters (no-arg constructor). The second constructor has parameters x and y of type int and it needs to initialize the fields.
//
//        Write the following methods (instance methods):

class Point {
    // write your code here
     private int x;
     private int y;

     public Point(int x, int y) {
         this.x = x;
         this.y = y;
     }

     public Point() {
     }

     public int getX() {
         return x;
     }

     public void setX(int x) {
         this.x = x;
     }

     public int getY() {
         return y;
     }

     public void setY(int y) {
         this.y = y;
     }
     public double distance(){
         return Math.sqrt((0-this.getX()) * (0-this.getX()) + ((0-this.getY()) * (0-this.getY())) );
     }

     public double distance(int x,int y){
         return Math.sqrt((x-this.getX()) * (x-this.getX()) + ((y-this.getY()) * (y-this.getY())) );
     }
     public double distance(Point point){
         return Math.sqrt((point.getX()-this.getX()) * (point.getX()-this.getX()) + ((point.getY()-this.getY()) * (point.getY()-this.getY())) );
     }
 }


public class Challange6Point {
}
