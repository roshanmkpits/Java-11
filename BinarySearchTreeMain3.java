package bst3.preorder;
//implementing preorder using linklist
 class BinaryTreeNode {
    int value ;
    int hight;
     BinaryTreeNode left;
     BinaryTreeNode right;
}

 class BinarySearchTree {
    BinaryTreeNode root;

    BinarySearchTree() {
        root = null;
    }


    private BinaryTreeNode insert(BinaryTreeNode currentNode, int value) {
        if (currentNode == null) {
            BinaryTreeNode newNode = new BinaryTreeNode();
            newNode.value = value;
            // System.out.println("The value successfully inserted");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }




    public void preOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}

    public class BinarySearchTreeMain3 {
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
        binarySearchTree.preOrder(binarySearchTree.root);
    }
}


//output
//70 50 30 20 40 60 90 80 100