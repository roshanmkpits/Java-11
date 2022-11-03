package avl4.inorder;
//insert operation
//rotate right
//rotate left
//for unbalanced head
class BinaryNode{
    public int height;
    int value;
      BinaryNode left;
    BinaryNode right;
    BinaryNode(){
        this.height=0;
    }
}
class Avl{
    BinaryNode root;
    Avl(){
        root=null;
        System.out.println("avl tree is created ");
    }
    //  getHeight
    public int getHeight(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // rotateRight
    private BinaryNode rotateRight(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // rotateLeft
    private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // getBalance
    public int getBalance(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // insertNode Method
    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && nodeValue < node.left.value) {
            return rotateRight(node);
        }

        if (balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }

        if (balance < - 1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

    }

    public void insert(int value) {
        root = insertNode(root, value);
        System.out.println("value inserted "+value);
    }

    // PreOrder Traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

}
public class AVLMain4 {
    public static void main(String[] args) {
     Avl avl=new Avl();
     avl.insert(5);
     avl.insert(10);
     avl.insert(15);
     avl.insert(20);
     avl.preOrder(avl.root);
     System.out.println();
     avl.inOrder(avl.root);

    }
}

//output
//avl tree is created
//value inserted 5
// value inserted 10
// value inserted 15
//value inserted 20
//10 5 15 20
//5 10 15 20