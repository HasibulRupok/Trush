import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class find_violation {
    static void quickSort(int arr[], int lb, int up,Vector<Integer> vec){
        if (lb < up){
            int partitionPlace = partition2(arr,lb,up);

            int violation = Math.abs(partitionPlace-up);
            vec.add(violation);

            quickSort(arr,lb,partitionPlace-1,vec);
            quickSort(arr,partitionPlace+1,up,vec);
        }
    }
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++){
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        return (i + 1);
    }
    static int partition2(int arr[], int lb, int ub){
        int pivot = lb;
        int start = lb;
        int end = ub;
        while (start < end){
            while (arr[start] <= arr[pivot]){
                start++;
            }
            while (arr[end] > arr[pivot]){
                end--;
            }
            if(start < end){
                arr[start] += arr[end];
                arr[end] = arr[start] - arr[end];
                arr[start] -= arr[end];
            }
        }
        arr[end] += arr[pivot];
        arr[pivot] = arr[end] - arr[pivot];
        arr[end] -= arr[pivot];

        return end;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr2 = new int[n];

        for (int i=0; i<n; i++){
            int x = sc.nextInt();
            arr2[i] = x;
        }

        int[] arr = {4,5,6,7,1};
        Vector<Integer> vec = new Vector<>();


        quickSort(arr2,0, arr2.length-1,vec);
        int totalViolation = 0;
        for (int x:vec){
            totalViolation += x;
        }
        System.out.println(totalViolation);
    }
}
