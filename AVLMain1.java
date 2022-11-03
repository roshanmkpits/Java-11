package avl1.create;

class BinaryNode{
    int value;
    int hight;
    BinaryNode left;
    BinaryNode right;
    BinaryNode(){
        this.hight=0;
    }
}
class Avl{
    BinaryNode root;
    Avl(){
        root=null;
        System.out.println("avl tree is created ");
    }
}
public class AVLMain1 {
    public static void main(String[] args) {
     Avl avl=new Avl();
    }
}
