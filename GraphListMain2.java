package graph2.list;


import java.util.ArrayList;
//graph using list
class GraphNode{
    String name;
    int index;

    ArrayList<GraphNode> neighbour=new ArrayList<GraphNode>();
    GraphNode(String name,int index){
        this.name=name;
        this.index=index;
    }
}

class Graph{
    ArrayList<GraphNode> nodelist=new ArrayList<GraphNode>();
    Graph(ArrayList<GraphNode> nodelist){
        this.nodelist=nodelist;
    }

    void unDirectedEdge(int i,int j){
        GraphNode frist=nodelist.get(i);
        GraphNode second=nodelist.get(j);

        frist.neighbour.add(second);
        second.neighbour.add(frist);
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodelist.size(); i++) {
            s.append(nodelist.get(i).name + ": ");
            for (int j =0; j < nodelist.get(i).neighbour.size(); j++) {
                if (j == nodelist.get(i).neighbour.size()-1 ) {
                    s.append((nodelist.get(i).neighbour.get(j).name) );
                } else {
                    s.append((nodelist.get(i).neighbour.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
public class GraphListMain2 {
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
        g.unDirectedEdge(1,4);
        g.unDirectedEdge(2,3);
        g.unDirectedEdge(3,4);


        System.out.println(g.toString());

    }
}

//output
//        A: B -> C -> D
//        B: A -> E
//        C: A -> D
//        D: A -> C -> E
//        E: B -> D