package tree1.simple;


import java.util.ArrayList;
//creating a simple tree
class TreeNode{
    String data;
    ArrayList<TreeNode> child;
    TreeNode(String data){
        this.data=data;
        child=new ArrayList<TreeNode>();
        }
        public void addChild(TreeNode node){
         child.add(node);
        }
        public String print(int level){
        String ret;
        ret=" ".repeat(level)+data+"\n";
            for (TreeNode node:child) {
                ret+=node.print(level+1);

            }
        return ret;
        }
}
public class SimpleTreeMain {
    public static void main(String[] args) {
        TreeNode drinks=new TreeNode("drinks");
        TreeNode hot=new TreeNode("hot");
        TreeNode cold=new TreeNode("cold");
        drinks.addChild(hot);
        drinks.addChild(cold);
        System.out.println(drinks.print(0));

    }
}

//output
//drinks
//  hot
//  cold
