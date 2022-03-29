import java.util.Arrays;

public class kth_largest_element {
    static void mergeSort(int[] arr, int k,int lb, int ub){
        if (lb < ub){
            int mid = (lb+ub)/2;
            mergeSort(arr,k,lb,mid);
            mergeSort(arr, k, mid+1,ub);
            merge(arr,lb,mid,ub);
        }
    }
    static void merge(int[] arr, int lb, int mid, int ub){
        int n1 = mid-lb+1;
        int n2 = ub-mid;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        for (int i=0; i<n1;i++){
            L[i] = arr[i];
        }
        for (int i=0; i<n2; i++){
            R[i] = arr[mid+1+i];
        }
        L[n1] = Integer.MIN_VALUE;
        R[n2] = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;
        for (int k=lb; k<= ub; k++){
            if (L[i] > R[j]){
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
        }
    }
    static int findKthMax(int[] arr,int k){
        mergeSort(arr,k,0, arr.length-1);

        return arr[k-1];
    }
    public static void main(String[] args) {
        int[] arr = {3,2,9,6,11};
        int maxValue = findKthMax(arr,2);

        System.out.println(maxValue);

    }
}
