package bst1.create;

//creating a binary search tree using link list
 class BinaryTreeNode {
    int value ;
    int hight;
    BinaryTreeNode left;
    BinaryTreeNode right;
}

 class BinarySearchTree {
    BinaryTreeNode root;
    BinarySearchTree(){
        root=null;
        System.out.println("Bst Created");

    }
}
public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
    }
}
//output
//Bst Created