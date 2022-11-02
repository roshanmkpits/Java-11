package bst5.postorder;
//implementing post order using linklist
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

     public void inOrder(BinaryTreeNode node) {
         if (node == null) {
             return;
         }

         inOrder(node.left);
         System.out.print(node.value + " ");
         inOrder(node.right);
     }

     public void postOrder(BinaryTreeNode node) {
         if (node == null) {
             return;
         }

         postOrder(node.left);

         postOrder(node.right);
         System.out.print(node.value + " ");
     }
}

    public class BinarySearchTreeMain5 {
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
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.postOrder(binarySearchTree.root);
    }
}


//output
//20 30 40 50 60 70 80 90 100