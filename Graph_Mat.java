package Assignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph_Mat {

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    int numOfVertex;
    int matrix[][];
    boolean isDirected;
    boolean[] isVisitedDFS;

    public Graph_Mat(int numOfVertex, boolean isDirected){
        this.numOfVertex = numOfVertex;
        this.isDirected = isDirected;
        matrix = new int[numOfVertex][numOfVertex];

        isVisitedDFS = new boolean[numOfVertex];
    }


    public void addEdge(int i, int j){
        if (i < 0 || i > numOfVertex || j < 0 || j > numOfVertex){
            System.out.println( TEXT_RED +"Invalid Index to add edge" + TEXT_RESET);
            return;
        }
        if (!isDirected){
            matrix[i][j] = 1;
            matrix[j][i] = 1;
        }
        else {
            matrix[i][j] = 1;
        }
    }

    public void removeEdge(int i, int j){
        if (i < 0 || i > numOfVertex || j < 0 || j > numOfVertex){
            System.out.println( TEXT_RED +"Invalid Index to remove edge" + TEXT_RESET);
            return;
        }
        if (!isDirected){
            matrix[i][j] = 0;
            matrix[j][i] = 0;
        }
        else {
            matrix[i][j] = 0;
        }
    }

    void print(){
        for (int i=0; i<numOfVertex; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void BFS(int s){
        if (s > numOfVertex || s<0){
            System.out.println(TEXT_RED +"Your index is invalid" + TEXT_RESET);
            return;
        }
        boolean isVisited[] = new boolean[numOfVertex];
        Queue<Integer> queue = new LinkedList<>();

        isVisited[s] = true;
        queue.add(s);

//        int u;
        System.out.print("BFS:  ");
        while (queue.size() != 0){
            int u = queue.remove();
            System.out.print(u + " ");

            for (int i=0; i<numOfVertex; i++){
                if(matrix[u][i] == 1 && !isVisited[i]){
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public void DFS(int s){
        System.out.print(s + " ");
        isVisitedDFS[s] = true;

        for (int i=0; i< matrix[s].length; i++){
            if (matrix[s][i] == 1 && !isVisitedDFS[i] ){
                DFS(i);
            }
        }
    }

    public void DFS3(int s){
        System.out.print(s + " ");
        isVisitedDFS[s] = true;

        for (int i=0; i< matrix.length; i++){
            if (matrix[s][i] == 1 && !isVisitedDFS[i]){
                DFS3(i);
            }
        }
    }

    public int getDistance(int s, int d){
        if (s > numOfVertex || s<0 || d > numOfVertex || d < 0){
            System.out.println(TEXT_RED +"Your index is invalid to fiend distance" + TEXT_RESET);
            return -1;
        }

        boolean isVisited[] = new boolean[numOfVertex];
        Queue<Integer> queue = new LinkedList<>();

        int[] distance = new int[numOfVertex];
        for (int i=0; i<numOfVertex; i++){
            distance[i] = -1;
        }

        isVisited[s] = true;
        queue.add(s);
        distance[s] = 0;

        while (queue.size() != 0){
            int u = queue.remove();

            for (int i=0; i<numOfVertex; i++){
                if(matrix[u][i] == 1 && !isVisited[i]){
                    queue.add(i);
                    isVisited[i] = true;

                    distance[i] = distance[u] + 1;
                }
            }
        }

        return distance[d];
    }

    public void DFS2(int s){
        boolean[] isVisited = new boolean[numOfVertex];
        Stack<Integer> stack = new Stack<>();

        stack.push(s);
        System.out.print("DFS: " );
        while (stack.empty() == false){
            s = stack.pop();

            if(!isVisited[s]){
                System.out.print(s + " ");
                isVisited[s] = true;
            }
            for (int i=0; i<numOfVertex; i++){
                if(matrix[s][i] == 1 && !isVisited[i]){
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }
}

