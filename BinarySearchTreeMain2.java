package bst2.insert;
//implementing inser operation in binarysearch tree
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
    public BinaryTreeNode insert(BinaryTreeNode currentNode,int value){
        if(currentNode==null){
            BinaryTreeNode node=new BinaryTreeNode();
            node.value=value;
            System.out.println("value inserted sucessfully");
            return node;
        } else if (value<=currentNode.value) {
            currentNode.left=insert(currentNode.left,value);
            return currentNode;

        }else {
            currentNode.right=insert(currentNode.right,value);
            return currentNode;
        }
    }

    void insert(int value){
        insert(root,value);
    }
}
public class BinarySearchTreeMain2 {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(70);
        binarySearchTree.insert(50);
        binarySearchTree.insert(90);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(80);
        binarySearchTree.insert(100);
    }
}
//    Bst Created
//    value inserted sucessfully
//        value inserted sucessfully
//        value inserted sucessfully
//        value inserted sucessfully
//        value inserted sucessfully
//        value inserted sucessfully
//        value inserted sucessfully
//        value inserted sucessfully
//        value inserted sucessfully