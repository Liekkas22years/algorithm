package csp;

import java.util.Scanner;

public class csp_202109_1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int[] b =new int[n];
        for (int i = 0; i < b.length; i++) {
            b[i]=sc.nextInt();
        }
        int sum1 = b[0];
        int sum2 = b[0];
        for (int i = 0; i < n - 1; i++) {
            if (b[i] == b[i+1]) {
                sum1+=b[i];
            }
            else{
                sum1+=b[i+1];
                sum2+=b[i+1];
            }
        }
        System.out.println(sum1);
        System.out.println(sum2);
    }
}
