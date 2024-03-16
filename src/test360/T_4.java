package test360;

import java.util.Scanner;

public class T_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        arr[0] = sc.nextInt();
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if ((arr[i-1] * arr[i])%2==1){
                count++;
                arr[i]++;
            }
        }
        System.out.print(count);
    }
}
