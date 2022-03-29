import java.util.Arrays;

//question number one

public class max_sum_subarray {
    static int findMaxSum(int arr[]){
        int temp_max = Integer.MIN_VALUE;
        int current_position = 0;
        for(int x:arr){
            current_position += x;
            if(temp_max < current_position){
                temp_max = current_position;
            }
            if (current_position < 0){
                current_position = 0;
            }
        }
        return temp_max;
    }
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Array is: "+ Arrays.toString(arr) + "\nMaximum contiguous sum is: "+ findMaxSum(arr));
    }
}
