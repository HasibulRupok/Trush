package FinalSolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Pair{
    int V;
    int P;

    public Pair(int v, int p) {
        this.V = v;
        this.P = p;
    }
}
class find_Effective_Cost{
    public void calculate_cost(ArrayList<Pair> list, ArrayList<Integer> outPut, int N){
        int setNum = 1;
        ArrayList<Pair> taken = new ArrayList<>();

        for (int i=0; i< list.size(); i++){
            if (list.get(i).V + 1 >= N){
                outPut.add(list.get(i).V + 1);
            }
            taken.add(list.get(i));
            for (int j=0; j< list.size(); j++){
                if (i == j) continue;

                int v = list.get(j).V;
                for (Pair x: taken){
                    v += x.V;
                }
                v += taken.size() + 1;
                if (v >= N){
                    outPut.add(v);
                }

            }
        }
    }
}
public class Cost_Effective {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();

        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for (int i=0; i<T; i++){
            list.add(new ArrayList<>());
        }

        for (int i=0; i<T; i++){
            for (int j=0; j<N; j++){
                int vi = sc.nextInt();
                int pi = sc.nextInt();
                list.get(i).add(new Pair(vi, pi));
            }
        }

//        for (int i=0; i< list.size(); i++){
//            for (Pair x: list.get(i)){
//                System.out.println(x.V + "  "+ x.P);
//            }
//        }

        ArrayList<Integer> outPut = new ArrayList<>();
        int[] print = new int[T];

        find_Effective_Cost fec = new find_Effective_Cost();
        for (int i=0; i<T; i++){
            fec.calculate_cost(list.get(i), outPut, N);

            outPut.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1 < o2) return -1;
                    else if (o2 < o1) return 1;
                    return 0;
                }
            });
            print[i] = outPut.get(0);
            outPut.clear();
        }

        System.out.println(Arrays.toString(print));
    }
}
