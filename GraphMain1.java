package graph1.adjacency;

import java.util.ArrayList;
//graph using adjacency matrix
class GraphNode{
    String name;
    int index;
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
}

public class GraphMain1 {
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




    }
}


//output

//           A B C D E
//        A: 0 1 1 1 0
//        B: 1 0 0 0 1
//        C: 1 0 0 1 0
//        D: 1 0 1 0 1
//        E: 0 1 0 1 0