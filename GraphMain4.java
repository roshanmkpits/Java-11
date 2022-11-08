package graph4.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

//graph using adjacency matrix
//implementing dfs depth frist search
class GraphNode{
    String name;
    int index;

    public boolean isVisited = false;
    GraphNode(String name,int index){
        this.name=name;
        this.index=index;
    }
}

class Graph{
    ArrayList<GraphNode> listnode=new ArrayList<GraphNode>();
    int [][] adjacencyMatrix;
    Graph(ArrayList<GraphNode> listnode){
        this.listnode=listnode;
        adjacencyMatrix=new int [listnode.size()][listnode.size()];
    }
    void unDirectedEdge(int i,int j){
        adjacencyMatrix[i][j]=1;
        adjacencyMatrix[j][i]=1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < listnode.size(); i++) {
            s.append(listnode.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < listnode.size(); i++) {
            s.append(listnode.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    //get neighbours

   ArrayList<GraphNode> getNeighbour(GraphNode node){
       ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
        int index=node.index;
       for (int i = 0; i <adjacencyMatrix.length ; i++) {
           if(adjacencyMatrix[index][i]==1){
               neighbors.add(listnode.get(i));
           }
       }
       return neighbors;
   }

    // BSF internall
//    void bfsVisit(GraphNode node) {
//        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
//        queue.add(node);
//        while(!queue.isEmpty()) {
//            GraphNode currentNode = queue.remove(0);
//            currentNode.isVisited = true;
//            System.out.print(currentNode.name + " ");
//            ArrayList<GraphNode> neighbors = getNeighbour(currentNode);
//            for (GraphNode neighbor: neighbors) {
//                if (!neighbor.isVisited) {
//                    queue.add(neighbor);
//                    neighbor.isVisited = true;
//                }
//            }
//        }
//    }
//
//    public void bfs() {
//        for (GraphNode node : listnode) {
//            if(!node.isVisited) {
//                bfsVisit(node);
//            }
//        }
//    }

    void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbors = getNeighbour(currentNode);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }

        }
    }

    void dfs() {
        for (GraphNode node : listnode) {
            if(!node.isVisited) {
                dfsVisit(node);
            }
        }
    }
}

public class GraphMain4 {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeArrayList = new ArrayList<GraphNode>();
        nodeArrayList.add(new GraphNode("A",0));
        nodeArrayList.add(new GraphNode("B",1));
        nodeArrayList.add(new GraphNode("C",2));
        nodeArrayList.add(new GraphNode("D",3));
        nodeArrayList.add(new GraphNode("E",4));
//        nodeArrayList.add(new GraphNode("F",5));
        Graph g=new Graph(nodeArrayList);
        g.unDirectedEdge(0,1);
        g.unDirectedEdge(0,2);
        g.unDirectedEdge(0,3);
        g.unDirectedEdge(1,0);
        g.unDirectedEdge(1,4);
        g.unDirectedEdge(2,0);
        g.unDirectedEdge(2,3);
        g.unDirectedEdge(3,0);
        g.unDirectedEdge(3,2);
        g.unDirectedEdge(3,4);

        System.out.println(g.toString());
        g.dfs();




    }
}


//output

//           A B C D E
//        A: 0 1 1 1 0
//        B: 1 0 0 0 1
//        C: 1 0 0 1 0
//        D: 1 0 1 0 1
//        E: 0 1 0 1 0

//         A D E C B