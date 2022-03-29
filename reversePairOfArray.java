
public class reversePairOfArray {
    public static void main(String[] args) {
        int[] arr = {2,4,3,5,1};
        int reversePair = 0;
        for (int i=0; i< arr.length; i++){
            for (int j=i+1; j< arr.length; j++){
                if (arr[i] > arr[j]*2){
                    reversePair++;
                }
            }
        }
        System.out.println(reversePair);
    }
}
