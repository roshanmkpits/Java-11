package tree2.binarytree;
//creating a binary tree using link list
class BinaryNode{
    String value;
    BinaryNode left;
    BinaryNode right;
    int hight;
}
class BinaryLL{
    BinaryNode root;
    BinaryLL(){
        root=null;
    }
}
public class BinarynodeMain {
    public static void main(String[] args) {
     BinaryLL binaryLL=new BinaryLL();
     System.out.println("binary tree created ");
    }
}

//output
//binary tree created