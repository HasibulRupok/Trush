import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Activity> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter activity list size: ");
        int n = sc.nextInt();
        System.out.println("Enter serial no, starting time, ending time");
        while (n > 0){
            int serial = sc.nextInt();
            int starting = sc.nextInt();
            int ending = sc.nextInt();

            arr.add(new Activity(serial, starting, ending));
            n-=1;
        }
        arr.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                if (o1.endTime < o2.endTime) return -1;
                else if (o2.endTime < o1.endTime) return 1;
                else return 0;
            }
        });

        int size = arr.size();
        int current = 0;
        int next = 0;

        /*
        int next = current+1;
        System.out.print("Selected Activities: " +arr.get(current).serialNo);
        for (int i=0; i<size; i++){
            if (arr.get(current).endTime <= arr.get(next).startingTime){
                System.out.print(", "+arr.get(next).serialNo);
                current = next;
            }
            next++;
            if (next >= size){
                break;
            }
        }   */

        System.out.println("Selected tasks: ");
        for (int i=0; i<size; i++){
            current = i;
            next = current+1;
            System.out.print("{"+arr.get(current).serialNo);
            while (next < size){
                if (arr.get(current).endTime  <= arr.get(next).startingTime){
                    System.out.print(", "+arr.get(next).serialNo);
                    current = next;
                }
                next++;
            }
            System.out.print("}");
            System.out.println();
        }
    }
}
/*
1 1 2
2 2 4
3 3 5
4 6 9

 */
