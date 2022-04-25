package shortestPath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class PAIR{
    int vertex;
    int weight;

    public PAIR(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
class PairComparator implements Comparator<PAIR>{
    @Override
    public int compare(PAIR o1, PAIR o2) {
        if (o1.weight < o2.weight) return -1;
        if (o2.weight < o1.weight) return 1;
        return 0;
    }
}
class Graph{
    int vertex;
    LinkedList<LinkedList<PAIR>> list = new LinkedList<>();
    int[] distance;
    boolean[] isPicked;
    int[] parent;

    public Graph(int vertex) {
        this.vertex = vertex;
        distance = new int[vertex];
        isPicked = new boolean[vertex];
        parent = new int[vertex];
        for (int i=0; i<vertex; i++){
            list.add(new LinkedList<>());
        }
    }
    void addEdge(int u, int v, int weight){
        list.get(u).add(new PAIR(v,weight));
        list.get(v).add(new PAIR(u, weight));
    }

    void shortestPath(int s){
        PriorityQueue<PAIR> pq = new PriorityQueue<>(new PairComparator());
//        int[] distance = new int[vertex];
//        boolean[] isPicked = new boolean[vertex];
//        int[] parent = new int[vertex];

        for (int i=0; i<vertex; i++){
            distance[i] = Integer.MAX_VALUE;
            isPicked[i] = false;
            parent[i] = -1;
        }

        pq.add(new PAIR(s,0));
        distance[s] = 0;
        while (!pq.isEmpty()){
            PAIR pooled = pq.poll();
            int edge = pooled.vertex;

            for (PAIR x: list.get(edge)){
                if (distance[x.vertex] > distance[edge]+x.weight){
                    distance[x.vertex] = distance[edge]+x.weight;
                    parent[x.vertex] = edge;

                    pq.add(x);
                }
            }
        }

//        for (int i=0; i<vertex; i++){
//            System.out.println("Node: "+i+", Distance: "+ distance[i]);
//        }
    }

    void findRoute(int destination){
        ArrayList<PAIR> details = new ArrayList<>();

        int pd = 0;
        int des = destination;
        while (pd != -1){
            pd = parent[des];
            if (pd < 0) break;
            int length = distance[des] - distance[pd];
            details.add(new PAIR(pd, length));
            des = pd;
        }
        for (int i= details.size()-1; i>-1; i--){
            System.out.print(details.get(i).vertex + " ---(" + details.get(i).weight + ")---> ");
        }
        System.out.print(destination + " : " + distance[destination]);
    }
}
public class shortestPath_Single_To_Multi_Main {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,1,4);
        g.addEdge(0,7,8);
        g.addEdge(1,2,8);
        g.addEdge(1,7,12);
        g.addEdge(7,6,1);
        g.addEdge(2,8,2);
        g.addEdge(2,5,4);
        g.addEdge(2,3,7);
        g.addEdge(8,6,6);
        g.addEdge(6,5,2);
        g.addEdge(5,3,14);
        g.addEdge(5,4,10);
        g.addEdge(3,4,9);

        g.shortestPath(0);
        g.findRoute(6);
    }
}
