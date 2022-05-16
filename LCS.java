package DP;
//    Longest Common Subsequence

import java.util.Scanner;

class findLcs{
    public void lengthOfLCS(String x, String y, int lenX, int lenY){
        int[][] L = new int[lenX+1][lenY+1];
        for (int i=0; i<= lenX; i++){
            for (int j=0; j<= lenY; j++){
                if (i==0 || j==0){
                    L[i][j] = 0;
                }
                else if (x.charAt(i-1) == y.charAt(j-1) ){
                    L[i][j] = L[i-1][j-1] + 1;
                }
                else {
                    L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
                }
            }
        }
        System.out.println("Longest subsequence length is: " + L[lenX][lenY]);


        int k = lenX;
        int j = lenY;
        String s = "";
        while (k > 0 && j>0){

            if (x.charAt(k-1) == y.charAt(j-1)){
                 s += x.charAt(k-1);
                k -= 1;
                j -= 1;
            }
            else {
                if (L[k][j-1] > L[k-1][j]){
                    j -= 1;
                }
                else {
                    k -= 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println("The subsequence is: " + sb.toString());
    }
}

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.print("X = ");
//        String x = sc.nextLine();
//
//        System.out.print("Y = ");
//        String y = sc.nextLine();

        String x = "ABCBDAB";
        String y = "BDCABA";
        int m = x.length();
        int n = y.length();

        findLcs lcs = new findLcs();
        lcs.lengthOfLCS(x,y,m,n);
    }
}
