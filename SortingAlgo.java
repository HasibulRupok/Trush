import java.util.Vector;

public class sort {
    static void quickSort(int arr[], int lb, int up){
        if (lb < up){
            int partitionPlace = partition2(arr,lb,up);

            quickSort(arr,lb,partitionPlace-1);
            quickSort(arr,partitionPlace+1,up);
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
            if (L[i] > R[j]){  //descending order
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
        }
    }
}
