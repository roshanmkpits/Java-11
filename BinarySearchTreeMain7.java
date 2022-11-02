package bst7.del;
//search operation in binary search tree
//deletion of binary search tree
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

     BinaryTreeNode search(BinaryTreeNode node,int value){
         if (node == null ) {
             System.out.println("value: "+value+ "not found in BST");
             return null;
         } else if (node.value == value) {
             System.out.println("value: "+value+ "found in BST");
             return node;
         } else if (value < node.value) {
             return search(node.left,value);
         } else {
             return search(node.right,value);
         }
     }
      void delete() {
         root = null;
         System.out.println("binary search tree  has been deleted successfully");
     }
}

    public class BinarySearchTreeMain7 {
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
        binarySearchTree.delete();

    }
}


//output
//binary search tree  has been deleted successfully