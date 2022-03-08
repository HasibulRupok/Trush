package Assignment;


public class Main {
    public static void main(String[] args) {      /*
        Graph_LST graph = new Graph_LST(11,true);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(2,6);
        graph.addEdge(3,7);
        graph.addEdge(3,8);
        graph.addEdge(5,9);
        graph.addEdge(5,10);
        graph.addEdge(1,8);
        graph.addEdge(0,5);

//        graph.DFS(0);
        System.out.println();
        graph.BFS(0);
        System.out.println("Distance between 0 to 10 is: " + graph.getDistance(0,10));

        graph.DFS2(0);
        */



        Graph_Mat g2 = new Graph_Mat(11,false);

        g2.addEdge(0,1);
        g2.addEdge(0,2);
        g2.addEdge(1,3);
        g2.addEdge(1,4);
        g2.addEdge(2,5);
        g2.addEdge(2,6);
        g2.addEdge(3,7);
        g2.addEdge(3,8);
        g2.addEdge(5,9);
        g2.addEdge(5,10);
        g2.addEdge(1,8);
        g2.addEdge(0,5);


        g2.DFS2(0);
        g2.BFS(0);

//        System.out.println("The distance between 0 and 10 is: "+g2.getDistance(0,10));

        g2.DFS3(0);



    }
}
