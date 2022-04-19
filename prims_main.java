package Prims_Algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class PairComparator implements Comparator<PAIR>{

    @Override
    public int compare(PAIR o1, PAIR o2) {
        if (o1.weight < o2.weight) return -1;
        else if (o2.weight < o1.weight) return 1;
        return 0;
    }
}

class PAIR{
    public int edge;
    public int weight;

    public PAIR(int edge, int weight) {
        this.edge = edge;
        this.weight = weight;
    }
}

class Graph{
    public int v;
    ArrayList<ArrayList<PAIR>> list = new ArrayList<>();

    public Graph(int v) {
        this.v = v;
        for (int i=0; i<v; i++){
            list.add(new ArrayList<PAIR>());
        }
    }
    public void addEdge(int u, int v, int w){
        list.get(u).add(new PAIR(v,w));
        list.get(v).add(new PAIR(u,w));
    }

    void Prims(){
        PriorityQueue<PAIR> q = new PriorityQueue<>(new PairComparator());
        int parent[] = new int[v];
        int key[] = new int[v];
        boolean inMST[] = new boolean[v];
        for (int i=0; i<v; i++){
            parent[i] = -1;
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }

        q.add(new PAIR(0,0));
        key[0] = 0;
        while (!q.isEmpty()){
            PAIR XX = q.poll();
            int edge = XX.edge;

            for (PAIR x: list.get(edge)){
                if (inMST[x.edge] == false && key[x.edge] > x.weight){
                    parent[x.edge] = XX.edge;
                    key[x.edge] = x.weight;
//                    System.out.println(x.edge + " --> " + x.weight);
                    q.add(x);
                }
            }
        }
        System.out.println("Node <----- Parent -----> Key");
        for (int i=0; i<v; i++){
            System.out.println(i + " <----- " + parent[i] + " -----> " + key[i]);
        }
    }
}

public class prims_main {
    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        graph.Prims();
    }
}
