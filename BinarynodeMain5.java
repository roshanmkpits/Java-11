package tree5.postorder;
//creating a binary tree using link list

//postorder traversal
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
    //preorder traversal
    public void preOrder(BinaryNode node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // Post Order Traversal
    void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }


}
public class BinarynodeMain5 {
    public static void main(String[] args) {
        BinaryLL binaryLL = new BinaryLL();
        System.out.println("binary tree created ");
        BinaryNode n1 = new BinaryNode();
        n1.value = "N1";
        BinaryNode n2 = new BinaryNode();
        n2.value = "N2";
        BinaryNode n3 = new BinaryNode();
        n3.value = "N3";
        BinaryNode n4 = new BinaryNode();
        n4.value = "N4";
        BinaryNode n5 = new BinaryNode();
        n5.value = "N5";
        BinaryNode n6 = new BinaryNode();
        n6.value = "N6";
        BinaryNode n7 = new BinaryNode();
        n7.value = "N7";

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        binaryLL.root=n1;
        binaryLL.postOrder(binaryLL.root);


    }
}

//output
//binary tree created
//        N4 N5 N2 N6 N7 N3 N1