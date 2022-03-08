package Assignment;

import java.util.*;

public class Graph_LST {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";

    int initialCapacity;
    boolean is_directed;
    ArrayList<ArrayList<Integer>> Adj = new ArrayList<ArrayList<Integer>>();
    boolean[] isVisitedDFS;

    public Graph_LST(int initialCapacity, boolean is_directed){
        this.initialCapacity = initialCapacity;
        this.is_directed = is_directed;
        isVisitedDFS = new boolean[initialCapacity];

        for (int i=0; i<this.initialCapacity; i++){
            Adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int x, int y){
        if(is_directed == true){
            Adj.get(x).add(y);
        }
        else {
            Adj.get(x).add(y);
            Adj.get(y).add(x);
        }
    }

    public void removeEdge(int u, int v){
        if (is_directed == true){
            int vIndex = Adj.get(u).indexOf(v);
            Adj.get(u).remove(vIndex);
        }
        else {
            int uIndex = Adj.get(v).indexOf(u);
            int vIndex = Adj.get(u).indexOf(v);
            Adj.get(u).remove(vIndex);
            Adj.get(v).remove(uIndex);
        }
    }

    public void DFS(int s){

        isVisitedDFS[s] = true;
        System.out.print(s + " ");

        Iterator<Integer> i = Adj.get(s).listIterator();
        while (i.hasNext()){
            int v = i.next();
            if(!isVisitedDFS[v]){
                DFS(v);
            }
        }
    }

    public void BFS(int s){
        if (s > initialCapacity || s<0){
            System.out.println("Your index is invalid");
            return;
        }
        boolean isVisited[] = new boolean[initialCapacity];
        ArrayList<Integer> queue = new ArrayList<>();


        isVisited[s] = true;
        queue.add(s);
        while (queue.size() != 0){
            int u = queue.remove(0);
            System.out.print(u + " ");

            Iterator<Integer> i = Adj.get(u).listIterator();
            while (i.hasNext()){
                int n = i.next();
                if( !isVisited[n] ){
                    isVisited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    public int getDistance(int s, int d){
        if(s < 0 || s >= initialCapacity || d < 0 || d >= initialCapacity){
            System.out.println( TEXT_RED +"Invalid source or destination" + TEXT_RESET);
            return -1;
        }

        int distance[] = new int[initialCapacity];
        for (int i=0; i<distance.length; i++){
            distance[i] = -1;
        }

        boolean[] isVisited = new boolean[initialCapacity];
        Queue<Integer> q = new LinkedList<>();

        isVisited[s] = true;
        distance[s] = 0;
        q.add(s);
        while (q.size() != 0){
            int u = q.remove();

            Iterator<Integer> i = Adj.get(u).listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!isVisited[n]){
                    isVisited[n] = true;
                    q.add(n);

                    distance[n] = distance[u] + 1;
                }

                if(n==d){
                    break;
                }
            }
        }

        return distance[d];
    }
    public void DFS2(int s){
        boolean[] isVisited = new boolean[initialCapacity];
        Stack<Integer> stack = new Stack<>();

        stack.push(s);
        System.out.print("DFS: " );
        while (stack.empty() == false){
            s = stack.pop();

            if(!isVisited[s]){
                System.out.print(s + " ");
                isVisited[s] = true;
            }

            Iterator<Integer> iterator = Adj.get(s).listIterator();
            while (iterator.hasNext()){
                int v = iterator.next();
                if(!isVisited[v]){
                    stack.push(v);
                }
            }
        }
        System.out.println();

    }
}
